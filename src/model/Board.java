package model;

import enums.BoardStatusEnum;
import enums.GameSideEnum;
import tbl.info.TblBoardInfo;

public class Board {
	private TblBoardInfo tblPlayerBoard;
	
	public Board() {}
	
	public Board(TblBoardInfo tblBoardInfo) {
		this.tblPlayerBoard = tblBoardInfo;
	}
	
	public TblBoardInfo getTblBoardInfo() {
		return this.tblPlayerBoard;
	}
	
	public void setTblBoardInfo(TblBoardInfo tblBoardInfo) {
		this.tblPlayerBoard = tblBoardInfo;
	}
	
	public int getId() {
		return (Integer) tblPlayerBoard.Get("id");
	}
	
	public int getMatchId() {
		return (Integer) tblPlayerBoard.Get("matchId");
	}
	
	public void setMatchId(int matchId) {
		this.tblPlayerBoard.Set("matchId", matchId);
	}
	
	public GameSideEnum getSide() {
		return GameSideEnum.getSide((Integer) this.tblPlayerBoard.Get("side"));
	}
	
	public void setSide(GameSideEnum sideEnum) {
		this.tblPlayerBoard.Set("matchId", sideEnum.ordinal());
	}
	
	public int getCannon1() {
		return (Integer) tblPlayerBoard.Get("cannon1");
	}
	
	public void setCannon1(int cannon1) {
		this.tblPlayerBoard.Set("cannon1", cannon1);
	}
	
	public int getCannon2() {
		return (Integer) tblPlayerBoard.Get("cannon2");
	}
	
	public void setCannon2(int cannon2) {
		this.tblPlayerBoard.Set("cannon2", cannon2);
	}
	
	public int getCannon3() {
		return (Integer) tblPlayerBoard.Get("cannon3");
	}
	
	public void setCannon3(int cannon3) {
		this.tblPlayerBoard.Set("cannon3", cannon3);
	}
	
	public int getCannon4() {
		return (Integer) tblPlayerBoard.Get("cannon4");
	}
	
	public void setCannon4(int cannon4) {
		this.tblPlayerBoard.Set("cannon4", cannon4);
	}
	
	public int getCannon5() {
		return (Integer) tblPlayerBoard.Get("cannon5");
	}
	
	public void setCannon5(int cannon5) {
		this.tblPlayerBoard.Set("cannon5", cannon5);
	}
	
	public int getCannon6() {
		return (Integer) tblPlayerBoard.Get("cannon6");
	}
	
	public void setCannon6(int cannon6) {
		this.tblPlayerBoard.Set("cannon6", cannon6);
	}
	
	public int getCannon7() {
		return (Integer) tblPlayerBoard.Get("cannon7");
	}
	
	public void setCannon7(int cannon7) {
		this.tblPlayerBoard.Set("cannon7", cannon7);
	}
	
	public BoardStatusEnum getStatus() {
		return BoardStatusEnum.getStatus((Integer) tblPlayerBoard.Get("status"));
	}
	
	public void setCannon1(BoardStatusEnum status) {
		this.tblPlayerBoard.Set("cannon1", status.ordinal());
	}
}
