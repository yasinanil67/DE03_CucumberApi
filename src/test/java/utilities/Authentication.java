package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepdefinitions.CreateUserBySeleniumStepDefinitions.email;

public class Authentication {


    public static String generateToken() {

        Map<String, String> payload = new HashMap<>();

        if (email != null) {//Eğer selenium ile user oluşturulursa email null kalmaz.
            payload.put("email", email);
            payload.put("password", "Password.123");
        } else {//User oluşturulmadıysa clarusway kullanıcısı ile token alınacak
            payload.put("email", "clarusway2024@hotmail.com");
            payload.put("password", "Clarusway.123");
        }

        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        //response.prettyPrint();

        try {//Default olarak alınan alınamadığı taktirde exceptiın'ı handle etmek için kullanıyoruz.
            return response.jsonPath().getString("token");
        } catch (Exception e) {
            System.err.println("Token alınamadı");
            return "";
        }

    }
}
