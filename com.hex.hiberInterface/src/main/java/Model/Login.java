package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="login")
public class Login {
	@Id
   private int userId;
   private String userPass;
   private String email;
   
   
public Login() {
	super();
}
public Login(int userId, String userPass, String email) {
	super();
	this.userId = userId;
	this.userPass = userPass;
	this.email = email;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserPass() {
	return userPass;
}
public void setUserPass(String userPass) {
	this.userPass = userPass;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
   
   
}
