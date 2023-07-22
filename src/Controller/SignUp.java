package Controller;

import Services.signUpServices;

public class SignUp {

	
private static  SignUp signUp; 
	
	
	// encrypt password 
	 
	signUpServices signUpService = signUpServices.getInstance();
	
	private SignUp() {
		
	}
	
	public static SignUp getInstance() {
		
		if(signUp == null) {
			signUp = new SignUp() ; 
		}
		return signUp ;
	}
	
	
	// username Exists Exception 
	public void getsignUp() throws Exception {
				
				try {
					signUpService.signUp() ; 
				}
				
				catch(Exception e){
					throw new Exception();
				}
			}
			
	
}
