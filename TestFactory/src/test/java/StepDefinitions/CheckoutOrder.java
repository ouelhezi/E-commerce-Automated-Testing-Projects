package StepDefinitions;

import PageFactory.AddRemovePage;
import PageFactory.CheckoutPage;
import PageFactory.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;

public class CheckoutOrder {

    WebDriver driver;
    LoginPage loginPage;
    AddRemovePage addRemovePage;
    CheckoutPage checkoutPage;

    @Given("Je suis sur le site Swag Labs")
    public void je_suis_sur_le_site_swag_labs() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
        addRemovePage = new AddRemovePage(driver);
    }

    @When("Je tape le user_name")
    public void jeTapeLeUser_name() {
        loginPage.setUserName("standard_user");
    }

    @And("Je tape le mot_de_passe")
    public void jeTapeLeMot_de_passe() {
        loginPage.setPassword("secret_sauce");
    }

    @And("Je tape sur le bouton log_in")
    public void jeTapeSurLeBoutonLog_in() {
        loginPage.clickLoginButton();
    }

    @Then("redirection vers la page produits")
    public void redirectionVersLaPageProduits() throws InterruptedException {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Test passed ");
            Thread.sleep(2000);
        }else  {
            System.out.println("Test failed ");
        }
    }

    @When("Je clique sur le bouton Add_To_Cart de Sauce Labs Backpack")
    public void jeCliqueSurLeBoutonAdd_To_CartDeSauceLabsBackpack() {
        addRemovePage.clickBackpack();
    }

    @And("Je clique sur le bouton Add_To_Cart de Sauce Labs Bike Light")
    public void jeCliqueSurLeBoutonAdd_To_CartDeSauceLabsBikeLight() throws InterruptedException {
        Thread.sleep(2000);
        addRemovePage.clickBikeLight();
    }

    @And("Je clique sur l icone Panier")
    public void jeCliqueSurLIconePanier() throws InterruptedException {
        Thread.sleep(2000);
        addRemovePage.clickPanier();
    }

    @Then("les produits s ajoutent au Panier")
    public void lesProduitsSAjoutentAuPanier() {
        Assert.assertEquals(addRemovePage.getBagde(),"2");
    }

    @When("Je clique sur le bouton Remove de Sauce_Labs_Backpack")
    public void jeCliqueSurLeBoutonRemoveDeSauce_Labs_Backpack() throws InterruptedException {
        Thread.sleep(2000);
        addRemovePage.clickRemoveBikeLight();
    }

    @Then("Le produit est retiré du Panier")
    public void leProduitEstRetiréDuPanier() {
        Assert.assertEquals(addRemovePage.getBagde(),"1");
    }

    @When("Je clique sur le bouton checkout")
    public void jeCliqueSurLeBoutonCheckout() throws InterruptedException {
        checkoutPage.click_checkout_button();
        Thread.sleep(2000);
    }

    @And("Je tape le firstName")
    public void jeTapeLeFirstName() {
        checkoutPage.setFirstName("oumaima");
    }

    @And("Je tape le LastName")
    public void jeTapeLeLastName() {
        checkoutPage.setLastName("ouelhezi");
    }

    @And("Je tape le postalCode")
    public void jeTapeLePostalCode() throws InterruptedException {
        checkoutPage.setPostalCode("12345");
        Thread.sleep(2000);
    }

    @And("Je clique sur le bouton continue")
    public void jeCliqueSurLeBoutonContinue() throws InterruptedException {
        checkoutPage.click_continue_button();
        Thread.sleep(2000);
    }

    @Then("redirection vers la page checkout step two")
    public void redirectionVersLaPageCheckoutStepTwo() throws InterruptedException {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/checkout-step-two.html")) {
            System.out.println("redirection vers la page checkout step two");
            Thread.sleep(2000);
        }else  {
            System.out.println("Test failed ");
        }
    }

    @When("Je clique sur le bouton finish")
    public void jeCliqueSurLeBoutonFinish() throws InterruptedException {
        checkoutPage.click_finish_button();
        Thread.sleep(2000);
    }

    @Then("redirection vers la page checkout complete")
    public void redirectionVersLaPageCheckoutComplete() throws InterruptedException {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/checkout-complete.html")) {
            System.out.println("redirection vers la page checkout complete");
            Thread.sleep(2000);
        }else  {
            System.out.println("Test failed ");
        }
    }

    @When("Je clique sur le bouton back home")
    public void jeCliqueSurLeBoutonBackHome() throws InterruptedException {
        checkoutPage.click_backHome_button();
        Thread.sleep(2000);
    }

    @Then("redirection vers la page liste des produits")
    public void redirectionVersLaPageListeDesProduits() throws InterruptedException {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("redirection vers la page home");
            Thread.sleep(2000);
        }else  {
            System.out.println("Test failed ");
        }
    }
}
