package pageFactory;

//import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomeLoansPage_PF {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"wrapper\"]/div/div/div[4]/div/div/div[2]/div/div[1]/div/section/div[2]/div[3]/div/ul/li[2]/a/span[text()=\"Request a call back\"]")
	WebElement btn_RequestACallback;
	
	@FindBy(xpath="//*[@id=\"wrapper\"]/div/div/section/div[2]/div[2]/div/div[4]/div/div[2]/div/div[1]/div[2]/div/p[2]/a[text()=\"Call me back\"]")
	WebElement btn_IneedhelpCallmeback;
	
	public HomeLoansPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRequestACallback() {
		btn_RequestACallback.click();		
	}
	
	public void clickIneedhelpCallmeback() {
		btn_IneedhelpCallmeback.click();		
	}
		
}
