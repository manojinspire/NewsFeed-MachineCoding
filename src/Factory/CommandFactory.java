package Factory;

import Controller.Login;
import Controller.SignUp;
import Models.User;
import Services.PostService;
import Services.UsersAccountService;

public class CommandFactory {
	
	
	public static void execute(String cmd , User user) throws Exception {
		
		PostService postService = PostService.getInstance() ; 
		
		UsersAccountService userService = UsersAccountService.getInstance() ;
		
		
		// commands from the NewsFeed 
		switch(cmd.toLowerCase())
		{
			case "~post":
				postService.createpost(user);
				break;
				
			case "~deletepost":
				try {
					postService.deletepost(user);
				}
				catch(Exception msg) {
					System.out.println(msg);
					break ;
				}
				break;
			case "~upvotepost" :
				try {
				postService.upvote(user.getId());
				} 
				catch(Exception msg){
					System.out.println(msg);
				}
				break;
			case "~downvotepost" :
				try {
				postService.downvote(user.getId());
				}
				catch(Exception msg) {
					System.out.println(msg) ; 
				}
				break;
			case "~getposts" :
				postService.getPosts(user);
				break;
			
			
			case "~userposts":
				userService.userPosts();
				break;
			case "~follow" :
				try {
				userService.follow(user) ;
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
				break ; 
			case "~unfollow" :
				
				try {
				userService.unfollow(user) ; 
				}
				catch(Exception e) {
					System.out.println(e) ; 
				}
				break ; 
			case "~followers" :
				userService.getfollowers(user) ;
				break ; 
			case "~following" :
				userService.getfollowing(user) ;
				break ;
				
				
			default :
			
				System.out.println("Invalid Choice");
				break;
			
				
				
		}
		
	}

}
