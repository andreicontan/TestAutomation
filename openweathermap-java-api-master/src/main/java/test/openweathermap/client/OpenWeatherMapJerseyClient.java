/*
* OpenWeatherMapJerseyClient.java
*
* Copyright (c) 2013, Nicolaas Frederick Huysamen. All rights reserved.
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 3 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
* MA 02110-1301 USA
*/

package test.openweathermap.client;

import com.google.gson.Gson;
import test.openweathermap.data.DailyForecastData;
import test.openweathermap.data.ForecastData;
import test.openweathermap.data.SearchData;
import test.openweathermap.data.WeatherData;
import test.openweathermap.util.Accuracy;
import test.openweathermap.util.Language;
import test.openweathermap.util.Unit;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Properties;

public class OpenWeatherMapJerseyClient {

    private static final String QP_QUERY = "q";
    private static final String QP_LATITUDE = "lat";
    private static final String QP_LONGITUDE = "lon";
    private static final String QP_ID = "id";
    private static final String QP_UNITS = "units";
    private static final String QP_LANGUAGE = "lang";
    private static final String QP_ACCURACY = "type";
    private static final String QP_API_KEY = "appid";

    private WebTarget weatherTarget = null;
    private WebTarget forecastTarget = null;
    private WebTarget dailyForecastTarget = null;
    private WebTarget searchTarget = null;

    private Unit unit = Unit.METRIC;
    private Language language = Language.ENGLISH;

    private Properties properties = new Properties();
    private Gson GSON = new Gson();


    public OpenWeatherMapJerseyClient() {
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("openweather.properties"));

            final WebTarget baseTarget = ClientBuilder.newClient().target(properties.getProperty("base.url"));

            weatherTarget = baseTarget.path("weather");
            forecastTarget = baseTarget.path("forecast");
            dailyForecastTarget = forecastTarget.path("daily");
            searchTarget = baseTarget.path("find");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setMeasureUnit(final Unit unit) {
        this.unit = unit;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }

    public WeatherData weatherByCityName(final String cityName) {
        return sendRequest(
                WeatherData.class,
                weatherTarget,
                new QueryParameter(QP_QUERY, cityName));
    }

    public WeatherData weatherByLatitudeLongitude(final float latitude, final float longitude) {
        return sendRequest(
                WeatherData.class,
                weatherTarget,
                new QueryParameter(QP_LATITUDE, latitude),
                new QueryParameter(QP_LONGITUDE, longitude));
    }

    public WeatherData weatherByCityId(final int cityId) {
        return sendRequest(
                WeatherData.class,
                weatherTarget,
                new QueryParameter(QP_ID, cityId));
    }

    public ForecastData forecastByCityName(final String cityName) {
        return sendRequest(
                ForecastData.class,
                forecastTarget,
                new QueryParameter(QP_QUERY, cityName));
    }

    public ForecastData forecastByLatitudeLongitude(final float latitude, final float longitude) {
        return sendRequest(
                ForecastData.class,
                forecastTarget,
                new QueryParameter(QP_LATITUDE, latitude),
                new QueryParameter(QP_LONGITUDE, longitude));
    }

    public ForecastData forecastByCityId(final int cityId) {
        return sendRequest(
                ForecastData.class,
                forecastTarget,
                new QueryParameter(QP_ID, cityId));
    }

    public DailyForecastData dailyForecastByCityName(final String cityName) {
        return sendRequest(
                DailyForecastData.class,
                dailyForecastTarget,
                new QueryParameter(QP_QUERY, cityName));
    }

    public DailyForecastData dailyForecastByLatitudeLongitude(final float latitude, final float longitude) {
        return sendRequest(
                DailyForecastData.class,
                dailyForecastTarget,
                new QueryParameter(QP_LATITUDE, latitude),
                new QueryParameter(QP_LONGITUDE, longitude));
    }

    public DailyForecastData dailyForecastByCityId(final int cityId) {
        return sendRequest(
                DailyForecastData.class,
                dailyForecastTarget,
                new QueryParameter(QP_ID, cityId));
    }

    public SearchData searchByCityName(final String cityName, final Integer maxResults, final Accuracy accuracy) {
        return sendRequest(
                SearchData.class,
                searchTarget,
                new QueryParameter(QP_QUERY, cityName),
                new QueryParameter(QP_ACCURACY, accuracy));
    }

    public SearchData searchByLatitudeLongitude(final float latitude, final float longitude, final Integer maxResults, final Accuracy accuracy) {
        return sendRequest(
                SearchData.class,
                searchTarget,
                new QueryParameter(QP_LATITUDE, latitude),
                new QueryParameter(QP_LONGITUDE, longitude),
                new QueryParameter(QP_ACCURACY, accuracy));
    }

    private <T> T sendRequest(final Class<T> type, final WebTarget baseTarget, final QueryParameter... queryParameters) {
        WebTarget target = baseTarget.queryParam(QP_UNITS, unit).queryParam(QP_LANGUAGE, language);
        target = target.queryParam(QP_API_KEY, properties.getProperty("api.key"));
        for (final QueryParameter parameter : queryParameters) {
            target = target.queryParam(parameter.key, parameter.value);
        }

        final Invocation.Builder builder = target.request();
        final Response response = builder.accept(MediaType.APPLICATION_JSON_TYPE).get();

        return GSON.fromJson(response.readEntity(String.class), type);
    }

    private static final class QueryParameter {

        private final String key;
        private final Object value;

        private QueryParameter(final String key, final Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
