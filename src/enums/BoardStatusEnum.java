package enums;

public enum BoardStatusEnum {
	NONE,
	READY,
	PLAYING,
	FINISHED;
	
	public static BoardStatusEnum getStatus(int status) {
		for(BoardStatusEnum boardEnum : BoardStatusEnum.values()) {
			if (status == boardEnum.ordinal()) {
				return boardEnum;
			}
		}
		return BoardStatusEnum.NONE;
	}
}
