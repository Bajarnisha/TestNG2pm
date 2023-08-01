package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Groups {

	WebDriver driver;
	
	
@Test(priority=1, groups= {"Sanity", "Regression"})

void OpenApp()
{
	driver =new ChromeDriver();
	driver.get("http://www.demo.guru99.com/v4");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test(priority=2, groups= {"Sanity", "Regression"})
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

@Test(priority=3, groups= {"Regression"})
void Search()
{
	System.out.println("Search");
}

@Test(priority=4, groups= {"Sanity"})
void AdvSearch()
{
	System.out.println("Advanced Search");
}
	

@Test(priority=5, groups= {"Sanity"})
 void Teardown()
 {

	System.out.println("close");


 }

	
	
	
	
	
	
	
	
	
	
}
