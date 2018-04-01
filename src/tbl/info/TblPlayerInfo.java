package tbl.info;

import template.DaoValue;

public class TblPlayerInfo extends DaoValue {
	public int id;
	public String name;
	public String password;
	public int matchId;
	
	public TblPlayerInfo() {
	}
	
	public TblPlayerInfo(String name, String pass) {
		this.name = name;
		this.password = pass;
		this.matchId = 0;
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
		return "player_info";
	}

	@Override
	public String getPrimaryKey() {
		return "id";
	}
}
