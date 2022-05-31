package com.studentapp.goRestTestInfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class DeleteUser extends TestBase {

    @Test
    public void deleteUserRecord(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 5a08acd60a4f9f76dd28e583fa505a76eeaa98e3da1658ee53c924cac7b1d8d1")
                .pathParam("id",3642)
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }


}
