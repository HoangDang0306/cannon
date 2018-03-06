package services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.EnemyBoard;
import template.DaoFactory;

public class EnemyBoardServices {
	public static int Insert(EnemyBoard enemyBoard) {
		return insert(null, enemyBoard);
	}
	
	private static int insert(SessionFactory factory, EnemyBoard enemyBoard) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("[Enemy Board Services] factory null");
				return -1;
			}
		}
		
		if (enemyBoard == null) {
			System.out.println("[Enemy Board Services] match null");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.save(enemyBoard);
			trans.commit();
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
	
	public static int Update(EnemyBoard enemyBoard) {
		return update(null, enemyBoard);
	}
	
	private static int update(SessionFactory factory, EnemyBoard enemyBoard) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("[Enemy Board Services] factory null");
				return -1;
			}
		}
		
		if (enemyBoard == null) {
			System.out.println("[Enemy Board Services] match null");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.update(enemyBoard);
			trans.commit();
			System.out.println("[Enemy Board Services] update Enemy Board successfully");
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
	
	public static EnemyBoard Select(int enemyBoardId) {
		return select(null, enemyBoardId);
	}
	
	private static EnemyBoard select(SessionFactory factory, int enemyBoardId) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("[Match Services]: factory null");
				return null;
			}
		}
		
		if (enemyBoardId <= 0) {
			System.out.println("[Match Services]: match null");
			return null;
		}
		
		EnemyBoard enemyBoard = null;
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			enemyBoard = (EnemyBoard) session.get(EnemyBoard.class, enemyBoardId);
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return enemyBoard;
	}

	public static void initEnemeBoard(EnemyBoard eBoard) {
		eBoard.setCannon1(randomInitCannon());
		eBoard.setCannon2(randomInitCannon());
		eBoard.setCannon3(randomInitCannon());
		eBoard.setCannon4(randomInitCannon());
		eBoard.setCannon5(randomInitCannon());
		eBoard.setCannon6(randomInitCannon());
		eBoard.setCannon7(randomInitCannon());
	}
	
	private static short randomInitCannon() {
		return 0;
	}
}
