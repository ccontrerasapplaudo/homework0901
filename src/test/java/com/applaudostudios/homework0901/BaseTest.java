package com.applaudostudios.homework0901;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.Objects;

public class BaseTest {

    public static WebDriver driver;
    String browser = System.getProperty("browser");
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;

    @BeforeTest(alwaysRun = true)
    public void setUp(){

        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");

        edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--log-level=3");
        edgeOptions.addArguments("--silent");

        if(browser == "" || browser == null){
            browser = "chrome";
        }

        switch(browser) {
            case "edge":
                driver = WebDriverManager.edgedriver().capabilities(edgeOptions).create();
                break;
            case "firefox":
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "chrome":
                driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
                break;
            default:
                driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quitDriver(){
        if(Objects.nonNull(driver)){
            driver.quit();
        }
    }

    public void waitTime() throws InterruptedException {
        synchronized (driver){
            driver.wait(1500);
        }
    }

}
