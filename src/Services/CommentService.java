package Services;

import java.util.List;

import Models.Comment;
import Repository.CommentsRepo;

public class CommentService {

	
	
	private static CommentService commentService ; 
	static CommentsRepo commentsRepo = CommentsRepo.getInstance();
	
	private CommentService() {
		
	}
	static int commentid = 0 ; 
	
	public static CommentService getInstance() {
		
		
		if(commentService == null) {
			commentService =  new CommentService() ; 
		}
		return commentService ; 
	}
	
	
	
	

	public List<Comment> getComments(int postId) {
		// TODO Auto-generated method stub
		 if(commentsRepo.getpostComments().containsKey(postId)) {
			 return  commentsRepo.getpostComments().get(postId) ; 
		 }
		 else {
			 return null ;
		 }
	}

	public void upvote(int commentid, int postid) {
		
		
		for(Comment comment : commentsRepo.getpostComments().get(postid)) {
			
			if(comment.getId()== commentid) {
				comment.setUpvotes(comment.getUpvotes()+1); 
				
			}
		}
	}
public void downvote(int commentid, int postid) {
		
		
		for(Comment comment : commentsRepo.getpostComments().get(postid)) {
			
			if(comment.getId()== commentid) {
				comment.setDownvotes(comment.getDownvotes()+1); 
				
			}
		}
	}

	public void postComment(int postid, int userid, String comnt) {
		

		
		
		Comment comment  = new Comment() ; 
		comment.setId(commentid);
		commentid+=1 ;
		comment.setPostid(postid);
		comment.setUserid(userid);
		comment.setComment(comnt);
	
		
		commentsRepo.save(comment);
			
		
		
	}
	
	
	

}
