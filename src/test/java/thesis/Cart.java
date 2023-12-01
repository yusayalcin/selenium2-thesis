package thesis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends PageBase{

    private final By goToCartButton = By.xpath("//*[@id='cart_button']");


    public Cart(WebDriver driver) {
        super(driver);
    }

    public DashboardPage goToCart() throws InterruptedException {
        this.waitVisibiiltyAndFindElement(goToCartButton).click();
        Thread.sleep(1500);
        return new DashboardPage(this.driver);
    }
}
