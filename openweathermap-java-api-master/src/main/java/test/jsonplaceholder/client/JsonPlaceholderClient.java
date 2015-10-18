package test.jsonplaceholder.client;

import test.jsonplaceholder.model.Post;

import java.util.List;

/**
 * Created by andreicontan on 18/10/15.
 */
public interface JsonPlaceholderClient {


    List<Post> getPostsByUserId(int userId);

    Post getPostById(int postId);

    Post addPost(Post post);

}
