package test.jsonplaceholder.client;

import org.omg.PortableServer.POA;
import test.jsonplaceholder.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JsonPlaceholderStubClient implements JsonPlaceholderClient {

    private Random random = new Random();

    public List<Post> getPostsByUserId(int userId) {
        List<Post> posts = new ArrayList<Post>();
        posts.add(buildPost(random.nextInt(), userId));
        return posts;
    }

    public Post getPostById(int postId) {
        return buildPost(postId, postId);
    }

    public Post addPost(Post post) {
        post.setId(random.nextInt(100));
        return post;
    }

    private Post buildPost(Integer postId, int userId) {
        Post post = new Post();
        post.setId(postId);
        post.setBody("post body - stub");
        post.setTitle("stub post");
        post.setUserId(userId);
        return post;
    }
}
