package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import utility.DataFaker;

import java.util.concurrent.ThreadLocalRandom;

import static utility.Screenshot.captureScreenshot;

public class ComplainForm extends BasePage {

    public ComplainForm() { super(); }

    private DataFaker faker = new DataFaker();

    @FindBy(id = "step2Button")
    WebElement step2Button;

    @Step
    public ComplainForm goToStep2 () {
        step2Button.click();
        captureScreenshot();

        return this;
    }

    @FindBy(css = ".filter-option.pull-left")
    WebElement selectFurnitureClick;

    @FindBy(css = ".bs-searchbox > input")
    WebElement selectFurniture;

    @FindBy(css = ".text > small")
    WebElement selectOption;

    @FindBy(id = "step3Button")
    WebElement step3Button;

    @Step
    public ComplainForm fillFurnitureModel() {
        selectFurnitureClick.click();
        selectFurniture.sendKeys("Minda");
        selectOption.click();
        step3Button.click();
        captureScreenshot();

        return this;
    }

    @FindBy(name = "r_v_numerpak")
    WebElement numerPakowacza;

    @FindBy(name = "r_v_dataprod")
    WebElement dataProdukcji;

    @FindBy(name = "r_elementy[0][number]")
    WebElement numerElementu;

    @FindBy(name = "r_elementy[0][quantity]")
    WebElement sztukiElementu;

    @FindBy(css = "label:nth-child(1) > input[type=\"checkbox\"]")
    WebElement uszkodzenieCheckbox;

    @FindBy(name = "r_v_description")
    WebElement opisReklamacji;

    private void fillStep3Form() {
        Integer random = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        numerPakowacza.sendKeys(random.toString());
        dataProdukcji.sendKeys("2018-01-01");
        numerElementu.sendKeys("20");
        sztukiElementu.sendKeys("1");

        opisReklamacji.sendKeys("Tutaj szczegółowy opis reklamacji");
    }

    @FindBy(id = "step4Button")
    WebElement step4Button;

    @Step
    public ComplainForm enterStep3ValidData() {
        fillStep3Form();
        step4Button.click();
        captureScreenshot();

        return this;
    }

    @FindBy(name = "r_name")
    WebElement customerName;

    @FindBy(name = "r_street")
    WebElement customerStreet;

    @FindBy(name = "r_city")
    WebElement customerCity;

    @FindBy(name = "r_postal")
    WebElement customerCityPostal;

    @FindBy(name = "r_phone")
    WebElement customerPhone;

    @FindBy(name = "r_email")
    WebElement customerEmail;

    @FindBy(name = "r_ordernumber")
    WebElement customerOrder;

    @FindBy(name = "r_v_orderplace")
    WebElement customerOrderPlace;

    private void fillCustomerFields() {
        customerName.sendKeys(faker.getFakeFirstname() + " " + faker.getFakeLastname());
        customerStreet.sendKeys(faker.getFakeStreet());
        customerCity.sendKeys(faker.getFakeCity());
        customerCityPostal.sendKeys("26-600");
        customerPhone.sendKeys(faker.getFakeMobilePhone());
        customerEmail.sendKeys(faker.getFakeEmail());
        Integer random = ThreadLocalRandom.current().nextInt(0, 5);
        customerOrder.sendKeys(random.toString());
        new Select(customerOrderPlace).selectByIndex(random);
    }

    @FindBy(id = "sendComplainButton")
    WebElement sendComplainButton;

    @Step
    public CompleteRequest enterCustomerForm() {
        fillCustomerFields();
        sendComplainButton.click();
        captureScreenshot();

        return new CompleteRequest();
    }
}
