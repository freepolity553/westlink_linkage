package employee.api;


import io.restassured.http.ContentType;
import org.json.JSONException;
import org.testng.annotations.Test;
import settings.WebDriverSettings;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class GetEmployeesWithProject extends WebDriverSettings {


    @Test(description = "Получить список сотрудников ", priority = 1)
    public void getEmployeesWithProject() throws JSONException {
        // GIVEN
        given()
                .log().all()
                .baseUri(urlApi)
                .contentType(ContentType.JSON)

                // WHEN
                .when()
                .get("/1/projects")

                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("data[0].name", containsString("Строительство"));
                //.body("data[0].first_name", Every.everyItem(Matchers.containsString("Иннок")));
        }

    }

