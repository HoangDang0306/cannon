package pages.game;

import org.apache.click.control.Form;
import org.apache.click.control.Submit;

import model.Player;
import pages.top.Login;
import utility.GameLog;

public class Index extends GameMainPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Player player = null;
	
	public Index() {
		GameLog.info("[INDEX] Index");
	}
	
	@Override
	public void onInit() {
		player = getPlayer();
		
		if (player == null) {
			setRedirect(Login.class);
			return;
		}
		
	}
	
	@Override
	public void onPost() {
		
	}
	
	@Override
	public void onRender() {
		createMenu();
	}
	
	private void createMenu() {
		Form menu = new Form("menu");
		
		Submit newGame = new Submit("new_game", "New Game");
		menu.add(newGame);
		
		Submit highScore = new Submit("high_score", "High Score");
		menu.add(highScore);
		
		addModel("menu", menu);
	}
	
}
