package Models;

import java.util.HashSet;
import java.util.List;

import Services.CommentService;

public class Post {
	
		private int postId;
		private int userId; 
		private String content ; 
		private List<Integer> comments ; 
		
		private int upvotes;
		private HashSet<Integer> upvotedusers ; 
		private HashSet<Integer> downvotedusers;
		private int downvotes;
		
		
		private long timeStamp;
		public int getPostId() {
			return postId;
		}
		public void setPostId(int postId) {
			this.postId = postId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public int getUpvotes() {
			return upvotes;
		}
		public void setUpvotes(int upvotes) {
			this.upvotes = upvotes;
		}
		public int getDownvotes() {
			return downvotes;
		}
		public void setDownvotes(int downvotes) {
			this.downvotes = downvotes;
		}
		
		public long getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(long timestamp2) {
			this.timeStamp = timestamp2;
		}
		
		public HashSet<Integer> getUpvotedusers() {
			return upvotedusers;
		}
		public void setUpvotedusers(HashSet<Integer> votedusers) {
			this.upvotedusers = votedusers;
		}
		
		public HashSet<Integer> getDownvotedusers() {
			return downvotedusers;
		}
		public void setDownvotedusers(HashSet<Integer> downvotedusers) {
			this.downvotedusers = downvotedusers;
		}
		
		public List<Integer> getComments() {
			return comments;
		}
		public void setComments(List<Integer> comments) {
			this.comments = comments;
		}
		public String toString() {
			
			
			return "Post {" +
					
					this.content + "," +
					"upVotes = " + this.getUpvotes() +
					
					", downVotes = " + this.getDownvotes() +
					", replyList=" + CommentService.getInstance().getComments(postId) + 
					'}' ;
		}
		 
		}
	
		
		


