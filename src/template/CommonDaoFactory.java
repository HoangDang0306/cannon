package template;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utility.GameLog;

public class CommonDaoFactory {
	public static int Insert(DaoValue daoValue) {
		return insert(null, daoValue);
	}
	
	public static int Insert(List<DaoValue> listDaoValue) {
		return insert(null, listDaoValue);
	}
	
	private static int insert(SessionFactory factory, List<DaoValue> listDaoValue) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				GameLog.getInstance().info("CommonDaoFactory: factory null");
				return -1;
			}
		}
		
		if (listDaoValue == null || listDaoValue.isEmpty()) {
			GameLog.getInstance().info("CommonDaoFactory: list dao value empty");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			GameLog.getInstance().info("Transaction begin");
			for(DaoValue daoValue : listDaoValue) {
				session.save(daoValue);
				GameLog.getInstance().info(daoValue.getInsertQuery());
			}
			trans.commit();
			GameLog.getInstance().info("Transaction close " + 0);
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			GameLog.getInstance().info("Transaction close " + -1);
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return 0;
	}
	
	private static int insert(SessionFactory factory, DaoValue daoValue) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				GameLog.getInstance().info("CommonDaoFactory: factory null");
				return -1;
			}
		}
		
		if (daoValue == null) {
			GameLog.getInstance().info("CommonDaoFactory: daoValue null");
			return -1;
		}
		
		int result = 0;
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			GameLog.getInstance().info("Transaction begin");
			result = (Integer) session.save(daoValue);
			trans.commit();
			GameLog.getInstance().info(daoValue.getInsertQuery());
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
			return -1;
		} finally {
			GameLog.getInstance().info("Transaction close " + result);
			session.close();
		}
		
		return result;
	}

	public static int Select(DaoValue daoValue) {
		return 0;
		
	}
	
	public static int Select(List<DaoValue> listDaoValue) {
		
		return 0;
	}
	
//	private static DaoValue select(SessionFactory factory, DaoValue daoValue) {
//		if (factory == null) {
//			factory = DaoFactory.getSessionFactory();
//			if (factory == null) {
//				GameLog.getInstance().info("CommonDaoFactory: factory null");
//				return -1;
//			}
//		}
//		
//		if (daoValue == null) {
//			GameLog.getInstance().info("CommonDaoFactory: daoValue null");
//			return -1;
//		}
//		
//		Session session = factory.openSession();
//		Transaction trans = session.beginTransaction();
//		
//		try {
//			daoValue = session.get(DaoValue.class, daoValue.Get(name))
//			GameLog.getInstance().info(daoValue.getSelectQuery());
//		} catch (HibernateException e) {
//			if (trans != null) {
//				trans.rollback();
//			}
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		
//		return null;
//	}
}
