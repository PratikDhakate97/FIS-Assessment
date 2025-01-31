package FIS_UI_Automation_Assessment;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UIAutomationAssesiment 
{

	public static void main(String [] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_jar files\\New folder\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.ebay.com/");
		
		driver.manage().window().maximize();
		
		//boom search
		driver.findElement(By.id("gh-ac")).sendKeys("book");
		
		// click on search buttion
		driver.findElement(By.id("gh-search-btn")).click();
		
		//click on 1st book on list
		driver.findElement(By.xpath("(//span[@role='heading'])[3]")).click();
		
		
		// switch to new window
		Set<String> allid = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(allid);
		String Childid = al.get(1);
		
		driver.switchTo().window(Childid);
		
		//click on add to cart
	   driver.findElement(By.id("atcBtn_btn_1")).click();
	   
	   
	   
	   
	   //verify cart has been updated
	   WebElement cartCountElement = driver.findElement(By.xpath("//span[@class='badge']"));
	   
	   // Cart count element
       String cartCount = cartCountElement.getText();

       // Check if cart count is updated
       if (cartCount.equals("1")) 
       {
           System.out.println("Cart updated successfully. Number of items: " + cartCount);
       } 
       else 
       {
           System.out.println("Cart update failed. Cart count: " + cartCount);
       }
    
	
	   
	}   
}
