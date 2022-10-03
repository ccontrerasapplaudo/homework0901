package homework0502.demoqa;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;

public class DemoQAFormsPage {
    protected WebDriver driver;
    private Wait wait;

    private By practiceFormButton = By.xpath("//li[@id=\"item-0\" and contains(.,\"Practice Form\")]");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By userEmail = By.id("userEmail");
    private By gender = By.cssSelector("div.custom-radio:nth-child(1)");
    private By subject = By.id("subjectsInput");
    private By subjectMenu = By.cssSelector("div.subjects-auto-complete__menu-list div:nth-child(1)");
    private By hobbie = By.cssSelector("div.custom-checkbox:nth-child(1)");
    private By userNumber = By.id("userNumber");
    private By dateOfBirthInput = By.id("dateOfBirthInput");
    private By dateToPick = By.xpath("//div[@class=\"react-datepicker__week\"]//div[contains(string(),\"12\")]");
    private By uploadPicture = By.id("uploadPicture");
    private By currentAddress = By.id("currentAddress");
    private By state = By.id("state");
    private By stateSelected = By.id("react-select-3-option-0");
    private By city = By.id("city");
    private By selectedCity = By.id("react-select-4-option-0");
    private By userForm = By.id("userForm");
    private By popUpCloseButton = By.id("closeLargeModal");
    private By subjectText = By.cssSelector("div.subjects-auto-complete__multi-value:nth-child(1)");
    private By dropDownValues = By.xpath("//div[contains(@class, 'singleValue')]");
    private By tableValues= By.cssSelector("div.table-responsive td:nth-child(2)");
    public DemoQAFormsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollDownPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void clickOnPracticeFormButton(){
        driver.findElement(practiceFormButton).click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("return document.getElementById('fixedban').remove();");
    }

    public void sendFormData(){
        driver.findElement(firstName).sendKeys("Carlos");
        driver.findElement(lastName).sendKeys("Contreras");
        driver.findElement(userEmail).sendKeys("email@email.com");
        driver.findElement(userNumber).sendKeys("1234567890");
        driver.findElement(currentAddress).sendKeys("Test address");
    }

    public void sendSubject() throws InterruptedException {
        driver.findElement(subject).sendKeys("Eng",Keys.DOWN);
        waitTime();
        driver.findElements(subjectMenu).get(0).click();
    }

    public void selectGenderOption(){
        driver.findElement(gender).click();
    }

    public void selectBirthDay() throws InterruptedException {
        driver.findElement(dateOfBirthInput).click();
        waitTime();
        driver.findElement(dateToPick).click();
    }

    public void selectHobbieOption(){
        driver.findElement(hobbie).click();
    }

    public void selectPicture(){
        driver.findElement(uploadPicture).sendKeys("C:\\Users\\carlo\\Desktop\\Selenium Jar and Drivers\\Selenium_logo.png");
    }

    public void selectDropdownOptions() throws InterruptedException {
        driver.findElement(state).click();
        waitTime();
        driver.findElement(stateSelected).click();
        waitTime();
        driver.findElement(city).click();
        waitTime();
        driver.findElement(selectedCity).click();
        waitTime();
    }

    public void clickSubmitButton(){
        driver.findElement(userForm).submit();
    }

    public List<String> obtainFormData(){
        List<String> formData = new ArrayList<String>();
        formData.add(driver.findElement(firstName).getAttribute("value"));
        formData.add(driver.findElement(lastName).getAttribute("value"));
        formData.add(driver.findElement(userEmail).getAttribute("value"));
        formData.add(driver.findElement(userNumber).getAttribute("value"));
        formData.add(driver.findElement(dateOfBirthInput).getAttribute("value"));
        formData.add(driver.findElement(subjectText).getText());
        formData.add(driver.findElement(uploadPicture).getAttribute("value"));
        formData.add(driver.findElement(currentAddress).getAttribute("value"));
        formData.add(driver.findElements(dropDownValues).get(0).getText());
        formData.add(driver.findElements(dropDownValues).get(1).getText());

        System.out.println(formData);

        return formData;
    }

    public List<String> obtainTableData(){
        List<WebElement> tableObtainedElements= driver.findElements(tableValues);
        List<String> tableData = new ArrayList<String>();

        for(int i=0;i<tableObtainedElements.size();i++){
            tableData.add(tableObtainedElements.get(i).getText());
        }

        System.out.println(tableData);

        return tableData;
    }

    public void closePopUp(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",  driver.findElement(popUpCloseButton));
    }

    public void waitTime() throws InterruptedException {
        synchronized (driver){
            driver.wait(2000);
        }
    }

    public void closeBrowser(){
        driver.quit();
    }
}
