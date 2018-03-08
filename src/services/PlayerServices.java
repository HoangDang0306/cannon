package services;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Player;
import template.DaoFactory;

public class PlayerServices {
	public static Player getPlayerByID(int id) {
		return select(null, id);
	}
	
	public static Player getPlayerByName(String name) {
		return select(null, name);
	}
	
//	public static List<Player> getListPlayer() {
//		
//	}
	
	private static Player select(SessionFactory factory, int id) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("player services: factory null 1");
				return null;
			}
		}
		
		if (id <= 0) {
			System.out.println("player services: player null");
			return null;
		}
		
		Player player = null;
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			player = (Player) session.get(Player.class, id);
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return player;
	}
	
	private static Player select(SessionFactory factory, String name) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("player services: factory null 2");
				return null;
			}
		}
		
		if (StringUtils.isEmpty(name)) {
			System.out.println("player services: player name null");
			return null;
		}
		
		Player player = null;
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			@SuppressWarnings("rawtypes")
			List listPlayer = session.createQuery("FROM Player").list();
			for (int i = 0; i < listPlayer.size(); i++) {
				if (listPlayer.get(i) instanceof Player) {
					Player p = (Player) listPlayer.get(i);
					if (p.getName().equals(name)) {
						player = p;
					}
				}
			}
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return player;
	}
	
	public static int Insert(Player player) {
		return insert(null, player);
	}
	
	public static int Insert(List<Player> listPlayer) {
		return insert(null, listPlayer);
	}
	
	private static int insert(SessionFactory factory, Player player) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("player services: factory null 3");
				return -1;
			}
		}
		
		if (player == null) {
			System.out.println("player services: player null");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.save(player);
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
	
	private static int insert(SessionFactory factory, List<Player> listPlayer) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("player services: factory null 4");
				return -1;
			}
		}
		
		if (listPlayer == null) {
			System.out.println("player services: list player null");
			return -1;
		}
		
		if (listPlayer.isEmpty()) {
			System.out.println("player services: player list empty");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			for (int i = 0; i < listPlayer.size(); i++) {
				session.save(listPlayer.get(i));
			}
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
	
	public static int Update(Player player) {
		return update(null, player);
	}
	
	public static int Update(List<Player> listPlayer) {
		return update(null, listPlayer);
	}
	
	private static int update(SessionFactory factory, Player player) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("player services: factory null 5");
				return -1;
			}
		}
		
		if (player == null) {
			System.out.println("player services: player null");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.update(player);
			trans.commit();
			System.out.println("update player successfully");
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

	private static int update(SessionFactory factory, List<Player> listPlayer) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("player services: factory null 6");
				return -1;
			}
		}
		
		if (listPlayer == null || listPlayer.isEmpty()) {
			System.out.println("player services: list player null | empty");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			for (int i = 0; i < listPlayer.size(); i++) {
				session.update(listPlayer.get(i));
			}
			trans.commit();
			System.out.println("update list player successfully");
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

	public static int Delete(Player player) {
		return delete(null, player);
	}
	
	public static int Delete(List<Player> listPlayer) {
		return delete(null, listPlayer);
	}
	
	private static int delete(SessionFactory factory, Player player) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("player services: factory null 7");
				return -1;
			}
		}
		
		if (player == null) {
			System.out.println("player services: player null");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			session.delete(player);
			trans.commit();
			System.out.println("delete player successfully");
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
	
	private static int delete(SessionFactory factory, List<Player> listPlayer) {
		if (factory == null) {
			factory = DaoFactory.getSessionFactory();
			if (factory == null) {
				System.out.println("player services: factory null 8");
				return -1;
			}
		}
		
		if (listPlayer == null || listPlayer.isEmpty()) {
			System.out.println("player services: player null | empty");
			return -1;
		}
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		try {
			for (int i = 0; i < listPlayer.size(); i++) {
				session.delete(listPlayer.get(i));
			}
			trans.commit();
			System.out.println("delete list player successfully");
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
