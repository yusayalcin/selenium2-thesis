package thesis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    
    private final By emailInputBox = By.xpath("//*[@id='id_username']");
    private final By passwordInputBox = By.xpath("//*[@id='id_password']");
    private final By signIn = By.xpath("//*[@id='login-box']/div/div/div[2]/form/div[3]/button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage login(String email, String password) throws InterruptedException {
        this.waitVisibiiltyAndFindElement(emailInputBox).sendKeys(email);
        this.waitVisibiiltyAndFindElement(passwordInputBox).sendKeys(password);
        this.waitVisibiiltyAndFindElement(signIn).click();
        Thread.sleep(1500);
        return new DashboardPage(this.driver);
    }
}
