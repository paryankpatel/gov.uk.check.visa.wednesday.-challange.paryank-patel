package gov.uk.visa.check.pages;

import com.aventstack.extentreports.Status;
import gov.uk.visa.check.customlisteners.CustomListeners;
import gov.uk.visa.check.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ResultPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement verifyResult;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You need a visa to work in health and care')]")
    WebElement resultMessage;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'You may need a visa')]")
    WebElement textVerification;


    public String getResultMessage() {
        Reporter.log("Verify text" + verifyResult.toString());
        CustomListeners.test.log(Status.PASS, "Verify text" + verifyResult);
        String text = verifyResult.getText();
        return text;

    }

    public void confirmResultMessage(String expectedMessage) {
        getTextFromElement(resultMessage);
        Reporter.log("verify message" + resultMessage.toString());
        CustomListeners.test.log(Status.PASS, "verify message" + resultMessage);

    }

    public String verifyText() {
        Reporter.log("verify text" + textVerification.toString());
        CustomListeners.test.log(Status.PASS, "verify text " + textVerification);
        return getTextFromElement(textVerification);

    }
}
