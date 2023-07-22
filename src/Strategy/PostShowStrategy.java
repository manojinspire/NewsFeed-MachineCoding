package Strategy;

import java.util.List;

import Models.Post;
import Repository.Postrepo;

public interface PostShowStrategy {

	// Strategy for showing NewsFeed ( Implemented by upVotes,Userid) 
	static Postrepo postrepo = Postrepo.getInstance() ; 
	
	public List<Post> getPosts(Postrepo postrepo) ;
			
	
}
