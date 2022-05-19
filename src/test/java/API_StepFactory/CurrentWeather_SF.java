package API_StepFactory;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Constants;

public class CurrentWeather_SF {

	static public Response response;
	
	public CurrentWeather_SF() {
		
	}
	
    public void GetCurrentWeatherUsingLatAndLon(Double lat, Double lon, String state_code) throws Exception {
    
    	RestAssured.baseURI = Constants.WEATHER_BASEURL;
		RequestSpecification request = RestAssured.given();
		response = request.get("/v2.0/current?lat=" + lat + "&lon=" + lon + "&key=" + Constants.TOKEN + "");

        System.out.println("response: " + response);
        List<Map<String, String>> responseDataList = response.jsonPath().getList("data");
        System.out.println("response Data list: " + responseDataList);
        String actual_state_code = responseDataList.get(0).get("state_code");
        System.out.println("actual_state_code: " + actual_state_code);
        System.out.println("expected_state_code: " + state_code);
        Assert.assertTrue(actual_state_code.contentEquals(state_code));
    }
    
    public int getStatusCode() throws Exception {
        return response.then().extract().statusCode();
    }
	
}
