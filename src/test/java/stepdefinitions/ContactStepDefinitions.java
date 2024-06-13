package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.ContactPojo;
import utilities.ObjectMapperUtils;

import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ContactStepDefinitions {

    Response response;
    static ContactPojo expectedData;//Farklı feature dosyalarında kullanılacak variable'lar static belirtilirse, bit öncekinde kullanlan değer sıfırlanmaz.
    static String contactId;//static variable'lar tüm proje için ortak olduklarından farklı feature'lar için de ortaktırlar.

    @Given("set the url for add contact")
    public void set_the_url_for_add_user() {
        //https://thinking-tester-contact-list.herokuapp.com/contacts
        spec.pathParams("first", "contacts");
    }

    @Given("set the expected data for add contact")
    public void set_the_expected_data_for_add_user() {
        String json = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "birthdate": "1970-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "New York",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }""";

        expectedData = ObjectMapperUtils.jsonToJava(json, ContactPojo.class);
        expectedData.setFirstName(Faker.instance().name().firstName());
        expectedData.setLastName(Faker.instance().name().lastName());
        expectedData.setEmail(Faker.instance().internet().emailAddress());

        System.out.println("expectedData = " + expectedData);


    }

    @When("send the post request and get the response")
    public void send_the_post_request_and_get_the_response() {

        response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();


    }

    @Then("do assertion for add contact")
    public void do_assertion_for_add_user() {

        ContactPojo actualData = response.as(ContactPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getCountry(), actualData.getCountry());
        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
        assertEquals(expectedData.getPhone(), actualData.getPhone());
        assertEquals(expectedData.getCity(), actualData.getCity());
        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
        assertEquals(expectedData.getEmail(), actualData.getEmail());

        contactId = response.jsonPath().getString("_id");
        System.out.println("contactId = " + contactId);

    }

    @Given("set the url for get contact")
    public void setTheUrlForGetContact() {
        //https://thinking-tester-contact-list.herokuapp.com/contacts/contactId
        spec.pathParams("first", "contacts", "second", contactId);
    }

    @And("set the expected data for get contact")
    public void setTheExpectedDataForGetContact() {
        System.out.println("expectedData = " + expectedData);//Bir önceki feature'da kullanılan expected data
    }

    @When("send the get request and get the response for get contact")
    public void sendTheGetRequestAndGetTheResponseForGetContact() {
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("do assertion for get contact")
    public void doAssertionForGetContact() {

        ContactPojo actualData = response.as(ContactPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getCountry(), actualData.getCountry());
        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
        assertEquals(expectedData.getPhone(), actualData.getPhone());
        assertEquals(expectedData.getCity(), actualData.getCity());
        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
        assertEquals(expectedData.getEmail(), actualData.getEmail());

    }

    @Given("set the url for update contact")
    public void setTheUrlForUpdateContact() {
        //https://thinking-tester-contact-list.herokuapp.com/contacts/contactId
        spec.pathParams("first", "contacts", "second", contactId);

    }

    @And("set the expected data for update contact")
    public void setTheExpectedDataForUpdateContact() {
        String json = """
                {
                    "firstName": "Amy",
                    "lastName": "Miller",
                    "birthdate": "1992-02-02",
                    "email": "amiller@fake.com",
                    "phone": "8005554242",
                    "street1": "13 School St.",
                    "street2": "Apt. 5",
                    "city": "Washington",
                    "stateProvince": "QC",
                    "postalCode": "A1A1A1",
                    "country": "Canada"
                }""";

        expectedData = ObjectMapperUtils.jsonToJava(json, ContactPojo.class);
        System.out.println("expectedData = " + expectedData);

    }

    @When("send the put request and get the response for update contact")
    public void sendThePutRequestAndGetTheResponseForUpdateContact() {
        response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();
    }

    @Then("do assertion for update contact")
    public void doAssertionForUpdateContact() {
        ContactPojo actualData = response.as(ContactPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getCountry(), actualData.getCountry());
        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
        assertEquals(expectedData.getPhone(), actualData.getPhone());
        assertEquals(expectedData.getCity(), actualData.getCity());
        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
        assertEquals(expectedData.getEmail(), actualData.getEmail());
    }

    @Given("set the url for delete contact")
    public void setTheUrlForDeleteContact() {
        //https://thinking-tester-contact-list.herokuapp.com/contacts/contactId
        spec.pathParams("first", "contacts", "second", contactId);
    }

    @And("set the expected data for delete contact")
    public void setTheExpectedDataForDeleteContact() {

    }

    @When("send the delete request and get the response for delete contact")
    public void sendTheDeleteRequestAndGetTheResponseForDeleteContact() {
        response = given(spec).delete("{first}/{second}");
        response.prettyPrint();
    }

    @Then("do assertion for delete contact")
    public void doAssertionForDeleteContact() {
        assertEquals(200, response.statusCode());
        assert response.asString().contains("Contact deleted");
    }
}
