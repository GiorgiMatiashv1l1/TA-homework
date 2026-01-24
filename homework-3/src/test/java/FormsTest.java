import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.FormsPage;

@Epic("Homework 3")
@Feature("DemoQA form")
public class FormsTest extends BaseTest {

    @Test
    @Story("Filling fields")
    @Description("Filling firstname, lastname, email, address, Gender box, mobile number, date of birth, inputs subject, hobby")
    public void formTest(){
        FormsPage formsPage = new FormsPage(driver);

        formsPage.open()
                .enterFirstName("Giorgi")
                .enterLastName("Matiashvili")
                .enterEmail("gmatiashvili011@gmail.com")
                .chooseMale()
                .enterMobileNumber("123456789")
                .setDateOfBirth("27", "November", "2004")
                .SelectMusic()
                .chooseSubject("Computer Science")
                .SelectState("NCR")
                .SelectCity("Delhi")
                .SubmitForm();

        attachScreenshot();
    }

}
