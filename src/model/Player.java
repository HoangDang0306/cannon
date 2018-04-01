package model;

import tbl.info.TblPlayerInfo;

public class Player {
	private TblPlayerInfo tblPlayerInfo;
	
	public Player() {
		
	}
	
	public Player(TblPlayerInfo tblPlayerInfo) {
		this.tblPlayerInfo = tblPlayerInfo;
	}
	
	public void setTblPlayerInfo(TblPlayerInfo tblPlayerInfo) {
		this.tblPlayerInfo = tblPlayerInfo;
	}
	
	public TblPlayerInfo getTblPlayerInfo() {
		return tblPlayerInfo;
	}
	
	public int getId() {
		return (Integer) tblPlayerInfo.Get("id");
	}
	
	public String getName() {
		return String.valueOf(tblPlayerInfo.Get("name"));
	}
	
	public void setName(String name) {
		this.tblPlayerInfo.Set("name", name);
	}
	
	public String getPassword() {
		return String.valueOf(tblPlayerInfo.Get("password"));
	}
	
	public void setPassword(String pass) {
		this.tblPlayerInfo.Set("password", pass);
	}
	
	public int getMatchId() {
		return (Integer) tblPlayerInfo.Get("matchId");
	}
	
	public void setMatchId(int matchId) {
		this.tblPlayerInfo.Set("match_id", matchId);
	}
}
