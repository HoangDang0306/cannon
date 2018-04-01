package services;

import java.util.List;

import model.Match;
import tbl.info.TblMatchInfo;
import template.CommonDaoFactory;
import template.DaoValue;

public class MatchServices {
	public static Match getMatchById(int id) {
		TblMatchInfo tblMatchInfo = new TblMatchInfo();
		tblMatchInfo.setId(id);
		
		List<DaoValue> list = CommonDaoFactory.Select(tblMatchInfo);
		if (list == null) {
			return null;
		}
		
		if (list.isEmpty()) {
			return null;
		}
		
		tblMatchInfo = (TblMatchInfo) list.get(0);
		
		return new Match(tblMatchInfo);
	}
}
