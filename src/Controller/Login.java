package Controller;

import java.util.Scanner;

import Models.User;
import Services.loginServices;

public class Login {

	
	private static  Login login ; 
	
	
	private User user;

	loginServices loginService = loginServices.getInstance();
	Scanner l = new Scanner(System.in);
	private Login() {
		
	}
	
	public static Login getInstance() {
		
		if(login == null) {
			login = new Login() ; 
		}
		return login ;
	}
	
	
	public User getLogin() {
		
		
			
			System.out.println("Enter username");
			String username = l.nextLine() ; 
			System.out.println("Enter password");
			String password= l.nextLine();
			try {
				user = loginService.validate(username , password) ; 
				System.out.println("Welcome" + user.getUsername());
				System.out.println("Services :-" +"post/upvotepost/deletepost/downvotepost/getposts/follow/unfollow/following/followers");
				return user; 
				
			}
			// Invalid Login Details Exception
			catch(Exception e){
				
				System.out.println(e);
				return getLogin(); 
			}
			
		
	}
	
	
}
