package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args){

        // I used WebElements from previous lecture :))

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enableButton.click();

        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated( By.id("message") ));

        if(inputField.isEnabled() && message.isDisplayed()){
            System.out.println("Input field enabled and text visible");
        }else{
            System.out.println("Skill issue");
        }

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"input-example\"]/button"), "Disable"));
        String btnText = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).getText();

        if("Disable".equals(btnText)){
            System.out.println("Button text changed successfully");
        }else{
            System.out.println("Skill issue");
        }


        inputField.sendKeys("Bootcamp");
        inputField.clear();

        driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement elementA = driver.findElement(By.id("column-a"));
        WebElement elementB = driver.findElement(By.id("column-b"));

        Point locationA = elementA.getLocation();
        Point locationB = elementB.getLocation();

        if(locationA.getY() == locationB.getY()){
            System.out.println("elements are aligned ");
        }else{
            System.out.println("Skill issue");
        }

        driver.quit();

    }

}
