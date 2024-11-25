package project.api;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class GetProject {


    Response body =
            given()
                    .params("username", "testccpe","password","testccpe").post("https://dev-stroytransgaz.april-inn.ru/api/v1")
                    .then()
                    .log().body()
                    .statusCode(200)
                    .extract().response();

    String access_token = body.path("access_token").toString();
    String Authorization = "Bearer " + access_token;


    @Test
    public void getProject(){

        given()
                .baseUri("https://dev-stroytransgaz.april-inn.ru/api/v1")
                .header("Authorization", Authorization)
                .when()
                .get("/projects/10")
                .then()
                .log().body()
                .statusCode(200);
    }
}


