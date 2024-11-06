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

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetArchivalDocList extends WebDriverSettings {


    @Test(description = "Создать РВИ ", priority = 1)
    public void getArchivalDocuments() throws JSONException {
        // GIVEN
        given()
                .log().all()
                .baseUri(urlApi)
                .contentType(ContentType.JSON)

                // WHEN
                .when()
                .get("/archive/documents")

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

