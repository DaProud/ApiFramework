package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class CreateAccountTest {

    @Test
    public void testMethod() {
        // Definim clientul
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://demoqa.com/");
        requestSpecification.contentType("application/json");

        // Definim request-ul
        JSONObject createUserBody = new JSONObject();
        createUserBody.put("userName", "TestAutomation" + System.currentTimeMillis());
        createUserBody.put("password", "134.!Password");

        requestSpecification.body(createUserBody.toString());

        // Interactionam cu response-ul
        Response response = requestSpecification.post("Account/v1/User");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());

        ResponseBody responseBody = response.getBody();
        System.out.println(responseBody.asString());
    }

}
