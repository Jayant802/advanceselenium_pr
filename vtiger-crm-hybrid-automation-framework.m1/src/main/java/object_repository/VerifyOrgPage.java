package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOrgPage {
	
	public VerifyOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//verification
	@FindBy(id = "dtlview_Organization Name")
	private WebElement organizationHeaderInfo;
	public WebElement getOrgHeaderInfo() {
		return organizationHeaderInfo;
	}
	

	
}
