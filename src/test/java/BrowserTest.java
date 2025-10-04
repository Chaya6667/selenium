import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserTest {
	
	public static void main(String[] args) {
        // Initialize the WebDriver (Ensure ChromeDriver is set up properly)
        WebDriver driver = new ChromeDriver();

        // Use the updated WebDriverWait constructor
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Open Google
        String url = "https://www.google.com";
        driver.get(url);

        // Wait until the title contains "Google"
        wait.until(ExpectedConditions.titleContains("Google"));

        // Print the page title
        System.out.println("Page title is: " + driver.getTitle());
        
        //search some thing 
        driver.findElement(By.id("APjFqb")).sendKeys("Morgan stanley");
        
        driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);

        // Quit the driver
        driver.quit();
    }


}
