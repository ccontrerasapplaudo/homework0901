package homework0601;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{

//  Merge Completed

    @FindBy(xpath = "//a[contains(.,'Digital Collections')]")
    WebElement aDigitalCollectionsButton;

    @FindBy(css = "div.trending-top-searches a")
    List<WebElement> buttonTopSearches;

    @FindBy(xpath = "//p[@class=\"description\"]/following::div[contains(text(),\"/\")]")
    List<WebElement> divPageNumber;

    @FindBy(className = "slick-next")
    WebElement buttonSlideNext;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void testOneHomePage(String url){
        visitWebPage(url);
        validateURL(url);
    }

    public void testTwoHomePage(String expectedText,int index) throws InterruptedException {
        waitAndClickElement(buttonSlideNext);
        waitTime();
        validateTextHardAssert(divPageNumber.get(index),expectedText);
    }

    public void testThreeHomePage(String buttonText,int index){
        validateText(buttonTopSearches.get(index),buttonText);
    }

    public void testFourHomePage(){
        waitAndClickElement(aDigitalCollectionsButton);
    }
}
