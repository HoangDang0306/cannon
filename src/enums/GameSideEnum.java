package enums;

public enum GameSideEnum {
	NONE,
	ENEMY,
	PLAYER;
	
	public static GameSideEnum getSide(int side) {
		for(GameSideEnum sideEnum : GameSideEnum.values()) {
			if (side == sideEnum.ordinal()) {
				return sideEnum;
			}
		}
		return GameSideEnum.NONE;
	}
}
