package test;

import org.testng.annotations.Test;
import page.Login;



public class LoginTest extends TestBase1 {

    @Test
    public void  loginTest() {

        Login login = new Login(driver);
        login.loginArch("testarch","testarch");

    }
}
