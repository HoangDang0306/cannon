package template;

public class DaoValue extends Object {
	public String TABLE_NAME;
	public String PRIMARY_KEY;
	
	public String getTableName() {
		return TABLE_NAME;
	}
	
	public void setTableName(String tableName) {
		TABLE_NAME = tableName;
	}
	
	public String getPrimaryKey() {
		return PRIMARY_KEY;
	}
	
	public void setPrimaryKey(String primaryKey) {
		PRIMARY_KEY = primaryKey;
	}
}
