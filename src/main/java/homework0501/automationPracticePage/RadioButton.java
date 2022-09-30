package homework0501.automationPracticePage;

import homework0501.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class RadioButton extends AbstractComponent {

    @FindBy(xpath = "//input[@class=\"radioButton\"]")
    private List<WebElement> radioButtons;

    @FindBy(xpath ="//input[@class=\"radioButton\"]/parent::label")
    private List<WebElement> radioButtonsLabel;

    public RadioButton(final WebDriver driver){
        super(driver);
    }

    public void clickRadioByRandomResult(int randomResult){
        System.out.println("a)");
        System.out.println("The random result is: "+randomResult);
        this.radioButtons.get(randomResult - 1).click();
        System.out.println("b)");
        System.out.println("Radio Button Clicked: "+randomResult);
    }

    public void getRadioButtonsText(int randomResult){
        System.out.println("c)");
        for(int i = 0; i < radioButtonsLabel.size(); i++) {
            if(i==(randomResult-1)) {
                System.out.println("Selected RadioButton: "+radioButtonsLabel.get(i).getText());
            }
            else{
                System.out.println("NOT Selected RadioButton: "+radioButtonsLabel.get(i).getText());
            }
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.radioButtons.size() > 1);
    }

}
