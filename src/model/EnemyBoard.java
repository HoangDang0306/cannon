package model;

import enums.BoardEnum;
import template.DaoValue;
import utility.CommonDefine;
import utility.CommonMethod;

public class EnemyBoard extends DaoValue {
	private int id;
	private int matchId;
	private int cannon1;
	private int cannon2;
	private int cannon3;
	private int cannon4;
	private int cannon5;
	private int cannon6;
	private int cannon7;
	private int status;
	
	public EnemyBoard() {
	}

	public EnemyBoard(int matchId) {
		this.matchId = matchId;
		initCannon();
		sync();
	}
	
	public EnemyBoard(int cannon1, int cannon2, int cannon3, int cannon4, int cannon5, int cannon6, int cannon7, BoardEnum boardEnum) {
		this.cannon1 = cannon1;
		this.cannon2 = cannon2;
		this.cannon3 = cannon3;
		this.cannon4 = cannon4;
		this.cannon5 = cannon5;
		this.cannon6 = cannon6;
		this.cannon7 = cannon7;
		this.status = boardEnum.ordinal();
		
		sync();
	}
	
	public void initCannon() {
		int num = CommonDefine.MAX_NUMBER_BLOCK_CANNON;
		this.cannon1 = CommonMethod.random(num);
		this.cannon2 = CommonMethod.random(num);
		this.cannon3 = CommonMethod.random(num);
		this.cannon4 = CommonMethod.random(num);
		this.cannon5 = CommonMethod.random(num);
		this.cannon6 = CommonMethod.random(num);
		this.cannon7 = CommonMethod.random(num);
		this.status = BoardEnum.READY.ordinal();
	}
	
	public int getCannon1() {
		return cannon1;
	}
	public void setCannon1(short cannon1) {
		this.cannon1 = cannon1;
	}
	public int getCannon2() {
		return cannon2;
	}
	public void setCannon2(short cannon2) {
		this.cannon2 = cannon2;
	}
	public int getCannon3() {
		return cannon3;
	}
	public void setCannon3(short cannon3) {
		this.cannon3 = cannon3;
	}
	public int getCannon4() {
		return cannon4;
	}
	public void setCannon4(short cannon4) {
		this.cannon4 = cannon4;
	}
	public int getCannon5() {
		return cannon5;
	}
	public void setCannon5(short cannon5) {
		this.cannon5 = cannon5;
	}
	public int getCannon6() {
		return cannon6;
	}
	public void setCannon6(short cannon6) {
		this.cannon6 = cannon6;
	}
	public int getCannon7() {
		return cannon7;
	}
	public void setCannon7(short cannon7) {
		this.cannon7 = cannon7;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return this.status;
	}
	public void setStatus(BoardEnum boardEnum) {
		this.status = boardEnum.ordinal();
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	@Override
	public String getTableName() {
		return "enemy_board_info";
	}

	@Override
	public String getPrimaryKey() {
		return "id";
	}
}
