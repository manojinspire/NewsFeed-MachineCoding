package Services;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Dtos.UserDtoresponse;
import Exception.NotFollowingUser;
import Exception.UserDoesnotExist;
import Models.Post;
import Models.User;
import Repository.Postrepo;
import Repository.UserAccounts;


public class UsersAccountService extends Security{

	private static UserAccounts accounts = UserAccounts.getInstance() ; 
	Postrepo postRepo = Postrepo.getInstance() ; 
	Scanner s = new Scanner(System.in) ; 
	private static UsersAccountService userService ; 
	
	private  UsersAccountService() {
		
	}
	
	public static UsersAccountService getInstance() {
		
		if(userService == null) {
			
			userService = new UsersAccountService() ; 
		}
		
		return userService ;
		
	}
	
	// to get Posts through userid
	public void userPosts() throws UserDoesnotExist {
		
			System.out.println("Enter user id") ;
			int id = s.nextInt() ;
			List<Post> posts ;
			if(postRepo.getuserPosts().containsKey(id)) {
				posts =postRepo.getuserPosts().get(id) ; 
			}
			else {
				throw new UserDoesnotExist("User Not Exist");
			}
			
			
			for(Post post : posts) {
				System.out.println(post) ; 
			}
		
		
	}
	
	
	// to validate wether user exists or not
	public boolean exists(String username) {
	
		if(accounts.getUsersbyUsername().containsKey(username)) {
			return true ; 
		}
		return false;
	}

	
	// to return user
	public UserDtoresponse getUser(String username) {
		
		
			
		User user = accounts.getUsersbyUsername().get(username) ; 
		UserDtoresponse response = new UserDtoresponse() ; 
		response.setId(user.getId());
		response.setUsername(user.getUsername());
		return response; 
		
	}

	
	// to get Password
	public Object getPassword(String username) {
	
		return Security.decode(accounts.getUsersbyUsername().get(username).getPassword()) ; 
	}

	
	// to save USER
	public void save(User user) throws Exception {
		
		accounts.save(user) ; 
		
		
	}

	// follow User
	public void follow(User admin) throws UserDoesnotExist {
		
		
		UserDtoresponse admindto = new UserDtoresponse() ;
		
		admindto.setId(admin.getId());
		admindto.setUsername(admin.getUsername());
		System.out.println("Enter id to follow") ; 
		int userid = s.nextInt() ; 
		// check whether user exists or not 
		
		if(accounts.getIndexbyID().containsKey(userid)) {
			User user = accounts.getIndexbyID().get(userid) ; 
			UserDtoresponse userdt = new UserDtoresponse() ; 
			userdt.setId(user.getId());
			userdt.setUsername(user.getUsername());
			accounts.getIndexbyID().get(user.getId()).getFollowers().add(admindto);
			accounts.getIndexbyID().get(admindto.getId()).getFollowing().add(userdt) ; 
			System.out.println("followed Successfully") ; 
			
		}
		else {
			throw new UserDoesnotExist("user doesnot exist to follow");
		}
		
		
	}
	
	
	// Unfollow User
	
	public void unfollow(User user) throws NotFollowingUser {
		
		
		System.out.println("Enter id to unfollow") ;
		int userid = s.nextInt() ; 
		boolean isuserexists = false ;
		List<UserDtoresponse> following  ;
		List<UserDtoresponse> followers  ; 
		try {
		 following = accounts.getIndexbyID().get(user.getId()).getFollowing() ;
		 followers = accounts.getIndexbyID().get(userid).getFollowers()  ;
		
		} 
		catch(Exception e) {
			throw new NotFollowingUser("U didn't followed the user");
		}
		
		for(Iterator<UserDtoresponse> itr = following.iterator();itr.hasNext();) {
			UserDtoresponse followed = itr.next() ;
			if(followed.getId()==userid) {
				isuserexists = true ;
				itr.remove();
			}
		}
		
		for(Iterator<UserDtoresponse> itr = followers.iterator();itr.hasNext();) {
			UserDtoresponse follower = itr.next() ;
			if(follower.getId() == user.getId()) {
				itr.remove()  ; 
			}
		}
		if(isuserexists) {
			System.out.println("Unfollowed Successfully") ; 
		}
		else {
			System.out.println("user not exists to unfollow") ; 
		}
		
		
		
		 
		
		
	} 
	
	// to get followers of User :- the people who follows me
	public void getfollowers(User user) {
		
		
		
		int id = user.getId() ; 
		List<UserDtoresponse> followers = accounts.getIndexbyID().get(id).getFollowers() ;
		if(followers.size() == 0) {
			System.out.println("No Followers") ; 
		}
		for(UserDtoresponse follower : followers) {
			System.out.println(follower) ; 
		}
		
	}

	
	//to get following :- the people whom i follow 
	public void getfollowing(User user) {
		
		
		
		
		int id = user.getId() ; 
		List<UserDtoresponse> followers = accounts.getIndexbyID().get(id).getFollowing() ;
		if(followers.size() == 0) {
			System.out.println("No following") ; 
		}
		for(UserDtoresponse follower : followers) {
			System.out.println(follower) ; 
		}
	}
	
	public User myprofile(String username) {
		return accounts.getUsersbyUsername().get(username) ; 
	}
	
	
	

	
	
	
	
	
	
}
