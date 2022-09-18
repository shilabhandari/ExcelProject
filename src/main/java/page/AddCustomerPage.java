package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class AddCustomerPage extends BasePage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")WebElement EMAIL_ELEMENT;
	
	public void verifyAddContactPage() {
		
		waitForElement(driver,5,ADD_CONTACT_HEADER_ELEMENT);
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), "Add contact", "Wrong page!!");
	}

	

	public void insertFullName(String fullName) {
        String insertedName = fullName + generatedRandom(999);
        FULL_NAME_ELEMENT.sendKeys(insertedName);
	}

	public void selectCompanyDropdown(String company) {
	  selectFromDropdown(COMPANY_ELEMENT,company);
		
	}

	public void selectFromDropdown(WebElement webElement, String visibleText) {
		Select sel = new Select( webElement);
		sel.selectByVisibleText(visibleText);
		
	}



	public void insertDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	
}
