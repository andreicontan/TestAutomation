package test.openweathermap.client;

import test.jsonplaceholder.client.JsonPlaceholderClient;
import test.jsonplaceholder.client.JsonPlaceholderStubClient;
import test.jsonplaceholder.model.Post;
import test.openweathermap.data.DailyForecastData;
import test.openweathermap.data.model.DailyForecast;
import test.openweathermap.data.model.Forecast;

public class Main {

    @Test
    public void testForecastByCityName(){
        OpenWeatherMapJerseyClient jerseyClient = new OpenWeatherMapJerseyClient();
        DailyForecastData dailyForecastData = jerseyClient.dailyForecastByCityName("cluj");
        System.out.println(dailyForecastData.getCity().getName());
//
//        for (DailyForecast forecast : dailyForecastData.getForecasts()){
//            System.out.println(forecast.getCloudCoverage());
//            System.out.println(forecast.getTemperatureData().getMaximum());
        }


//
//
//        JsonPlaceholderClient client = new JsonPlaceholderStubClient();
//        Post postResult = client.getPostById(100);
//
//        System.out.println("Title: " + postResult.getTitle() + " " + postResult.getBody());
//
//        Post post = new Post();
//        post.setBody("test");
//        post.setTitle("test");
//        post.setUserId(12);
//        Post result = client.addPost(post);
//        System.out.println(result.getId());

    //}
}
