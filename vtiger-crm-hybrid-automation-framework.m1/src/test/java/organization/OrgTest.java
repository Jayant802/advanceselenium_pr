package organization;


import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_utlity.FileUtility;
import generic_utlity.JavaUtility;
import generic_utlity.WebDriverUtility;
import object_repository.ContactPage;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;

import object_repository.VerifyOrgPage;

/**
 * Test Script Name : CreateOrgTest
 *
 * Application : Vtiger CRM Module : Organizations Test Scenario : Create a new
 * Organization
 *
 * Description: This test script automates the creation of a new Organization in
 * the Vtiger CRM application.
 *
 * Test Flow: 1. Launch browser 2. Maximize browser window 3. Configure implicit
 * wait 4. Navigate to Vtiger CRM application 5. Login using valid credentials
 * 6. Navigate to Organizations module 7. Open Create Organization page 8.
 * Generate a unique Organization name 9. Enter Organization name 10. Save the
 * Organization 11. Verify the created Organization name 12. Logout from the
 * application 13. Close the browser
 *
 * Expected Result: The Organization should be created successfully and the
 * displayed Organization name should match the entered name.
 *
 * Author : Piyush Baldaniya
 */

public class OrgTest {

	@Test
	public void createOrgTest() throws IOException, ParseException, InterruptedException {

		// ============================================================
		// GET COMMON DATA FROM JSON FILE
		// ============================================================

		Reporter.log("====================================================", true);
		Reporter.log("READING COMMON DATA FROM JSON FILE", true);
		Reporter.log("====================================================", true);

		String browser = FileUtility.getDataFromJsonFile("browser");
		String url = FileUtility.getDataFromJsonFile("url");
		String un = FileUtility.getDataFromJsonFile("username");
		String pwd = FileUtility.getDataFromJsonFile("password");

		Reporter.log("[INFO] Browser : " + browser, true);
		Reporter.log("[INFO] URL : " + url, true);
		Reporter.log("[INFO] Username retrieved successfully.", true);

		// ============================================================
		// GENERATE UNIQUE ORGANIZATION NAME
		// ============================================================

		int number = JavaUtility.generateRandomNumber();

		String orgName = FileUtility.getDataFromExcelFile("org", 2, 0) + number;

		Reporter.log("[INFO] Generated Organization Name : " + orgName, true);

		// ============================================================
		// 1. OPEN THE BROWSER
		// ============================================================

		Reporter.log("====================================================", true);
		Reporter.log("TEST EXECUTION STARTED", true);
		Reporter.log("Test Case : Create Organization", true);
		Reporter.log("====================================================", true);

		Reporter.log("[STEP 1] Launching browser...", true);

		WebDriver driver = null;

		if (browser.equals("edge")) {

			driver = new EdgeDriver();

			Reporter.log("[INFO] Edge browser launched successfully.", true);

		} else if (browser.equals("chrome")) {

			driver = new ChromeDriver();

			Reporter.log("[INFO] Chrome browser launched successfully.", true);

		} else if (browser.equals("firefox")) {

			driver = new FirefoxDriver();

			Reporter.log("[INFO] Firefox browser launched successfully.", true);

		} else {

			driver = new ChromeDriver();

			Reporter.log("[INFO] Invalid browser value. Chrome browser launched by default.", true);
		}

		// ============================================================
		// BROWSER CONFIGURATION
		// ============================================================

		driver.manage().window().maximize();

		Reporter.log("[INFO] Browser window maximized.", true);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		Reporter.log("[INFO] Implicit wait configured to 15 seconds.", true);

		// ============================================================
		// CREATE PAGE OBJECTS
		// ============================================================
		
		LoginPage lp = new LoginPage(driver);

		HomePage hp = new HomePage(driver);
		
		OrgPage cp = new OrgPage(driver);
		
		VerifyOrgPage vcp = new VerifyOrgPage(driver);

		WebDriverUtility wdUtil = new WebDriverUtility();

		Reporter.log("[INFO] Page objects created successfully.", true);

		// ============================================================
		// 2. LOGIN
		// ============================================================

		Reporter.log("----------------------------------------------------", true);
		Reporter.log("[STEP 2] Navigating to Vtiger CRM application...", true);

		driver.get(url);

		Reporter.log("[INFO] Vtiger CRM application opened.", true);

		// ============================================================
		// LOGIN PAGE
		// ============================================================

		WebElement username = lp.getUsernameField();

		WebElement password = lp.getPasswordField();

		WebElement loginBtn = lp.getLoginButton();

		Reporter.log("[INFO] Login page elements identified.", true);

		// Refresh the page
		driver.navigate().refresh();

		Reporter.log("[INFO] Login page refreshed.", true);

		// ============================================================
		// RE-INITIALIZATION AFTER REFRESH
		// ============================================================

		username = driver.findElement(By.name("user_name"));

		username.sendKeys(un);

		Reporter.log("[INFO] Username entered.", true);

		password = driver.findElement(By.name("user_password"));

		password.sendKeys(pwd);

		Reporter.log("[INFO] Password entered.", true);

		loginBtn = driver.findElement(By.id("submitButton"));

		loginBtn.click();

		Reporter.log("[INFO] Login button clicked.", true);

		Reporter.log("[INFO] Login operation completed.", true);

		// ============================================================
		// 3. CREATE ORGANIZATION
		// ============================================================

		Reporter.log("----------------------------------------------------", true);
		Reporter.log("[STEP 3] Navigating to Organizations module...", true);

		hp.getOrgLink().click();

		Reporter.log("[INFO] Organizations module opened.", true);

		// ============================================================
		// ORGANIZATION LIST PAGE
		// ============================================================

//		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
		cp.getCreateOrganizationLookupImg().click();
		Reporter.log("[INFO] Create Organization page opened.", true);

		// ============================================================
		// CREATE ORGANIZATION PAGE
		// ============================================================

		Reporter.log("[INFO] Organization Name : " + orgName, true);

//		WebElement orgField = driver.findElement(By.name("accountname"));
		
	
		WebElement lastNameField = cp.getAccountNameEdt();

		Reporter.log("[INFO] Organization name field identified.", true);

		lastNameField.sendKeys(orgName);

		Reporter.log("[INFO] Organization name entered successfully.", true);

		// ============================================================
		// 4. SAVE ORGANIZATION
		// ============================================================

		Reporter.log("----------------------------------------------------", true);
		Reporter.log("[STEP 4] Saving Organization...", true);

//		driver.findElement(By.className("save")).click();
		cp.getSaveBtn().click();


		Reporter.log("[INFO] Save button clicked.", true);

		Reporter.log("[INFO] Organization save operation completed.", true);

		// ============================================================
		// 5. VERIFICATION
		// ============================================================

		Reporter.log("----------------------------------------------------", true);
		Reporter.log("[STEP 5] Verifying Organization creation...", true);

//		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		String actOrgName = vcp.getOrgHeaderInfo().getText();


		Reporter.log("[INFO] Expected Organization Name : " + orgName, true);

		Reporter.log("[INFO] Actual Organization Name   : " + actOrgName, true);

		if (actOrgName.equals(orgName)) {

			Reporter.log("[PASS] Organization created successfully !!!", true);

		} else {

			Reporter.log("[FAIL] Organization creation failed...", true);
		}

		// ============================================================
		// 6. LOGOUT
		// ============================================================

		Reporter.log("----------------------------------------------------", true);
		Reporter.log("[STEP 6] Logging out from Vtiger CRM...", true);

//		WebElement profileIcon = driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"));
		WebElement profileIcon = hp.getProfileIcon();
		
		Reporter.log("[INFO] Profile icon identified.", true);

		wdUtil.hover(driver, profileIcon);

		Reporter.log("[INFO] Mouse moved to profile icon.", true);

//		driver.findElement(By.linkText("Sign Out")).click();
		hp.getSignOutLink().click();


		Reporter.log("[INFO] Sign Out option clicked.", true);

		Reporter.log("[INFO] Logout completed successfully.", true);

		// ============================================================
		// 7. CLOSE THE BROWSER
		// ============================================================

		Reporter.log("----------------------------------------------------", true);
		Reporter.log("[STEP 7] Closing browser...", true);

		Thread.sleep(1000);

		driver.quit();

		Reporter.log("[INFO] Browser closed successfully.", true);

		// ============================================================
		// TEST EXECUTION COMPLETED
		// ============================================================

		Reporter.log("====================================================", true);

		Reporter.log("TEST EXECUTION COMPLETED", true);

		Reporter.log("Test Case : Create Organization", true);

		Reporter.log("====================================================", true);
	}
}













