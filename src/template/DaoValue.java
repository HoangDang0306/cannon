package template;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

public abstract class DaoValue implements Cloneable {
	public abstract String getTableName();
	public abstract String getPrimaryKey();
	
	private DaoValue clone;
	public DaoValue getClone() {
		return this.clone;
	};
	
	public DaoValue() {
		sync();
	}
	
	public Object Get(String name) {
		Field[] fields = getClass().getDeclaredFields();
		
		for (Field field : fields) {
			field.setAccessible(true);
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
		Field[] fields = getClass().getDeclaredFields();
		
		for (Field field : fields) {
			field.setAccessible(true);
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
	
	public void sync() {
		try {
			clone = (DaoValue) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getInsertQuery() {
		Field[] fields = getClass().getDeclaredFields();
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + getTableName() + " VALUES (");
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (fields[i].getName().equals("clone")) {
				continue;
			} else if (fields[i].getName().equals(getPrimaryKey())) {
				sb.append("DEFAULT, ");
			} else {
				if (this.Get(fields[i].getName()) == null) {
					if (i < fields.length - 1) {
						sb.append("'', ");
					} else {
						sb.append("''");
					}
				} else {
					if (i < fields.length - 1) {
						sb.append(this.Get(fields[i].getName()) + ", ");
					} else {
						sb.append(this.Get(fields[i].getName()));
					}
				}
			}
		}
		sb.append(")");
		
		return sb.toString();
	};
	
	public String getSelectQuery() {
		Field[] fields = getClass().getDeclaredFields();

		StringBuilder query = new StringBuilder();
		query.append("FROM ");
		query.append(getClass().getSimpleName());
		query.append(" WHERE ");
		
		StringBuilder values = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (fields[i].getName().equals("id")) {
				if (Integer.parseInt(this.Get(fields[i].getName()).toString()) == 0) {
					continue;
				}
			}
			
			if (this.Get(fields[i].getName()) != null) {
				if (!this.Get(fields[i].getName()).equals(clone.Get(fields[i].getName()))) {
					if (values.toString().isEmpty()) {
						values.append(fields[i].getName() + " = '" + this.Get(fields[i].getName()) + "'");
					} else {
						values.append(" AND " + fields[i].getName() + " = '" + this.Get(fields[i].getName()) + "'");
					}
				}
			} 
		}
		
		query.append(values.toString());
		
		return query.toString();
	}
	
	public String getUpdateQuery() {
		Field[] fields = getClass().getDeclaredFields();
		
		DaoValue clone = getClone();
		
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + getTableName() + " SET ");
		
		StringBuilder values = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (fields[i].getName().equals("clone")) {
				continue;
			} else if (fields[i].getName().equals(getPrimaryKey())) {
				continue;
			} else if (Get(fields[i].getName()).equals(getClone().Get(fields[i].getName()))) {
				continue;
			} else {
				if (StringUtils.isEmpty(values.toString())) {
					values.append(fields[i].getName() + " = " + Get(fields[i].getName()));
				} else {
					values.append(", " + fields[i].getName() + " = " + Get(fields[i].getName()));
				}
			}
		}
		
		if (StringUtils.isEmpty(values.toString())) {
			return "";
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
			} else if (this.Get(fields[i].getName()).equals(clone.Get(fields[i].getName()))) {
				continue;
			} else {
				if (StringUtils.isEmpty(values.toString())) {
					values.append(fields[i].getName() + " = " + clone.Get(fields[i].getName()));
				} else {
					values.append(" AND " + fields[i].getName() + " = " + clone.Get(fields[i].getName()));
				}
			}
		}
		
		sb.append(values.toString());
		
		return sb.toString();
	};
	
//	public String getDeleteQuery() {};
}
