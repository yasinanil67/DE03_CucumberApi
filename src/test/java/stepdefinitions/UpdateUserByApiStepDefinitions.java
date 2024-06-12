package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.User;
import pojos.UserPojo;
import utilities.ObjectMapperUtils;

import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UpdateUserByApiStepDefinitions {

    UserPojo expectedData;
    Response response;

    @Given("set the url for put request")
    public void setTheUrlForPutRequest() {
        //https://thinking-tester-contact-list.herokuapp.com/users/me
        spec.pathParams("first", "users", "second", "me");

    }

    @And("set the expected data for put request")
    public void setTheExpectedDataForPutRequest() {
        String json = """
                {
                    "firstName": "Tom",
                    "lastName": "Cook",
                    "email": "test2@fake.com",
                    "password": "Tom.123"
                }""";
        expectedData = ObjectMapperUtils.jsonToJava(json, UserPojo.class);
        expectedData.setEmail(Faker.instance().internet().emailAddress());
        System.out.println("expectedData = " + expectedData);


    }

    @When("send the put request and get the response")
    public void sendThePutRequestAndGetTheResponse() {

        response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

    }

    @Then("do assertion for put request")
    public void doAssertionForPutRequest() {

        User actualData = response.as(User.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getEmail(), actualData.getEmail());

    }
}
