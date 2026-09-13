package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemovePage {
    WebDriver driver;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement backpack;
    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;
    @FindBy(className = "shopping_cart_link")
    WebElement panier;
    @FindBy(className = "shopping_cart_badge")
    WebElement badge;
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBikeLight;


    public AddRemovePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBackpack(){
        backpack.click();
    }

    public void clickBikeLight(){
        bikeLight.click();
    }

    public void clickPanier(){
        panier.click();
    }

    public String getBagde(){
        return badge.getText();
    }

    public void clickRemoveBikeLight(){
        removeBikeLight.click();
    }




}
