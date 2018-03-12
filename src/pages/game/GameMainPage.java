package pages.game;

import org.apache.click.Page;

import model.Player;
import pages.top.Login;
import services.PlayerServices;
import utility.GameLog;

public class GameMainPage extends Page {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Player player = null;
	
	public GameMainPage() {
		GameLog.getInstance().info("[GAME MAIN PAGE] Game Main Page");

		if (getContext().getSessionAttribute("playerId") == null) {
			setRedirect(Login.class);
			return;
		}
		
		int playerId = (Integer) getContext().getSessionAttribute("playerId");
		player = PlayerServices.getPlayerByID(playerId);
	}
	
	public static Player getPlayer() {
		return player;
	}
	
}
