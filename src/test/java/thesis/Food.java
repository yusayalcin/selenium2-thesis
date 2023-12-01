package thesis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Food extends PageBase{    
    
    private final By pizzaOrderButton = By.xpath("/html/body/div/div/div[1]/div/center/a");
    private final By smallPizza = By.xpath("//*[@id='1-1']");
    private final By addPizzaToCart = By.xpath("//*[@id='submit_toppings']");


    
    private final By pastaOrderButton = By.xpath("/html/body/div/div/div[5]/div/center/a");
    private final By smallPasta = By.xpath("//*[@id='reg_pasta_card-3']/button");

    public Food(WebDriver driver) {
        super(driver);
    }

    public DashboardPage orderPizza() throws InterruptedException {
        this.waitVisibiiltyAndFindElement(pizzaOrderButton).click();
        this.waitVisibiiltyAndFindElement(smallPizza).click();
        this.waitVisibiiltyAndFindElement(addPizzaToCart).click();
        Thread.sleep(1500);
        return new DashboardPage(this.driver);
    }

    public DashboardPage orderPasta() throws InterruptedException {
        this.waitVisibiiltyAndFindElement(pastaOrderButton).click();
        this.waitVisibiiltyAndFindElement(smallPasta).click();
        Thread.sleep(1500);
        return new DashboardPage(this.driver);
    }
    
}
