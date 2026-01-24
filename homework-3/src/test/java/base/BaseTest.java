package base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createChrome();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachmentScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
