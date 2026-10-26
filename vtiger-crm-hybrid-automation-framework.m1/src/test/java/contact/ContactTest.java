package contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utlitiy.BaseClass;
import generic_utlitiy.FileUtility;
import generic_utlitiy.JavaUtility;
import object_repository.ContactPage;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.VerifyContactPage;

/**
 * Test Script Name : CreateContactTest
 *
 * Application : Vtiger CRM Module : Contacts Test Scenario : Create a new
 * Contact
 *
 * Description: This test script automates the creation of a new Contact in the
 * Vtiger CRM application using Page Object Model.
 *
 * Author : Piyush Baldaniya
 * 
 */
@Listeners(listeners_utility.List_Imp.class)
public class ContactTest extends BaseClass {

//	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
	
	@Test
	public void createContactTest() throws InterruptedException, IOException, ParseException {

//		Get data from properties file
		String url = FileUtility.getDataFromJsonFile("url");
		String un = FileUtility.getDataFromJsonFile("username");
		String pwd = FileUtility.getDataFromJsonFile("password");
		
		
		
		int number = JavaUtility.generateRandomNumber();
//		
//		Get test script data from excel file
		String lastName = FileUtility.getDataFromExcelFile("contacts", 3, 0) + number;

		// ============================================================
		// 1. OPEN THE BROWSER
		// ============================================================

		// after listeners comment 
		
//		System.out.println("====================================================");
//		System.out.println("TEST EXECUTION STARTED");
//		System.out.println("Test Case : Create Contact");
//		System.out.println("====================================================");
//
//		System.out.println("[INFO] Launching Chrome browser...");
//
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Instantiate ContactPage object
		ContactPage cp = new ContactPage(driver);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		VerifyContactPage vcp = new VerifyContactPage(driver);

		// ============================================================
		// 2. LOGIN
		// ============================================================

		//----------------- after the listeners comments this code 
		
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 1] Navigating to Vtiger CRM application...");
//
//		driver.get(url);
//
//		System.out.println("[INFO] Vtiger CRM application opened.");
//
//		WebElement username = lp.getUsernameField();
//		WebElement password = lp.getPasswordField();
//		WebElement loginBtn = lp.getLoginButton();
//
//		System.out.println("[INFO] Login page elements identified.");
//
//		username.sendKeys(un);
//		System.out.println("[INFO] Username entered.");
//
//		password.sendKeys(pwd);
//		System.out.println("[INFO] Password entered.");
//
//		loginBtn.click();
//
//		System.out.println("[INFO] Login button clicked.");
//		System.out.println("[INFO] Login operation completed.");

		// ============================================================
		// 3. CREATE CONTACT
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 2] Navigating to Contacts module...");

		hp.getContactsLink().click();
		System.out.println("[INFO] Contacts module opened.");

		cp.getCreateContactLookupImg().click();
		System.out.println("[INFO] Create Contact page opened.");
		System.out.println("[INFO] Contact Last Name : " + lastName);

		WebElement lastNameField = cp.getLastNameEdt();
		System.out.println("[INFO] Contact last name field identified.");

		lastNameField.sendKeys(lastName);
		System.out.println("[INFO] Contact last name entered successfully.");

		// ============================================================
		// 4. SAVE CONTACT
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 3] Saving Contact...");

		cp.getSaveBtn().click();

		System.out.println("[INFO] Save button clicked.");
		System.out.println("[INFO] Contact save operation completed.");

		// ============================================================
		// 5. VERIFICATION
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 4] Verifying Contact creation...");

		String actLastName = vcp.getContactHeaderInfo().getText();

		System.out.println("[INFO] Expected Contact Last Name : " + lastName);
		System.out.println("[INFO] Actual Contact Last Name   : " + actLastName);

		//----------------- after the listeners comments this code 

//		if (actLastName.equals(lastName)) {
//			System.out.println("[PASS] Contact created successfully !!!");
//		} else {
//			System.out.println("[FAIL] Contact creation failed...");
//		}
		
		Assert.assertEquals(actLastName, lastName + "abc");
		

		// ============================================================
		// 6. LOGOUT
		// ============================================================
//
		//----------------- after the listeners comments this code 

		
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 5] Logging out from Vtiger CRM...");
//
//		WebElement profileIcon = hp.getProfileIcon();
//		System.out.println("[INFO] Profile icon identified.");
//
//		Actions act = new Actions(driver);
//		act.moveToElement(profileIcon).build().perform();
//		System.out.println("[INFO] Mouse moved to profile icon.");
//
//
//		System.out.println("[INFO] Sign Out option clicked.");
//		System.out.println("[INFO] Logout completed successfully.");

		// ============================================================
		// 7. CLOSE THE BROWSER
		// ============================================================

		//----------------- after the listeners comments this code 

		
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 6] Closing browser...");
//
//		Thread.sleep(1000);
//
//		driver.quit();
//		System.out.println("[INFO] Browser closed successfully.");

		// ============================================================
		// TEST EXECUTION COMPLETED
		// ============================================================

		System.out.println("====================================================");
		System.out.println("TEST EXECUTION COMPLETED");
		System.out.println("Test Case : Create Contact");
		System.out.println("====================================================");
	}
}












