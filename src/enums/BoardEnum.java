package enums;

public enum BoardEnum {
	NONE,
	READY,
	PLAYING,
	FINISHED;
	
	public static BoardEnum getStatus(int status) {
		for(BoardEnum boardEnum : BoardEnum.values()) {
			if (status == boardEnum.ordinal()) {
				return boardEnum;
			}
		}
		return BoardEnum.NONE;
	}
}
