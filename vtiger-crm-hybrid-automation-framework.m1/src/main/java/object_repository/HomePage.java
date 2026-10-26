
package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// ==========================================
	// INITIALIZATION
	// ==========================================

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ==========================================
	// DECLARATION (@FindBy)
	// ==========================================

	// Module Elements
	
	// contacts module 
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	public WebElement getContactsLink() {
		return contactsLink;
	}


	
	// organization module 
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	public WebElement getOrgLink() {
		return orgLink;
	}
	
	
	
	// Opportunities module 
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesBtn;
	public WebElement getOppLink() {
		return opportunitiesBtn;
	}

	// Logout Elements
	@FindBy(css = "[src='themes/softed/images/user.PNG']")
	private WebElement profileIcon;
	public WebElement getProfileIcon() {
		return profileIcon;
	}

	

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	
	// during listener topic add this methods 
	public void logout() {
		profileIcon.click();
		signOutLink.click();
	}
	
}