package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		ChromeOptions opt = new ChromeOptions();
		
		driver = new ChromeDriver(opt);
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test(groups = {"sanity"})
	public void verifyLoginTest() {
		
		//driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();;
		String actualError = driver.findElement(By.id("error")).getText();
		String expectedError = "Your username is invalid!";
		Assert.assertEquals(actualError, expectedError);
		
		
	}
	
	@Test(groups = {"Smoke"})
	public void verifyLoginTest1() {
		
		driver.findElement(By.id("username")).sendKeys("student");
		//driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();;
		String actualError = driver.findElement(By.id("error")).getText();
		String expectedError = "Your password is invalid!";
		Assert.assertEquals(actualError, expectedError);
		
		
	}
	
	@Test(groups = {"Smoke"})
	public void verifyLoginTest2() {
		
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();;
		String actual = driver.findElement(By.xpath("//*[@class='post-header']")).getText();
		String expect = "Logged In Successfully";
		Assert.assertEquals(actual, expect);
		
		
	}
	
	
	

	@AfterMethod
	public void tearDown() {
		if(!(driver==null)) {
			driver.quit();
		}
		
	}
}
