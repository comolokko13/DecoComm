package pages;

import common.AbstractComponent;
import model.CreditCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends AbstractComponent {

    WebDriver driver;

    public PaymentPage(WebDriver driver)  { super(driver); }

    @FindBy(xpath = "//div[@data-card-fields='number']")
    private WebElement userCardNumber;

    @FindBy(xpath = "//div[@data-card-fields='name']")
    private WebElement userNameOnCard;

    @FindBy(xpath = "//div[@class='field--half field field--required'][1]")
    private WebElement userExpirationDate;

    @FindBy(xpath = "//div[@class='field--half field field--required'][2]")
    private WebElement userSecurityCode;

    @FindBy(xpath = "//button[@id='continue_button']")
    private WebElement payNowButton;

    public void getCreditCartPayment(CreditCart creditCart) {
        userCardNumber.sendKeys(creditCart.getCardNumber());
        userNameOnCard.sendKeys(creditCart.getNameOnCard());
        userExpirationDate.sendKeys(creditCart.getExpirationDate());
        userSecurityCode.sendKeys(creditCart.getSecurityCode());
    }

    public WebElement setClickPayNowButton(WebElement payNowButton){
        this.payNowButton=payNowButton;
        return payNowButton;
    }

    public void getClickPayNowButton(){
        payNowButton.click();
    }
}
