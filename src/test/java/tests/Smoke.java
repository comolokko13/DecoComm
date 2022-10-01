package tests;

import java.util.concurrent.TimeUnit;
import common.AbstractComponent;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.CreditCart;
import model.Customer;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import org.openqa.selenium.WebDriver;

public class Smoke {

    WebDriver driver;
    WebDriverWait wait;

    /**
     * Set up browser settings and open the Web Page
     */
    @BeforeMethod
    public void setUp() throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
    }

    @Test
    public void shouldSuccessfullyPurchaseTheItem() throws InterruptedException{

        AbstractComponent abstractComponent = new AbstractComponent(driver);
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        InformationPage informationPage = new InformationPage(driver);
        ShippingPage shippingPage = new ShippingPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        homePage.goToMain_Url();
        homePage.closeJoinUsPopUpButton();
        homePage.closeSubscribePopUpButton();

        abstractComponent.implicitlyWait();
        abstractComponent.scrollDownPage();

        homePage.getSelectItem();
        productsPage.clickAddProductToCart();
        productsPage.clickViewProductToCart();
        cartPage.getGoToCheckoutPage();

        abstractComponent.implicitlyWait();
        informationPage.getLoginApplication(new Customer("rachelallison578@gmail.com",  "Harry", "Potter", "Amazon", "Test Street 12345", "East", "Atlanta",
                "30318","123456789"));
        informationPage.getSelectCountry("United States");
        informationPage.getSelectState("Georgia");

        abstractComponent.scrollDownPage();
        abstractComponent.implicitlyWait();
        informationPage.getContinueToShippingPage();

        abstractComponent.implicitlyWait();
        shippingPage.getContinueToPaymentPage();

//        paymentPage.getCreditCartPayment(new CreditCart("30318789456123", "Harry Potter", "0127", "123"));
//        abstractComponent.scrollDownPage();
//        paymentPage.getClickPayNowButton;
    }

    @AfterMethod
    public void tearDown()  {
        driver.quit();
    }
}
