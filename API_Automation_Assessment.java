package FIS_UI_Automation_Assessment;

public class API_Automation_Assessment 
{
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertTrue;
	
	
	
		
		
		public class CoinDeskAPITest {

		    public static void main(String[] args) {
		        // Set the base URI for the API
		        RestAssured.baseURI = "https://api.coindesk.com/v1/bpi/currentprice.json";

		        // Send a GET request to the API
		        Response response = RestAssured.get();

		        // Print the response body
		        System.out.println("Response: " + response.getBody().asString());

		        // Validate the response status code
		        int statusCode = response.getStatusCode();
		        assertEquals(statusCode, 200, "Status code is not 200");

		        // Parse the JSON response
		        String json = response.getBody().asString();

		        // Verify there are 3 BPIs: USD, GBP, EUR
		        boolean containsUSD = json.contains("\"USD\"");
		        boolean containsGBP = json.contains("\"GBP\"");
		        boolean containsEUR = json.contains("\"EUR\"");
		        assertTrue(containsUSD, "USD BPI is missing");
		        assertTrue(containsGBP, "GBP BPI is missing");
		        assertTrue(containsEUR, "EUR BPI is missing");

		        // Verify GBP "description" is "British Pound Sterling"
		        String gbpDescription = response.jsonPath().getString("bpi.GBP.description");
		        assertEquals(gbpDescription, "British Pound Sterling", "GBP description mismatch");

		        System.out.println("All validations passed successfully!");
		    }
		
		
		
	}

