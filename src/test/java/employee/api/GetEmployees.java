package employee.api;


import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utilites.api.BearerToken;
import settings.WebDriverSettings;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetEmployees {

    //Получение токена
    BearerToken accessToken = new BearerToken();
    String token = accessToken.getAccessToken();

    @Test(description = "Получить список сотрудников ", priority = 2)
    @Step("Step 1")
    public void getEmployeesList()  {
//        //Получение токена
//        BearerToken accessToken = new BearerToken();
//        String token = accessToken.getAccessToken();

        // GIVEN
        given()
                .filter(new AllureRestAssured())
                .log().all()
                .baseUri("https://dev-stroytransgaz.april-inn.ru/api/v1")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)

                // WHEN
                .when()
                .get("/employees")

                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
//                .body("data.middle_name", anyOf(),containsString("Тестовский"))//containsString("Аркадиевич"))
//                .body("data[0].first_name", containsString("Тест"))
//                .body("data[0].last_name", containsString("КГИП"))
//                .body("data[0].email", containsString("test"))
//                .body("data[0].department", containsString("ИТ"))
                .body("data[0].company", containsString("Строй"));
        }


}

