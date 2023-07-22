package Client;

import java.util.Scanner;

import Controller.Login;
import Controller.SignUp;
import Factory.CommandFactory;
import Models.User;

public class NewsFeed {
	
	public static void main(String[] args) throws Exception {
		
		
		// input from the client 
		

		
		Login login = Login.getInstance() ;
		SignUp signUp = SignUp.getInstance();
		Scanner s = new Scanner(System.in) ;
		User user =null;
		
		
		while(true) {
			
			
			if(user == null) {
				
				System.out.println("signup/login") ; 
				
			}
			String cmd = s.nextLine(); 

			
			switch(cmd.toLowerCase()) {
			
				
				case "~login" :
					user = login.getLogin() ; 
					
					break ;
				case "~signup" :
					signUp.getsignUp() ;
					break;
				default:
					CommandFactory.execute(cmd, user) ;
					break;
					
			}
			
		}
			

		
		
	}

}
