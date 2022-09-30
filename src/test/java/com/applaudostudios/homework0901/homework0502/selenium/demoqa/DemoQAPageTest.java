package com.applaudostudios.homework0901.homework0502.selenium.demoqa;

import com.applaudostudios.homework0901.homework0502.selenium.BaseTest;
import homework0502.demoqa.DemoQAFormsPage;
import homework0502.demoqa.DemoQAPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DemoQAPageTest extends BaseTest {

    private SoftAssert softAssert;

    @Test
    public void demoQAWorkflow() throws InterruptedException{
        DemoQAPage demoQAPage = new DemoQAPage(driver);
        DemoQAFormsPage demoQAFormsPage = new DemoQAFormsPage(driver);
        String expectedURL="https://demoqa.com/forms";
        softAssert = new SoftAssert();

        System.out.println("\n ********** Executing Step 1 **********");
        demoQAPage.navigateTo();
        waitTime();

        System.out.println("\n ********** Executing Step 2 **********");
        demoQAPage.clickOnFormsButton();
        softAssert.assertEquals(expectedURL,driver.getCurrentUrl(),"Step 2: The URL is not https://demoqa.com/forms");
        waitTime();

        System.out.println("\n ********** Executing Step 3 **********");
        expectedURL="https://demoqa.com/automation-practice-form";
        demoQAFormsPage.clickOnPracticeFormButton();
        softAssert.assertEquals(expectedURL, driver.getCurrentUrl(),"Step 3: The URL is not https://demoqa.com/automation-practice-form");
        waitTime();

        demoQAFormsPage.scrollDownPage();
        waitTime();

        System.out.println("\n ********** Executing Step 4 **********");
        demoQAFormsPage.sendFormData();
        demoQAFormsPage.sendSubject();
        waitTime();

        System.out.println("\n ********** Executing Step 5 **********");
        demoQAFormsPage.selectGenderOption();
        waitTime();

        System.out.println("\n ********** Executing Step 6 **********");
        demoQAFormsPage.selectBirthDay();
        waitTime();

        System.out.println("\n ********** Executing Step 7 **********");
        demoQAFormsPage.selectHobbieOption();
        waitTime();

        System.out.println("\n ********** Executing Step 8 **********");
        demoQAFormsPage.selectPicture();
        waitTime();

        System.out.println("\n ********** Executing Step 9 **********");
        demoQAFormsPage.selectDropdownOptions();
        waitTime();

        System.out.println("Verifying Form Info");
        List<String> formData=demoQAFormsPage.obtainFormData();

        System.out.println("\n ********** Executing Step 10 **********");
        demoQAFormsPage.clickSubmitButton();
        waitTime();

        System.out.println("Verifying PopUp Table Info");
        List<String> popUpTableData=demoQAFormsPage.obtainTableData();
        softAssert.assertEquals(popUpTableData.get(0), formData.get(0)+" "+formData.get(1),"The name is incorrect");
        softAssert.assertEquals(popUpTableData.get(1), formData.get(2),"The email is incorrect");
        softAssert.assertEquals(popUpTableData.get(2),"Male","The gender is incorrect");
        softAssert.assertEquals(popUpTableData.get(3), formData.get(3),"The number is incorrect");
        softAssert.assertEquals(popUpTableData.get(4), "12 September,2022","The date is incorrect");
        softAssert.assertEquals(popUpTableData.get(5), formData.get(5),"The subject is incorrect");
        softAssert.assertEquals(popUpTableData.get(6), "Sports","The hobbie is incorrect");
        softAssert.assertEquals(popUpTableData.get(7),"Selenium_logo.png","The file is incorrect");
        softAssert.assertEquals(popUpTableData.get(8),formData.get(7),"The address is incorrect");
        softAssert.assertEquals(popUpTableData.get(9),formData.get(8)+" "+formData.get(9),"The state and city are incorrect");

        waitTime();

        System.out.println("\n ********** Executing Step 11 **********");
        demoQAFormsPage.closePopUp();
        waitTime();

        demoQAFormsPage.closeBrowser();

        softAssert.assertAll();


    }

    public void waitTime() throws InterruptedException {
        synchronized (driver){
            driver.wait(2000);
        }
    }
}
