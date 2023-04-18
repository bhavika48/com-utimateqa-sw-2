package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // verify login page
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        String expectedMessage = "Welcome Back!";
        driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));

    }
    @Test
    public void verifyTheErrorMessage() {
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("parampatel01@gmail.com");
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("parampatel01");
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        signInButton.click();
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualmessage = actualTextElement.getText();
        Assert.assertEquals("Invalid email or password is not displayed", expectedMessage, actualmessage);
    }

    @After
    public void tearDown() {
         closeBrowser();
    }

}
