package homework0501.automationPracticePage;

import homework0501.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;


public class OpenTabButton extends AbstractComponent {

    @FindBy(id = "opentab")
    private WebElement openTabButton;
    private WebDriver webDriver;

    public OpenTabButton(final WebDriver driver){
        super(driver);
        this.webDriver=driver;
    }

    public void openNewTab(){
        System.out.println("m)");
        System.out.println("Opening 9 tabs");
        for(int i=0;i<8;i++){
            openTabButton.click();
        }
    }

    public void returnParentTab(){
        System.out.println("n)");
        System.out.println("Switch to parent tab");
        ArrayList<String> tabs_windows = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs_windows.get(0));
    }

    public void numberOfTabs(){
        System.out.println("o)");
        System.out.println("Number of tabs: "+webDriver.getWindowHandles().size());
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.openTabButton.isDisplayed());
    }
}

