package product;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import extra.GenRanNum;

public class product {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		//-----------------------login----------------------------
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		
		username.sendKeys("admin");
		password.sendKeys("manager");
		loginBtn.click();
		Thread.sleep(2000);
		
		//-------------------create product------------------------
		
		WebElement co = driver.findElement(By.linkText("Products"));
		co.click();
		driver.findElement(By.cssSelector("img[alt='Create Product...']")).click();
		
		
		
		//---------------------form fill up---------------------------
		String orgName = "boatRoocker_" + GenRanNum.generateRandomNumber();
		WebElement org = driver.findElement(By.name("productname"));
		org.sendKeys(orgName);
		
		
		
		//-------------------------save---------------------------
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		
		
		//-------------------------handle pop up-----------------------
//  	Alert alert = driver.switchTo().alert();
//  	alert.accept();
		
		
		//----------------------logout--------------------------
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		Thread.sleep(20000);
		driver.quit();
		
		
		
	}

}
