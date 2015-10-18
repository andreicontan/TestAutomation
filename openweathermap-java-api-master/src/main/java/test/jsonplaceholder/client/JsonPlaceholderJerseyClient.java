package test.jsonplaceholder.client;

import com.google.gson.Gson;
import test.jsonplaceholder.model.Post;


import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;


public class JsonPlaceholderJerseyClient implements JsonPlaceholderClient {


   private Gson GSON = new Gson();

    private WebTarget postsTarget;

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    private static final String USER_ID_PARAM = "userId";

    public JsonPlaceholderJerseyClient() {
        final WebTarget baseTarget = ClientBuilder.newClient().target(BASE_URL);
        postsTarget = baseTarget.path("posts");
    }

    public List<Post> getPostsByUserId(int userId) {
        postsTarget.queryParam(USER_ID_PARAM, userId);
        final Response response = postsTarget.request().accept(MediaType.APPLICATION_JSON_TYPE).get();

        return Arrays.asList(GSON.fromJson(response.readEntity(String.class), Post[].class));
    }

    public Post getPostById(int postId) {
        WebTarget getPostByIdTarget = postsTarget.path(String.valueOf(postId));
        final Response response = getPostByIdTarget.request().accept(MediaType.APPLICATION_JSON_TYPE).get();

        return GSON.fromJson(response.readEntity(String.class), Post.class);
    }

    public Post addPost(Post post) {
        Invocation.Builder requestBuilder = postsTarget.request().accept(MediaType.APPLICATION_JSON_TYPE);
        final Response response = requestBuilder
                .post(Entity.entity(GSON.toJson(post), MediaType.APPLICATION_JSON_TYPE));

        return GSON.fromJson(response.readEntity(String.class), Post.class);
    }
}
