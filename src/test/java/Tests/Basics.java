package Tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import base.RESTBase;
import io.restassured.response.Response;
import jsons.Jsons;
import util.Utils;

public class Basics extends RESTBase{
	
	Utils utils  = new Utils();
	public static String persNo = "";
	public static String encNo = "";

	@Test
	public void createPersonTest() {
		Response responsePat = 
				 given()
				.relaxedHTTPSValidation().log().all()
				.auth().preemptive().basic(USERNAME, PASSWORD)
				.header("Content-Type", "application/json").body(Jsons.patBody())

				.when().post(PATIENT)

				.then().extract().response();
		
		responsePat.then().statusCode(201);

		persNo = utils.getID(responsePat);
		System.out.println("Person Number is: " + persNo);
		
	}

	 @Test(dependsOnMethods = { "createPersonTest" })
	 public void createEnounterTest() {
		 
		 Response responsePat = 
				 given()
				.relaxedHTTPSValidation().log().all()
				.auth().preemptive().basic(USERNAME, PASSWORD)
				.header("Content-Type", "application/json").body(Jsons.encBody(persNo))

				.when().post(ENCOUNTER)

				.then().extract().response();
		
                responsePat.then().statusCode(201);
                encNo = utils.getID(responsePat);
                System.out.println("Response is: " +responsePat.toString());
                System.out.println("Encounter Number is: " + encNo);
	
	 }
	
//	 @Test(dependsOnMethods = { "createEnounterTest" })
//	 public void getEnounterTest() {
//	
//	 }

}
