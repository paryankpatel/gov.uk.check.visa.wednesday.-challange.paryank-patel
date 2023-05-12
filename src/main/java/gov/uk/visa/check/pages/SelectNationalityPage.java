package gov.uk.visa.check.pages;

import com.aventstack.extentreports.Status;
import gov.uk.visa.check.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import gov.uk.visa.check.customlisteners.CustomListeners;

public class SelectNationalityPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@name='response']")
    WebElement nationalityDropDownList;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"current-question\"]/button")
    WebElement continueTab;

   public void selectNationality(String name){
       Reporter.log("Select Nationality" + nationalityDropDownList.toString());
       CustomListeners.test.log(Status.PASS,"Select Nationality" + nationalityDropDownList);
       selectByVisibleTextFromDropDown(nationalityDropDownList,name);
   }
   public void clickOnContinueButton(){
       Reporter.log("Click on" + continueTab.toString());
       CustomListeners.test.log(Status.PASS,"Click on" + continueTab);
       clickOnElement(continueTab);
   }
}
