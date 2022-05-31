package com.studentapp.goRestTestInfo;

import com.studentapp.model.GoRestPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class UpdateUserRecord extends TestBase {

    @Test
    public void updateStudentWithPatch() {
        GoRestPojo goRestPojo=new GoRestPojo();
        goRestPojo.setName("Kim Marsh");
        goRestPojo.setEmail("klo@yahoo.com");
        goRestPojo.setStatus("active");
        goRestPojo.setGender("Female");


        Response response=given()
                .header("Content-Type","application/json")
               .header("Authorization", "Bearer 5a08acd60a4f9f76dd28e583fa505a76eeaa98e3da1658ee53c924cac7b1d8d1")
                .body(goRestPojo)
                .pathParam("id",3762)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}