package gov.uk.visa.check.pages;

import com.aventstack.extentreports.Status;
import gov.uk.visa.check.customlisteners.CustomListeners;
import gov.uk.visa.check.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class StartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[@class='gem-c-button govuk-button govuk-button--start']")
    WebElement startNowButton;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Accept additional cookies')]")
    WebElement acceptCookies;


     public void clickOnStartNow(){
         Reporter.log("Click on" + startNowButton.toString());
         CustomListeners.test.log(Status.PASS,"Click on" + startNowButton);
         clickOnElement(startNowButton);
     }
     public void acceptCookiesTab(){
         clickOnElement(acceptCookies);
         Reporter.log("Accept cookies" + acceptCookies.toString());
         CustomListeners.test.log(Status.PASS, "Accept cookies"+ acceptCookies);
     }
}
