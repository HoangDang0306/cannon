package pages.game;

import org.apache.click.Page;

import model.Player;
import services.PlayerServices;
import utility.GameLog;

public class GameMainPage extends Page {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Player player = null;
	
	public GameMainPage() {
		GameLog.info("[GAME MAIN PAGE] Game Main Page");
		
		int playerId = (Integer) getContext().getSessionAttribute("playerId");
		
		player = PlayerServices.getPlayerByID(playerId);
	}
	
	public static Player getPlayer() {
		return player;
	}
	
}
