package project.api;


import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;
import settings.DriverSettingsAPI;
import utilites.api.BearerToken;
import utilites.ui.RandomValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;


public class CreateProject {

    //Получение токена
    BearerToken accessToken = new BearerToken();
    String token = accessToken.getAccessToken();
    ValidatableResponse validatableResponse;

    @Test(description = "Создать проект ", priority = 1)
    @Step("Step 1")
    public void createProject()  {
        //Получение токена
        BearerToken accessToken = new BearerToken();
        String token = accessToken.getAccessToken();
//        RandomValue randomNum = new RandomValue();

        List<String> randomValueList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String SALTCHARS = "1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < 5) { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            randomValueList.add(salt.toString());
        }
        String json = "{\"type\":\"Проектная документация\"," +
                "\"num\":\""+ randomValueList.remove(0) +"\"," +
                "\"name\":\"Проект Тест QA\"," +
                "\"contract\":\"Договор №12345\"," +
                "\"location\":\"Волгоград\"," +
                "\"type_of_work\":\"Строительство\"," +
                "\"funding_source\":\"Прямое финансирование\"," +
                "\"bim\":\"ИМ здания РД\"," +
                "\"launch_dt\":\"2024-11-22T00:00:00.000Z\"," +
                "\"completion_dt\":\"\"," +
                "\"template_id\":3," +
                "\"note\":\"<p>Описание проекта</p>\"," +
                "\"participants\":" +
                "[{\"role_id\":2,\"employee_id\":28},{\"role_id\":1,\"employee_id\":8}]}";

Response resp= RestAssured.
                // GIVEN
                  given()
                .log().all()
                .baseUri("https://dev-stroytransgaz.april-inn.ru/api/v1")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(json)

                // WHEN
                .when().post("/projects");

                // THEN
        resp.then().log().all().assertThat()
                .statusCode(201)
                .statusLine("HTTP/1.1 201 Created");

        //Fetch response parameters
        JsonPath js = new JsonPath(resp.asString());
        String status = js.getString("status");
        String id = js.getString("data.project_id");
        System.out.println("Id " + id);
        int projectid = Integer.parseInt(id);
        System.out.println("Project id " + projectid);

//                .root("data")
//                .body("", hasItems(hasEntry("middle_name", "Тестовский"), hasEntry("company", "Стройтрансгаз")),
//                        "", hasItems(hasEntry("email", "m.davydov@stroytransgaz.com"), hasEntry("first_name", "Козлов")));

//        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
    }

}