//----------------------------- 2 time modify code using pom --------------------------

//package contact;
//
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.json.simple.parser.ParseException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//import generic_utlity.FileUtility;
//import generic_utlity.JavaUtility;
//import object_repository.ContactPage;

/**
 * Test Script Name : CreateContactTest
 *
 * Application : Vtiger CRM Module : Contacts Test Scenario : Create a new
 * Contact
 *
 * Description: This test script automates the creation of a new Contact in the
 * Vtiger CRM application using Page Object Model.
 *
 * Author : Piyush Baldaniya
 */
//public class CreateContactTest {
//
//	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
//
////		Get data from properties file
////		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");
////		Properties pObj = new Properties();
////		pObj.load(fis);
////		String url = pObj.getProperty("url");
////		String un = pObj.getProperty("username");
////		String pwd = pObj.getProperty("password");
//
////		Get test script data from excel file
//		
////		FileInputStream fis1 = new FileInputStream("./src/test/resources/testscriptdata.xlsx");
////		Workbook wb = WorkbookFactory.create(fis1);
////		Sheet sh = wb.getSheet("contact");
////		Row row = sh.getRow(5);
////		Cell cell = row.getCell(0);
////		String lastName = cell.getStringCellValue();
//		
//		
//    //get data via generic utility from json file
//		
//		String browser = FileUtility.getDataFromJsonFile("browser");
//		String url = FileUtility.getDataFromJsonFile("url");
//		String un = FileUtility.getDataFromJsonFile("username");
//		String pwd = FileUtility.getDataFromJsonFile("password");
//		
//		int number = JavaUtility.generateRandomNumber();
//		
//		
//		
//		String lastName = FileUtility.getDataFromExcelFile("contacts", 3, 0) + number;
//		
//
//		// ============================================================
//		// 1. OPEN THE  BROWSER
//		// ============================================================
//
//		System.out.println("====================================================");
//		System.out.println("TEST EXECUTION STARTED");
//		System.out.println("Test Case : Create Contact");
//		System.out.println("====================================================");
//
//		System.out.println("[INFO] Launching Chrome browser...");
//
//		WebDriver driver = new ChromeDriver();
//
//		System.out.println("[INFO] Chrome browser launched successfully.");
//
//		driver.manage().window().maximize();
//
//		System.out.println("[INFO] Browser window maximized.");
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//		System.out.println("[INFO] Implicit wait configured to 15 seconds.");
//
//		// Instantiate ContactPage object
//		ContactPage cp = new ContactPage(driver);
//
//		// ============================================================
//		// 2. LOGIN
//		// ============================================================
//
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 1] Navigating to Vtiger CRM application...");
//
//		driver.get(url);
//
//		System.out.println("[INFO] Vtiger CRM application opened.");
//
//		WebElement username = cp.getUsernameField();
//		WebElement password = cp.getPasswordField();
//		WebElement loginBtn = cp.getLoginButton();
//
//		System.out.println("[INFO] Login page elements identified.");
//
//		username.sendKeys(un);
//		System.out.println("[INFO] Username entered.");
//
//		password.sendKeys(pwd);
//		System.out.println("[INFO] Password entered.");
//
//		loginBtn.click();
//		
//		Thread.sleep(2000);
//
//		System.out.println("[INFO] Login button clicked.");
//		System.out.println("[INFO] Login operation completed.");
//
//		// ============================================================
//		// 3. CREATE CONTACT
//		// ============================================================
//
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 2] Navigating to Contacts module...");
//
//		cp.getContactsLink().click();
//
//		System.out.println("[INFO] Contacts module opened.");
//
//		cp.getCreateContactLookupImg().click();
//
//		System.out.println("[INFO] Create Contact page opened.");
//
//		System.out.println("[INFO] Contact Last Name : " + lastName);
//
//		WebElement lastNameField = cp.getLastNameEdt();
//
//		System.out.println("[INFO] Contact last name field identified.");
//
//		lastNameField.sendKeys(lastName);
//
//		System.out.println("[INFO] Contact last name entered successfully.");
//
//		// ============================================================
//		// 4. SAVE CONTACT
//		// ============================================================
//
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 3] Saving Contact...");
//
//		cp.getSaveBtn().click();
//
//		System.out.println("[INFO] Save button clicked.");
//		System.out.println("[INFO] Contact save operation completed.");
//
//		// ============================================================
//		// 5. VERIFICATION
//		// ============================================================
//
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 4] Verifying Contact creation...");
//
//		String actLastName = cp.getContactHeaderInfo().getText();
//
//		System.out.println("[INFO] Expected Contact Last Name : " + lastName);
//		System.out.println("[INFO] Actual Contact Last Name   : " + actLastName);
//
//		if (actLastName.equals(lastName)) {
//
//			System.out.println("[PASS] Contact created successfully !!!");
//
//		} else {
//
//			System.out.println("[FAIL] Contact creation failed...");
//
//		}
//
//		// ============================================================
//		// 6. LOGOUT
//		// ============================================================
//
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 5] Logging out from Vtiger CRM...");
//
//		WebElement profileIcon = cp.getProfileIcon();
//
//		System.out.println("[INFO] Profile icon identified.");
//
//		Actions act = new Actions(driver);
//
//		act.moveToElement(profileIcon).build().perform();
//
//		System.out.println("[INFO] Mouse moved to profile icon.");
//
//		cp.getSignOutLink().click();
//
//		System.out.println("[INFO] Sign Out option clicked.");
//		System.out.println("[INFO] Logout completed successfully.");
//
//		// ============================================================
//		// 7. CLOSE THE BROWSER
//		// ============================================================
//
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 6] Closing browser...");
//
//		Thread.sleep(1000);
//
//		driver.quit();
//
//		System.out.println("[INFO] Browser closed successfully.");
//
//		// ============================================================
//		// TEST EXECUTION COMPLETED
//		// ============================================================
//
//		System.out.println("====================================================");
//		System.out.println("TEST EXECUTION COMPLETED");
//		System.out.println("Test Case : Create Contact");
//		System.out.println("====================================================");
//		
//		
//		
//		
//	}
//}
















