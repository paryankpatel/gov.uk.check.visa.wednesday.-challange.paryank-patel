package gov.uk.visa.check.pages;

import com.aventstack.extentreports.Status;
import gov.uk.visa.check.customlisteners.CustomListeners;
import gov.uk.visa.check.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class WorkTypePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='response-0']")
    WebElement selectOption;

    @CacheLookup
    @FindBy(xpath = "//button[@class='gem-c-button govuk-button gem-c-button--bottom-margin']")
    WebElement continueButton;


    public void selectJobType(String job) {
        clickOnElement(selectOption);
        Reporter.log("select option" + selectOption.toString());
        CustomListeners.test.log(Status.PASS, "select option" + selectOption);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on" + continueButton);
        clickOnElement(continueButton);
    }
}
