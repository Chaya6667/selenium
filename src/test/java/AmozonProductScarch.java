import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmozonProductScarch {

	public static void main(String[] args) {
	

		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";

		driver.get(url);

		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();


		String handel = driver.getWindowHandle();
		
		System.out.println("window id: "+handel);
		
		driver.switchTo().window(handel);
		
		
		Set<String> hendels = driver.getWindowHandles();
		System.out.println("window set of: "+hendels);
		Iterator it = hendels.iterator();
		
		String perent = (String) it.next();
		String child = (String) it.next();
		
		driver.switchTo().window(child);

		driver.findElement(By.id("search-field")).sendKeys("Potato");
		
		driver.switchTo().window(perent);
		
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement placeOrderBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']")));
		placeOrderBtn.click();

	

		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//select[option[contains(text(),'India')]]")
		));

		Select select = new Select(dropdown);
		select.selectByVisibleText("India");
		

driver.findElement(By.xpath("//input[@class='chkAgree']")).click();

driver.findElement(By.xpath("//button[text()='Proceed']")).click();

driver.quit();


	}





	}


