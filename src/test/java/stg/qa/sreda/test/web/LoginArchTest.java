package stg.qa.sreda.test.web;

import org.testng.annotations.Test;
import settings.WebDriverSettings;
import stg.qa.sreda.config.Config;
import stg.qa.sreda.page.LoginPage;
import stg.qa.sreda.page.MainPage;

public class LoginArchTest extends WebDriverSettings {

private static final Config Arch = Config.getInstance();
    @Test

    void loginByArchShouldBeAvailable () {
        driver.get(Arch.frontUrl());

        new LoginPage(driver).doLogin("testarch","testarch");
        new MainPage(driver).enterArchive();

    }
}
