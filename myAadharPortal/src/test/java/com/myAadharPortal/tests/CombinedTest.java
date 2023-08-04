package com.myAadharPortal.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CombinedTest {

    private WebDriver driver;

    @BeforeClass
    public void setupDriver() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void testCitizenRegistration() {
        driver.get("F:\\mphasis\\Angular\\aadhar-frontend1\\src\\app\\homepage\\citizen-register\\citizen-register.component.html"); // Replace with your actual URL

        // Fill in the form fields
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys("John Doe");

        WebElement dobInput = driver.findElement(By.id("dob"));
        dobInput.sendKeys("1990-01-01");

        WebElement addressInput = driver.findElement(By.id("address"));
        addressInput.sendKeys("123 Main Street");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("john@example.com");

        WebElement mobileNoInput = driver.findElement(By.id("mobileNo"));
        mobileNoInput.sendKeys("1234567890");

        WebElement genderSelect = driver.findElement(By.id("gender"));
        genderSelect.sendKeys("Male");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("testpassword");

        // Submit the form
        WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit']"));
        registerButton.click();

        // Verify the success message or check if the new citizen appears in the list
        // For example:
        // WebElement successMessage = driver.findElement(By.xpath("//div[@class='success-message']"));
        // Assert.assertEquals(successMessage.getText(), "Registration successful");
    }

    @Test(priority = 2)
    public void adminLoginTest() {
        driver.get("F:\\mphasis\\Angular\\aadhar-frontend1\\src\\app\\homepage\\admin-login\\admin-login.component.html"); // Replace with the actual URL of your admin login page

        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

        emailInput.sendKeys("admin@example.com"); // Replace with the actual admin email
        passwordInput.sendKeys("adminpassword"); // Replace with the actual admin password
        loginButton.click();

        // Add any additional verification or actions related to the admin login test
    }

    @Test(priority = 3)
    public void citizenLoginTest() {
        driver.get("F:\\mphasis\\Angular\\aadhar-frontend1\\src\\app\\homepage\\citizen-login\\citizen-login.component.html"); // Replace with the actual URL of your citizen login page

        WebElement mobileNoInput = driver.findElement(By.id("mobileNo"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

        mobileNoInput.sendKeys("1234567890"); // Replace with the actual citizen mobile number
        passwordInput.sendKeys("citizenpassword"); // Replace with the actual citizen password
        loginButton.click();

        // Add any additional verification or actions related to the citizen login test
    }
}
