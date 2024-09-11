package Dao;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conne.Connt;
import Model.Login;

public class Dao implements DaoInter {

	Scanner sc, sc1;
	SessionFactory f;

	public Dao() {
		f = Connt.getSessionFact();

		sc = new Scanner(System.in);
		sc1 = new Scanner(System.in);

	}

	public boolean signUp(int userId, String userPass, String email) {
		try {
			Session ses = f.openSession();
			Transaction tx = ses.beginTransaction();
			Login l = new Login(userId, userPass, email);
			ses.save(l);
			tx.commit();
			ses.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean SignIn(int userId, String userPass) {
		try {
			Session ses = f.openSession();
			Transaction tx = ses.beginTransaction();
			Login l = ses.get(Login.class, userId);
			if ((l != null) && l.getUserPass().equals(userPass)) {
				ses.close();
				return true;
			}
			ses.close();
			return false;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());

			return false;
		}
	}

	@Override
	public boolean removeAccount(int userId) {
		try {
			Session ses = f.openSession();
			Transaction tx = ses.beginTransaction();
			Login l = ses.get(Login.class, userId);
			if (l != null) {
				ses.delete(l);
				tx.commit();
				ses.close();
				return true;
			}
			ses.close();
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());

			return false;
		}

	}

	public boolean removeHQL(int userId) {
		Session ses = f.openSession();
		Transaction tx = ses.beginTransaction();

		String hql = "delete from Login l where l.userId=:bn ";

		Query q = ses.createQuery(hql);

		q.setParameter("bn", userId);

		
		q.executeUpdate();
		tx.commit();
		return true;
		
		

	}
	public boolean updateHQL(int userId,String newPass) {
		Session ses = f.openSession();
		Transaction tx = ses.beginTransaction();

		String hql = "update from Login l set l.userPass=:nm where l.userId=:bn ";

		Query q = ses.createQuery(hql);
		q.setParameter("nm", newPass);
		q.setParameter("bn", userId);

		q.executeUpdate();
		tx.commit();
		return true;
		
		

	}

	@Override
	public boolean updatePassword(int userId, String newPass) {
		try {
			Session ses = f.openSession();
			Transaction tx = ses.beginTransaction();
			Login l = ses.get(Login.class, userId);
			if (l != null) {
				l.setUserPass(newPass);
				ses.update(l);
				tx.commit();
				ses.close();
				return true;
			}
			ses.close();
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());

			return false;
		}
	}

}
