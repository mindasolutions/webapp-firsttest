package tests;

import config.TestConfig;
import org.junit.Test;
import pages.Home;

public class CustomerTest extends TestConfig {

    @Test
    public void customerFillComplaintForm () {
        new Home()
                .openComplainForm()
                .goToStep2()
                .fillFurnitureModel()
                .enterStep3ValidData()
                .enterCustomerForm()
                .customerShouldSuccessfulySendForm();
    }

}
