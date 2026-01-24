package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage{
    private static final String URL = "https://demo.automationtesting.in/Alerts.html";

    //first alert
    private final By alertWithOk = By.xpath("//a[@href='#OKTab']\n");
    private final By alertWithOkBtn = By.xpath("//button[@onclick='alertbox()']\n");

    //second alert
    private final By alertWithOkAndCancel = By.xpath("//a[@href='#CancelTab']\n");
    private final By alertWithOkAndCancelBtn = By.xpath("//button[@onclick='confirmbox()']\n");
    private final By alertMsg = By.id("demo");

    private final By alertWithTextBox = By.xpath("//a[@href='#Textbox']\n");
    private final By alertWithTextBoxBtn = By.xpath("//button[@onclick='promptbox()']\n");
    private final By alertMsg2 = By.id("demo1");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Alerts Page")
    public AlertsPage Open(){
        driver.get(URL);
        return this;
    }

    @Step("Click First Alert")
    public AlertsPage OpenFirstAlertInner(){
        click(alertWithOk);
        return this;
    }

    @Step("Click to Activate first alert")
    public AlertsPage OpenFirstAlert(){
        click(alertWithOkBtn);
        return this;
    }

    @Step("Click Second Alert")
    public AlertsPage OpenSecondAlertInner(){
        click(alertWithOkAndCancel);
        return this;
    }

    @Step("Click to Activate Second Alert")
    public AlertsPage OpenSecondAlert(){
        click(alertWithOkAndCancelBtn);
        return this;
    }

    @Step("Get Alert Message")
    public AlertsPage GetAlertMessage(){
        getText(alertMsg);
        return this;
    }

    @Step("Click Alert with Textbox")
    public AlertsPage OpenAlertWithTextBoxInner(){
        click(alertWithTextBox);
        return this;
    }

    @Step("Open to Activate Alert With Textbox")
    public AlertsPage OpenAlertWithTextBox(){
        click(alertWithTextBoxBtn);
        return this;
    }

    @Step("Enter Text in alert Textbox")
    public AlertsPage EnterTextInTextBox(String text){
        alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        return this;
    }

    @Step("Get Text of TextBox Alert message")
    public String getMsgOfTextBoxAlert(){
        return getText(alertMsg2);
    }

    @Step("Accept Alert")
    public AlertsPage Accept(){
        alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
}
