package test;

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
	
	//Reading from Excel file
	ExcelReader exlReader = new ExcelReader("testData\\TF_TestData.xlsx");
	String username = exlReader.getCellData("LoginInfo", "UserName", 2);
	String password = exlReader.getCellData("LoginInfo", "Password", 2);
	String fullName = exlReader.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlReader.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlReader.getCellData("AddContactInfo", "Email", 2);
	String phone = exlReader.getCellData("AddContactInfo", "Phone", 2);
	String address = exlReader.getCellData("AddContactInfo", "Address", 2);
	String city = exlReader.getCellData("AddContactInfo", "City", 2);
	String state = exlReader.getCellData("AddContactInfo", "State", 2);
	String zip = exlReader.getCellData("AddContactInfo", "Zip", 2);
	String country = exlReader.getCellData("AddContactInfo", "Country", 2);
	
	@Test
	public void validUserShouldBeAbleToCreateCustomer() {
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(username);
		login.insertPassword(password);
		login.clickSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertStateRegion(state);
		addCustomerPage.insertZipPostalCode(zip);
		addCustomerPage.selectCountryDropdown(country);
		addCustomerPage.clickSaveButton();
		addCustomerPage.verifyContactsPage();
		addCustomerPage.verifyProfilePage();
		dashboardPage.clicklistCustomerMenuButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
		
		
//		BrowserFactory.tearDown();
		
	}
	
}
