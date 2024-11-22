package archive.api;


import archive.TestdataAPI;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.testng.annotations.Test;
import settings.DriverSettingsAPI;
import settings.WebDriverSettings;
import utilites.api.BearerToken;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetArchivalDocument  {

    //Получение токена
    BearerToken accessToken = new BearerToken();
    String token = accessToken.getAccessToken();

    @Test(description = "детальная информация о документе ", priority = 1)
    public void getArchivalDocument() throws JSONException {
        // GIVEN
        given()
                .log().all()
                .baseUri(DriverSettingsAPI.urlApi)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)


                // WHEN
                .when()
                .get("/archival_document/5/details")

                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("data[0].name", equalTo("Согласование на доп.обеспечение "))
                .body("data[0].company_name", equalTo("Промстройсвязь"))
                .body("data[0].project_name", equalTo("1982.43 Строительство водного сооружения г.Волгоград"));
        }

    }

