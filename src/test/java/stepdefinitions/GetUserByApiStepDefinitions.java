package stepdefinitions;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.User;
import utilities.ObjectMapperUtils;

import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.CreateUserBySeleniumStepDefinitions.email;

public class GetUserByApiStepDefinitions {

    Response response;
    User expectedData;

    @Given("set the url for get request")
    public void set_the_url_for_get_request() {
        //https://thinking-tester-contact-list.herokuapp.com/users/me
        spec.pathParams("first", "users", "second", "me");
    }

    @Given("set the expected data for get request")
    public void set_the_expected_data_for_get_request() {
        String json = """
                {
                  "firstName": "John",
                  "lastName": "Doe",
                  "email": "test@fake.com"
                }
                """;

        expectedData = ObjectMapperUtils.jsonToJava(json, User.class);
        expectedData.setEmail(email);//Selenium ile Java faker'ın oluşturduğu email'i buraya assign ediyoruz.
        System.out.println("expectedData = " + expectedData);

    }

    @When("send the get request and get the response")
    public void send_the_get_request_and_get_the_response() {
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("do assertion for get request")
    public void do_assertion_for_get_request() {

        User actualData = ObjectMapperUtils.jsonToJava(response.asString(), User.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getEmail(), actualData.getEmail());

    }

}
