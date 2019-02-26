package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static utility.Screenshot.captureScreenshot;

public class LogIn extends LoginPage {

    public LogIn() {
        super();
    }

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "logIn")
    private WebElement logInButton;

    private void fillLogInForm ( boolean validForm ) {
        usernameInput.sendKeys("dawid@minda.pl_office");
        if(validForm) {
            passwordInput.sendKeys("12345678");
        }
    }

    @Step
    public Profile submitLogInFormWithValidData() {
        fillLogInForm(true);
        captureScreenshot();
        logInButton.click();
        return new Profile();
    }

    @Step
    public LogIn submitLogInFormWithInvalidData() {
        fillLogInForm(false);
        captureScreenshot();
        logInButton.click();
        return this;
    }

    @FindBy(id = "alertMessage")
    private WebElement logInError;

    @Step
    public void userShouldNotBeSuccessfullyLogged() {
        String profilePageHeaderText = logInError.getText();
        String expectedHeaderText = "Niepoprawne logowanie. Spróbuj ponownie.";

        Assert.assertThat(profilePageHeaderText, IsEqual.equalTo(expectedHeaderText));
    }
}
