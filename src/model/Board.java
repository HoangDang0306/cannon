package model;

import java.util.ArrayList;

import enums.BoardStatusEnum;
import enums.GameSideEnum;
import tbl.info.TblBoardInfo;
import utility.CommonDefine;
import utility.CommonMethod;

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
	
	public int getCannon8() {
		return (Integer) tblPlayerBoard.Get("cannon7");
	}
	
	public void setCannon8(int cannon8) {
		this.tblPlayerBoard.Set("cannon8", cannon8);
	}
	
	public BoardStatusEnum getStatus() {
		return BoardStatusEnum.getStatus((Integer) tblPlayerBoard.Get("status"));
	}
	
	public void setStatus(BoardStatusEnum status) {
		this.tblPlayerBoard.Set("cannon1", status.ordinal());
	}
	
	public void initCannon() {
		setCannon1(CommonMethod.random(CommonDefine.MAX_VALUE_BLOCK_INIT_CANNON));
		setCannon2(CommonMethod.random(CommonDefine.MAX_VALUE_BLOCK_INIT_CANNON));
		setCannon3(CommonMethod.random(CommonDefine.MAX_VALUE_BLOCK_INIT_CANNON));
		setCannon4(CommonMethod.random(CommonDefine.MAX_VALUE_BLOCK_INIT_CANNON));
		setCannon5(CommonMethod.random(CommonDefine.MAX_VALUE_BLOCK_INIT_CANNON));
		setCannon6(CommonMethod.random(CommonDefine.MAX_VALUE_BLOCK_INIT_CANNON));
		setCannon7(CommonMethod.random(CommonDefine.MAX_VALUE_BLOCK_INIT_CANNON));
	}
	
	public void initCannonMouth() {
		
	}
	
	/*
	 * return array of ready cannon
	 */
	public ArrayList<Integer> getReadyCannonMouth() {
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < CommonDefine.MAX_NUMBER_CANNON; i++) {
			if (isCannonReady(i + 1)) {
				array.add(i + 1);
			}
		}
		
		return array;
	}
	
	public boolean isCannonReady(int index) {
		String cannonName = "cannon" + index;
		int value = (Integer) tblPlayerBoard.Get(cannonName);
		int a = value & 1 << 1;
		int b = value & 1;
		
		return (a != 0 && b != 0) || (a == 0 && b == 0);
	}
	
	public void fire(int index) {
		
	}
	
	/*
	 * @input index of Cannon 1 - 7
	 * @output number ready block of that cannon
	 */
	public int getNumberReadyBlockOfCannon(int index) {
		if (!isCannonReady(index)) {
			return 0;
		}
		
		String cannonName = "cannon" + index;
		int value = (Integer) this.tblPlayerBoard.Get(cannonName);
		
		int check = value & 1;
		int count = 0;
		while (((value >> 1) & 1) == check) {
			count++;
			value = value >> 1;
		}
		return count;
	}
	
	public void beDamage(int index) {
		int indexBeDamage = CommonMethod.random(CommonDefine.MAX_NUMBER_BLOCK_EACH_CANNON);
		
		String cannonName = "cannon" + index;
		int value = (Integer) this.tblPlayerBoard.Get(cannonName);
		
		value = value | 1 << (CommonDefine.MAX_NUMBER_BLOCK_EACH_CANNON + indexBeDamage);
		
		this.tblPlayerBoard.Set(cannonName, value);
	}
}
