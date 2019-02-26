package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static utility.Screenshot.captureScreenshot;

public class Home extends BasePage {

    public Home() {
        super();
    }

    @FindBy(id = "adminPanel")
    private WebElement panelLink;

    @Step
    public LogIn openAdminPanel() {
        panelLink.click();
        captureScreenshot();

        return new LogIn();
    }

    @FindBy(id = "addComplain")
    private WebElement complainLink;

    @Step
    public ComplainForm openComplainForm() {
        complainLink.click();
        captureScreenshot();

        return new ComplainForm();
    }
}
