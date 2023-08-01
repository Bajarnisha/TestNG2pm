package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AnnotationPriority { //close missing

	WebDriver driver;
	
	
@Test(priority=1)
void OpenApp()
{
	driver =new ChromeDriver();
	driver.get("http://www.demo.guru99.com/v4");
	//Nisha
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

@Test(priority=3, dependsOnMethods= {"Login"})
void Search()
{
	System.out.println("Search");
}
@Test(priority=4, dependsOnMethods= {"OpenApp"})
 void Teardown()
 {

	driver.close();


 }
}
