package homework0501.automationPracticePage;

import homework0501.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownMenu extends AbstractComponent {

    @FindBy(id = "dropdown-class-example")
    private WebElement dropDownMenu;

    @FindBy(css = "select#dropdown-class-example option:nth-child(4)")
    private WebElement getDropDownMenuWebElement;

    @FindBy(css = "select#dropdown-class-example option")
    private List <WebElement> getSelectedDropdownItem;
    private Select selectedItem;

    private List<WebElement> auxiliaryObject;

    public DropdownMenu(final WebDriver driver){
        super(driver);
    }

    public void selectElement(){
        System.out.println("g)");
        System.out.println("Selecting Option2");
        selectedItem = new Select(dropDownMenu);
        selectedItem.selectByIndex(2);

        System.out.println("h)");
        auxiliaryObject = selectedItem.getAllSelectedOptions();
        System.out.println("Selected option Text: "+auxiliaryObject.get(0).getText());
    }

    public void selectElementUsingWebElement(){
        System.out.println("i)");
        System.out.println("Selecting Option3");
        dropDownMenu.click();
        this.wait.until((d) -> this.getDropDownMenuWebElement.isDisplayed());
        getDropDownMenuWebElement.click();

        for(int i=0;i<getSelectedDropdownItem.size();i++){
            if(getSelectedDropdownItem.get(i).isSelected()){
                System.out.println("j)");
                System.out.println("Selected option Text: "+getSelectedDropdownItem.get(i).getText());
            }
        }


    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
