package template;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utility.GameLog;

public class CommonDaoFactory {
	public static int Insert(DaoValue daoValue) {
		return insert(null, daoValue);
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
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.save(daoValue);
			trans.commit();
			GameLog.getInstance().info(daoValue.getInsertQuery());
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return 0;
	}
}
