package archive.api;


import archive.TestdataAPI;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.hamcrest.core.Every;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.WebDriverSettings;
import utilites.api.BearerToken;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetArchivalDocList extends WebDriverSettings {

    //Получение токена
    BearerToken accessToken = new BearerToken();
    String token = accessToken.getAccessToken();

    @Test(description = "Создать РВИ ", priority = 1)
    public void getArchivalDocuments() throws JSONException {
        // GIVEN
        given()
                .log().all()
                .baseUri(urlApi)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .queryParams("start_date", "2006-01-02T15:04:05Z","end_date","2025-01-02T15:04:05Z")

                // WHEN
                .when()
                .get("/archival_documents")

                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
        }

    }

