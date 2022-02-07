package week2.assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	public static void main(String[] args) throws InterruptedException {
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
		Thread.sleep(2000);
		WebElement FirstName = driver
				.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a"));
		String capturedName = FirstName.getText();
		System.out.println(capturedName);
		FirstName.click();
		driver.findElement(By.xpath("//a[text() = 'Duplicate Lead']")).click();
		if (driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("This is the duplicate lead");
		} else {
			System.out.println("This is not the Duplicate lead");
		}
		driver.findElement(By.name("submitButton")).click();
		String DuplicateName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(DuplicateName);
		if (capturedName.endsWith(DuplicateName)) {
			System.out.println("Duplicated lead name is same as captured name");
		} else {
			System.out.println("Duplicated lead name is not same as captured name");
		}
		driver.close();
	}

}
