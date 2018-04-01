package tbl.info;

import template.DaoValue;

public class TblBoardInfo extends DaoValue {
	private int id;
	private int matchId;
	private int side;
	private int cannon1;
	private int cannon2;
	private int cannon3;
	private int cannon4;
	private int cannon5;
	private int cannon6;
	private int cannon7;
	private int status;
	
	public TblBoardInfo() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getSide() {
		return this.side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public int getCannon1() {
		return cannon1;
	}
	public void setCannon1(int cannon1) {
		this.cannon1 = cannon1;
	}
	public int getCannon2() {
		return cannon2;
	}
	public void setCannon2(int cannon2) {
		this.cannon2 = cannon2;
	}
	public int getCannon3() {
		return cannon3;
	}
	public void setCannon3(int cannon3) {
		this.cannon3 = cannon3;
	}
	public int getCannon4() {
		return cannon4;
	}
	public void setCannon4(int cannon4) {
		this.cannon4 = cannon4;
	}
	public int getCannon5() {
		return cannon5;
	}
	public void setCannon5(int cannon5) {
		this.cannon5 = cannon5;
	}
	public int getCannon6() {
		return cannon6;
	}
	public void setCannon6(int cannon6) {
		this.cannon6 = cannon6;
	}
	public int getCannon7() {
		return cannon7;
	}
	public void setCannon7(int cannon7) {
		this.cannon7 = cannon7;
	}
	public int getStatus() {
		return this.status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String getTableName() {
		return "board_info";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}
