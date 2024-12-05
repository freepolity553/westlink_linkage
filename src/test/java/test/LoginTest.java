package test;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import settings.Constants;


public class LoginTest extends TestBase1 {



    @Test
    @Step("login")
    public void  loginTest() {


        login.loginArch(Constants.USERNAME_ARCH, Constants.PASSWORD_ARCH);

    }

    @Test
    @Step("loginArch")
    public void  loginTest1() {


        login.loginArch(Constants.USERNAME_ARCH, Constants.PASSWORD_ARCH);
        main.clickArchiveMenu();
        archive.checkAllElementsOnPagePresent();

    }
}
