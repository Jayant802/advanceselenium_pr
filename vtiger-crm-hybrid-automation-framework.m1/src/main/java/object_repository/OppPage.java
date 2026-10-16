package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppPage {
	public OppPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[alt='Create Opportunity...']")
	private WebElement createOpportunityLookupImg;
	public WebElement getCreateOpportunityLookupImg() {
		return createOpportunityLookupImg;
	}
	
	@FindBy(name = "potentialname")
	private WebElement opportunityName;
	public WebElement getOpportunityEdt() {
		return opportunityName;
	}
	
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	
	
//	
//	// login Element  
//	
//	@FindBy(name = "user_name")
//	private WebElement usernameField;
//	
//	@FindBy(name = "user_password")
//	private WebElement passwordField;
//	
//	@FindBy(id = "submitButton")
//	private WebElement loginButton;
//	
//	public WebElement getUsernameField() {
//		return usernameField;
//	}
//	
//	public WebElement getPasswordField() {
//		return passwordField;
//	}
//	
//	public WebElement getLoginButton() {
//		return loginButton;
//	}
//	
//	
//	// create opportunity 
////	WebElement co = driver.findElement(By.linkText("Opportunities"));
////	driver.findElement(By.cssSelector("img[alt='Create Opportunity...']")).click();
////	WebElement org = driver.findElement(By.name("potentialname"));
////	driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
//	
//	@FindBy(linkText = "Opportunities")
//	private WebElement opportunitiesBtn;
//	public WebElement getOpportunitiesBtn() {
//		return opportunitiesBtn;
//	}
//	
//	@FindBy(css = "img[alt='Create Opportunity...']")
//	private WebElement createOpportunityLookupImg;
//	public WebElement getCreateOpportunityLookupImg() {
//		return createOpportunityLookupImg;
//	}
//	
//	@FindBy(name = "potentialname")
//	private WebElement opportunityName;
//	public WebElement getOpportunityEdt() {
//		return opportunityName;
//	}
//	
//	@FindBy(css = "input[title='Save [Alt+S]']")
//	private WebElement saveBtn;
//	public WebElement getSaveBtn() {
//		return saveBtn;
//	}
//	
//	
//	//verification
//	//@FindBy(id = "dtlview_Organization Name")
//	// potentialname
//	@FindBy(name = "potentialname")
//	private WebElement contactHeaderInfo;
//	public WebElement getContactHeaderInfo() {
//		return contactHeaderInfo;
//	}
//	
//	
//	
//	
//	
//	// Logout Elements
//		@FindBy(css = "[src='themes/softed/images/user.PNG']")
//		private WebElement profileIcon;
//			
//		@FindBy(linkText = "Sign Out")
//		private WebElement signOutLink;
//			
//		public WebElement getProfileIcon() {
//			return profileIcon;
//		}
//
//		public WebElement getSignOutLink() {
//			return signOutLink;
//		}
//		
//	
	
}
