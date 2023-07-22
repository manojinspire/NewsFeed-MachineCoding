package Strategy;

import java.util.List;
import java.util.Scanner;

import Models.Post;
import Repository.Postrepo;

public class getPostbyUserId implements PostShowStrategy{

	
	
	
	Scanner s = new Scanner(System.in) ; 
	@Override
	public List<Post> getPosts(Postrepo postrepo) {
	
		System.out.println("enter userid") ; 
		int userid = s.nextInt(); 
		
		if(!postrepo.getuserPosts().containsKey(userid)) {
			System.out.println("No posts available") ; 
			return null ; 
		}
		List<Post> posts = postrepo.getuserPosts().get(userid) ;
		return posts;
		
	}
	
	

}
