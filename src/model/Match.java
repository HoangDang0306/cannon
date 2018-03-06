package model;

import enums.MatchStatusEnum;

public class Match {
	private int id;
	private int playerId;
	private int playerBoardId;
	private int enemyBoardId;
	private int currentSide;
	private short playerHp;
	private short enemyHp;
	private int status;
	
	public Match() {
		
	}
	
	public Match(int id, int playerId, int playerBoardId, int enemyBoardId, int currentSide, short playerHp, short enemyHp, MatchStatusEnum status) {
		this.id = id;
		this.playerId = playerId;
		this.playerBoardId = playerBoardId;
		this.enemyBoardId = enemyBoardId;
		this.currentSide = currentSide;
		this.playerHp = playerHp;
		this.enemyHp = enemyHp;
		this.status = status.getId();
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getPlayerBoardId() {
		return playerBoardId;
	}
	public void setPlayerBoardId(int playerBoardId) {
		this.playerBoardId = playerBoardId;
	}
	public int getEnemyBoardId() {
		return enemyBoardId;
	}
	public void setEnemyBoardId(int enemyBoardId) {
		this.enemyBoardId = enemyBoardId;
	}
	public int getCurrentSide() {
		return currentSide;
	}
	public void setCurrentSide(int currentSide) {
		this.currentSide = currentSide;
	}
	public int getId() {
		return id;
	}
	public short getPlayerHp() {
		return this.playerHp;
	}
	public void setPlayerHp(short playerHp) {
		this.playerHp = playerHp;
	}
	public short getEnemyHp() {
		return this.enemyHp;
	}
	public void setEnemyHp(short enemyHp) {
		this.enemyHp = enemyHp;
	}
	public MatchStatusEnum getStatus() {
		return MatchStatusEnum.getStatus(this.status);
	}
	public void setStatus(MatchStatusEnum status) {
		this.status = MatchStatusEnum.getValue(status);
	}
}
