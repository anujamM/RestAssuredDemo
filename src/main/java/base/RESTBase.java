package base;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class RESTBase {
	protected final String USERNAME = "sfetcsc";
	protected final String PASSWORD = "Passw0rd-SFET";
	protected String env = "sf-qa1959";
	protected final String URL = "https://sfet-nprodnstg.dm50.dev.smed.net/" + env + "/dynamic/services/regsched/R4/v1";
	protected final String PATIENT = "patient/";
	protected final String ENCOUNTER = "encounter/";
	

	@BeforeTest
	public void setup() {
		RestAssured.baseURI = URL;
	}
}
