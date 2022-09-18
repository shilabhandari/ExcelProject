package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
		WebDriver driver;
		
		ExcelReader excelRead= new ExcelReader("testData\\Bank_Cash_NewAccount.xlsx");
		String username= excelRead.getCellData("LoginInfo", "Username", 2);
		String password= excelRead.getCellData("LoginInfo", "Password", 2);
	    String accountTitle= excelRead.getCellData("NewAccountInfo", "Account_Title", 2);
		String description= excelRead.getCellData("NewAccountInfo", "Description", 2);
		String initialBalance= excelRead.getCellData("NewAccountInfo", "Initial_Balance", 2);
		String accountNum= excelRead.getCellData("NewAccountInfo", "Account_Number", 2);
		String contactPerson= excelRead.getCellData("NewAccountInfo", "Contact_Person", 2);
		String phoneNum= excelRead.getCellData("NewAccountInfo", "Phone", 2);
		String bankURL= excelRead.getCellData("NewAccountInfo", "URL", 2);
		
		
		@Test
		public void validUserShouldAbleToCreateCustomer() throws InterruptedException, IOException {
			 
			driver = BrowserFactory.init();
			
			LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class);
			loginPage.insertUserName("username");
			loginPage.insertPassword("password");
			loginPage.clickSigninButton();
			
			DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPage.verifyDashboardPage();
			dashboardPage.clickCustomerMenuButton();
			dashboardPage.clickAddCustomerMenuButton();
			
			AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
			addCustomerPage.verifyAddContactPage();
			addCustomerPage.insertDescription(description);
			addCustomerPage.selectCompanyDropdown("");
			
		}

}
