package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	WebDriver driver;
	String insertedName;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver =  driver;
	}

	@FindBy(how =How.XPATH, using = "//h5[contains(text(),'Add Contact')]") WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='account']") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']") WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='state']") WebElement STATE_REGION_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']") WebElement ZIP_POSTALCODE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='country']") WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']") WebElement SAVE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Contacts')]") WebElement CONTACTS_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[@id='summary']") WebElement SUMMARY_ON_PROFILE_ELEMENT;
	
	
	public void verifyAddContactPage() {
		
		waitForElement(driver, 10, ADD_CONTACT_HEADER_ELEMENT);
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), "Add Contact", "Add Contact Page not found !!");
	}
	
	public void insertFullName(String fullName) {
		insertedName = fullName + generateRandom(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}
	
	public void selectCompanyDropdown(String company) {		
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT, company);
	}
	
	public void insertEmail(String email) {
		String insertedEmail = generateRandom(999) + email;
		EMAIL_ELEMENT.sendKeys(insertedEmail);
	}
	
	public void insertPhone(String phone) {
		String insertedPhone = phone + generateRandom(9999);
		PHONE_ELEMENT.sendKeys(insertedPhone);
	}
	
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	
	public void insertStateRegion(String state) {
		STATE_REGION_ELEMENT.sendKeys(state);
	}
	
	public void insertZipPostalCode(String zip) {
		ZIP_POSTALCODE_ELEMENT.sendKeys(zip);
	}
	
	public void selectCountryDropdown(String country) {
		selectFromDropdown(COUNTRY_DROPDOWN_ELEMENT, country);
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}
	
	public void verifyContactsPage() {
		waitForElement(driver, 10, CONTACTS_HEADER_ELEMENT);
		Assert.assertEquals(CONTACTS_HEADER_ELEMENT.getText(), "Contacts", "Wrong Page !!");
	}
	
	public void verifyProfilePage() {
		waitForElement(driver, 5, SUMMARY_ON_PROFILE_ELEMENT);
		Assert.assertEquals(SUMMARY_ON_PROFILE_ELEMENT.getText(), "Summary", "Wrong Page !!");
	}
	
	//Code Breakdown for Knowlwdge
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[2]/td[3]/following-sibling::td[4]/a[2]
	String beforeXpath = "//tbody/tr[";
	String afterXpath = "]/td[3]";
	String afterXpathDelete = "]/td[3]/following-sibling::td[4]/a[2]";
	
	public void verifyEnteredNameAndDelete() {
		for (int i = 1; i < 10; i++) {
			String name = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			if(name.contains(insertedName)) {
				System.out.println("Inserted Name Exists");
				driver.findElement(By.xpath(beforeXpath + i + afterXpathDelete)).click();
				driver.switchTo().alert().accept();
			}
		}
	}
	
}
