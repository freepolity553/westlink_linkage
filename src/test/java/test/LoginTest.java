package test;

import org.testng.annotations.Test;
import page.Login;



public class LoginTest extends TestBase1 {

    @Test
    public void  loginTest() {


        login.loginArch("testarch","testarch");

    }

    @Test
    public void  loginTest1() {


        login.loginArch("testarch","testarch");
        main.clickArchiveMenu();
        archive.checkAllElementsOnPagePresent();

    }
}
