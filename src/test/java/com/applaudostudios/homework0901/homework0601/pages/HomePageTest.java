package com.applaudostudios.homework0901.homework0601.pages;


import com.applaudostudios.homework0901.BaseTest;
import com.applaudostudios.homework0901.homework0601.retries.HomePageRetry;
import homework0601.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;
    private int counter = 0;

    @BeforeClass(alwaysRun = true)
    public void setupPages(){
        this.homePage = new HomePage(driver);
    }

    @Test(priority = 1,groups = "homePageGroup")
    public void navigateToPage() throws InterruptedException {
        System.out.println("Executing Test 1 of HomePage\n");
        homePage.testOneHomePage("https://www.loc.gov/");
        waitTime();
        System.out.println("Finishing Test 1 of HomePage\n");
    }

    @Test(priority = 2,groups = "homePageGroup",retryAnalyzer = HomePageRetry.class)
    public void analyzeWithIRetry() throws InterruptedException {
        System.out.println("Executing Test 2 of HomePage\n");
        homePage.testTwoHomePage("4/4",counter);
        counter++;
        waitTime();
        System.out.println("Finishing Test 2 of HomePage\n");
    }

    @Test(priority = 2,groups = "homePageGroup",dataProvider = "validateSearchesData")
    public void validateSearches(String buttonText,int index) throws InterruptedException {
        System.out.println("Executing Test 3 of HomePage\n");
        homePage.testThreeHomePage(buttonText,index);
        waitTime();
        System.out.println("Finishing Test 3 of HomePage\n");
    }

    @Test(dependsOnMethods = {"navigateToPage","analyzeWithIRetry","validateSearches"},groups = "homePageGroup")
    public void clickDigitalCollections() throws InterruptedException {
        System.out.println("Executing Test 4 of HomePage\n");
        homePage.testFourHomePage();
        waitTime();
        System.out.println("Finishing Test 4 of HomePage\n");
    }

    @DataProvider
    public Object[][] validateSearchesData(){
        return new Object[][]{
                {"Civil War",0},
                {"WPA",1},
                {"National Parks",2},
                {"Dust Bowl",3},
                {"Maps",4},
                {"Ukraine",5},
        };
    }
}
