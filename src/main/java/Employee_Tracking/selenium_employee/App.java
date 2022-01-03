package main.java.Employee_Tracking.selenium_employee;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class App 
{	
	public WebDriver driver;
	public final String  BASE_URL = "file:///D:/laksys/Document/Tasks/Emlpoyee_Tracking/index2.html";
	public final String  DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe\\";
	
	public App() {
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		this.driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void openBrowser() {
		driver.get(BASE_URL);
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void AddUserAuthenticationTest() throws InterruptedException {
		UserAuthenticationTest login = new UserAuthenticationTest(driver);
		login.EmployeeLoginSetup();
		login.EmployeeLogout();
		login.EmptyEmailError();
		login.EmptyPasswordError();
		login.IncorrectEmailError();
		login.IncorrectPasswordError();
	}
	
	@Test(priority = 2)
	public void AddEmployeeinformationTest() throws InterruptedException {
		EmployeeInformationTest info = new EmployeeInformationTest(driver);
		info.EmployeeInformationAndEditingData();
		info.EmptyEmployeeInformationError();
		info.EmployeeTableDataError();
	}
	
	@Test(priority = 3)
	public void AddEmployeeActivityTest() throws InterruptedException {
		EmployeeActivityTest active = new EmployeeActivityTest(driver);
		active.EmployeeActivityandEditingData();
		active.EmptyEmployeeActivityError();
		active.EmployeeActivityDataTableError();
	}
}