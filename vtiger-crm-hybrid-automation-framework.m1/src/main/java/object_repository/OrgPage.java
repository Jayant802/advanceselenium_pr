package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	
	
	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[title='Create Organization...']")
	private WebElement createOrganizationLookupImg;
	public WebElement getCreateOrganizationLookupImg() {
		return createOrganizationLookupImg;
	}
	
	@FindBy(name = "accountname")
	private WebElement accountnameEdt;
	public WebElement getAccountNameEdt() {
		return accountnameEdt;
	}
	
	@FindBy(className = "save")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	
	
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
//	//organization Module Element 
////	driver.findElement(By.linkText("Organizations")).click();
////	driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
////	WebElement orgField = driver.findElement(By.name("accountname"));
////	driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
////	// Verification
////	String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
//	
//	@FindBy(linkText = "Organizations")
//	private WebElement organizationLink;
//	public WebElement getOrganizationLink() {
//		return organizationLink;
//	}
//	
//	
//	@FindBy(css = "[title='Create Organization...']")
//	private WebElement createOrganizationLookupImg;
//	public WebElement getCreateOrganizationLookupImg() {
//		return createOrganizationLookupImg;
//	}
//	
//	
//	@FindBy(name = "accountname")
//	private WebElement accountnameEdt;
//	public WebElement getAccountNameEdt() {
//		return accountnameEdt;
//	}
//	
//	@FindBy(className = "save")
//	private WebElement saveBtn;
//	public WebElement getSaveBtn() {
//		return saveBtn;
//	}
//	
//	
//	//verification
//	@FindBy(id = "dtlview_Organization Name")
//	private WebElement contactHeaderInfo;
//	public WebElement getContactHeaderInfo() {
//		return contactHeaderInfo;
//	}
//	
//	
//	
//	
//	// Logout Elements
//	@FindBy(css = "[src='themes/softed/images/user.PNG']")
//	private WebElement profileIcon;
//		
//	@FindBy(linkText = "Sign Out")
//	private WebElement signOutLink;
//		
//	public WebElement getProfileIcon() {
//		return profileIcon;
//	}
//
//	public WebElement getSignOutLink() {
//		return signOutLink;
//	}
	
}