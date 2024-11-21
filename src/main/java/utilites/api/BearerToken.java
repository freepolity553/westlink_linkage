package utilites.api;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class BearerToken {

    public String getAccessToken()  {
        String urlApi = "https://dev-stroytransgaz.april-inn.ru/auth/login"; //DEV

        Response response = given()
                .header("Content-Type", "application/json")

                .body("{\"username\":\"testccpe\",\"password\":\"testccpe\"}")

                .when()
                .post(urlApi);

        System.out.println("Token - " + response.path("accessToken").toString());

        Assert.assertEquals(response.statusCode(), 200);


        JSONObject jsonObject = new JSONObject(response.getBody().asString());

        String accessToken = jsonObject.get("accessToken").toString();

        return accessToken;
    }
}
