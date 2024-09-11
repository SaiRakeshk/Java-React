package Service;

import java.util.Scanner;

import Dao.Dao;
import Dao.DaoInter;
import Model.Login;

public class Service {
	Scanner sc = new Scanner(System.in);
	DaoInter dao = new Dao();
	Login l = new Login();

	public void signUp() {
		System.out.println("Enter user Id");
		int userId1 = sc.nextInt();
		System.out.println("Enter Password");
		String userPass1 = sc.next();
		System.out.println("Enter Email");
		String email1 = sc.next();

		if (dao.signUp(userId1, userPass1, email1)) {
			System.out.println("Sign-Up successful");
		} else {
			System.out.println("Signup failed");

		}
	}

	public void SignIn() {
		System.out.println("Enter user Id");
		int userId2 = sc.nextInt();
		System.out.println("Enter Password");
		String userPass2 = sc.next();

		if (dao.SignIn(userId2, userPass2)) {
			System.out.println("Sign-In successful");
		} else {
			System.out.println("Signin failed");

		}
	}

	public void removeAccount() {
		System.out.println("Enter user Id");
		int userId2 = sc.nextInt();
		if (dao.removeAccount(userId2)) {
			System.out.println("Account deleted");
		} else {
			System.out.println("Invalid user Id");

		}

	}

	public void updatePassword() {
		System.out.println("Enter user Id");
		int userId2 = sc.nextInt();
		System.out.println("Enter Password to update ");
		String userPass2 = sc.next();
		if (dao.updatePassword(userId2, userPass2)) {
			System.out.println("Account updated");
		} else {
			System.out.println("Invalid user Id");

		}
	}
	public void removeHQl() {
		System.out.println("Enter user Id");
		int userId2 = sc.nextInt();
		if (dao. removeHQL(userId2)) {
			System.out.println("Account deleted");
		} else {
			System.out.println("Invalid user Id");

		}


}
	public void updateHQL() {
		System.out.println("Enter user Id");
		int userId2 = sc.nextInt();
		System.out.println("Enter Password to update ");
		String userPass2 = sc.next();
		if (dao.updatePassword(userId2, userPass2)) {
			System.out.println("Account updated");
		} else {
			System.out.println("Invalid user Id");

		}
	}
}
