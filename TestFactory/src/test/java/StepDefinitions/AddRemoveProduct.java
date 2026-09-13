package StepDefinitions;

import PageFactory.AddRemovePage;
import PageFactory.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddRemoveProduct {
    WebDriver driver;
    LoginPage loginPage;
    AddRemovePage  addRemovePage;

    @Given("Je suis sur le site ecommerce Swag Labs")
    public void jeSuisSurLeSiteEcommerceSwagLabs() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
        addRemovePage = new AddRemovePage(driver);
    }

    @When("Je tape le username")
    public void jeTapeLeUsername() {
        loginPage.setUserName("standard_user");
    }

    @And("Je tape le mot de passe")
    public void jeTapeLeMotDePasse() {
        loginPage.setPassword("secret_sauce");
    }

    @And("Je tape sur le bouton login")
    public void jeTapeSurLeBoutonLogin() {
        loginPage.clickLoginButton();
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
        addRemovePage.clickBackpack();
    }

    @And("Je clique sur le bouton Add To Cart de Sauce Labs Bike Light")
    public void jeCliqueSurLeBoutonAddToCartDeSauceLabsBikeLight() throws InterruptedException {
        Thread.sleep(2000);
        addRemovePage.clickBikeLight();
    }

    @And("Je clique sur l icone du panier")
    public void jeCliqueSurLIconeDuPanier() throws InterruptedException {
        Thread.sleep(2000);
        addRemovePage.clickPanier();
    }

    @Then("les produits s ajoutent au panier")
    public void lesProduitsSAjoutentAuPanier() {
        Assert.assertEquals(addRemovePage.getBagde(),'2');
    }

    @When("Je clique sur le bouton Remove de Sauce Labs Backpack")
    public void jeCliqueSurLeBoutonRemoveDeSauceLabsBackpack() throws InterruptedException {
        Thread.sleep(2000);
        addRemovePage.clickRemoveBikeLight();
    }

    @Then("Le produit est retiré du panier")
    public void leProduitEstRetiréDuPanier() {
        Assert.assertEquals(addRemovePage.getBagde(),'1');
    }


}
