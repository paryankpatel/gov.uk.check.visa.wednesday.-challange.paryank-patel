package gov.uk.visa.check.pages;

import com.aventstack.extentreports.Status;
import gov.uk.visa.check.customlisteners.CustomListeners;
import gov.uk.visa.check.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@value='longer_than_six_months']")
    WebElement moreThanSixMonth;

    @CacheLookup
    @FindBy(xpath = "//input[@value='six_months_or_less']")
    WebElement sixMonthOrLess;

    @CacheLookup
    @FindBy(xpath = "//button[@class='gem-c-button govuk-button gem-c-button--bottom-margin']")
    WebElement continueButton;

    public void selectLenghtOfStay(String moreOrLess) {
        switch (moreOrLess) {
            case "six months or less":
                sixMonthOrLess.click();
                break;
            case "longer than six months":
                moreThanSixMonth.click();
                break;

        }


    }

    public void clickOnContinueButton() {
        Reporter.log("Click on" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on" + continueButton);
        clickOnElement(continueButton);
    }
}

