package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver =  driver;
	}
	
	@FindBy(how =How.XPATH, using = "//h2[contains(text(), 'Dashboard ')]") WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how =How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how =How.XPATH, using = "//a[contains(text(),'Add Customer')]") WebElement ADD_CUSTOMER_MENU_ELEMENT;
	@FindBy(how =How.XPATH, using = "//a[contains(text(), 'List Customers')]") WebElement LIST_CUSTOMER_MENU_ELEMENT;
	
	public void verifyDashboardPage() {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard", "Dashboard Page not found !!");
	}
	
	public void clickCustomerMenuButton() {
		CUSTOMER_MENU_ELEMENT.click();
	}
	
	public void clickAddCustomerMenuButton() {
		ADD_CUSTOMER_MENU_ELEMENT.click();
	}
	
	public void clicklistCustomerMenuButton() {
		LIST_CUSTOMER_MENU_ELEMENT.click();
	}
		
}
