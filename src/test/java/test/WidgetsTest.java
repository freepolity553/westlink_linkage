package test;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import settings.Constants;


public class WidgetsTest extends TestBase {


    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "",priority = 1)
    @Step("")
    public void  addTableWidgetTest() {
        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        dashboard.enterDashboard();
        widgets.click(widgets.constructorWidgets);
        widgets.addTableWidget();



    }

}
