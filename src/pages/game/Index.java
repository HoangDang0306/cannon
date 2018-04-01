package pages.game;

import org.apache.click.control.Form;
import org.apache.click.control.Submit;
import org.apache.commons.lang.StringUtils;

import model.Player;
import pages.top.Login;
import tbl.info.TblMatchInfo;
import utility.GameLog;

public class Index extends GameMainPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Player player = null;
	private static TblMatchInfo match = null;
	
	public Index() {
		GameLog.getInstance().info("[INDEX] Index");
	}
	
	@Override
	public void onInit() {
		player = getPlayer();
		
		if (player == null) {
			setRedirect(Login.class);
			return;
		}
		
//		match = MatchServices.getCurrentMatch(player.getTblPlayerInfo());
		
		createMenu();
		
	}
	
	@Override
	public void onPost() {
		String newGameStr = getContext().getRequestParameter("game");
		String highScore = getContext().getRequestParameter("score");
		
		if (StringUtils.isNotEmpty(newGameStr)) {
			setRedirect(Game.class);
			return;
		}
		
		if (StringUtils.isNotEmpty(highScore)) {
//			setRedirect(Game.class);
//			return;
		}
	}
	
	@Override
	public void onRender() {
		createMenu();
	}
	
	private void createMenu() {
		Form menu = new Form("menu");
		
		if (match != null) {
			Submit con = new Submit("continue", "Continue");
			menu.add(con);
		}
		
		Submit newGame = new Submit("game", "New Game");
		menu.add(newGame);
		
		Submit highScore = new Submit("score", "High Score");
		menu.add(highScore);
		
		addModel("menu", menu);
	}
	
//	private static void createNewMatch() {
//		Match match = new Match(player.getId(), GameSideEnum.PLAYER, CommonDefine.PLAYER_INIT_HP, CommonDefine.ENEMY_INIT_HP, MatchStatusEnum.PREPARE);
//		if (CommonDaoFactory.Insert(match) < 0) {
//			GameLog.getInstance().info("Index: Cannot craete new match");
//			return;
//		}
//		
//		System.out.println(match.getId());
//	}
	
}
