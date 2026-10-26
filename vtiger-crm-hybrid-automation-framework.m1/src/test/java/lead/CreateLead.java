package lead;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import extra.GenRanNum;
import generic_utlitiy.FileUtility;
import generic_utlitiy.JavaUtility;
import object_repository.LeadPage;
import object_repository.OrgPage;

public class CreateLead {
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
//		WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//
//        driver.get("http://localhost:8888/index.php?action=Login&module=Users");
//        
//        //-----------------Login---------------------------------
//        
//        WebElement username = driver.findElement(By.name("user_name"));
//        WebElement password = driver.findElement(By.name("user_password"));
//        WebElement loginBtn = driver.findElement(By.id("submitButton"));
//        
//        username.sendKeys("admin");
//        password.sendKeys("manager");
//        loginBtn.click();
//        
//        
//        //--------------Create lead------------
//    	driver.findElement(By.linkText("Leads")).click();
//		driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
//		
//		
//		
//		// -----------------form fill up---------------
//		String orgName = "kumar_" + GenRanNum.generateRandomNumber();
//		WebElement orgField = driver.findElement(By.name("lastname"));
//		orgField.sendKeys(orgName);
//		
//		
//		String comName = "Google_" + GenRanNum.generateRandomNumber();
//		WebElement orgField2 = driver.findElement(By.name("company"));
//		orgField2.sendKeys(comName);
//
//        
//        
//        // ------------------------Save----------------------------
//     	driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
//     		
//		
//        
//        
//    	//----------------------logout-------------------------------------
//		WebElement profile =
//		driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(profile).build().perform();
//		driver.findElement(By.linkText("Sign Out")).click();
//		
//		
//		
//		//----------------------close the browser---------------------------------
//		Thread.sleep(10000);
//		driver.quit();
		
		
		String browser = FileUtility.getDataFromJsonFile("browser");
		String url = FileUtility.getDataFromJsonFile("url");
		String un = FileUtility.getDataFromJsonFile("username");
		String pwd = FileUtility.getDataFromJsonFile("password");
		
		int number = JavaUtility.generateRandomNumber();
		
		
		String lastName = FileUtility.getDataFromExcelFile("leads", 2, 0) + number;
		String CompanyName = FileUtility.getDataFromExcelFile("leads", 2, 1) + number;

		
		// 1. OPEN THE BROWSER 
		
		WebDriver driver = new ChromeDriver();
		
		System.out.println("[INFO] Chrome browser launched successfully.");

		driver.manage().window().maximize();

		System.out.println("[INFO] Browser window maximized.");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		System.out.println("[INFO] Implicit wait configured to 15 seconds.");

	


		
		
		
		// Instantiate ContactPage object
		LeadPage cp = new LeadPage(driver);
		
		
		//login

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 1] Navigating to Vtiger CRM application...");

		driver.get(url);

		System.out.println("[INFO] Vtiger CRM application opened.");

		WebElement username = cp.getUsernameField();
		WebElement password = cp.getPasswordField();
		WebElement loginBtn = cp.getLoginButton();

		System.out.println("[INFO] Login page elements identified.");

		username.sendKeys(un);
		System.out.println("[INFO] Username entered.");

		password.sendKeys(pwd);
		System.out.println("[INFO] Password entered.");

		loginBtn.click();
		
		Thread.sleep(2000);

		System.out.println("[INFO] Login button clicked.");
		System.out.println("[INFO] Login operation completed.");

	

		
		
		
		// Create lead
	
		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 2] Navigating to Contacts module...");

		cp.getLeadsBtn().click();

		System.out.println("[INFO] Contacts module opened.");

		cp.getCreateLeadLookupImg().click();

		System.out.println("[INFO] Create Contact page opened.");

		System.out.println("[INFO] Contact Last Name : " + lastName);
		
		// fill the data of last name 
		WebElement lastNameField = cp.getlastnameEdt();

		System.out.println("[INFO] Contact last name field identified.");

		lastNameField.sendKeys(lastName);
		
		
		// fill the data of company name 
		
		System.out.println("[INFO] Contact Last Name : " + CompanyName);

		System.out.println("[INFO] Contact last name entered successfully.");
		
		WebElement companyNameField = cp.getcompanynameEdt();

		System.out.println("[INFO] Contact last name field identified.");

		companyNameField.sendKeys(CompanyName);

		System.out.println("[INFO] Contact last name entered successfully.");

		
		
		
		
		
		
		// Save
		//driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 3] Saving Contact...");

		cp.getSaveBtn().click();

		System.out.println("[INFO] Save button clicked.");
		System.out.println("[INFO] Contact save operation completed.");

		
		
		
		// Verification
		
		// verify the last name 
		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 4] Verifying Contact creation...");
		Thread.sleep(2000);

		String actLastName = cp.getContactHeaderInfo_lastName().getText();

		System.out.println("[INFO] Expected Contact Last Name : " + lastName);
		System.out.println("[INFO] Actual Contact Last Name   : " + actLastName);

		if (actLastName.equals(lastName)) {

			System.out.println("[PASS] Contact created successfully !!!");

		} else {

			System.out.println("[FAIL] Contact creation failed...");

		}
		
		// verify the company name 
				System.out.println("----------------------------------------------------");
				System.out.println("[STEP 4] Verifying Contact creation...");
				Thread.sleep(2000);

				String actCompanyName = cp.getContactHeaderInfo_companyName().getText();

				System.out.println("[INFO] Expected Contact Last Name : " + CompanyName);
				System.out.println("[INFO] Actual Contact Last Name   : " + actCompanyName);

				if (actCompanyName.equals(CompanyName)) {

					System.out.println("[PASS] Contact created successfully !!!");

				} else {

					System.out.println("[FAIL] Contact creation failed...");

				}
		
		
		

		
		
		
			// logout
//			WebElement profile =
//			driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//			Actions act = new Actions(driver);
//			act.moveToElement(profile).build().perform();
//			driver.findElement(By.linkText("Sign Out")).click();
//			
		
		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 5] Logging out from Vtiger CRM...");

		WebElement profileIcon = cp.getProfileIcon();

		System.out.println("[INFO] Profile icon identified.");

		Actions act = new Actions(driver);

		act.moveToElement(profileIcon).build().perform();

		System.out.println("[INFO] Mouse moved to profile icon.");

		cp.getSignOutLink().click();

		System.out.println("[INFO] Sign Out option clicked.");
		System.out.println("[INFO] Logout completed successfully.");

	
			
			
			// close the browser
//			Thread.sleep(10000);
//			driver.quit();
		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 6] Closing browser...");

		Thread.sleep(1000);

		driver.quit();

		System.out.println("[INFO] Browser closed successfully.");

		// ============================================================
		// TEST EXECUTION COMPLETED
		// ============================================================

		System.out.println("====================================================");
		System.out.println("TEST EXECUTION COMPLETED");
		System.out.println("Test Case : Create Contact");
		System.out.println("====================================================");
						
		
      
	}
}
