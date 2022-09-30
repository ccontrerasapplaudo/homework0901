package homework0501.automationPracticePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticePage {
    private WebDriver driver;
    private RadioButton radioButton;
    private SuggestionClassInput suggestionClassInput;
    private DropdownMenu dropdownMenu;
    private ButtonsToTest buttonsToTest;
    private OpenTabButton openTabButton;
    public AutomationPracticePage(final WebDriver driver){
        this.driver = driver;
        this.radioButton = PageFactory.initElements(driver, RadioButton.class);
        this.suggestionClassInput = PageFactory.initElements(driver, SuggestionClassInput.class);
        this.dropdownMenu = PageFactory.initElements(driver,DropdownMenu.class);
        this.buttonsToTest = PageFactory.initElements(driver,ButtonsToTest.class);
        this.openTabButton = PageFactory.initElements(driver,OpenTabButton.class);

    }

    public void goTo(){
        this.driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

    public SuggestionClassInput getSuggestionClassInput() {
        return suggestionClassInput;
    }

    public DropdownMenu getDropdownMenu() {
        return dropdownMenu;
    }

    public ButtonsToTest getButtonsToTest() {
        return buttonsToTest;
    }

    public OpenTabButton getOpenTabButton() {
        return openTabButton;
    }
}
