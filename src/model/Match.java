package model;

import enums.MatchStatusEnum;
import template.DaoValue;

public class Match extends DaoValue {
	private int id;
	private int playerId;
	private int currentSide;
	private int playerHp;
	private int enemyHp;
	private int status;
	
	public Match() {
		sync();
	}
	
	public Match(int id, int playerId, int currentSide, int playerHp, int enemyHp, MatchStatusEnum status) {
		this.id = id;
		this.playerId = playerId;
		this.currentSide = currentSide;
		this.playerHp = playerHp;
		this.enemyHp = enemyHp;
		this.status = status.getId();
		
		sync();
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
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
	public void setId(int id) {
		this.id = id;
	}
	public int getPlayerHp() {
		return this.playerHp;
	}
	public void setPlayerHp(short playerHp) {
		this.playerHp = playerHp;
	}
	public int getEnemyHp() {
		return this.enemyHp;
	}
	public void setEnemyHp(short enemyHp) {
		this.enemyHp = enemyHp;
	}
	public int getStatus() {
		return this.status;
	}
	public void setStatus(MatchStatusEnum status) {
		this.status = MatchStatusEnum.getValue(status);
	}
	
	@Override
	public String getTableName() {
		return "match_info";
	}

	@Override
	public String getPrimaryKey() {
		return "id";
	}
}
