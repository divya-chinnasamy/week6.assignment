package week6.assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

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
			
//				3. Click view All and click Sales from App Launcher
			driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']/button")).click();
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
			
//				4. Click on Opportunity tab 
			WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
			driver.executeScript("arguments[0].click();", opportunity);
			
//				5. Click on New button
			driver.findElement(By.xpath("//div[text()='New']")).click();
			
//				6. Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it 
			driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[1]")).sendKeys("Salesforce Automation by Divya",Keys.ENTER);
			String oName = "Salesforce Automation by Divya";
			System.out.println(oName);
			
//				7. Choose close date as Today
			driver.findElement(By.xpath("//label[text()='Close Date']/following::div/input")).sendKeys("10/30/2022",Keys.ENTER);
			
//				8. Select 'Stage' as Need Analysis
			driver.findElement(By.xpath("//button[@data-value='--None--']")).click();
			driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
			
//				9. click Save and VerifyOppurtunity Name"
			driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
			String finalName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
			System.out.println(finalName);
			
			if(oName.equals(finalName)) {
				System.out.println("Oppurtunity name - Verified" + finalName);
			}
			else {
				System.out.println("Not Verified");
			}

	}

}
