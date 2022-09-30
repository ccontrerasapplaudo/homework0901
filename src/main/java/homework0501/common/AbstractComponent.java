package homework0501.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractComponent {

    protected WebDriverWait wait;

    public AbstractComponent(final WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();
}
