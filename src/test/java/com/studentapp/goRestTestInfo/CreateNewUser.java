package com.studentapp.goRestTestInfo;

import com.studentapp.model.GoRestPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class CreateNewUser extends TestBase {

    @Test
    public void createAUSer() {
        GoRestPojo goRestPojo = new GoRestPojo();
        goRestPojo.setName("Tenali Ramakrishna");
        goRestPojo.setGender("female");
        goRestPojo.setEmail("tenali.ramakrishna13@gmail.com");
        goRestPojo.setStatus("active");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 5a08acd60a4f9f76dd28e583fa505a76eeaa98e3da1658ee53c924cac7b1d8d1")
                .body(goRestPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

}
