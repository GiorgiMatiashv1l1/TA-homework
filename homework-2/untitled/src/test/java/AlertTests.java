import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void alertTest(){
        driver.get("https://demo.automationtesting.in/Alerts.html");

        //first alert
        WebElement alertWithOk = driver.findElement(By.xpath("//a[@href='#OKTab']\n"));
        WebElement alertWithOkBtn = driver.findElement(By.xpath("//button[@onclick='alertbox()']\n"));

        alertWithOk.click();
        alertWithOkBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //second alert
        WebElement alertWithOkAndCancel = driver.findElement(By.xpath("//a[@href='#CancelTab']\n"));
        WebElement alertWithOkAndCancelBtn = driver.findElement(By.xpath("//button[@onclick='confirmbox()']\n"));
        WebElement alertMsg = driver.findElement(By.id("demo"));
        alertWithOkAndCancel.click();
        alertWithOkAndCancelBtn.click();
        alert.accept();
        System.out.println(alertMsg.getText());

        //third alert
        WebElement alertWithTextBox = driver.findElement(By.xpath("//a[@href='#Textbox']\n"));
        WebElement alertWithTextBoxBtn = driver.findElement(By.xpath("//button[@onclick='promptbox()']\n"));
        WebElement alertMsg2 = driver.findElement(By.id("demo1"));
        alertWithTextBox.click();
        alertWithTextBoxBtn.click();
        alert.sendKeys("Giorgi");
        alert.accept();
        System.out.println(alertMsg2.getText());
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
