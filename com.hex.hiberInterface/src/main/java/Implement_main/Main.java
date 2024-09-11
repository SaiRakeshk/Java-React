package Implement_main;

import java.util.Scanner;

import Service.Service;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Service s= new Service();
		
		while(true) {
			System.out.println("1. To SignIn");
			System.out.println("2. To SignUp");
			System.out.println("3. To remove Account.");
			System.out.println("4. To Update Account.");
			System.out.println("5. To remove Account by HQL.");
			System.out.println("6. To update Password by HQL.");
			System.out.println("0. To exit");
			int ch=sc.nextInt();
			if(ch==1) {
				s.SignIn();
			}
			else if(ch==2){
				s.signUp();
			}
			else if(ch==3) {
				s.removeAccount();
			}
			else if (ch==4) {
				s.updatePassword();
			}
			else if (ch==5) {
				s.removeHQl();
			}
			else if (ch==6) {
				s.updateHQL();
			}
			else if(ch==0) {
				break;
			}
			else {
				continue;
			}
		}
	}
}
