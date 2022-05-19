package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage_PF {
	
	@FindBy(xpath = "//*[@id=\"header-container\"]/header/div[3]/div[1]/div/nav/ul/li[1]/a[text()=\"Personal\"]")
	WebElement elm_PersonalHeaderNav;
	
	@FindBy(xpath = "//*[@id=\"header-container\"]/header/div[3]/div[1]/div/nav/ul/li[1]/ul/li[5]/a/span[text()=\"Home loans\"]")
	WebElement elm_HomeloansPrimaryNav;
	
	@FindBy(xpath = "//*[@id=\"header-container\"]/header/div[3]/div[1]/div/nav/ul/li[1]/ul/li[5]/div/ul/li[1]/a/span[text()=\"Home loans\"]")
	WebElement elm_HomeloansSecondaryNav;
	
	WebDriver driver;
	
	public	NavigationPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPersonalHeaderNav() {
		elm_PersonalHeaderNav.click();		
	}
	
	public void clickHomeloansPrimaryNav() {
		elm_HomeloansPrimaryNav.click();		
	}
	
	public void clickHomeloansSecondaryNav() {
		elm_HomeloansSecondaryNav.click();		
	}
	
}
