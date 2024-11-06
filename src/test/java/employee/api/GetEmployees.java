package employee.api;


import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;
import settings.WebDriverSettings;

import static io.restassured.RestAssured.given;
import static java.util.function.Predicate.not;
import static org.hamcrest.Matchers.*;

public class GetEmployees extends WebDriverSettings {


    @Test(description = "Получить список сотрудников ", priority = 1)
    @Step("Step 1")
    public void getEmployeesList() throws JSONException {



        // GIVEN
        given()
                .filter(new AllureRestAssured())
                .log().all()
                .baseUri(urlApi)
                .contentType(ContentType.JSON)

                // WHEN
                .when()
                .get("/employees")

                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("data.middle_name", anyOf(),containsString("Арк"))//containsString("Аркадиевич"))
                .body("data[0].first_name", containsString("Инноке"))
                .body("data[0].last_name", containsString("Шм"))
                .body("data[0].email", containsString("shi"))
                .body("data[0].office_phone", containsString("499100"))
                .body("data[0].office_phone_ext", containsString("23"))
                .body("data[0].mobile_phone", containsString("790"))
                .body("data[0].position", containsString("дир"))
                .body("data[0].department", containsString("ИТ"))
                .body("data[0].company", containsString("Строй"));
        }
    }