// --------------------first time code--------------------------------- 


//package contact;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//public class CreateContactTest{
//		public static void main(String[] args) throws InterruptedException, IOException {
//			WebDriver driver = new ChromeDriver();
//
//	        driver.manage().window().maximize();
//
//	        driver.get("http://localhost:8888/index.php?action=Login&module=Users");
////	        
////	        String url = "http://localhost:8888/";
////			String un = "admin";
////			String pwd = "manager";
//	        
//	        
//	        
//	    	//get data from properties file
//			FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");
//			Properties pObj = new Properties();
//			pObj.load(fis);
//			String url = pObj.getProperty("url");
//			String un = pObj.getProperty("username");
//			String pwd = pObj.getProperty("password");
//			
//			
//			
//			
////			test script data => the data which is common for particular test scripts
////			String lastName = "Sharma";
//			
//			FileInputStream fis1 = new FileInputStream("./src/test/resources/testscriptdata.xlsx");
//			Workbook wb = WorkbookFactory.create(fis1);
//			Sheet sh = wb.getSheet("contacts");
//			Row row = sh.getRow(2);
//			Cell cell = row.getCell(0);
//			String lastName = cell.getStringCellValue();
//
//	        
//	        
//	               
//	        WebElement username = driver.findElement(By.name("user_name"));
//	        WebElement password = driver.findElement(By.name("user_password"));
//	        WebElement loginBtn = driver.findElement(By.id("submitButton"));
//	        
//	        username.sendKeys(un);
//	        password.sendKeys(pwd);
//	        loginBtn.click();
//	        Thread.sleep(2000);
//	        
//	        
//	        
//	        
//	        
//	        
//	        
//	        
//	       // create contanct 
//	        
//	       driver.findElement(By.linkText("Contacts")).click();
//	       driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
//	       
//	       
//	    // Filling Form
//	     //  String lastName = "Kumar";
//	       WebElement lastNameField = driver.findElement(By.name("lastname"));
//	       lastNameField.sendKeys(lastName);
//	       
//	    // Save
//	       driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
//	       
//	    // Verification
//	       String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
//	       if (actLastName.equals(lastName)) {
//	       System.out.println("Contact Successfully created !!!");
//	       }else {
//	       System.out.println("Failed.....");
//	       }
//	       
//	       
//	       
//	       // logout
//	       
//	       WebElement profile =
//	    		   driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//	    		   Actions act = new Actions(driver);
//	    		   act.moveToElement(profile).build().perform();
//	    		   driver.findElement(By.linkText("Sign Out")).click();
//	    		   // close the browser
//	    		   Thread.sleep(10000);
//	    		   driver.quit();
//	    		   
//	        
//	        
//	        Thread.sleep(4000);
//
//	      //  driver.quit();
//		
//			
//		}
//
//}









