package pages.game;

import java.util.List;

import org.apache.click.element.CssImport;
import org.apache.click.element.Element;

import model.Player;
import pages.top.Login;
import services.PlayerServices;
import template.PageBase;
import utility.GameLog;

public class GameMainPage extends PageBase {
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

		logRequest(playerId);
		
		player = PlayerServices.getPlayerByID(playerId);
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	@Override
	public List<Element> getHeadElements() {
		super.getHeadElements();
		
		headElements.add(new CssImport("../../css/game.css"));
		
		return headElements;
	}
	
	@Override
	public String getTemplate() {
		return "pages/template/game_main_page.htm";
	}
	
}
