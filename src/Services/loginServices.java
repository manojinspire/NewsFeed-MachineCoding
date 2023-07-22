package Services;

import Exception.InvalidLoginDetails;
import Exception.UserDoesnotExist;
import Models.User;


public class loginServices {
	
	static loginServices loginService ; 
	
	private static UsersAccountService users = UsersAccountService.getInstance();
	
	private loginServices(UsersAccountService users) {
		
		this.users =users;
	}
	
	public static loginServices getInstance() {
		if(loginService == null) {
			loginService = new loginServices(users) ; 
		}
		return loginService;
	}
	
	public User validate(String username , String password) throws Exception  {
		
		
		
			if((users.exists(username)&& !(users.getPassword(username).equals(password)))) {
				throw new InvalidLoginDetails("Invalid Login Details") ; 
			}
			else if(!users.exists(username)){
				throw new UserDoesnotExist("user is doesnot exist") ; 
			}
			return users.myprofile(username) ; 
			
		
	}

}
