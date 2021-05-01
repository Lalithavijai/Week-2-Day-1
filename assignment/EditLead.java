package week2.day2.assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;


public class EditLead {

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
		
		
		
		//Find  First name and enter values
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("lalitha");
		
		//Click Find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//Capture first matching
		//String capturedname = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a")).getText();
		//System.out.println(capturedname);
	
		//click the first matching
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a")).click();
		
		String text3 = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		System.out.println(text3 +":is the title displayed");
		
		
		//Click Edit
		driver.findElement(By.linkText("Edit")).click();
		
		
		
		
		
		// Clear company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		
		//Update company name
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TransUnion");
		driver.findElement(By.xpath("(//Input[@name='submitButton'])[1]")).click();
		
		String updateComp = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(updateComp +":is the updated company Name");
		if (updateComp.contains("TransUnion"))
		{
			System.out.println("Company name is verified");
		}
		
		else
		{
			System.out.println("Company name is wrongly updated");
		}
		
		
	}

}
