package pages;

import common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends AbstractComponent {

    public ProductsPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//button[@class='product-form__add-button button button--primary']")
    private WebElement addToCartButton;
    
    @FindBy(xpath = "//a[normalize-space()='View cart']")
    private WebElement viewCartButton;

    public void clickAddProductToCart() {
        addToCartButton.click();
    }

    public void clickViewProductToCart(){
        viewCartButton.click();
    }

}
