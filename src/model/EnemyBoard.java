package model;

import template.DaoValue;

public class EnemyBoard extends DaoValue {
	private int id;
	private short cannon1;
	private short cannon2;
	private short cannon3;
	private short cannon4;
	private short cannon5;
	private short cannon6;
	private short cannon7;
	
	public EnemyBoard() {
		
	}
	
	public EnemyBoard(short cannon1, short cannon2, short cannon3, short cannon4, short cannon5, short cannon6, short cannon7) {
		this.cannon1 = cannon1;
		this.cannon2 = cannon2;
		this.cannon3 = cannon3;
		this.cannon4 = cannon4;
		this.cannon5 = cannon5;
		this.cannon6 = cannon6;
		this.cannon7 = cannon7;
	}
	
	public short getCannon1() {
		return cannon1;
	}
	public void setCannon1(short cannon1) {
		this.cannon1 = cannon1;
	}
	public short getCannon2() {
		return cannon2;
	}
	public void setCannon2(short cannon2) {
		this.cannon2 = cannon2;
	}
	public short getCannon3() {
		return cannon3;
	}
	public void setCannon3(short cannon3) {
		this.cannon3 = cannon3;
	}
	public short getCannon4() {
		return cannon4;
	}
	public void setCannon4(short cannon4) {
		this.cannon4 = cannon4;
	}
	public short getCannon5() {
		return cannon5;
	}
	public void setCannon5(short cannon5) {
		this.cannon5 = cannon5;
	}
	public short getCannon6() {
		return cannon6;
	}
	public void setCannon6(short cannon6) {
		this.cannon6 = cannon6;
	}
	public short getCannon7() {
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

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoValue getClone() {
		// TODO Auto-generated method stub
		return null;
	}
}
