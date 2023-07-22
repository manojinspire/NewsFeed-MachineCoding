package Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Exception.UserPostsDoesNotExists;
import Models.Post;

public class Postrepo {
	
	private static Postrepo postrepo ; 
	
	
	private Map<Integer, Post> posts = new HashMap<Integer,Post>() ;
	private Map<Integer, List<Post>> userPosts = new HashMap<Integer,List<Post>>() ; 
	
	
	private Postrepo() {
		
	}
	
	public static Postrepo getInstance() {
		if(postrepo == null) {
			postrepo  = new Postrepo() ; 
		}
		return postrepo; 
	}
	
	public void create(Post post) {
	
		posts.put(post.getPostId() , post) ; 
		
			if(userPosts.containsKey(post.getUserId())) {
				List<Post> p = userPosts.get(post.getUserId()) ; 
				p.add(post) ; 
				userPosts.put(post.getUserId() , p) ; 
			}
			else {
				
				List<Post> p = new ArrayList<Post>() ; 
				p.add(post) ; 
				userPosts.put(post.getUserId() , p) ; 
			}
			

	}
	public Map<Integer, Post> getposts() {
		return posts;
	}
	
	public Map<Integer, List<Post>> getuserPosts() {
		return userPosts;
	}
	
	public void update(int postid, int val , int userid) throws UserPostsDoesNotExists {
		// System.out.println("updating" + postid + "by val of " + val + " by user "+userid) ;
		Post p ; 
		
			p = posts.get(postid);
		 
			
			
		
		HashSet<Integer> upVoteset = p.getUpvotedusers() ;
		HashSet<Integer> downVoteset = p.getDownvotedusers() ; 
		if(upVoteset == null) {
			upVoteset = new HashSet<Integer>() ;
		}
		if(downVoteset == null) {
			downVoteset = new HashSet<Integer>() ; 
		}
		if(val==1) {
			
			if(upVoteset.contains(userid)) {
				System.out.println("already upvoted") ; 
				return ; 
			}
			else {
				if(downVoteset.contains(userid)) {
					downVoteset.remove(userid) ; 
					p.setDownvotes(p.getDownvotes()-1);
					p.setUpvotes(p.getUpvotes()+1);
					upVoteset.add(userid) ; 
					System.out.println("upvoted Successfully"); 
				}
				else {
					p.setUpvotes(p.getUpvotes()+1);
					upVoteset.add(userid) ; 
					System.out.println("upvoted Successfully"); 
					
				}
			}
		}
		else {
			if(downVoteset.contains(userid)) {
				System.out.println("already downvoted") ; 
				return  ;
			}
			else {
				
				if(upVoteset.contains(userid)) {
					
					upVoteset.remove(userid) ; 
					downVoteset.add(userid) ; 
					p.setUpvotes(p.getUpvotes()-1);
					p.setDownvotes(p.getDownvotes()+1);
					System.out.println("downvoted Successfully");
				}
				else {
					downVoteset.add(userid) ; 
					p.setDownvotes(p.getDownvotes()+1);
					System.out.println("downvoted Successfully");
				}
			}
		}
		
		p.setUpvotedusers(upVoteset);
		p.setDownvotedusers(downVoteset); 
		
		
		
		
		posts.put(postid, p) ;
		
		List<Post> userRelatedposts = userPosts.get(p.getUserId()) ; 

		for(Iterator<Post> itr = userRelatedposts.iterator();itr.hasNext();) {
			Post post = itr.next() ; 
			if(post.getPostId() == postid) {
				itr.remove();
				
		}
			
		}
		userRelatedposts.add(p) ; 
		userPosts.put(p.getUserId(), userRelatedposts) ; 
		
	}

	public void deletepost(int postid, int userid) {
		
		
		List<Post>  userposts = userPosts.get(userid) ; 
		
		for(Iterator<Post> itr = userposts.iterator();itr.hasNext();) {
			Post post = itr.next() ; 
			if(post.getPostId() == postid) {
				itr.remove();
				
		}
			
		}
		userPosts.put(userid, userposts) ; 
		posts.put(postid, null) ; 
		
		System.out.println("post successfully deleted");
		
	}
	
	

	
	
	
	
	

}
