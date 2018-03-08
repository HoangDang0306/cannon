package template;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

public abstract class DaoValue {
	public abstract String getTableName();
	public abstract String getPrimaryKey();
	
	public abstract DaoValue getClone();
	
	public Object Get(String name) {
		Field[] fields = getClass().getFields();
		
		for (Field field : fields) {
			if (field.getName().equals(name)) {
				try {
					return field.get(this);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	public void Set(String name, Object obj) {
		Field[] fields = getClass().getFields();
		
		for (Field field : fields) {
			if (field.getName().equals(name)) {
				try {
					field.set(this, obj);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	public String getInsertQuery() {
		Field[] fields = getClass().getFields();
		
		DaoValue clone = getClone();
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + getTableName() + " VALUES (");
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (fields[i].getName().equals("clone") || fields[i].getName().equals("TABLE_NAME") /*|| fields[i].getName().equals("PRIMARY_KEY")*/) {
				continue;
			} else if (fields[i].getName().equals(getPrimaryKey())) {
				sb.append("DEFAULT, ");
			} else {
				if (clone.Get(fields[i].getName()) == null || StringUtils.isEmpty(clone.Get(fields[i].getName()).toString()) || clone.Get(fields[i].getName()).equals("NULL") || clone.Get(fields[i].getName()).equals("null")) {
					System.out.println();
					if (i < fields.length - 1) {
						sb.append("'', ");
					} else {
						sb.append("''");
					}
				} else {
					if (i < fields.length - 1) {
						sb.append(clone.Get(fields[i].getName()) + ", ");
					} else {
						sb.append(clone.Get(fields[i].getName()));
					}
				}
			}
		}
		sb.append(")");
		
		return sb.toString();
	};
	
	public String getSelectQuery() {
		Field[] fields = getClass().getFields();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM " + getTableName() + " WHERE ");
		
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (fields[i].getName().equals("clone") || fields[i].getName().equals("TABLE_NAME") || fields[i].getName().equals("PRIMARY_KEY")) {
				continue;
			} else if (fields[i].getName().equals(getPrimaryKey())) {
				continue;
			} else if (Get(fields[i].getName()) == getClone().Get(fields[i].getName().toString())) {
				continue;
			} else {
				if (i < fields.length - 1) {
					sb.append(fields[i].getName() + " = " + Get(fields[i].getName()) + ", ");
				} else {
					sb.append(fields[i].getName() + " = " + Get(fields[i].getName()));
				}
			}
		}
		
		return sb.toString();
	};
	
	public String getUpdateQuery() {
		Field[] fields = getClass().getFields();
		
		DaoValue clone = getClone();
		
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + getTableName() + " SET ");
		
		StringBuilder values = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (fields[i].getName().equals("clone") || fields[i].getName().equals("TABLE_NAME") || fields[i].getName().equals("PRIMARY_KEY")) {
				continue;
			} else if (fields[i].getName().equals(getPrimaryKey())) {
				continue;
			} else if (Get(fields[i].getName()) == getClone().Get(fields[i].getName().toString())) {
				continue;
			} else {
				if (StringUtils.isEmpty(values.toString())) { //first value
					values.append(fields[i].getName() + " = " + Get(fields[i].getName()));
				} else {
					values.append(", " + fields[i].getName() + " = " + Get(fields[i].getName()));
				}
			}
		}
		
		sb.append(values.toString());
		sb.append(" WHERE ");
		
		values = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (fields[i].getName().equals("clone") || fields[i].getName().equals("TABLE_NAME") || fields[i].getName().equals("PRIMARY_KEY")) {
				continue;
			} else if (fields[i].getName().equals(getPrimaryKey())) {
				continue;
			} else if (Get(fields[i].getName()) == getClone().Get(fields[i].getName().toString())) {
				continue;
			} else {
				if (StringUtils.isEmpty(values.toString())) { //first value
					values.append(fields[i].getName() + " = " + clone.Get(fields[i].getName()));
				} else {
					values.append(", " + fields[i].getName() + " = " + clone.Get(fields[i].getName()));
				}
			}
		}
		
		sb.append(values.toString());
		
		return sb.toString();
	};
	
//	public String getDeleteQuery() {};
}
