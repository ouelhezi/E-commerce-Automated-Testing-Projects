package StepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddRemoveProduct {
    WebDriver driver;
    
    @Given("Je suis sur le site ecommerce Swag Labs")
    public void jeSuisSurLeSiteEcommerceSwagLabs() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @When("Je tape le username")
    public void jeTapeLeUsername() {
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.sendKeys("standard_user");
    }

    @And("Je tape le mot de passe")
    public void jeTapeLeMotDePasse() {
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");
    }

    @And("Je tape sur le bouton login")
    public void jeTapeSurLeBoutonLogin() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("redirection vers la page des produits")
    public void redirectionVersLaPageDesProduits() throws InterruptedException {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Test passed ");
            Thread.sleep(2000);
        }else  {
            System.out.println("Test failed ");
        }
    }

    @When("Je clique sur le bouton Add To Cart de Sauce Labs Backpack")
    public void jeCliqueSurLeBoutonAddToCartDeSauceLabsBackpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("Je clique sur le bouton Add To Cart de Sauce Labs Bike Light")
    public void jeCliqueSurLeBoutonAddToCartDeSauceLabsBikeLight() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @And("Je clique sur l icone du panier")
    public void jeCliqueSurLIconeDuPanier() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("les produits s ajoutent au panier")
    public void lesProduitsSAjoutentAuPanier() {
        WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
        System.out.println("valeur du Badge =" + badge.getText());
        assertEquals("2",badge.getText());
                /*
        List<WebElement> produits = driver.findElements(By.className("cart_item"));

        if (produits.size() == 2) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
            System.out.println("Nombre de produits : " + produits.size());
        }*/
    }

    @When("Je clique sur le bouton Remove de Sauce Labs Backpack")
    public void jeCliqueSurLeBoutonRemoveDeSauceLabsBackpack() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
    }

    @Then("Le produit est retiré du panier")
    public void leProduitEstRetiréDuPanier() {
        WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
        System.out.println("valeur du Badge =" + badge.getText());
        assertEquals("1",badge.getText());
    }


}
