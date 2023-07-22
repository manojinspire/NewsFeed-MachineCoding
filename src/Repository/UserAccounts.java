package Repository;

import java.util.HashMap;
import java.util.Map;

import Exception.UsernameExist;
import Models.User;

public class UserAccounts {

	static UserAccounts accounts;
	
	private  Map<String,User> usersbyUsername = new HashMap<String, User>();
	
	private Map<Integer, User> indexbyID  = new HashMap<Integer, User>() ; 
	public static UserAccounts getInstance() {
		
		
		if(accounts == null) {
			accounts = new UserAccounts(); 
		}
		return accounts;
		
	}
	public void save(User user) throws Exception {
		
		
		
			if(usersbyUsername.containsKey(user.getUsername())) {
				throw new UsernameExist("username already exists try with new username") ; 
			}
			else {
				usersbyUsername.put(user.getUsername() , user) ; 
				indexbyID.put(user.getId(), user) ; 
			}
			
	}
	public Map<String, User> getUsersbyUsername() {
		return usersbyUsername;
	}
	public void setUsersbyUsername(Map<String, User> usersbyUsername) {
		this.usersbyUsername = usersbyUsername;
	}
	public Map<Integer, User> getIndexbyID() {
		return indexbyID;
	}
	public void setIndexbyID(Map<Integer, User> indexbyID) {
		this.indexbyID = indexbyID;
	}
	
	
	
	
	
	
	


	
	
}
