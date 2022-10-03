package pages;

import common.AbstractComponent;
import model.CreditCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends AbstractComponent {

    public PaymentPage(WebDriver driver)  { super(driver); }

    @FindBy(xpath = "//div[@data-card-fields='number']")
    private WebElement userCardNumberTextBox;

    @FindBy(xpath = "//div[@data-card-fields='name']")
    private WebElement userNameOnCardTextBox;

    @FindBy(xpath = "//div[@class='field--half field field--required'][1]")
    private WebElement userExpirationDateTextBox;

    @FindBy(xpath = "//div[@class='field--half field field--required'][2]")
    private WebElement userSecurityCodeTextBox;

    @FindBy(xpath = "//button[@id='continue_button']")
    private WebElement payNowButton;

    public void getCreditCartPayment(CreditCart creditCart) {
        userCardNumberTextBox.sendKeys(creditCart.getCardNumber());
        userNameOnCardTextBox.sendKeys(creditCart.getNameOnCard());
        userExpirationDateTextBox.sendKeys(creditCart.getExpirationDate());
        userSecurityCodeTextBox.sendKeys(creditCart.getSecurityCode());
    }

    public void clickPayNowButton(){
        payNowButton.click();
    }
}
