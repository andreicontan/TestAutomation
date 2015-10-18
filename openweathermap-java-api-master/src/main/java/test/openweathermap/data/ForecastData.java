/*
* ForecastData.java
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

package test.openweathermap.data;

import com.google.gson.annotations.SerializedName;
import test.openweathermap.data.model.City;
import test.openweathermap.data.model.Forecast;

public class ForecastData {

    @SerializedName(value = "cod")
    private Integer cod;

    @SerializedName(value = "message")
    private String message;

    @SerializedName(value = "cnt")
    private Integer numberOfForecasts;

    @SerializedName(value = "city")
    private City city;

    @SerializedName(value = "list")
    private Forecast[] forecasts;

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

    public Forecast[] getForecasts() {
        return forecasts;
    }

    public void setForecasts(final Forecast[] forecasts) {
        this.forecasts = forecasts;
    }
}
