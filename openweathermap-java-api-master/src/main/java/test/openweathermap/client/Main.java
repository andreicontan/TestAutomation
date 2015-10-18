package test.openweathermap.client;

import test.jsonplaceholder.client.JsonPlaceholderClient;
import test.jsonplaceholder.client.JsonPlaceholderStubClient;
import test.jsonplaceholder.model.Post;
import test.openweathermap.data.DailyForecastData;

public class Main {

    public static void main(String[] args) {
        OpenWeatherMapJerseyClient jerseyClient = new OpenWeatherMapJerseyClient();
        DailyForecastData dailyForecastData = jerseyClient.dailyForecastByCityName("cluj");
        System.out.println(dailyForecastData.getCod());

        JsonPlaceholderClient client = new JsonPlaceholderStubClient();
        Post postResult = client.getPostById(100);

        Post post = new Post();
        post.setBody("test");
        post.setTitle("test");
        post.setUserId(12);
        Post result = client.addPost(post);
        System.out.println(result.getId());

    }
}
