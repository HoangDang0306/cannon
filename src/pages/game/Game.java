package pages.game;

import model.EnemyBoard;
import model.Match;
import model.Player;
import services.MatchServices;

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
			System.out.println("[Game] player null");
			return;
		}
		
		Match match = null;
		if (player.getCurrentMatch() > 0) { // existing 
			match = MatchServices.Select(player.getCurrentMatch());
		} else { //new match
			//new enemy board
			EnemyBoard enemyBoard = new EnemyBoard();
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
