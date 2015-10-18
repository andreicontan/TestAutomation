package test.openweathermap.data;

import com.google.gson.annotations.SerializedName;
import test.openweathermap.data.model.City;
import test.openweathermap.data.model.DailyForecast;


public class DailyForecastData {

    @SerializedName(value = "cod")
    private Integer cod;

    @SerializedName(value = "message")
    private String message;

    @SerializedName(value = "cnt")
    private Integer numberOfForecasts;

    @SerializedName(value = "city")
    private City city;

    @SerializedName(value = "list")
    private DailyForecast[] forecasts;

    public Integer getCod() {
        return cod;
    }

    public void setCod(final Integer cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Integer getNumberOfForecasts() {
        return numberOfForecasts;
    }

    public void setNumberOfForecasts(final Integer numberOfForecasts) {
        this.numberOfForecasts = numberOfForecasts;
    }

    public City getCity() {
        return city;
    }

    public void setCity(final City city) {
        this.city = city;
    }

    public DailyForecast[] getForecasts() {
        return forecasts;
    }

    public void setForecasts(final DailyForecast[] forecasts) {
        this.forecasts = forecasts;
    }
}
