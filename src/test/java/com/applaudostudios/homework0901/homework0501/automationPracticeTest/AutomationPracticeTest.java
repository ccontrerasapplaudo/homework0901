package com.applaudostudios.homework0901.homework0501.automationPracticeTest;


import com.applaudostudios.homework0901.BaseTest;
import homework0501.automationPracticePage.AutomationPracticePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AutomationPracticeTest extends BaseTest {

    private AutomationPracticePage automationPracticePage;

    @BeforeTest
    public void setupPages(){
        this.automationPracticePage = new AutomationPracticePage(driver);
    }

    @Test(dataProvider = "getData")
    public void AutomationPracticeWorkflow(int randomResult){

        System.out.println("\n ********** Results exercise 1 **********");
        automationPracticePage.goTo();
        Assert.assertTrue(automationPracticePage.getRadioButton().isDisplayed());
        automationPracticePage.getRadioButton().clickRadioByRandomResult(randomResult);
        automationPracticePage.getRadioButton().getRadioButtonsText(randomResult);

        System.out.println("\n ********** Results exercise 2 **********");
        Assert.assertTrue(automationPracticePage.getSuggestionClassInput().isDisplayed());
        automationPracticePage.getSuggestionClassInput().obtainInputPlaceholder();
        automationPracticePage.getSuggestionClassInput().sendSuggestion();
        automationPracticePage.getSuggestionClassInput().clickSuggestion();
        automationPracticePage.getSuggestionClassInput().printExpectedResult();

        System.out.println("\n ********** Results exercise 3 **********");
        automationPracticePage.getDropdownMenu().selectElement();
        automationPracticePage.getDropdownMenu().selectElementUsingWebElement();

        System.out.println("\n ********** Results exercise 4 **********");
        automationPracticePage.getButtonsToTest().setButtonsToTestClick();

        System.out.println("\n ********** Results exercise 5 **********");
        Assert.assertTrue(automationPracticePage.getOpenTabButton().isDisplayed());
        automationPracticePage.getOpenTabButton().openNewTab();
        automationPracticePage.getOpenTabButton().returnParentTab();
        automationPracticePage.getOpenTabButton().numberOfTabs();
    }

    @DataProvider
    public Object[][] getData(){

        int min = 1;
        int max = 3;
        int randomResult = (int)(Math.random()*(max-min+1)+min);

        return new Object[][]{
                {randomResult},
        };

    }

}
