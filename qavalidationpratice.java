package qavalidation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class qavalidationpratice {
	@Test
	public static void pratice() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://qavalidation.com/demo-form/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='g4072-fullname']")).sendKeys("Shiwani Lama");
		driver.findElement(By.xpath("//input[@id='g4072-email']")).sendKeys("shiwanilama@gmail.com");
		driver.findElement(By.xpath("//input[@id='g4072-phonenumber']")).sendKeys("9810824556");
		Select gender= new Select(driver.findElement(By.xpath("//select[@id='g4072-gender']")));
		gender.selectByValue("Female");
		driver.findElement(By.xpath("//input[@id='g4072-yearsofexperience-1']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		driver.findElement(By.xpath("//input[@id='g4072-skills-Functional testing']")).click();
		driver.findElement(By.xpath("//input[@id='g4072-skills-Automation testing']")).click();
		Select dropdown= new Select(driver.findElement(By.xpath("//select[@id='g4072-qatools']")));
		dropdown.selectByVisibleText("Selenium");
		driver.findElement(By.xpath("//textarea[@id='contact-form-comment-g4072-otherdetails']")).sendKeys("A great website to pratice automation");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Submit!')]")).click();
		//Thread.sleep(8000);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@id='contact-form-success-header']")));
		driver.quit();
			
		
	}
}
