package week2.assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text() = 'Email']")).click();
		driver.findElement(By.xpath("//input[@name= 'emailAddress']")).sendKeys("hari@testleaf.com");
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		driver.findElement(By.xpath("//a[text() = 'Hari']")).click();
		driver.findElement(By.xpath("//a[text() = 'Duplicate Lead']")).click();
		driver.close();

	}

}
