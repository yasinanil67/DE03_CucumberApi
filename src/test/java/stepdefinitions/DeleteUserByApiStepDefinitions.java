package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteUserByApiStepDefinitions {

    Response response;

    @Given("set the url for delete request")
    public void set_the_url_for_delete_request() {
        spec.pathParams("first", "users", "second", "me");
    }

    @When("send the delete request and get the response")
    public void send_the_delete_request_and_get_the_response() {
        response = given(spec).delete("{first}/{second}");
        //response.prettyPrint();
    }

    @Then("status code should be two hundreds")
    public void status_code_should_be_two_hundreds() {
        response.then().statusCode(200);
    }

    @Then("body should be empty")
    public void body_should_be_empty() {
        assertTrue(response.asString().isEmpty());
    }

}