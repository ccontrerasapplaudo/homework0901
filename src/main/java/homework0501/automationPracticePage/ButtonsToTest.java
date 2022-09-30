package homework0501.automationPracticePage;

import homework0501.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ButtonsToTest extends AbstractComponent {

    @FindBy(xpath = "//header[@class=\"jumbotron text-center header_style\"]//button[@class=\"btn btn-primary\"]")
    private List<WebElement> buttonsToTest;
    @FindBy(xpath = "//*[contains(text(),\"VIEW ALL COURSES\")]")
    private WebElement controlElement;

    private WebDriver webDriver;

    public ButtonsToTest(final WebDriver driver){
        super(driver);
        this.webDriver=driver;
    }

    public void setButtonsToTestClick(){
        String initialURL = webDriver.getCurrentUrl();

        System.out.println("k) l)");
        System.out.println("Clicking on every button \n");

        buttonsToTest.get(0).click();
        this.wait.until((d)->controlElement.isDisplayed());

        String finalURL = webDriver.getCurrentUrl();
        webDriver.navigate().back();

        if(initialURL.equals(finalURL)){
            System.out.println("Same URL - Btn: "+buttonsToTest.get(0).getText());
        }
        else{
            System.out.println("Different URL - Btn: "+buttonsToTest.get(0).getText());
        }

        buttonsToTest.get(1).click();
        finalURL = webDriver.getCurrentUrl();

        if(initialURL.equals(finalURL)){
            System.out.println("Same URL - Btn: "+buttonsToTest.get(1).getText());
        }
        else{
            System.out.println("Different URL - Btn: "+buttonsToTest.get(1).getText());
        }

        buttonsToTest.get(2).click();
        finalURL = webDriver.getCurrentUrl();

        if(initialURL.equals(finalURL)){
            System.out.println("Same URL - Btn: "+buttonsToTest.get(2).getText());
        }
        else{
            System.out.println("Different URL - Btn: "+buttonsToTest.get(2).getText());
        }

        buttonsToTest.get(3).click();
        finalURL = webDriver.getCurrentUrl();

        if(initialURL.equals(finalURL)){
            System.out.println("Same URL - Btn: "+buttonsToTest.get(3).getText());
        }
        else{
            System.out.println("Different URL - Btn: "+buttonsToTest.get(3).getText());
        }

    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
