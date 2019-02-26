package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static config.WebDriverSingleton.getInstance;
import static utility.Actions.waitForVisibilityOfElement;

public class DefaultPage {


    public DefaultPage() {
        PageFactory.initElements(getInstance(), this);
        waitForVisibilityOfElement(pageContent);
    }

    @FindBy(className = "page-container-bg-solid")
    private WebElement pageContent;
}
