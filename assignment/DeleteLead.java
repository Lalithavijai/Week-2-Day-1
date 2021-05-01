package week2.day2.assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Chrome Driver needs to be downloaded and set to the path
		WebDriverManager.chromedriver().setup();
		
		// Launch the chrome browser
		ChromeDriver driver=new ChromeDriver();
		
		// Load the url
		driver.get("http://leaftaps.com/opentaps/control/login"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Maximize the screen
		driver.manage().window().maximize();	
		
		//Find the user name and type the value
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//Find the password and type the value
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Find the login button and click
		driver.findElementByClassName("decorativeSubmit").click();

		//Verify that you are logged in
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		
		//Click link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click leads
		driver.findElement(By.linkText("Leads")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Click phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//Enter phone
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("21");
		
		//Click Find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//Capture first matching
		String text2 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
		//String text2 = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).getText();
		System.out.println(text2);
	
		//click the first matching
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//Click delete
		driver.findElement(By.linkText("Delete")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		
		//Enter lead id and enter the  value
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[1]")).sendKeys(text2);
		
		//Click Find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
				
		
		
		
		
		
	}

}
