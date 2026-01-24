package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormsPage extends BasePage{
    public FormsPage(WebDriver driver) {
        super(driver);
    }

    private final static String URL = "https://demoqa.com/automation-practice-form";

    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");

    private final By maleBox = By.xpath("//label[@for='gender-radio-1']");
    private final By mobileNumber = By.id("userNumber");


    private final By dateOfBirth = By.id("dateOfBirthInput");
    private final By yearSelector = By.className("react-datepicker__year-select");
    private final By monthSelector = By.className("react-datepicker__month-select");

    private final By subjectInput = By.id("subjectsInput");
    private final By musicCheckBox = By.xpath("//label[text()=\"Music\"]");

    //for scroll
    private final By uploadPictureDiv = By.id("uploadPicture");

    private final By stateSelector = By.xpath("//div[text()=\"Select State\"]");
    private final By citySelector = By.id("city");

    private final By submitBtn = By.id("submit");


    @Step("Open Form")
    public FormsPage open(){
        driver.get(URL);
        return this;
    }

    @Step("Fill the firstname")
    public FormsPage enterFirstName(String value){
        ScrollToElement(submitBtn);
        type(firstName, value);
        return this;
    }

    @Step("Fill the Lastname")
    public FormsPage enterLastName(String value){
        type(lastName, value);
        return this;
    }

    @Step("Fill the email")
    public FormsPage enterEmail(String value){
        type(email, value);
        return this;
    }

    @Step("Fill Phone number")
    public FormsPage enterMobileNumber(String value){
        type(mobileNumber, value);
        return this;
    }

    @Step("Fill the address")
    public FormsPage enterAddress(String value){
        type(currentAddress, value);
        return this;
    }

    @Step("Choose male Gender")
    public FormsPage chooseMale(){
        click(maleBox);
        return this;
    }

    @Step("Choose Subject")
    public FormsPage chooseSubject(String subject){
        click(subjectInput);
        SendKeys(subjectInput, subject, Keys.ENTER);
        return this;
    }


    @Step("choose date of birth")
    public FormsPage setDateOfBirth(String day, String month, String year) {
        ScrollToElement(currentAddress);
        click(dateOfBirth);

        WebElement yearDropdown = driver.findElement(this.yearSelector);
        new Select(yearDropdown).selectByVisibleText(year);

        WebElement monthDropdown = driver.findElement(this.monthSelector);
        new Select(monthDropdown).selectByVisibleText(month);
        By daySelector = By.xpath("//div[contains(@class,'react-datepicker__day') and not(contains(@class,'react-datepicker__day--outside-month')) and text()='" + day + "']");
        click(daySelector);
        return this;
    }

    @Step("Choose Hobby: Music")
    public FormsPage SelectMusic(){
        click(musicCheckBox);
        return this;
    }

    @Step("Select state")
    public FormsPage SelectState(String stateName){
        ScrollToElement(stateSelector);
        click(stateSelector);
        click(By.xpath("//div[contains(@id,'react-select') and text()='" + stateName + "']"));
        return this;
    }

    @Step("Select City")
    public FormsPage SelectCity(String cityName){
        click(citySelector);
        click(By.xpath("//div[contains(@id,'react-select') and text()='" + cityName + "']"));
        return this;
    }

    @Step("Submit")
    public FormsPage SubmitForm(){
        ScrollToElement(submitBtn);
        click(submitBtn);
        return this;
    }



}
