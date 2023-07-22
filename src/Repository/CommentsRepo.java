package Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Models.Comment;

public class CommentsRepo {
		
	
		private static CommentsRepo CommentRepo;
		
	
		
		private  HashMap<Integer,List<Comment>> postComments;
		private CommentsRepo(){
			this.postComments = new HashMap<Integer,List<Comment>>() ; 
			
		}
		
		static CommentsRepo comments= CommentsRepo.getInstance();
		public static CommentsRepo getInstance() {
			
				if(CommentRepo == null) {
					 
					CommentRepo = new CommentsRepo() ; 
					
				}
				
				
				return CommentRepo; 
		}
		
		public HashMap<Integer,List<Comment>> getpostComments() {
			
			return postComments; 
		}

		public void save(Comment comment) {
			
			
			
			if(comments.postComments.containsKey(comment.getPostid())) {
			
				comments.postComments.get(comment.getPostid()).add(comment) ;
			}
			else {
				comments.postComments.put(comment.getPostid(), new ArrayList<Comment>());
				comments.postComments.get(comment.getPostid()).add(comment) ;
			}
			System.out.println("saved successfully"); 
			
		}
		
		
		
		
		
		
		 
		
		

}
