package pages.game;

import model.Player;
import utility.GameLog;

public class Game extends GameMainPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Player player = null;
	
	public Game() {
		
	}
	
	@Override
	public void onInit() {
		super.onInit();
		
		player = getPlayer();
		if (player == null) {
			GameLog.getInstance().info("[Game] player null");
			return;
		}
	}
	
	@Override
	public void onPost() {
		super.onInit();
	}
	
	@Override
	public void onRender() {
		super.onInit();
	}
	
}
