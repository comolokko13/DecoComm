package pages;

import common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractComponent {

    public CartPage(WebDriver driver){ super(driver); }

    @FindBy (css = "button[name='checkout']")
    private WebElement checkoutButton;

    public void goToCheckoutPage(){
        checkoutButton.click();
    }
}
