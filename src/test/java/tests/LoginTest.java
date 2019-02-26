package tests;

import config.TestConfig;
import org.junit.Test;
import pages.Home;

public class LoginTest extends TestConfig {

    @Test
    public void userShouldSuccessfullyLogin() {
        new Home()
                .openAdminPanel()
                .submitLogInFormWithValidData()
                .userShouldBeSuccessfullyLogged();
    }

    @Test
    public void userShouldNotSuccessfullyLogin() {
        new Home()
                .openAdminPanel()
                .submitLogInFormWithInvalidData()
                .userShouldNotBeSuccessfullyLogged();
    }
}
