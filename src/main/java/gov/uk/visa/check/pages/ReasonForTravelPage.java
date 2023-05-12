package gov.uk.visa.check.pages;

import com.aventstack.extentreports.Status;
import gov.uk.visa.check.customlisteners.CustomListeners;
import gov.uk.visa.check.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ReasonForTravelPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"current-question\"]/div/fieldset/div/div[1]/label")
    WebElement selectTourism;



    @CacheLookup
    @FindBy(xpath = "//button[@class='gem-c-button govuk-button gem-c-button--bottom-margin']")
    WebElement continueButton;





    public void selectReasonForVisit(String name){
        Reporter.log("Select reason" + selectTourism.toString());
        CustomListeners.test.log(Status.PASS,"Select reason" + selectTourism);
        clickOnElement(selectTourism);
    }

    public void clickOnContinueButton(){
        Reporter.log("Click on" + continueButton.toString());
        CustomListeners.test.log(Status.PASS,"Click on" + continueButton);
        clickOnElement(continueButton);
    }



}
