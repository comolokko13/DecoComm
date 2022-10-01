package pages;

import common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends AbstractComponent {

    public ShippingPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//button[@id='continue_button']")
    private WebElement continueToPaymentPageButton;

    public WebElement setContinueToPaymentPage(WebElement continueToPaymentPageButton){
        this.continueToPaymentPageButton=continueToPaymentPageButton;
        return continueToPaymentPageButton;
    }

    public void getContinueToPaymentPage(){
        continueToPaymentPageButton.click();
    }
}
