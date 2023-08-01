package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Params {

	WebDriver driver;
	
	
@Test(priority=1)
@Parameters({"browser"})
void OpenApp(String BP)
{
	if(BP.equals("Chrome"))
	{	
		driver=new ChromeDriver();
	}
	else if(BP.equals("Edge"))
	{	
	driver=new EdgeDriver();
	}
	else
	{
		driver=new InternetExplorerDriver();
	}
	driver.get("http://www.demo.guru99.com/v4");
}

@Test(priority=2, dependsOnMethods= {"OpenApp"})
void Login()
{

	driver.findElement(By.name("uid")).sendKeys("mngr514943");
	driver.findElement(By.name("password")).sendKeys("qUnatUn");
	driver.findElement(By.name("btnLogin")).click();
	
	WebElement Text=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/marquee"));
	
	if(Text.isDisplayed())
	{
		System.out.println("Login Success");
	}
			
}



@Test(priority=3, dependsOnMethods= {"OpenApp"})
 void Teardown()
 {

	driver.close();


 }
}



	

	
	
	
	
	
	

