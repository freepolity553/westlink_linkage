package archive.api;


import io.restassured.http.ContentType;
import org.json.JSONException;
import org.testng.annotations.Test;
import settings.WebDriverSettings;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import utilites.api.BearerToken;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetArchivalDocumentVersionList  {
    //Получение токена
    BearerToken accessToken = new BearerToken();
    String token = accessToken.getAccessToken();

    @Test(description = "детальная информация о документе ", priority = 1)
    public void getArchivalDocument() throws JSONException {
        // GIVEN
        given()
                .log().all()
                .baseUri("https://dev-stroytransgaz.april-inn.ru/api/v1")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)


                // WHEN
                .when()
                .get("/archival_document/6/versions")

                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
//                .body("data.project_name", equalTo("Строительство телевышки на западном съезде с ЦКАД"))
//                .body("data.versions[0].document_version_id", equalTo(41));
        }

    }

