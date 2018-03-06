package services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.PlayerBoard;
import template.DaoFactory;

public class PlayerBoardServices {
	public static int Insert(PlayerBoard playerBoard) {
		return insert(null, playerBoard);
	}
	
	private static int insert(SessionFactory factory, PlayerBoard playerBoard) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("[Player Board Services] factory null");
				return -1;
			}
		}
		
		if (playerBoard == null) {
			System.out.println("[Player Board Services] player board null");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.save(playerBoard);
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
	
	public static int Update(PlayerBoard playerBoard) {
		return update(null, playerBoard);
	}
	
	private static int update(SessionFactory factory, PlayerBoard playerBoard) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("[Player BOard Services] factory null");
				return -1;
			}
		}
		
		if (playerBoard == null) {
			System.out.println("[Player Board Services] player board null");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.update(playerBoard);
			trans.commit();
			System.out.println("update player board successfully");
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
	
	public static PlayerBoard Select(int playerBoardId) {
		return select(null, playerBoardId);
	}
	
	private static PlayerBoard select(SessionFactory factory, int playerBoardId) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("player board services: factory null");
				return null;
			}
		}
		
		if (playerBoardId <= 0) {
			System.out.println("player board services: player null");
			return null;
		}
		
		PlayerBoard playerBoard = null;
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			playerBoard = (PlayerBoard) session.get(PlayerBoard.class, playerBoardId);
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return playerBoard;
	}	
}
