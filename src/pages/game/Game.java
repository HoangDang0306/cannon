package pages.game;

import java.util.ArrayList;
import java.util.List;

import enums.GameSideEnum;
import enums.MatchStatusEnum;
import model.EnemyBoard;
import model.Match;
import model.Player;
import model.PlayerBoard;
import services.MatchServices;
import template.CommonDaoFactory;
import template.DaoValue;
import utility.CommonDefine;
import utility.GameLog;

public class Game extends GameMainPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Player player = null;
	private static Match match = null;
	
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
		
		if (player.getMatchId() > 0) { // existing 
			match = MatchServices.Select(player.getMatchId());
			System.out.println("day day");
		} else { //new match
			List<DaoValue> listDaoValue = new ArrayList<DaoValue>();
			
			EnemyBoard enemyBoard = new EnemyBoard(player.getId());
			listDaoValue.add(enemyBoard);
			
			PlayerBoard playerBoard = new PlayerBoard(player.getId());
			listDaoValue.add(playerBoard);
			
			match = new Match(0, player.getId(), GameSideEnum.PLAYER.ordinal(), CommonDefine.PLAYER_INIT_HP, CommonDefine.ENEMY_INIT_HP, MatchStatusEnum.PREPARE);
			listDaoValue.add(match);
			
			if (CommonDaoFactory.Insert(listDaoValue) < 0) {
				GameLog.getInstance().info("Eo insert dc match moi");
				return;
			}
			
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
