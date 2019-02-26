package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class CompleteRequest extends BasePage {

    public CompleteRequest() {
        super();
    }

    @FindBy(css = "h2")
    private WebElement profilePageHeader;

    @Step
    public void customerShouldSuccessfulySendForm() {
        String profilePageHeaderText = profilePageHeader.getText();
        String expectedHeaderText = "Sukces!";

        Assert.assertThat(profilePageHeaderText, IsEqual.equalTo(expectedHeaderText));
    }

}
