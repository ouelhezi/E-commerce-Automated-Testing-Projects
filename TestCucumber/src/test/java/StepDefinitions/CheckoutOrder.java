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

import static org.junit.Assert.assertEquals;

public class CheckoutOrder {

    WebDriver driver;

    @Given("Je suis sur le site Swag Labs")
    public void je_suis_sur_le_site_swag_labs() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @When("Je tape le user_name")
    public void jeTapeLeUser_name() {
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.sendKeys("standard_user");
    }

    @And("Je tape le mot_de_passe")
    public void jeTapeLeMot_de_passe() {
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");
    }

    @And("Je tape sur le bouton log_in")
    public void jeTapeSurLeBoutonLog_in() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
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
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("Je clique sur le bouton Add_To_Cart de Sauce Labs Bike Light")
    public void jeCliqueSurLeBoutonAdd_To_CartDeSauceLabsBikeLight() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @And("Je clique sur l icone Panier")
    public void jeCliqueSurLIconePanier() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("les produits s ajoutent au Panier")
    public void lesProduitsSAjoutentAuPanier() {
        WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
        System.out.println("valeur du Badge =" + badge.getText());
        assertEquals("2",badge.getText());
    }

    @When("Je clique sur le bouton Remove de Sauce_Labs_Backpack")
    public void jeCliqueSurLeBoutonRemoveDeSauce_Labs_Backpack() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
    }

    @Then("Le produit est retiré du Panier")
    public void leProduitEstRetiréDuPanier() {
        WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
        System.out.println("valeur du Badge =" + badge.getText());
        assertEquals("1",badge.getText());
    }

    @When("Je clique sur le bouton checkout")
    public void jeCliqueSurLeBoutonCheckout() throws InterruptedException {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        Thread.sleep(2000);
    }

    @And("Je tape le firstName")
    public void jeTapeLeFirstName() {
        WebElement  inputFirstName = driver.findElement(By.id("first-name"));
        inputFirstName.sendKeys("oumaima");
    }

    @And("Je tape le LastName")
    public void jeTapeLeLastName() {
        WebElement inputLastName = driver.findElement(By.id("last-name"));
        inputLastName.sendKeys("ouelhezi");
    }

    @And("Je tape le postalCode")
    public void jeTapeLePostalCode() throws InterruptedException {
        WebElement inputPostalCode = driver.findElement(By.id("postal-code"));
        inputPostalCode.sendKeys("12345");
        Thread.sleep(2000);
    }

    @And("Je clique sur le bouton continue")
    public void jeCliqueSurLeBoutonContinue() throws InterruptedException {
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
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
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
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
        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
        backHomeButton.click();
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
