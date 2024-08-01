package AutomationTestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class LoginTest {

	 public static void main(String[] args) {
	        // Chrome Driver path
	        System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver-win64\\chromedriver.exe");
	        
	        // Instantiate a ChromeDriver class
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("user-data-dir=D:\\Chrome\\NewProfile");
	        WebDriver driver = new ChromeDriver(options);
	        driver.manage().window().maximize(); // Maximize Window
	        
	        // Direct to the Login Page
	        driver.get("http://localhost/book_shop/login.php");
	        
	        // Provide Correct Email
	        WebElement emailField = driver.findElement(By.name("email"));
	        emailField.isDisplayed();
	        emailField.isEnabled(); 
	        emailField.sendKeys("user@1");
	        
	        // Provide Correct Password
	        WebElement passwordField = driver.findElement(By.name("pass"));
	        passwordField.isDisplayed();
	        passwordField.isEnabled(); 
	        passwordField.sendKeys("111");
	        
	        // Click Login Button
	        WebElement loginButton = driver.findElement(By.xpath("(//input[@name='submit'])[1]"));
	        loginButton.isDisplayed();
	        loginButton.isEnabled(); 
	        loginButton.click();

	        // Wait for the home page to load and the logo to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='logo'])[1]")));

	        // Check if the logo is displayed
	        if (logo.isDisplayed()) {
	            System.out.println("Login successful.");
	        } else {
	            System.out.println("Login failed.");
	        }
	        
	        // Close the browser
	        driver.close();
	        
	}

}
