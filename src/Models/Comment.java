package Models;

import Dtos.UserDtoresponse;

public class Comment {
	
	private int id ;
	private int postid; 
	private String comment ; 
	
	private int userid; 
	
	private int upvotes ; 
	private int downvotes;

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	} 
	
	public String toString() {
		return '{' + "comment = " + this.comment 
				+ " upotes = "+ this.getUpvotes() + 
				"downvotes = "+this.getDownvotes()+
		'}' ; 
	}
	

}
