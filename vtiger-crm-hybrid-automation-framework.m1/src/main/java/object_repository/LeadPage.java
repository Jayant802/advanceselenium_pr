package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// login Element  
	
	@FindBy(name = "user_name")
	private WebElement usernameField;
	
	@FindBy(name = "user_password")
	private WebElement passwordField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	public WebElement getUsernameField() {
		return usernameField;
	}
	
	public WebElement getPasswordField() {
		return passwordField;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	// create Lead
//	driver.findElement(By.linkText("Leads")).click();
//	driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
//	WebElement orgField = driver.findElement(By.name("lastname"));
//	WebElement orgField2 = driver.findElement(By.name("company"));

	
	
	
	@FindBy(linkText = "Leads")
	private WebElement LeadsBtn;
	public WebElement getLeadsBtn() {
		return LeadsBtn;
	}
	
	@FindBy(css = "img[alt='Create Lead...']")
	private WebElement createLeadLookupImg;
	public WebElement getCreateLeadLookupImg() {
		return createLeadLookupImg;
	}
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	public WebElement getlastnameEdt() {
		return lastnameEdt;
	}
	
	@FindBy(name = "company")
	private WebElement companynameEdt;
	public WebElement getcompanynameEdt() {
		return companynameEdt;
	}
	

	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	//verification
	//@FindBy(id = "dtlview_Organization Name")
	// potentialname
	@FindBy(id = "dtlview_Last Name")
	private WebElement contactHeaderInfo_One;
	public WebElement getContactHeaderInfo_lastName() {
		return contactHeaderInfo_One;
	}
	
	//dtlview_Company
	@FindBy(id = "dtlview_Company")
	private WebElement contactHeaderInfo_Two;
	public WebElement getContactHeaderInfo_companyName() {
		return contactHeaderInfo_Two;
	}

	
	
	// Logout Elements
		@FindBy(css = "[src='themes/softed/images/user.PNG']")
		private WebElement profileIcon;
			
		@FindBy(linkText = "Sign Out")
		private WebElement signOutLink;
			
		public WebElement getProfileIcon() {
			return profileIcon;
		}

		public WebElement getSignOutLink() {
			return signOutLink;
		}
		
	
}
