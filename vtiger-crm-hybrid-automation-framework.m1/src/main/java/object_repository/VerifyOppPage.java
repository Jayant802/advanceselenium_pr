package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOppPage {
		
	public VerifyOppPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "potentialname")
	private WebElement contactHeaderInfo;
	public WebElement getOppHeaderInfo() {
		return contactHeaderInfo;
	}
	
	
}
