package main.java.Employee_Tracking.selenium_employee;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EmployeeInformationTest
{
	public WebDriver driver;
	public WebElement email, password,login,logout;
	public WebElement inputText, activityInput;
	public final String EMP_URL = "file:///D:/laksys/Document/Tasks/Emlpoyee_Tracking/frame.html" ;
	
	public EmployeeInformationTest(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test(priority = 10)
	public void EmployeeInformationAndEditingData() {
		System.out.println( "Automation Testing of Employee Information" );
		driver.get(EMP_URL);
	    driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);     
	    WebDriverWait wait = new WebDriverWait(driver, 150);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/iframe[2]")));
	   //Switch by Index
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")));
	    //Input
	    driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Arun");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Devloper");
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();

		driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("varun");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Engineer");
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();

		driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Megha");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Software");
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();
		//Editing input 
		driver.findElement(By.xpath("//*[@id=\"employeeList\"]/tbody/tr/td[3]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Arun M");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Developer");
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();

		driver.findElement(By.xpath("//*[@id=\"employeeList\"]/tbody/tr[2]/td[3]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Varun");
		driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("System Developer");
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();
		//Delete input and Web driver to wait for alert
		driver.findElement(By.xpath("//*[@id=\"employeeList\"]/tbody/tr[2]/td[3]/a[2]")).click();
		WebDriverWait dele2 = new WebDriverWait(driver,250);
		dele2.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();

		driver.findElement(By.xpath("//*[@id=\"employeeList\"]/tbody/tr[3]/td[3]/a[2]")).click();
		WebDriverWait dele3 = new WebDriverWait(driver,250);
		dele3.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	@Test(priority = 11)
	public void EmptyEmployeeInformationError() {
		System.out.println( "Automation Testing of Empty Text Employee Information" );
		driver.get(EMP_URL);
	    driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);     
	    WebDriverWait wait = new WebDriverWait(driver, 150);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/iframe[2]")));
	    //Switch by Index
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")));
	    
	    inputText = driver.findElement(By.cssSelector("#fullName,#empCode"));
		String text = inputText.getAttribute("value");
		inputText = driver.findElement(By.xpath("//*[@id=\"fullName\"]"));//1st input
	    inputText.sendKeys("");
	    inputText = driver.findElement(By.xpath("//*[@id=\"empCode\"]"));
	    inputText.sendKeys(" ");
		if(text.isBlank()) {
			System.out.println("Employee input box is empty"+ text);
		}
	}
	
	@Test(priority = 12)
	public void EmployeeTableDataError() {
		System.out.println( "Automation Testing of Employee Full Data with cloumns and rows" );
		driver.get(EMP_URL);
	    driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);     
	    WebDriverWait wait = new WebDriverWait(driver, 150);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/iframe[2]")));
	    //Switch by Index
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")));

	    driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("");
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();

		driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Engineer");
		driver.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/input[1]")).click();

		driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Megha");
	    driver.findElement(By.xpath("//*[@id=\"empCode\"]")).sendKeys("Software");
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
   	}
}
