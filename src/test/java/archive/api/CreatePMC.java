package archive.api;

import archive.QueryDB;
import archive.TestdataAPI;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import settings.WebDriverSettings;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@Listeners
@Epic("New functionality")
@Feature("Archive Tests")
public class CreatePMC extends WebDriverSettings {
    QueryDB app;

    @Test(description = "Создать РВИ ", priority = 1)
    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка создания РВИ")
    public void createPMC() throws JSONException {
        // GIVEN
        given()
                .filter(new AllureRestAssured())
                .log().all()
                .baseUri(urlApi)
                .contentType(ContentType.JSON)
                .body(TestdataAPI.requestPMC)

                // WHEN
                .when()
                .post("/pmc")

                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(201);


//                .body("data[0].name", equalTo("Согласование на доп.обеспечение "))
//                .body("data[0].company_name", equalTo("Промстройсвязь"))
//                .body("data[0].project_name", equalTo("1982.43 Строительство водного сооружения г.Волгоград"));
    }

    @Test
    public void checkDBonPMC () throws JSONException{
        app = new QueryDB();
        app.connect();
        given()
                .filter(new AllureRestAssured())
                .log().all()
                .baseUri(urlApi)
                .contentType(ContentType.JSON)
                .body(TestdataAPI.requestPMC)

                // WHEN
                .when()
                .get("/api/v1/pmc")

                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("data[0].num", equalTo(QueryDB.fnum));
    }


    @Test(description = "Создать РВИ ", priority = 1)
    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка создания РВИ")
    public void createPMCserverError() throws JSONException {
        // GIVEN
        given()

                .log().all()
                .baseUri(urlApi)
                .contentType(ContentType.JSON)
                .body(TestdataAPI.requestPMCerror)

                // WHEN
                .when()
                .post("/pmc")

                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(500);

    }
}
