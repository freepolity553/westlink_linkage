package test;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import settings.Constants;

import java.time.Duration;


public class E2ETest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")

    @Test(description = "Login",priority = 1)
    @Step("login")
    public void  E2ETest() {

        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        mainPanel.enterDashboard();
//        users.enterUsersPage();
//        groups.click(groups.groupsTab);
//        groups.createGroup();
//        users.click(users.usersTab);
//        users.createNewUser();
//        users.addGroup();
//        groups.back();
//        organization.click(organization.organizationTab);
//        organization.addOrg();
//        users.back();
        users.click(mainPanel.adminDashboard);
        metrics.click(metrics.constructorMetrics);
        metrics.addSQLMetric();
        metrics.click(mainPanel.adminDashboard);
        widgets.click(widgets.constructorWidgets);
        widgets.addTableWidget();
        metrics.click(mainPanel.adminDashboard);
        widgets.click(widgets.constructorWidgets);
        widgets.addDiagrammeWidget();
        metrics.click(mainPanel.adminDashboard);
        dashboards.click(dashboards.constructorDashboards);
        dashboards.addDashboard();




    }
}
