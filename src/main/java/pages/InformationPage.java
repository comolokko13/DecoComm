package pages;

import common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import model.Customer;

public class InformationPage extends AbstractComponent {

    public InformationPage(WebDriver driver){ super(driver); }

    @FindBy(xpath = "//input[@id='checkout_email']")
    private WebElement userEmailTextBox;

    @FindBy(xpath = "//select[@id='checkout_shipping_address_country']")
    private WebElement userCountrySelectBox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_first_name']")
    private WebElement userFirstNameTextBox ;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_last_name']")
    private WebElement userLastNameTextBox ;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_company']")
    private WebElement userCompanyTextBox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_address1']")
    private WebElement userAddressFirstTextBox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_address2']")
    private WebElement userAddressSecondTextBox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_city']")
    private WebElement userCityTextBox;

    @FindBy(xpath = "//select[@id='checkout_shipping_address_province']")
    private WebElement userStateSelectBox;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_zip']")
    private WebElement userZipCodeTextBox ;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_phone']")
    private WebElement userPhoneTextBox ;

    @FindBy(xpath = "//button[@id='continue_button']")
    private WebElement continueToShippingPageButton;

    public void getSelectCountry(String countrySelect){
        Select selectCountry = new Select(userCountrySelectBox);
        selectCountry.selectByVisibleText(countrySelect);
    }

    public void getSelectState(String stateSelect){
        Select selectState = new Select(userStateSelectBox);
        selectState.selectByVisibleText(stateSelect);
    }

    public void fillLoginDetails(Customer customer) {
        userEmailTextBox.sendKeys(customer.getEmail());
        userFirstNameTextBox.sendKeys(customer.getFirstName());
        userLastNameTextBox.sendKeys(customer.getLastName());
        userCompanyTextBox.sendKeys(customer.getCompany());
        userAddressFirstTextBox.sendKeys(customer.getAddress1());
        userAddressSecondTextBox.sendKeys(customer.getAddress2());
        userCityTextBox.sendKeys(customer.getCity());
        userZipCodeTextBox.sendKeys(customer.getZipCode());
        userPhoneTextBox.sendKeys(customer.getPhone());
    }

    public void clickContinueToShippingPage(){
        continueToShippingPageButton.click();
    }

}
