package thesis;

import org.junit.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class MainTest {

    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    private DashboardPage login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashBoardPage = loginPage.login("admin", "admin123");
        return dashBoardPage;
    }

    @Test
    public void loginTest() throws InterruptedException {
        new MainPage(this.driver);

        DashboardPage dashBoardPage = login();

        Assert.assertTrue(dashBoardPage.getBodyText().contains("Pizza"));
    }

    @Test
    public void locationPage() throws InterruptedException {
       MainPage main = new MainPage(this.driver);

        DashboardPage dashBoardPage = login();
        main.locationPage();


        Assert.assertTrue(dashBoardPage.getBodyText().contains("Located"));
    }

    @Test
    public void returnToMainPage() throws InterruptedException {
       MainPage main = new MainPage(this.driver);

        DashboardPage dashBoardPage = login();
        main.locationPage();
        main.mainPageReturn();


        Assert.assertTrue(dashBoardPage.getBodyText().contains("Pizza"));
    }

    @Test
    public void ordering() throws InterruptedException {
       MainPage main = new MainPage(this.driver);

        DashboardPage dashBoardPage = login();


        Food food = main.openFood();
        food.orderPizza();

        main.goToCart();

        Assert.assertTrue(dashBoardPage.getBodyText().contains("450"));
    }

     @Test
    public void orderPasta() throws InterruptedException {
       MainPage main = new MainPage(this.driver);

        DashboardPage dashBoardPage = login();


        Food food = main.openFood();
        food.orderPasta();

        main.goToCart();

        Assert.assertTrue(dashBoardPage.getBodyText().contains("95"));
    }


    @Test
    public void deleteOrder() throws InterruptedException {
       MainPage main = new MainPage(this.driver);

        DashboardPage dashBoardPage = login();


        Food food = main.openFood();
        food.orderPizza();

        main.goToCart();
        main.delete();
        driver.switchTo().alert().accept();

        Assert.assertTrue(dashBoardPage.getBodyText().contains("0"));
    }

    @Test
    public void checkOutOrder() throws InterruptedException {
       MainPage main = new MainPage(this.driver);

        DashboardPage dashBoardPage = login();


        Food food = main.openFood();
        food.orderPizza();

        main.goToCart();
        main.checkout();

        Assert.assertTrue(dashBoardPage.getBodyText().contains("0"));
    }


    @Test
    public void openPastaWithoutAuth() throws InterruptedException {

       DashboardPage dashBoardPage = new DashboardPage(driver);

        this.driver.get("http://127.0.0.1:8000/Pasta");

        Assert.assertFalse(dashBoardPage.getBodyText().contains("Pasta"));
    }

    @Test
    public void openPizzaWithoutAuth() throws InterruptedException {

       DashboardPage dashBoardPage = new DashboardPage(driver);

        this.driver.get("http://127.0.0.1:8000/Pizza");

        Assert.assertTrue(dashBoardPage.getBodyText().contains("Login"));
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}