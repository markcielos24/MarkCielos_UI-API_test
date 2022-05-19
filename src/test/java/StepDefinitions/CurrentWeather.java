package StepsDefinitions;

import API_StepFactory.CurrentWeather_SF;

import io.cucumber.java.en.*;
import utils.Constants;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CurrentWeather {

    String token = "";
    CurrentWeather_SF currentweather;

    @Given("user have Current Weather API access")
    public void user_have_Current_Weather_API_access() throws Exception {

        token = Constants.TOKEN;

    }

    @When("^user GET current weather using latitude (.*) and longtitude (.*) state code match (.*)$")
    public void user_GET_current_weather_using_lat_and_lon_with_expected_state_code(Double lat, Double lon, String state_code) throws Exception {

        currentweather = new CurrentWeather_SF();
        currentweather.GetCurrentWeatherUsingLatAndLon(lat, lon, state_code.trim());

    }

    @Then("^Current Weather API response status should be (\\d+)$")
    public void Current_Weather_API_response_status_should_be(int statusCode) throws Exception {

        assertThat("Check response status code for Current Weather ", currentweather.getStatusCode(), equalTo(statusCode));

    }

}
