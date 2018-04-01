package tbl.info;

import template.DaoValue;

public class TblMatchInfo extends DaoValue {
	private int id;
	private int playerId;
	private int playerBoard;
	private int enemyBoard;
	private int currentSide;
	private int playerHp;
	private int enemyHp;
	private int playerScore;
	private int turn;
	private int status;
	
	public TblMatchInfo() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getPlayerBoard() {
		return playerBoard;
	}
	public void setPlayerBoard(int playerBoard) {
		this.playerBoard = playerBoard;
	}
	public int getEnemyBoard() {
		return enemyBoard;
	}
	public void setEnemyBoard(int enemyBoard) {
		this.enemyBoard = enemyBoard;
	}
	public int getCurrentSide() {
		return currentSide;
	}
	public void setCurrentSide(int currentSide) {
		this.currentSide = currentSide;
	}
	public int getPlayerHp() {
		return playerHp;
	}
	public void setPlayerHp(int playerHp) {
		this.playerHp = playerHp;
	}
	public int getEnemyHp() {
		return enemyHp;
	}
	public void setEnemyHp(int enemyHp) {
		this.enemyHp = enemyHp;
	}
	public int getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