//package organization;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import org.json.simple.parser.ParseException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import extra.GenRanNum;
//import generic_utlity.FileUtility;
//import generic_utlity.JavaUtility;
//import object_repository.ContactPage;
//import object_repository.OrgPage;
//
//
//public class organization {
//	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
//		
//		// open the browser
////		WebDriver driver = new ChromeDriver();
////		driver.manage().window().maximize();
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
////		
//		
//		// Login
////		driver.get("http://localhost:8888/");
////		WebElement username = driver.findElement(By.name("user_name"));
////		WebElement password = driver.findElement(By.name("user_password"));
////		username.sendKeys("admin");
////		password.sendKeys("manager" + Keys.ENTER);
//		
//		
//		
//		
//		String browser = FileUtility.getDataFromJsonFile("browser");
//		String url = FileUtility.getDataFromJsonFile("url");
//		String un = FileUtility.getDataFromJsonFile("username");
//		String pwd = FileUtility.getDataFromJsonFile("password");
//		
//		int number = JavaUtility.generateRandomNumber();
//		
//		
//		String orgName = FileUtility.getDataFromExcelFile("org", 3, 0) + number;
//		
//		
//		// 1. OPEN THE BROWSER 
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
//	
//
//
//		
//		
//		
//		// Instantiate ContactPage object
//		OrgPage cp = new OrgPage(driver);
//		
//		
//		//login
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
//	
//
//		
//		
//		
//		// Create organization
////		driver.findElement(By.linkText("Organizations")).click();
////		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
////		
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 2] Navigating to Contacts module...");
//
//		cp.getOrganizationLink().click();
//
//		System.out.println("[INFO] Contacts module opened.");
//
//		cp.getCreateOrganizationLookupImg().click();
//
//		System.out.println("[INFO] Create Contact page opened.");
//
//		System.out.println("[INFO] Contact Last Name : " + orgName);
//
//		WebElement accountNameField = cp.getAccountNameEdt();
//
//		System.out.println("[INFO] Contact last name field identified.");
//
//		accountNameField.sendKeys(orgName);
//
//		System.out.println("[INFO] Contact last name entered successfully.");
//
//		
//		
//		
//		
//		// Filling Form
////		String orgName = "MakunaiGlobal_" + GenRanNum.generateRandomNumber();
////		WebElement orgField = driver.findElement(By.name("accountname"));
////		orgField.sendKeys(orgName);
////		
//		
//		// Save
//		//driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 3] Saving Contact...");
//
//		cp.getSaveBtn().click();
//
//		System.out.println("[INFO] Save button clicked.");
//		System.out.println("[INFO] Contact save operation completed.");
//
//		
//		
//		
//		// Verification
////		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
////		if (actOrgName.equals(orgName)) {
////				System.out.println("Organization Succesfully created !!!");
////			}else {
////				System.out.println("Failed.....");
////			}
//		
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 4] Verifying Contact creation...");
//		Thread.sleep(2000);
//
//		String actOrgName = cp.getContactHeaderInfo().getText();
//
//		System.out.println("[INFO] Expected Contact Last Name : " + orgName);
//		System.out.println("[INFO] Actual Contact Last Name   : " + actOrgName);
//
//		if (actOrgName.equals(orgName)) {
//
//			System.out.println("[PASS] Contact created successfully !!!");
//
//		} else {
//
//			System.out.println("[FAIL] Contact creation failed...");
//
//		}
//
//		
//		
//		
//			// logout
////			WebElement profile =
////			driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
////			Actions act = new Actions(driver);
////			act.moveToElement(profile).build().perform();
////			driver.findElement(By.linkText("Sign Out")).click();
////			
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
//	
//			
//			
//			// close the browser
////			Thread.sleep(10000);
////			driver.quit();
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
//			}
//}
