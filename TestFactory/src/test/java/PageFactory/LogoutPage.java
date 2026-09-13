package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    WebDriver driver;

    @FindBy(id="react-burger-menu-btn")
    WebElement menuButton;
    @FindBy(id="logout_sidebar_link")
    WebElement logoutButton;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void  clickMenuButton() {
        menuButton.click();
    }

    public void  clickLogoutButton() {
        logoutButton.click();
    }


}
