package pages.top;

import org.apache.click.control.Form;
import org.apache.click.control.PasswordField;
import org.apache.click.control.Submit;
import org.apache.click.control.TextField;
import org.apache.commons.lang.StringUtils;

import model.Player;
import services.PlayerServices;
import template.CommonDaoFactory;
import template.PageBase;
import utility.GameLog;

public class Register extends PageBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Register() {
		GameLog.getInstance().info("[REGISTER] Register page.");
	}
	
	@Override
	public void onInit() {
		super.onInit();
		
	}
	
	@Override
	public void onPost() {
		super.onPost();
		
		String name = getContext().getRequestParameter("name");
		String pass = getContext().getRequestParameter("pass");
		String confirm = getContext().getRequestParameter("confirm");
		
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(pass) || StringUtils.isEmpty(confirm)) {
			showError("Please fill correctly");
			return;
		}
		
		if (!pass.equals(confirm)) {
			showError("Password is not corresponding");
			return;
		}
		
		if (StringUtils.isNotEmpty(name)) {
			Player player = PlayerServices.getPlayerByName(name);
			if (player != null) {
				System.out.println("[LOGIN] This username is existing!");
				showError("This username is existing!");
				return;
			}
			
			player = new Player();
			player.setName(name);
			player.setPassword(pass);
			player.setMatchId(0);
			
			if (CommonDaoFactory.Insert(player.getTblPlayerInfo()) < 0) {
				System.out.println("[LOGIN] Insert Player failed");
				return;
			}
			
			setRedirect(Login.class);
		}
	}
	
	@Override
	public void onRender() {
		super.onRender();
		
		createRegisterForm();
	}
	
	private void createRegisterForm() {
		Form form = new Form("login_form");
		
		TextField user = new TextField("user", "Username");
		form.add(user);
		
		PasswordField pass = new PasswordField("pass", "Password");
		form.add(pass);
		
		PasswordField confirm = new PasswordField("confirm", "Confirm");
		form.add(confirm);
		
		Submit submit = new Submit("submit", "Submit");
		form.add(submit);
		
		addModel("formRegister", form);
	}
	
	private void showError(String error) {
		String errorStr = "<span style='color:red;'>" + error + "</span>";
		addModel("error", errorStr); 
	}
}
