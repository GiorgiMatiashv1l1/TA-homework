import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import pages.AlertsPage;

@Epic("TA Homework 3")
@Feature("Alerts Page Test")
public class AlertsTest extends BaseTest {
    @Test(priority = 1)
    @Story("Test First Alert")
    public void testFirstAlert(){
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.Open()
                .OpenFirstAlertInner()
                .OpenFirstAlert()
                .Accept();
    }

    @Test(priority = 2)
    @Story("Test Second Alert")
    public void testSecondAlert(){
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.Open()
                .OpenSecondAlertInner()
                .OpenSecondAlert()
                .Accept()
                .GetAlertMessage();
    }

    @Test(priority = 3)
    @Story("Test Third Alert")
    public void testThirdAlert(){
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.Open()
                .OpenAlertWithTextBoxInner()
                .OpenAlertWithTextBox()
                .EnterTextInTextBox("this is test text")
                .getMsgOfTextBoxAlert();
        attachScreenshot();
    }

}
