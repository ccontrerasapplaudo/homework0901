package homework0601;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SurveyPage extends BasePage{
    @FindBy(xpath = "//a[contains(text(),\"Take our survey\")]")
    WebElement aTakeOurSurvey;

    @FindBy(xpath = "//div[contains(@class, \"question vertical\")]")
    List<WebElement> divQuestions;

    @FindBy(css = "label.answer-label")
    List<WebElement> rdoTakeSurvey;

    @FindBy(name = "surveyForm")
    WebElement formSurvery;

    @FindBy(xpath = "//div[contains(@class, \"thanks-message\")]")
    WebElement divThanksMessage;

    public SurveyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void testEightSurveyPage(String url){
        navigateToPage(url);
        scrollToElement(aTakeOurSurvey);
        waitAndClickElement(aTakeOurSurvey);
    }
    public void testNineSurveyPage(int expectedNumber){
        verifyNumberOfElements(divQuestions,expectedNumber);
    }
    public void testTenSurveyPage(int answerNumber){
        scrollToElement(rdoTakeSurvey.get(answerNumber));
        waitAndClickElement(rdoTakeSurvey.get(answerNumber));
        verifyIfSelected(rdoTakeSurvey.get(answerNumber));
    }
    public void testElevenSurveyPage(String expectedText){
        submitForm(formSurvery);
        waitForElementVisibility(divThanksMessage);
        compareText(divThanksMessage.getText(),expectedText);
    }
}
