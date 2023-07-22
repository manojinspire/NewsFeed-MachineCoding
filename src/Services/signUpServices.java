package Services;

import java.util.Scanner;

import Models.User;


public class signUpServices extends Security{
	
	static signUpServices signUpService ; 
	
	private static UsersAccountService users = UsersAccountService.getInstance();
	
 
	int userid= 0; 
	Scanner s =new Scanner(System.in);
	private signUpServices(UsersAccountService users) {
		
		this.users =users;
	}
	
	public static signUpServices getInstance() {
		if(signUpService == null) {
			signUpService = new signUpServices(users) ; 
		}
		return signUpService;
	}
	
	public void signUp()  {
		
		System.out.println("Enter username");
		
		
		
		String username = s.nextLine();
				
		System.out.println("Enter password") ;
		
		
		String password = s.nextLine();
		
		 
		
		try {
			
			String encryptedPassword= Security.encode(password)  ; 
			User user = new User(userid, username, encryptedPassword); 
			users.save(user);
			System.out.println("Successfully registered");
			userid+=1;
		}
		catch(Exception e){
			System.out.println("username already exists");
			signUp();
		}
	
		
	}

}
