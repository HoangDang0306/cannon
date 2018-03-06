package model;

import java.util.Date;

import template.DaoValue;
import utility.CommonDefine;
import utility.CommonMethod;

public class Player extends DaoValue {
	private int id;
	private String name;
	private String password;
	private String created;
	private String updated;
	private int match;
	
	public Player() {
		
	}
	
	public Player(String user, String pass) {
		this.name = user;
		this.password = pass;
		this.created = CommonMethod.getDateString(new Date(), CommonDefine.DATE_NORMAL_DAY);
		this.updated = CommonMethod.getDateString(new Date(), CommonDefine.DATE_NORMAL_DAY);
		this.match = 0;
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
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public int getCurrentMatch() {
		return match;
	}
	public void setCurrentMatch(int currentMatch) {
		this.match = currentMatch;
	}
}
