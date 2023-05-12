package gov.uk.visa.check.testsuite;

import gov.uk.visa.check.customlisteners.CustomListeners;
import gov.uk.visa.check.pages.*;
import gov.uk.visa.check.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class VisaConfirlmationTest extends BaseTest {

     StartPage startPage;
     SelectNationalityPage selectNationalityPage;
     WorkTypePage workTypePage;
     ReasonForTravelPage reasonForTravelPage;
     ResultPage resultPage;
     DurationOfStayPage durationOfStayPage;

     @BeforeMethod(alwaysRun = true)
     public void inIT(){
         startPage = new StartPage();
         selectNationalityPage = new SelectNationalityPage();
         workTypePage = new WorkTypePage();
         reasonForTravelPage = new ReasonForTravelPage();
         resultPage = new ResultPage();
         durationOfStayPage = new DurationOfStayPage();

     }
     @Test(groups = {"sanity","regression"})
     public void anAustralianComingToUkForTourism() throws InterruptedException {
       startPage.clickOnStartNow();
       startPage.acceptCookiesTab();
       Thread.sleep(2000);
       selectNationalityPage.selectNationality("Australia");
       Thread.sleep(2000);
       selectNationalityPage.clickOnContinueButton();
       Thread.sleep(2000);
       reasonForTravelPage.selectReasonForVisit("tourism");
       reasonForTravelPage.clickOnContinueButton();
       String expectedMessage = "You will not need a visa to come to the UK";
       String actualMessage = resultPage.getResultMessage();
         Assert.assertEquals(actualMessage,expectedMessage,"Message does not match");


     }
     @Test(groups = {"smoke","regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() throws InterruptedException {
         startPage.clickOnStartNow();
         startPage.acceptCookiesTab();
         Thread.sleep(2000);
         selectNationalityPage.selectNationality("Chile");
         Thread.sleep(2000);
         selectNationalityPage.clickOnContinueButton();
         Thread.sleep(2000);
         reasonForTravelPage.selectReasonForVisit("Work,academic visit or business");
         reasonForTravelPage.clickOnContinueButton();
         durationOfStayPage.selectLenghtOfStay("longer than six months");
         durationOfStayPage.clickOnContinueButton();
         workTypePage.selectJobType("Health and care professional");
         workTypePage.clickOnContinueButton();


     }
     @Test(groups = {"regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() throws InterruptedException {
         startPage.clickOnStartNow();
         startPage.acceptCookiesTab();
         Thread.sleep(2000);
         selectNationalityPage.selectNationality("Colombia");
         Thread.sleep(2000);
         selectNationalityPage.clickOnContinueButton();
         Thread.sleep(2000);
         reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
         reasonForTravelPage.clickOnContinueButton();
         softAssert(resultPage.verifyText(),"You may need a visa");
     }
}
