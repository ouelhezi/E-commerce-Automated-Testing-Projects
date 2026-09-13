package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(id="checkout")
    WebElement checkout;
    @FindBy(id="first-name")
    WebElement firstName;
    @FindBy(id="last-name")
    WebElement lastName;
    @FindBy(id="postal-code")
    WebElement postalCode;
    @FindBy(id="continue")
    WebElement continueButton;
    @FindBy(id="finish")
    WebElement finishButton;
    @FindBy(id="back-to-products")
    WebElement backHomeButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_checkout_button() {
        checkout.click();
    }
    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.sendKeys(postalCode);
    }

    public void click_continue_button() {
        continueButton.click();
    }

    public void click_finish_button() {
        finishButton.click();
    }

    public void click_backHome_button() {
        backHomeButton.click();
    }

}
