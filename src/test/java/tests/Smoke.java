package tests;

import java.util.concurrent.TimeUnit;
import common.AbstractComponent;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.CreditCart;
import model.Customer;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import org.openqa.selenium.WebDriver;

public class Smoke {

    WebDriver driver;

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
        abstractComponent.scrollDownForLongPage();

        homePage.getSelectItem();
        abstractComponent.scrollDownForShortPage();
        productsPage.clickAddProductToCart();
        productsPage.clickViewProductToCart();
        cartPage.goToCheckoutPage();

        abstractComponent.implicitlyWait();
        informationPage.fillLoginDetails(new Customer("rachelallison578@gmail.com",  "Harry", "Potter", "Amazon", "Test Street 12345", "East", "Atlanta",
                "30318","123456789"));
        informationPage.getSelectCountry("United States");
        informationPage.getSelectState("Georgia");

        abstractComponent.scrollDownForLongPage();
        abstractComponent.implicitlyWait();
        informationPage.clickContinueToShippingPage();

        abstractComponent.implicitlyWait();
        shippingPage.clickContinueToPaymentPage();

//        paymentPage.getCreditCartPayment(new CreditCart("30318789456123", "Harry Potter", "0127", "123"));
//        abstractComponent.scrollDownForLongPage();
//        paymentPage.clickPayNowButton();
    }

    @AfterMethod
    public void tearDown()  {
        driver.quit();
    }
}
