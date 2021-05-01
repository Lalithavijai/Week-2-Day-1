package week2.day2.assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		
		//Click contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
	
		//Find the First name and type the value
		driver.findElement(By.id("firstNameField")).sendKeys("Lalitha");
		
		//Find the First name and type the value
		driver.findElement(By.id("lastNameField")).sendKeys("Vijai");
		
		//Find the dept and type the value
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Computer software Department1");
		
		//Find the description and type the value
		driver.findElement(By.id("createContactForm_description")).sendKeys("This is a important description");
		
		//Find the email add and type the value
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("lalithavijai@gmail.com");
		

		// From the drop down choose State
	
		WebElement eleDropDown1 = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd1=new Select(eleDropDown1);
		dd1.selectByVisibleText("New York");
		
		//Find create contact and click
		driver.findElement(By.className("smallSubmit")).click();
		
		//Find editbutton and click
		driver.findElement(By.className("subMenuButton")).click();
		
		//Find description note and clear and pass value
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_description")).sendKeys("Kindly take a look on the Updated desc");
		
		//Find update and click
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
	
		System.out.println(driver.getTitle());
		//driver.getTitle("View Contact | opentaps CRM");
		//driver.getTitle("View Contact | opentaps CRM");
	
		
		
		
		
		
		
		
	}

}
