package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class Profile extends DefaultPage {

    public Profile() {
        super();
    }

    @FindBy(css = ".page-title > h1")
    private WebElement profilePageHeader;

    @Step
    public void userShouldBeSuccessfullyLogged() {
        String profilePageHeaderText = profilePageHeader.getText();
        String expectedHeaderText = "Strona główna";

        Assert.assertThat(profilePageHeaderText, IsEqual.equalTo(expectedHeaderText));
    }

}
