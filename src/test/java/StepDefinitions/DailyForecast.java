package StepsDefinitions;

import API_StepFactory.DailyForecast_SF;

import io.cucumber.java.en.*;
import utils.Constants;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DailyForecast {

    String token = "";
    DailyForecast_SF dailyforecast;

    @Given("user have Daily Forecast API access")
    public void user_have_Daily_Forecast_API_access() throws Exception {

        token = Constants.TOKEN;

    }

    @When("^user GET daily forecast using postal code (\\d+)$")
    public void user_GET_daily_forecast_using_postal_code(int postal_code) throws Exception {

        dailyforecast = new DailyForecast_SF();
        dailyforecast.GetDailyForecastUsingPostalCode(postal_code);

    }

    @Then("^Daily Forecast API response status should be (\\d+)$")
    public void Daily_Forecast_API_response_status_should_be(int statusCode) throws Exception {

        assertThat("Check response status code for Daily Forecast ", dailyforecast.getStatusCode(), equalTo(statusCode));

    }

}
