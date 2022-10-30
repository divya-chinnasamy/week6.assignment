package week6.assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//1.Launch Salesforce application
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//2. Login with valid credentials username and password 
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		
		//3. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
//			3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']/button")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
//			4. Click on Opportunity tab 
		WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);
		
//			5. Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
//			6. Choose Close date as Tomorrow Date
		driver.findElement(By.xpath("//label[text()='Close Date']/following::div/input")).sendKeys("10/31/2022",Keys.ENTER);
		
//			7. Click on save 
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

		Thread.sleep(3000);
//			8. Verify the Alert message (Complete this field) displayed for Name and Stage"
		driver.findElement(By.xpath("//button[@title='Close error dialog']//lightning-primitive-icon[1]")).click();
		
		//completing the name and stage after handling alert
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[1]")).sendKeys("Salesforce Automation by Divya",Keys.ENTER);
		
		Thread.sleep(3000);
		//Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//button[@data-value='--None--']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
		
//		9. Click on save 
	driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
	
	}

}
