package thesis;

import org.openqa.selenium.*;

public class MainPage extends PageBase {
    private final By locationButton = By.xpath("//*[@id='navbarText']/ul/li[2]/a");
    private final By mainButton = By.xpath("//*[@id='topNav']/a");
    private final By goToCartButton = By.xpath("//*[@id='cart_button']");
    private final By deleteFood = By.xpath("//*[@id='cart_body']/tr/td[3]");
    private final By checkOutButton = By.xpath("//*[@id='checkout_button']");

    

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("http://127.0.0.1:8000/login");
    }

    public void locationPage() {
        try {
            this.waitVisibiiltyAndFindElement(locationButton).click();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public void mainPageReturn() {
        try {
            this.waitVisibiiltyAndFindElement(mainButton).click();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public Food openFood() {
        return new Food(this.driver);
    }

    public void goToCart() throws InterruptedException {
        try {
            this.waitVisibiiltyAndFindElement(goToCartButton).click();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public void delete() throws InterruptedException {
        try {
            this.waitVisibiiltyAndFindElement(deleteFood).click();
           // Thread.sleep(1500);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public void checkout() throws InterruptedException {
        try {
            this.waitVisibiiltyAndFindElement(checkOutButton).click();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }



   /*  public void signOut() {
        try {
            this.waitVisibiiltyAndFindElement(signoutButton).click();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }*/
}
