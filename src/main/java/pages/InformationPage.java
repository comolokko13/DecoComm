package pages;

import common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import model.Customer;

public class InformationPage extends AbstractComponent {

    WebDriver driver;
    Select selectState;
    Select selectCountry;
    WebDriverWait wait;

    public InformationPage(WebDriver driver){ super(driver); }

    @FindBy(xpath = "//input[@id='checkout_email']")
    private WebElement userEmail;

    @FindBy(xpath = "//select[@id='checkout_shipping_address_country']")
    private WebElement userCountry;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_first_name']")
    private WebElement userFirstName ;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_last_name']")
    private WebElement userLastName ;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_company']")
    private WebElement userCompany;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_address1']")
    private WebElement userAddress1;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_address2']")
    private WebElement userAddress2;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_city']")
    private WebElement userCity;

    @FindBy(xpath = "//select[@id='checkout_shipping_address_province']")
    private WebElement userState;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_zip']")
    private WebElement userZipCode ;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_phone']")
    private WebElement userPhone ;

    @FindBy(xpath = "//button[@id='continue_button']")
    private WebElement continueToShippingButton;

    public WebElement setContinueToShippingPage(WebElement continueToShippingButton){
        this.continueToShippingButton=continueToShippingButton;
        return continueToShippingButton;
    }

    public void getSelectCountry(String countrySelect){
        Select selectCountry = new Select(userCountry);
        selectCountry.selectByVisibleText(countrySelect);
    }

    public void getSelectState(String stateSelect){
        Select selectState = new Select(userState);
        selectState.selectByVisibleText(stateSelect);
    }

    public void getLoginApplication(Customer customer) {
        userEmail.sendKeys(customer.getEmail());
        userFirstName.sendKeys(customer.getFirstName());
        userLastName.sendKeys(customer.getLastName());
        userCompany.sendKeys(customer.getCompany());
        userAddress1.sendKeys(customer.getAddress1());
        userAddress2.sendKeys(customer.getAddress2());
        userCity.sendKeys(customer.getCity());
        userZipCode.sendKeys(customer.getZipCode());
        userPhone.sendKeys(customer.getPhone());
    }

    public void getContinueToShippingPage(){
        continueToShippingButton.click();
    }

}
