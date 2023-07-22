package Services;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import Exception.UserPostsDoesNotExists;
import Models.Comment;
import Models.Post;
import Models.User;
import Repository.CommentsRepo;
import Repository.Postrepo;
import Strategy.PostShowStrategy;
import Strategy.getPostbyUserId;
import Strategy.sortedbyupvotes;

public class PostService {
	
	
	Postrepo postrepo = Postrepo.getInstance();
	PostShowStrategy postshow  ; 
	private static CommentService commentService = CommentService.getInstance() ; 
	
	static Scanner s  = new Scanner(System.in) ; 
	private static UsersAccountService users = UsersAccountService.getInstance();
	int postid = 0 ;
	
	private static PostService postService ; 
	
	private PostService() {
		
	}
	public static PostService getInstance() {
		if(postService == null) {
			postService = new PostService() ; 
		}
		return postService;
	}
	public void upvote(int userid) throws UserPostsDoesNotExists {
		
		
		System.out.println("which is the id of your post to upvote") ;
		
		
		int postid = s.nextInt() ; 
		
		  
		try {
		
		postrepo.update(postid , 1,userid);
		
		}
		catch(Exception msg) {
			throw new UserPostsDoesNotExists("Post DoesNot Exists to upVote");
		}
		
		
	
	}
	public void downvote(int userid) throws UserPostsDoesNotExists {
	System.out.println("which is the id of your post to downvote") ;
		
		
		int postid = s.nextInt() ; 
		
		try {
		postrepo.update(postid, -1,userid );
		}
		catch(Exception e) {
			throw new UserPostsDoesNotExists("Post Does Not Exists to downVote") ; 
		}
	}
	
	public void createpost(User user) throws ParseException {
		
		String username = user.getUsername() ; 
		System.out.println("upload Content" +username) ; 
		
		
		String content = s.nextLine() ; 
		int id = users.getUser(username).getId() ; 
		Post p = new Post() ; 
		p.setPostId(postid);
		postid+=1 ; 
		p.setContent(content);
		java.util.Date date = new java.util.Date(2023,7, 19, 10, 2, 2);
		long timestamp = date.getTime() ;
		p.setTimeStamp(timestamp);
		// use epoch 
		
		postrepo.create(p)  ; 
	
		System.out.println("post successfully created") ; 
	}
	
	// to delete post
	public void deletepost(User user) throws UserPostsDoesNotExists {
		if(!postrepo.getuserPosts().containsKey(user.getId())){
			
			throw new UserPostsDoesNotExists("user doesnot have any posts");
			
			
		}
		List<Post> alluserposts= postrepo.getuserPosts().get(user.getId()) ; 
		System.out.println("which post from the following u want to delete") ; 
		
		for(Post post : alluserposts) {
			System.out.println(post);
		}
		
		System.out.println("what is the postid") ; 
		int pid = s.nextInt() ; 
		int userid = user.getId() ; 
		
		postrepo.deletepost(pid , userid) ; 
	}
	
	// sowing posts 
	public void getPosts(User user){
		System.out.println("return posts by -> userid/upvotes/postid")  ; 
		String cmd  = s.nextLine() ; 
		if(cmd.equalsIgnoreCase("userid")) {
			
			
			
			
		
			postshow = new getPostbyUserId() ; 
			List<Post> posts= postshow.getPosts(postrepo) ;
			if(posts == null) {
				return ; 
			}
			for(Post post : posts) {
				System.out.println(post) ; 
			}
			
			
			
		}
		else if(cmd.equalsIgnoreCase("upvotes")) {
			System.out.println("printing by upvotes") ; 
			postshow= new sortedbyupvotes() ; 
			List<Post> posts = postshow.getPosts(postrepo) ; 
			if(posts == null) {
				System.out.println("No posts available"); 
				return ; 
			}
			
			for(Post post : posts) {
				System.out.println(post) ; 
			}
			
			
			
		}
		else if(cmd.equalsIgnoreCase("postid")) {
			
			System.out.println("Enter post id");
			int postid = s.nextInt() ;
			if(postrepo.getposts().containsKey(postid)) {
					Post post = postrepo.getposts().get(postid) ;
					System.out.println(post);
					
					s.nextLine();
					System.out.println("do u want to see comments"); 
					
					System.out.println("type yes/no") ; 
					String val  = s.nextLine();
					if(val.equalsIgnoreCase("yes")) {
						
						List<Comment> comments = commentService.getComments(post.getPostId()) ; 
						if(comments == null) {
							System.out.println("no comments")  ;
						}
						else {
							for(Comment comment : comments ) {
								System.out.println(comment) ; 
								System.out.println("do u want to vote this comment reply : yes/no") ;
								String rr = s.nextLine();
								s.nextLine();
								if(rr.equalsIgnoreCase("yes")) {
									s.nextLine() ; 
									System.out.println("enter upvote/downvote");
									String r = s.nextLine() ; 
									if(r.equalsIgnoreCase("upvote")) {
										commentService.upvote(comment.getId(), postid );
									}
									else if(r.equalsIgnoreCase("downvote")) {
										commentService.downvote(comment.getId(), postid) ;
									}
								}
								
							}
						}
					}
					System.out.println("do u want to comment on this post reply : yes/no"); 
					String interestedtoComment = s.nextLine() ; 
					if(interestedtoComment.equalsIgnoreCase("yes")) {
						System.out.println("type Comment") ; 
						String comnt = s.nextLine() ; 
						commentService.postComment(postid,user.getId(),comnt);
					}
					
						
					
					
					
					
			}
			else {
				System.out.println("post not available") ;
			}
		}
		
		return ; 
	
		
	}

}
