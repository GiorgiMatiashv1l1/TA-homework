import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class FormTests {
     static ChromeOptions options = new ChromeOptions();
     static WebDriver driver = new ChromeDriver(options);
     static Actions action = new Actions(driver);


    @Test
    public static void formTest(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        WebElement firstname = driver.findElement(By.id("firstName"));
        WebElement lastname = driver.findElement(By.id("lastName"));

        WebElement email = driver.findElement(By.id("userEmail"));

        //Gender CheckBox
        List<WebElement> gender = driver.findElements(By.xpath("//input[@name=\"gender\"]"));

        WebElement mobileNumber = driver.findElement(By.id("userNumber"));

        WebElement subjectInput = driver.findElement(By.id("subjectsContainer"));

        // Hobbies CheckBoxes
        List<WebElement> hobbies = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));

        // adding just for scrolling,
        // scroll will stop on this element and I will add second scroll later.
        WebElement uploadPictureDiv = driver.findElement(By.id("uploadPicture"));

        WebElement address = driver.findElement(By.id("currentAddress"));


        action.scrollToElement(uploadPictureDiv).perform();

        firstname.sendKeys("Giorgi");
        lastname.sendKeys("Matiashvili");
        email.sendKeys("23202245@ibsu.edu.ge");

        for(WebElement option : gender){
            if(option.getAttribute("value").equals("Male")){
                option.click();
                break;
            }
        }


        for(WebElement checkBox : hobbies){
            if(checkBox.getAttribute("value").equals("Music")){
                checkBox.click();
            }
        }



    }
}
