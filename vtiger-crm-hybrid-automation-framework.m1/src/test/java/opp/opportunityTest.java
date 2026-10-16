package opp;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import extra.GenRanNum;
import generic_utlity.FileUtility;
import generic_utlity.JavaUtility;
import generic_utlity.WebDriverUtility;
import object_repository.ContactPage;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OppPage;
import object_repository.OrgPage;
import object_repository.VerifyOppPage;

public class opportunityTest {
	@Test
	public void createopportunityTest() throws InterruptedException, IOException, ParseException {
		
		//--------------------------- 3rd time modification using testNG-------------------
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

				String oppName = FileUtility.getDataFromExcelFile("org", 2, 0) + number;

				Reporter.log("[INFO] Generated Organization Name : " + oppName, true);

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
				
				OppPage cp = new OppPage(driver);
				
				VerifyOppPage vcp = new VerifyOppPage(driver);

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

				hp.getOppLink().click();

				Reporter.log("[INFO] Organizations module opened.", true);

				// ============================================================
				// ORGANIZATION LIST PAGE
				// ============================================================

//				driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
				cp.getCreateOpportunityLookupImg().click();
				Reporter.log("[INFO] Create Organization page opened.", true);

				// ============================================================
				// CREATE ORGANIZATION PAGE
				// ============================================================

				Reporter.log("[INFO] Organization Name : " + oppName, true);

//				WebElement orgField = driver.findElement(By.name("accountname"));
				
			
				WebElement lastNameField = cp.getOpportunityEdt();

				Reporter.log("[INFO] Organization name field identified.", true);

				lastNameField.sendKeys(oppName);

				Reporter.log("[INFO] Organization name entered successfully.", true);

				// ============================================================
				// 4. SAVE ORGANIZATION
				// ============================================================

				Reporter.log("----------------------------------------------------", true);
				Reporter.log("[STEP 4] Saving Organization...", true);

//				driver.findElement(By.className("save")).click();
				cp.getSaveBtn().click();


				Reporter.log("[INFO] Save button clicked.", true);

				Reporter.log("[INFO] Organization save operation completed.", true);
				
				
				
				// pop up handel 	
				
				WebDriverUtility wb = new WebDriverUtility();
				wb.acceptAlert(driver);
				

				// ============================================================
				// 5. VERIFICATION
				// ============================================================

				Reporter.log("----------------------------------------------------", true);
				Reporter.log("[STEP 5] Verifying Organization creation...", true);

//				String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
				
				String actOppName = vcp.getOppHeaderInfo().getText();


				Reporter.log("[INFO] Expected Organization Name : " + oppName, true);

				Reporter.log("[INFO] Actual Organization Name   : " + actOppName, true);

				if (actOppName.equals(oppName)) {

					Reporter.log("[PASS] Organization created successfully !!!", true);

				} else {

					Reporter.log("[FAIL] Organization creation failed...", true);
				}

				// ============================================================
				// 6. LOGOUT
				// ============================================================

				Reporter.log("----------------------------------------------------", true);
				Reporter.log("[STEP 6] Logging out from Vtiger CRM...", true);

//				WebElement profileIcon = driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"));
				WebElement profileIcon = hp.getProfileIcon();
				
				Reporter.log("[INFO] Profile icon identified.", true);

				wdUtil.hover(driver, profileIcon);

				Reporter.log("[INFO] Mouse moved to profile icon.", true);

//				driver.findElement(By.linkText("Sign Out")).click();
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
			

		
		
		
		
		
		
		
		
		
       //----------------------- 2nd time modification usding pom concept 		
		
		
		
 //get data via generic utility from json file
		
//		String browser = FileUtility.getDataFromJsonFile("browser");
//		String url = FileUtility.getDataFromJsonFile("url");
//		String un = FileUtility.getDataFromJsonFile("username");
//		String pwd = FileUtility.getDataFromJsonFile("password");
//		
//		int number = JavaUtility.generateRandomNumber();
//		
//		
//		
//		String oppName = FileUtility.getDataFromExcelFile("Oppertunities", 3, 0) + number;
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
//		OppPage cp = new OppPage(driver);
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
//		// 3. CREATE opportunity
//		// ============================================================
//
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 2] Navigating to Contacts module...");
//
//		cp.getOpportunitiesBtn().click();
//
//		System.out.println("[INFO] Contacts module opened.");
//
//		cp.getCreateOpportunityLookupImg().click();
//
//		System.out.println("[INFO] Create Contact page opened.");
//
//		System.out.println("[INFO] Contact Last Name : " + oppName);
//
//		WebElement lastNameField = cp.getOpportunityEdt();
//
//		System.out.println("[INFO] Contact last name field identified.");
//
//		lastNameField.sendKeys(oppName);
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
//		// pop up handel 	
//		WebDriverUtility wb = new WebDriverUtility();
//		wb.acceptAlert(driver);
//		
//
//		// ============================================================
//		// 5. VERIFICATION
//		// ============================================================
//
//		System.out.println("----------------------------------------------------");
//		System.out.println("[STEP 4] Verifying Contact creation...");
//
//		String actOppName = cp.getContactHeaderInfo().getText();
//
//		System.out.println("[INFO] Expected Contact Last Name : " + oppName);
//		System.out.println("[INFO] Actual Contact Last Name   : " + actOppName);
//
//		if (actOppName.equals(oppName)) {
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
		

		
		
		
		
		// ======================  1st time normal script ======================
		
		
		
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
//		
//		//------------------------login------------------------
//		
//		WebElement username = driver.findElement(By.name("user_name"));
//		WebElement password = driver.findElement(By.name("user_password"));
//		WebElement loginBtn = driver.findElement(By.id("submitButton"));
//		
//		username.sendKeys("admin");
//		password.sendKeys("manager");
//		loginBtn.click();
//		
//		//---------------------create Opportunity--------------
//		WebElement co = driver.findElement(By.linkText("Opportunities"));
//		co.click();
//		driver.findElement(By.cssSelector("img[alt='Create Opportunity...']")).click();
//		
//		
//		//---------------------form fill up---------------------------
//		String orgName = "RRS_" + GenRanNum.generateRandomNumber();
//		WebElement org = driver.findElement(By.name("potentialname"));
//		org.sendKeys(orgName);
//		
//		
//		//-------------------------save---------------------------
//		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
//		
//		
//		
//		//-------------------------handle pop up-----------------------
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		
//		
//		//----------------------logout--------------------------
//		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(profile).build().perform();
//		driver.findElement(By.linkText("Sign Out")).click();
//		
//		
// 
//		//-----------------close the browser--------------------
//		Thread.sleep(10000);
//		driver.quit();
//		
		
		
		
		
		
		
		
		
		
	}
}



