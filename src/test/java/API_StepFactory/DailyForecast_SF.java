package API_StepFactory;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Constants;

public class DailyForecast_SF {

	static public Response response;
	
	public DailyForecast_SF() {
		
	}
	
    public void GetDailyForecastUsingPostalCode(int postal_code) throws Exception {
    
    	RestAssured.baseURI = Constants.WEATHER_BASEURL;
		RequestSpecification request = RestAssured.given();
		response = request.get("/v2.0/forecast/daily?postal_code=" + postal_code + "&key=" + Constants.TOKEN + "");

        System.out.println("response: " + response);
        List<Map<String, String>> responseDataList = response.jsonPath().getList("data");
        System.out.println("response Data list: " + responseDataList);
    }
    
    public int getStatusCode() throws Exception {
        return response.then().extract().statusCode();
    }
	
}
