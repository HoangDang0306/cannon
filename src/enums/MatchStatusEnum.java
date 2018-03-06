package enums;

public enum MatchStatusEnum {
	NONE(0, "none"),
	PREPARE(1, "prepare"),
	PLAYING(2, "playing"),
	FINISHED(3, "finished");
	
	private int id;
	private String describe;
	
	MatchStatusEnum(int id, String describe) {
		this.id = id;
		this.describe = describe;
	}
	
	public int getId() {
		return id;
	}
	
	public static int getValue(MatchStatusEnum matchStatus) {
		for (MatchStatusEnum status : MatchStatusEnum.values()) {
			if (matchStatus.equals(status)) {
				return status.id;
			}
		}
		
		return MatchStatusEnum.NONE.id;
	}
	
	public static MatchStatusEnum getStatus(int id) {
		for (MatchStatusEnum status : MatchStatusEnum.values()) {
			if (status.id == id) {
				return status;
			}
		}
		
		return MatchStatusEnum.NONE;
	}
	
	public String getDescribe(MatchStatusEnum matchStatus) {
		for (MatchStatusEnum status : MatchStatusEnum.values()) {
			if (matchStatus.equals(status)) {
				return status.describe;
			}
		}
		
		return MatchStatusEnum.NONE.describe;
	}
}
