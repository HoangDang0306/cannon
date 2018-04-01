package services;

import java.util.List;

import model.Board;
import tbl.info.TblBoardInfo;
import template.CommonDaoFactory;
import template.DaoValue;

public class BoardServices {
	public static Board getBoardById(int id) {
		TblBoardInfo tblBoardInfo = new TblBoardInfo();
		tblBoardInfo.setId(id);
		
		List<DaoValue> list = CommonDaoFactory.Select(tblBoardInfo);
		if (list == null) {
			return null;
		}
		if (list.isEmpty()) {
			return null;
		}
		
		tblBoardInfo = (TblBoardInfo) list.get(0);
		
		return new Board(tblBoardInfo);
	}
}
