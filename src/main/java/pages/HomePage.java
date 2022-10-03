package pages;

import common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class HomePage extends AbstractComponent {

    WebDriver driver;

    private static final String MAIN_URL = "https://decohubhome.com/";

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "button[title='Close'][aria-label='Close']")
    private List<WebElement> joinUsPopUpList;

    @FindBy(xpath = "//button[@class='popup-newsletter__close link']")
    private List<WebElement> subscribePopUpList;

    @FindBy (xpath = "//div[@class='product-item product-item--vertical 1/4--lap 1/5--desk 1/6--wide is-selected']")
    private List<WebElement> livingRoomSets;

    private By joinUsPopUpButton = By.cssSelector("button[title='Close'][aria-label='Close']");
    private By subscribePopUpButton = By.xpath("//button[@class='popup-newsletter__close link']");

    public void goToMain_Url(){
        driver.get(MAIN_URL);
    }

    public void closeJoinUsPopUpButton() {
        waitForElementToAppear(joinUsPopUpButton);
        joinUsPopUpList.get(0).click();
    }

    public void closeSubscribePopUpButton() {
        waitForElementToAppear(subscribePopUpButton);
        subscribePopUpList.get(0).click();
    }

    public void getSelectItem(){
        int maxProducts = livingRoomSets.size();
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        livingRoomSets.get(randomProduct).click();
    }


}
