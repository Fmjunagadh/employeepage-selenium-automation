package main.java.Employee_Tracking.selenium_employee;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UserAuthenticationTest
{
	private WebElement email, password, login, logout;
	
	public WebElement inputText, activityInput;
	public WebDriver driver;
	public final String LOGIN_URL = "file:///D:/laksys/Document/Tasks/Emlpoyee_Tracking/index2.html";
	public final String EMAIL = "test@gmail.com";
	public final String PSWD = "test123";
	
	public UserAuthenticationTest(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test(priority = 4)
	public void EmployeeLoginSetup() {
		System.out.println("Employee Login page setup");
		driver.get(LOGIN_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        email = driver.findElement(By.xpath("/html/body/div/form/input[1]"));
        password = driver.findElement(By.xpath("/html/body/div/form/input[2]"));
        login = driver.findElement(By.xpath("/html/body/div/form/button"));
        email.sendKeys(EMAIL);
        password.sendKeys(PSWD);
        login.click();
	}
	
	@Test(priority = 5)
	public void EmployeeLogout() {
        logout = driver.findElement(By.xpath("/html/body/form/input"));
        logout.click();
        System.out.println("Employee has Logged Out");
    }	
	
	@Test(priority = 6)
	public void EmptyEmailError() {
		driver.get(LOGIN_URL);
		System.out.println("Entered Empty Email");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		email = driver.findElement(By.xpath("/html/body/div/form/input[1]"));
        password = driver.findElement(By.xpath("/html/body/div/form/input[2]"));
        login = driver.findElement(By.xpath("/html/body/div/form/button"));
		email.sendKeys("");
        password.sendKeys(PSWD);
        login.click();
		System.out.println("Please enter email address");
	}	
	
	@Test(priority = 7)
	public void EmptyPasswordError() {
		driver.get(LOGIN_URL);
		System.out.println("Entered Empty Password");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		email = driver.findElement(By.xpath("/html/body/div/form/input[1]"));
        password = driver.findElement(By.xpath("/html/body/div/form/input[2]"));
        login = driver.findElement(By.xpath("/html/body/div/form/button"));
		email.sendKeys(EMAIL);
        password.sendKeys("");
        login.click();
		System.out.println("Please enter your password");
	}	
	
	@Test(priority = 8)
	public void IncorrectEmailError() {
		driver.get(LOGIN_URL);
		System.out.println("Entered Incorrect Email");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		email = driver.findElement(By.xpath("/html/body/div/form/input[1]"));
        password = driver.findElement(By.xpath("/html/body/div/form/input[2]"));
        login = driver.findElement(By.xpath("/html/body/div/form/button"));
		email.sendKeys("test");
        password.sendKeys(PSWD);
        login.click();
		System.out.println("Please enter email address correctly");
	}
	
	@Test(priority = 9)
	public void IncorrectPasswordError() {
		driver.get(LOGIN_URL);
		System.out.println("Entered Incorrect Password");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		email = driver.findElement(By.xpath("/html/body/div/form/input[1]"));
        password = driver.findElement(By.xpath("/html/body/div/form/input[2]"));
        login = driver.findElement(By.xpath("/html/body/div/form/button"));
		email.sendKeys(EMAIL);
        password.sendKeys("test");
        login.click();
        //Correct login input
		System.out.println("Please enter your password correctly");
		email.sendKeys(EMAIL);
		password.sendKeys(PSWD);
		login.click();
		System.out.println("Login successfull");		
	}	
}
