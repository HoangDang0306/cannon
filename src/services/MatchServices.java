package services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Match;
import template.DaoFactory;

public class MatchServices {
	public static int Insert(Match match) {
		return insert(null, match);
	}
	
	private static int insert(SessionFactory factory, Match match) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("[Match Services] factory null");
				return -1;
			}
		}
		
		if (match == null) {
			System.out.println("[Match Services] match null");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.save(match);
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
	
	public static int Update(Match match) {
		return update(null, match);
	}
	
	private static int update(SessionFactory factory, Match match) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("[Match Services] factory null");
				return -1;
			}
		}
		
		if (match == null) {
			System.out.println("[Match Services] match null");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.update(match);
			trans.commit();
			System.out.println("[Match Services] update match successfully");
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
	
	public static Match Select(int matchId) {
		return select(null, matchId);
	}
	
	private static Match select(SessionFactory factory, int matchId) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("[Match Services]: factory null");
				return null;
			}
		}
		
		if (matchId <= 0) {
			System.out.println("[Match Services]: match null");
			return null;
		}
		
		Match match = null;
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			match = (Match) session.get(Match.class, matchId);
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return match;
	}
}
