package Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Models.Post;
import Repository.Postrepo;

public class sortedbyupvotes implements PostShowStrategy {

	@Override
	public List<Post> getPosts(Postrepo postrepo) {
		// TODO Auto-generated method stub
		ArrayList<Post> sorted= new ArrayList<Post>() ; 
		for(int postid : postrepo.getposts().keySet()) {
			sorted.add(postrepo.getposts().get(postid)) ; 
		}
		
		Collections.sort(sorted, new Comparator<Post>() {
		    @Override
		    public int compare(Post p1, Post p2) {
		        return (p2.getUpvotes()-p2.getDownvotes()) - (p1.getUpvotes()-p1.getDownvotes()) ; 
		    }
		});
		
		return sorted; 
			
		
		 
	}

}
