package model;

import template.DaoValue;

public class Player extends DaoValue {
	private static final String TABLE_NAME = "player_info";
	private static final String PRIMARY_KEY = "id";
	
	public int id;
	public String name;
	public String password;
	public int matchId;
	
	public Player() {
	}
	
	public Player(String name, String pass) {
		this.name = name;
		this.password = pass;
		this.matchId = 0;
		
		sync();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getPrimaryKey() {
		return PRIMARY_KEY;
	}
}
