package com.studentapp.goRestTestInfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


public class GetAllUser extends TestBase {

    @Test
public void getAllUsers(){
        Response response= given()
                 .when()
                 .get();
        response.then().statusCode(200);
        System.out.println("------------Response from the Records---------------");
        List<Integer> totalRecords=response.then().extract().path("");
        System.out.println("1. Total Records :" +totalRecords.size());

        List<?> name = response.then().extract().path("findAll{it.id==3820}.name");
        System.out.println("2. id 3820 has name           :" + name);

        List<?> email = response.then().extract().path("findAll{it.id==3823}.email");
        System.out.println("id 3823 has name           :" + email);

        List<HashMap<String,?>> status = response.then().extract().path("findAll{it.status == 'active'}.id");
        System.out.println("All Active Ids: "+status);

        List<?> femaleGender = response.then().extract().path("findAll{it.id==3827}.gender");
        System.out.println("id 3827 has Gender Female  :" + femaleGender);
        List<?> maleGender = response.then().extract().path("findAll{it.id==3809}.gender");
        System.out.println("id 3809 has Gender Male    :" + maleGender);
        System.out.println("----------- End of Response ----------------------");
        response.prettyPrint();
    }

    }



