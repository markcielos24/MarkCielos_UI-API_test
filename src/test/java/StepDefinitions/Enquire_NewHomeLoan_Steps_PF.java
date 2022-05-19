package StepsDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import javax.imageio.ImageIO;

//import javax.swing.JOptionPane;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageFactory.NavigationPage_PF;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import pageFactory.ContanctCentre_CallBackForm_PF;
import pageFactory.HomeLoansPage_PF;

public class Enquire_NewHomeLoan_Steps_PF {

    WebDriver driver = null;
    NavigationPage_PF navigationpage;
    HomeLoansPage_PF homeloanspage;
    ContanctCentre_CallBackForm_PF contanctcentre_callbackform;
    String projectpath;

    JavascriptExecutor js;

    @Given("browser is open")
    public void browser_is_open() {

        projectpath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectpath+"/src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();

    }
    @And("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://www.nab.com.au/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @When("user go to Home loans")
    public void user_go_to_Home_loans() throws InterruptedException {

        navigationpage = new NavigationPage_PF(driver);

        navigationpage.clickPersonalHeaderNav();
        Thread.sleep(1000);
        navigationpage.clickHomeloansPrimaryNav();
        Thread.sleep(1000);
        navigationpage.clickHomeloansSecondaryNav();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @And("user click Request a call back")
    public void user_click_Request_a_call_back() throws InterruptedException {

        homeloanspage = new HomeLoansPage_PF(driver);

        homeloanspage.clickRequestACallback();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @And("user click I need help call me back")
    public void user_click_I_need_help_call_me_back() throws InterruptedException {

        homeloanspage.clickIneedhelpCallmeback();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        Thread.sleep(5000);
    }
    @And("user click New home loans and next button")
    public void user_click_New_home_loans_and_next_button() {

        js = (JavascriptExecutor)driver;

        String clickNewhomeloans = "document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#myRadioButtons-0 > label > span\").click()";
        js.executeScript(clickNewhomeloans);

        String clickWereToHelpNext = "document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#main-container > div > div.sc-ifAKCX.Col__StyledCol-o7bhp7-0.ibULtI > section > div.sc-bdVaJa.iAQrVS > button > div > span\").click()";
        js.executeScript(clickWereToHelpNext);

    }
    @And("^user select a loan (.*) and click next button$")
    public void user_select_a_loan_topic(String topic) throws InterruptedException {

        String currentHandle = driver.getWindowHandle();

        switch (topic) {
            case "Buying a new property":
                String clickBuyNewProperty = "document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#myRadioButtons-0 > label > span\").click()";
                js.executeScript(clickBuyNewProperty);
                break;
            case "Switching my loan to NAB":
                String clickSwitchLonToNAB = "document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#myRadioButtons-1 > label > span\").click()";
                js.executeScript(clickSwitchLonToNAB);
                break;
            case "First home loan deposit scheme":
                String clickFirstHomeLoanDepositScheme = "document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#myRadioButtons-2 > label > span\").click()";
                js.executeScript(clickFirstHomeLoanDepositScheme);
                break;
            case "Family home guarantee":
                String clickFamilyHomeGuarantee = "document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#myRadioButtons-3 > label > span\").click()";
                js.executeScript(clickFamilyHomeGuarantee);
                break;
        }
        String clickTopicNext = "document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#main-container > div > div.sc-ifAKCX.Col__StyledCol-o7bhp7-0.ibULtI > section > div.sc-bdVaJa.iAQrVS > button.Buttonstyle__StyledButton-sc-1vu4swu-3.cchfek > div > span\").click()";
        js.executeScript(clickTopicNext);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        Thread.sleep(5000);

        //Get all the handles currently available
        Set<String> handles = driver.getWindowHandles();

        if(handles.size() > 1) {
            Thread.sleep(1000);
//			JOptionPane.showMessageDialog(null, "no high demand", "no high demand", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("no high demand");
        }
        else {
            //high demand extra page
            System.out.println("high demand");
//			JOptionPane.showMessageDialog(null, "high demand", "high demand", JOptionPane.INFORMATION_MESSAGE);
            String clickIstillRequireFurtherAssistance = "document.querySelector(\"#contact-form-shadow-root\").shadowRoot.querySelector(\"#main-container > div > div > section > div.sc-bdVaJa.iAQrVS > button.Buttonstyle__StyledButton-sc-1vu4swu-3.cchfek > div > span\").click()";
            js.executeScript(clickIstillRequireFurtherAssistance);
            Thread.sleep(2000);
            handles = driver.getWindowHandles();
        }

        //Get all the handles currently available
//		Set<String> handles = driver.getWindowHandles();
        for(String actual: handles) {
            if(!actual.equalsIgnoreCase(currentHandle)) {
                //Switch to the opened tab
                driver.switchTo().window(actual);
                break;
//				//opening the URL saved.
//				driver.get(urlToClick);
            }
        }

    }
    @Then("^provide if existing customer (.*) and NAB ID (\\d+)$")
    public void provide_if_existing_customer_and_NAB_ID(String existingCustomer, int nabID) throws InterruptedException {

        contanctcentre_callbackform = new ContanctCentre_CallBackForm_PF(driver);

        if(existingCustomer.toUpperCase().contentEquals("YES")) {
            contanctcentre_callbackform.clickExistingCustomerYES();
            contanctcentre_callbackform.enterNABID(nabID);
        }
        else {
            contanctcentre_callbackform.clickExistingCustomerNO();
        }
        Thread.sleep(1000);

    }
    @And("^provide firstname (.*)$")
    public void provide_firstname(String firstname) throws InterruptedException {
        contanctcentre_callbackform.enterFirstName(firstname);
        Thread.sleep(1000);
    }
    @And("^provide lastname (.*)$")
    public void provide_lastname(String lastname) throws InterruptedException {
        contanctcentre_callbackform.enterLastName(lastname);
        Thread.sleep(1000);
    }
    @And("^provide phone (\\d+)$")
    public void provide_phone(int phone) throws InterruptedException {
        contanctcentre_callbackform.enterPhone(phone);
        Thread.sleep(1000);
    }
    @And("^provide email (.*)$")
    public void provide_email(String email) throws InterruptedException {
        contanctcentre_callbackform.enterEmail(email);
        Thread.sleep(1000);
    }
    @And("^provide state (.*)$")
    public void provide_state(String state) throws InterruptedException {

        contanctcentre_callbackform.clickStateDropdown();

        switch (state.toUpperCase()) {
            case "ACT":
                driver.findElement(By.xpath("//div[@id=\"react-select-3-option-0\"]")).click();
                break;
            case "NSW":
                driver.findElement(By.xpath("//div[@id=\"react-select-3-option-1\"]")).click();
                break;
            case "NT":
                driver.findElement(By.xpath("//div[@id=\"react-select-3-option-2\"]")).click();
                break;
            case "QLD":
                driver.findElement(By.xpath("//div[@id=\"react-select-3-option-3\"]")).click();
                break;
            case "SA":
                driver.findElement(By.xpath("//div[@id=\"react-select-3-option-4\"]")).click();
                break;
            case "TAS":
                driver.findElement(By.xpath("//div[@id=\"react-select-3-option-5\"]")).click();
                break;
            case "VIC":
                driver.findElement(By.xpath("//div[@id=\"react-select-3-option-6\"]")).click();
                break;
            case "WA":
                driver.findElement(By.xpath("//div[@id=\"react-select-3-option-7\"]")).click();
                break;
        }

        Thread.sleep(1000);

    }
    @And("user take screenshot and close browser")
    public void user_take_screenshot_and_close_browser() throws IOException {

        String fileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
        Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File(projectpath+"/src/test/resources/screenshots/" + fileName));

        driver.close();
        driver.quit();

    }

}
