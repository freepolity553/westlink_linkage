package linkageTests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.Constants;

import java.io.IOException;
import java.time.Duration;


public class E2ETest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

    @Epic("Testing")
    @Feature(value = "Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing description")
    @Story(value = "Story description")


    @Test(invocationCount = 1)
    public void  E2ETest() throws IOException {

        login.loginAdminDemo(Constants.USERNAME_ADMIN_DEMO, Constants.PASSWORD_ADMIN_DEMO);
        mainPanel.enterDashboard();
        connections.click(connections.constructorConnections);
        connections.addConnection();
        users.enterUsersPage();
        groups.click(groups.groupsTab);
        groups.createGroup();
        users.click(users.usersTab);
        users.createNewUser();
        users.addGroup();
        groups.back();
        organization.click(organization.organizationTab);
        organization.addOrg();
        users.click(mainPanel.adminDashboard);
        metrics.click(metrics.constructorMetrics);
        metrics.addSQLMetric();
        metrics.click(mainPanel.adminDashboard);
        widgets.click(widgets.constructorWidgets);
        widgets.addTableWidget();
        metrics.click(mainPanel.adminDashboard);
        widgets.click(widgets.constructorWidgets);
        widgets.addDiagrammeWidget();
        widgets.click(mainPanel.adminDashboard);
        dashboards.click(dashboards.constructorDashboards);
        dashboards.addDashboardSimple();
        dashboards.click(mainPanel.adminDashboard);
        metrics.click(metrics.constructorMetrics);
        metrics.addCitiesMetric();
        metrics.click(mainPanel.adminDashboard);
        metrics.click(metrics.constructorMetrics);
        metrics.addPointsMetric();
        metrics.click(mainPanel.adminDashboard);
        widgets.click(widgets.constructorWidgets);
        widgets.addCitiesWidget();
        metrics.click(mainPanel.adminDashboard);
        widgets.click(widgets.constructorWidgets);
        widgets.addPointsWidget();
        widgets.click(mainPanel.adminDashboard);
        dashboards.click(dashboards.constructorDashboards);
        dashboards.addDashboardAgrotech();



        dashboards.click(By.xpath("//button[1]//div[1]"));
        dashboards.threadSleep(2000);
        dashboards.click(By.xpath("//p[contains(text(),'Cохранить')]"));
        dashboards.click(By.xpath("/html/body/div[1]/div/div[3]/div[5]/div/div/div[1]/div/div/div[1]/div[2]"));
        dashboards.threadSleep(3000);

        widgets.readExcell();
        Assert.assertEquals(widgets.getCityName(),widgets.readExcell());
        dashboards.threadSleep(3000);
//        dashboards.addCodependentFiltering();
        dashboards.click(mainPanel.adminDashboard);
        workstation.click(workstation.constructorWorkstation);
        workstation.addWorkstation();
        users.clickAvatar();
        users.logout();
        login.loginUser();
        mainPanel.enterDashboard();



    }
}
