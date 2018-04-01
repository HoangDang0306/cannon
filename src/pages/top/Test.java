package pages.top;

import tbl.info.TblPlayerInfo;
import template.CommonDaoFactory;

public class Test {
	public static void main(String[] aaa) {
		TblPlayerInfo tbl = new TblPlayerInfo();
		tbl.Set("name", "hahahahahahahaha");
		
		
		System.out.println(tbl.getId() + " truoc");
		CommonDaoFactory.Insert(tbl);
		System.out.println(tbl.getId() + " sau");
	}
}
