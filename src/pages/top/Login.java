package pages.top;

import org.apache.click.Page;
import org.apache.click.control.Form;
import org.apache.click.control.PasswordField;
import org.apache.click.control.Submit;
import org.apache.click.control.TextField;
import org.apache.commons.lang.StringUtils;

import enums.MatchStatusEnum;
import model.EnemyBoard;
import model.Match;
import model.Player;
import model.PlayerBoard;
import pages.game.Index;
import services.PlayerServices;
import template.CommonDaoFactory;

public class Login extends Page {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Login() {
		System.out.println("[LOGIN] Login page.");
		
	}
	
	@Override
	public void onInit() {
		super.onInit();
		
		Player p = new Player("a", "b");
		CommonDaoFactory.Insert(p);
		
		short a = 1;
		PlayerBoard b = new PlayerBoard(1, a, a, a, a, a, a, a);
		CommonDaoFactory.Insert(b);
		
		
	}
	
	@Override
	public void onPost() {
		super.onPost();
		
		String regis = getContext().getRequestParameter("register");
		if (StringUtils.isNotEmpty(regis) && regis.equals("register")) {
			setRedirect(Register.class);
			return;
		}
		
		String user = getContext().getRequestParameter("user");
		String pass = getContext().getRequestParameter("pass");
		
		if (StringUtils.isEmpty(user)) {
			showError("Please enter username");
			return;
		}
		
		if (StringUtils.isEmpty(pass)) {
			showError("Please enter password");
			return;
		}
		
		if (StringUtils.isNotEmpty(user) && StringUtils.isNotEmpty(pass)) {
			Player player = PlayerServices.getPlayerByName(user);
			if (player == null) {
				System.out.println("[LOGIN] Username was not registed!");
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
		
		TextField user = new TextField("user", "Username");
		form.add(user);
		
		PasswordField pass = new PasswordField("pass", "Password");
		form.add(pass);
		
		Submit submit = new Submit("submit", "Submit");
		form.add(submit);
		
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

