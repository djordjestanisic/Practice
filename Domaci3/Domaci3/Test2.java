package Domaci3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test2 {
    public static void main(String[] args) {

        // test2 ---> samo ispravan password

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.linkText("PRACTICE"));
        practiceButton.click();

        WebElement loginButton = driver.findElement(By.linkText("Test Login Page"));
        loginButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement error1 = driver.findElement(By.id("error"));
        Assert.assertTrue(error1.isDisplayed());

        WebElement errorMessage = driver.findElement(By.className("show"));
        String errorText = errorMessage.getText();

        String expectedText = "Enter your username!";
        Assert.assertNotEquals(errorText, expectedText);


    }
}
