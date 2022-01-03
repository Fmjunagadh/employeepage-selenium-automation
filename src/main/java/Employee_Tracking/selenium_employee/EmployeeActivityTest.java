package main.java.Employee_Tracking.selenium_employee;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EmployeeActivityTest
{
	public WebElement email, password,login,logout;
	public WebElement inputText, activityInput;
	public WebDriver driver;
	public final String ACTIVE_URL = "file:///D:/laksys/Document/Tasks/Emlpoyee_Tracking/frame.html";
			
	public EmployeeActivityTest(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test(priority = 13)
	public void EmployeeActivityandEditingData() {
		System.out.println( "Automation Testing of Employee Activites" );
		driver.get(ACTIVE_URL);
		//Web driver wait for frame1
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);     
	    WebDriverWait wait = new WebDriverWait(driver, 150);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/iframe[1]")));
	    //Switch by Index
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[1]")));
	    driver.findElement(By.xpath("/html/body/a[2]")).click();
	    System.out.println("Clicked On Activity to insert inputs");
	    //Switch by Index
	    driver.switchTo().parentFrame();
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")));
	    //Inputs
	    driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Rashmi");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Selenium Documentation");
	    driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();

	    driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Manish");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Java Testing");
	    driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();

	    driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Suman");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Employee Activity");
	    driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();
	    //Editing input
		driver.findElement(By.xpath("//*[@id=\"employeeList\"]/tbody/tr[1]/td[3]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Rashmi G");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Selenium ");
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();

		driver.findElement(By.xpath("//*[@id=\"employeeList\"]/tbody/tr[3]/td[3]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Suman A");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Python");
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();
		//Delete input and Web driver to wait for alert
		driver.findElement(By.xpath("//*[@id=\"employeeList\"]/tbody/tr[1]/td[3]/a[2]")).click();
		WebDriverWait dele2 = new WebDriverWait(driver,250);
		dele2.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();

		driver.findElement(By.xpath("//*[@id=\"employeeList\"]/tbody/tr[2]/td[3]/a[2]")).click();
		WebDriverWait dele3 = new WebDriverWait(driver,250);
		dele3.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	@Test(priority = 14)
	public void EmptyEmployeeActivityError() {
		System.out.println( "Automation Testing of Employee Activites" );
		driver.get(ACTIVE_URL);
		//Web driver wait for frame1
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);     
	    WebDriverWait wait = new WebDriverWait(driver, 150);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/iframe[1]")));
	    //Switch by Index
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[1]")));
	    driver.findElement(By.xpath("/html/body/a[2]")).click();
	    System.out.println("Clicked On Activity to Switch from Employee to Activity Frame");
	    //Switch by Index
	    driver.switchTo().parentFrame();
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")));
	    //Input1 to Activities
	    activityInput = driver.findElement(By.cssSelector("#fullName,#empCode"));
		String input = activityInput.getAttribute("value");
		
		activityInput = driver.findElement(By.xpath("//*[@id=\"fullName\"]"));//1st input
	    activityInput.sendKeys("");
	    activityInput = driver.findElement(By.xpath("//*[@id=\"empCode\"]"));
	    activityInput.sendKeys(" ");
		if(input.isBlank()) {
			System.out.println("Employees Activity input box is empty"+ activityInput);
		}
	}
	
	@Test(priority = 15)
	public void EmployeeActivityDataTableError() {
		System.out.println( "Automation Testing of Employee Activity Data Table" );
		driver.get(ACTIVE_URL);
		//Web driver wait for frame1
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);     
	    WebDriverWait wait = new WebDriverWait(driver, 150);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/iframe[1]")));
	    //Switch by Index
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[1]")));
	    driver.findElement(By.xpath("/html/body/a[2]")).click();
	    System.out.println("Clicked On Activities to Switch from Employee to Activity Frame Data Table");
	    //Switch by Index
	    driver.switchTo().parentFrame();
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")));
	    //Inputs
	    driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Rashmi");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("");
	    driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();

	    driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Java Testing");
	    driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();

	    driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("");
	    driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();
	    //To locate Table
  		WebElement mytable = driver.findElement(By.xpath("//*[@id=\"employeeList\"]/tbody"));
  		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
  		int rows_count = rows_table.size();
  		for(int row = 0; row < rows_count; row++) {
  			//To locate columns(cells) of that specific row.
      	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
      	    //To calculate no of columns (cells). In that specific row.
      	    int columns_count = Columns_row.size();
      	    System.out.println("Number of cells In Row " + row + " are " + columns_count);
      	    //Loop will execute till the last cell of that specific row.
      	    for (int column = 0; column < columns_count; column++) {
      	        // To retrieve text from that specific cell.
      	        String celtext = Columns_row.get(column).getText();
      	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
      	        if(celtext.isEmpty()) {
      	        	System.out.println("Row " + row + " and column " + column + " is empty");
      	        }
      	    }
      	    System.out.println("-------------------------------------------------- ");
      	}
  		driver.close();
	}
}
