package pages.top;

import org.apache.click.control.Form;
import org.apache.click.control.PasswordField;
import org.apache.click.control.Submit;
import org.apache.click.control.TextField;
import org.apache.commons.lang.StringUtils;

import model.Player;
import pages.game.Index;
import services.PlayerServices;
import template.PageBase;
import utility.GameLog;

public class Login extends PageBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Login() {
		GameLog.getInstance().info("Login");
	}
	
	@Override
	public void onInit() {
		super.onInit();

		createLoginForm();
	}
	
	@Override
	public void onPost() {
		super.onPost();
		String regis = getContext().getRequestParameter("register");
		if (StringUtils.isNotEmpty(regis) && regis.equals("Register")) {
			setRedirect(Register.class);
			return;
		}
		
		String name = getContext().getRequestParameter("name");
		String pass = getContext().getRequestParameter("pass");
		
		if (StringUtils.isEmpty(name)) {
			showError("Please enter username");
			return;
		}
		
		if (StringUtils.isEmpty(pass)) {
			showError("Please enter password");
			return;
		}
		
		if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(pass)) {
			Player player = PlayerServices.getPlayerByName(name);
			if (player == null) {
				GameLog.getInstance().info("[LOGIN] Username was not registed!");
				showError("Username was not registed!");
				return;
			}
			
			setSessionPlayerId(player.getId());
			this.setRedirect(Index.class);
		}
	}
	
	@Override
	public void onRender() {
		super.onRender();
	}
	
	private void createLoginForm() {
		Form form = new Form("login_form");
		
		TextField name = new TextField("name", "Username");
		form.add(name);
		
		PasswordField pass = new PasswordField("pass", "Password");
		form.add(pass);
		
		Submit submit = new Submit("submit", "Login");
		form.add(submit);
		
		Submit register = new Submit("register", "Register");
		form.add(register);
		
		addModel("formLogin", form);
	}
	
	private void showError(String error) {
		String errorStr = "<span style='color:red;'>" + error + "</span>";
		addModel("error", errorStr); 
	}

	private void setSessionPlayerId(int playerId) {
		getContext().setSessionAttribute("playerId", playerId);
	}
}

