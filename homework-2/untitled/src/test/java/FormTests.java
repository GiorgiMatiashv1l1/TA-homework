import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FormTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test(priority = 0)
    public void formTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstname = driver.findElement(By.id("firstName"));
        WebElement lastname = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("userEmail"));

        // Gender CheckBox
        // I wanted to create gender list and click the on that says male,
        // but i got ClickInterceptedException and i couldn't fix it , so i'll just make a webelement male :DD
        // List<WebElement> gender = driver.findElements(By.xpath("//input[@name=\"gender\"]"));
        WebElement male = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));

        WebElement mobileNumber = driver.findElement(By.id("userNumber"));
        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));

        // subject input
        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));

        //Hobbies music checkbox
        WebElement musicCheckBox = driver.findElement(By.xpath("//label[text()=\"Music\"]"));

        // adding just for scrolling,
        // scroll will stop on this element and I will add second scroll later.
        WebElement uploadPictureDiv = driver.findElement(By.id("uploadPicture"));
        WebElement address = driver.findElement(By.id("currentAddress"));
        action.scrollToElement(uploadPictureDiv).perform();

        firstname.sendKeys("Giorgi");
        lastname.sendKeys("Matiashvili");
        email.sendKeys("23202245@ibsu.edu.ge");
        male.click();
        mobileNumber.sendKeys("5515515511");

        dateOfBirth.click();
        String birthYear = "2004";
        String birthMonth = "November";
        String birthDay = "27";

        while (true) {

            //I know it's a bad Xpath, but I honestly have no idea how to write it in this case :D
            String monthYear = driver.findElement(
                    By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")
            ).getText();

            String arr[] = monthYear.split(" ");
            String month = arr[0];
            String year = arr[1];

            if (month.equalsIgnoreCase(birthMonth) && year.equals(birthYear)) {
                break;
            } else {
                WebElement chooseMonthBtn = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
                chooseMonthBtn.click();
                Select selectMonth = new Select(chooseMonthBtn);
                selectMonth.selectByIndex(10);

                WebElement chooseYearBtn = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
                chooseYearBtn.click();
                Select selectYear = new Select(chooseYearBtn);
                selectYear.selectByValue("2004");
                break;
            }
        }

        //this is for choosing day on calendar
        List<WebElement> days = driver.findElements(By.cssSelector(".react-datepicker__day"));
        for (WebElement day : days) {
            String bd = day.getText();

            if (bd.equals(birthDay)) {
                day.click();
                break;
            }
        }

        //subject inputs
        js.executeScript("window.scrollBy(0,300);");
        subjectInput.click();
        subjectInput.sendKeys("Computer");

        WebElement compSciOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[text()=\"Computer Science\"]")
                )
        );
        compSciOption.click();

        //Hobbies
        musicCheckBox.click();

        //address
        address.click();
        address.sendKeys("Tbilisi, Varketili");


        js.executeScript("window.scrollBy(0,300);");

        //choosing state and city
        WebElement stateSelector = driver.findElement(By.xpath("//div[text()=\"Select State\"]"));
        stateSelector.click();
        WebElement ncrOpt = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()=\"NCR\"]"))
        );

        ncrOpt.click();

        WebElement citySelector = wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("city"))
        );

        citySelector.click();

        WebElement delhiOpt = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()=\"Delhi\"]"))
        );

        delhiOpt.click();

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();



        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

        for(WebElement row : rows){
            List<WebElement> columns = driver.findElements(By.xpath("//table//tbody//tr//td"));
            System.out.println(row.getText());
            System.out.println();
        }



    }
}


