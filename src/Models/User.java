package Models;

import java.util.ArrayList;
import java.util.List;

import Dtos.UserDtoresponse;

public class User {
	
	private int id ; 
	private String username ; 
	private String password; 
	
	private List<UserDtoresponse> followers = new ArrayList<>();
	protected List<Post> posts  =new ArrayList<>() ;
	    
	private List<UserDtoresponse> following = new ArrayList<>() ; 
	
	public User()
	{
		
	}
	
	public User(int id, String username, String password) {
		this.id = id;
		this.username= username;
		this.password=password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserDtoresponse> getFollowers() {
		return followers;
	}

	public void setFollowers(List<UserDtoresponse> followers) {
		this.followers = followers;
	}
	public List<UserDtoresponse> getFollowing() {
		return following;
	}

	public void setFollowing(List<UserDtoresponse> following) {
		this.following = following;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	
	
	
	
	public String toString() {
		return "user id : " + this.id +  
				"username :"+  this.username ;  
	}
	
	
	
	
	
	
	

}
