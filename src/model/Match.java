package model;

import enums.BoardStatusEnum;
import enums.GameSideEnum;
import tbl.info.TblMatchInfo;

public class Match {
	private TblMatchInfo tblMatchInfo;
	
	public Match() {
		
	}
	
	public Match(TblMatchInfo tblMatchInfo) {
		this.tblMatchInfo = tblMatchInfo;
	}
	
	public TblMatchInfo getTblMatchInfo() {
		return this.tblMatchInfo;
	}
	
	public void setTblMatchInfo(TblMatchInfo tblMatchInfo) {
		this.tblMatchInfo = tblMatchInfo;
	}
	
	public int getId() {
		return this.tblMatchInfo.getId();
	}
	
	public int getPlayerId() {
		return this.tblMatchInfo.getPlayerId();
	}
	
	public void setPlayerId(int playerId) {
		this.tblMatchInfo.setPlayerId(playerId);
	}
	
	public GameSideEnum getCurrentSide() {
		return GameSideEnum.getSide((Integer) tblMatchInfo.getCurrentSide());
	}
	
	public void setCurrentSide(GameSideEnum sideEnum) {
		this.tblMatchInfo.setCurrentSide(sideEnum.ordinal());
	}
	
	public int getPlayerHp() {
		return this.tblMatchInfo.getPlayerHp();
	}
	
	public void setPlayerHp(int hp) {
		this.tblMatchInfo.setPlayerHp(hp);
	}
	
	public int getEnemyHp() {
		return this.tblMatchInfo.getEnemyHp();
	}
	
	public void setEnemyHp(int hp) {
		this.tblMatchInfo.setEnemyHp(hp);
	}
	
	public int getPlayerScore() {
		return this.tblMatchInfo.getPlayerScore();
	}
	
	public void setPlayerScore(int score) {
		this.tblMatchInfo.setPlayerScore(score);
	}
	
	public int getTurn() {
		return this.tblMatchInfo.getTurn();
	}
	
	public void setTurn(int turn) {
		this.tblMatchInfo.setTurn(turn);;
	}
	
	public BoardStatusEnum getBoardStatus() {
		return BoardStatusEnum.getStatus((Integer) this.tblMatchInfo.getStatus());
	}
	
	public void setBoardStatus(BoardStatusEnum boardStatus) {
		this.tblMatchInfo.setStatus(boardStatus.ordinal());
	}
}
