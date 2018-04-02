package pages.game;

import java.util.List;

import org.apache.click.control.Form;
import org.apache.click.control.Submit;
import org.apache.click.element.CssImport;
import org.apache.click.element.Element;
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
	
	@Override
	public List<Element> getHeadElements() {
		super.getHeadElements();
		
		headElements.add(new CssImport("../../css/index.css"));
		
		return headElements;
	}
	
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
		Form form = new Form("form");
		
//		if (match != null) {
//			Submit con = new Submit("continue", "Continue");
//			menu.add(con);
//		}
		
		Submit newGame = new Submit("game", "New Game");
		form.add(newGame);
		
		Submit highScore = new Submit("score", "High Score");
		form.add(highScore);
		
		addControl(form);
	}
}
