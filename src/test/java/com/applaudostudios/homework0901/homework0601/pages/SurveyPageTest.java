package com.applaudostudios.homework0901.homework0601.pages;

import com.applaudostudios.homework0901.BaseTest;
import homework0601.SurveyPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SurveyPageTest extends BaseTest {
    private SurveyPage surveyPage;

    @BeforeClass(alwaysRun = true)
    public void setupPages(){
        this.surveyPage = new SurveyPage(driver);
    }

    @Test(priority = 5,groups = "SurveyGroup")
    public void scrollToTakeOurSurvey() throws InterruptedException {
        System.out.println("Executing Test 8 of SurveyPage\n");
        surveyPage.testEightSurveyPage("https://www.loc.gov/");
        waitTime();
        System.out.println("Finishing Test 8 of SurveyPage\n");
    }

    @Test(priority = 6,groups = "SurveyGroup")
    public void verifyNumberOfQuestions() throws InterruptedException {
        System.out.println("Executing Test 9 of SurveyPage\n");
        surveyPage.testNineSurveyPage(3);
        waitTime();
        System.out.println("Finishing Test 9 of SurveyPage\n");
    }

    @Test(priority = 7,groups = "SurveyGroup",dataProvider = "answerNumbersData")
    public void answerQuestions(int answerNumber) throws InterruptedException {
        System.out.println("Executing Test 10 of SurveyPage\n");
        surveyPage.testTenSurveyPage(answerNumber);
        waitTime();
        System.out.println("Finishing Test 10 of SurveyPage\n");
    }

    @Test(priority = 8,groups = "SurveyGroup")
    public void sendAnswers() throws InterruptedException {
        System.out.println("Executing Test 11 of SurveyPage\n");
        surveyPage.testElevenSurveyPage("Thank you for providing feedback on the Library of Congress web site! Click \"finish survey\" to redirected to www.loc.gov, or simply close this page to exit.");
        waitTime();
        System.out.println("Finishing Test 11 of SurveyPage\n");
    }

    @DataProvider
    public Object[][] answerNumbersData(){
        return new Object[][]{
                {0},
                {2},
                {15},
        };
    }

}
