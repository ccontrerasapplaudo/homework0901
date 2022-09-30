package homework0601;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DigitalCollectionsPage extends BasePage{
    @FindBy(id = "search")
    WebElement inputSearchBox;

    @FindBy(css = "button.header-search-button")
    WebElement buttonSearch;

    @FindBy(xpath = "//*[contains(text(),\"Digital Collections\")]")
    List<WebElement> elementContainingWord;
    public DigitalCollectionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void testFiveDigitalCollectionsPage(){

    }

    public void testSixDigitalCollectionsPage(){
        verifyIfTextIsPresentOnWebPage(elementContainingWord);
    }

    public void testSevenDigitalCollectionsPage(String search){
        sendKeysToElement(inputSearchBox,search);
        waitAndClickElement(buttonSearch);
        returnPreviousPage();
    }
}
