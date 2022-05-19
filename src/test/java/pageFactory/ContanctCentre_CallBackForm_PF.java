package pageFactory;

//import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContanctCentre_CallBackForm_PF {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"field-page-Page1-isExisting\"]/label[1]/span")
	WebElement btn_ExistingCustomerYES;
	
	@FindBy(xpath="//*[@id=\"field-page-Page1-isExisting\"]/label[2]/span")
	WebElement btn_ExistingCustomerNO;
	
	@FindBy(xpath="//*[@id=\"field-page-Page1-nabID\"]")
	WebElement edit_NABID;
	
	@FindBy(xpath="//*[@id=\"field-page-Page1-aboutYou-firstName\"]")
	WebElement edit_FirstName;
	
	@FindBy(xpath="//*[@id=\"field-page-Page1-aboutYou-lastName\"]")
	WebElement edit_LastName;

	@FindBy(xpath="//*[@id=\"field-page-Page1-aboutYou-phoneNumber\"]")
	WebElement edit_Phone;
	
	@FindBy(xpath="//*[@id=\"field-page-Page1-aboutYou-email\"]")
	WebElement edit_Email;
		
	@FindBy(xpath="//div[@id='page-Page1-aboutYou-state']/div/div/div/div")
	WebElement elm_StateDropdown;
	
	//constructor
	public ContanctCentre_CallBackForm_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public void clickExistingCustomerYES() {
		btn_ExistingCustomerYES.click();		
	}
	
	public void clickExistingCustomerNO() {
		btn_ExistingCustomerNO.click();		
	}
	
	public void enterNABID(int nabID) {
		edit_NABID.sendKeys(String.valueOf(nabID));		
	}
	
	public void enterFirstName(String firstname) {
		edit_FirstName.sendKeys(firstname);		
	}
	
	public void enterLastName(String lastname) {
		edit_LastName.sendKeys(lastname);		
	}
	
	public void enterPhone(int phone) {
		edit_Phone.sendKeys(String.valueOf(phone));		
	}
	
	public void enterEmail(String email) {
		edit_Email.sendKeys(email);		
	}
	
	public void clickStateDropdown() {
		elm_StateDropdown.click();		
	}
		
}
