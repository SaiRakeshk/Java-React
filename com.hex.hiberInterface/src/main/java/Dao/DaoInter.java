package Dao;



public interface DaoInter {
	 boolean signUp(int userId, String userPass,String email);
	 boolean SignIn( int userId, String userPass);
	 boolean removeAccount(int userId);
	 boolean updatePassword(int userId, String newPass);
	 boolean removeHQL(int userId);
	 public boolean updateHQL(int userId,String newPass) ;
}
