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

public class Background {
    WebDriver driver;

    @Given("je suis redirige vers le site swaglabs")
    public void je_suis_redirige_vers_le_site_swaglabs() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }


    @When("je saisis my username")
    public void jeSaisisMyUsername() {
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.sendKeys("standard_user");
    }

    @And("je saisis my password")
    public void jeSaisisMyPassword() {
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");
    }

    @And("je clique sur login button")
    public void jeCliqueSurLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("la page de produits s affiche")
    public void laPageDeProduitsSAffiche() {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Test passed ");
        }else  {
            System.out.println("Test failed ");
        }
    }

    @When("je clique sur le btn addtocard du pdt backpack")
    public void jeCliqueSurLeBtnAddtocardDuPdtBackpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("je clique sur le btn addtocard du pdt tshirt")
    public void jeCliqueSurLeBtnAddtocardDuPdtTshirt() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @Then("les pdts sont ajoutes au panier")
    public void lesPdtsSontAjoutesAuPanier() {
        WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
        System.out.println("valeur du Badge =" + badge.getText());
        assertEquals("2",badge.getText());
    }

    @When("je presse sur le bouton panier")
    public void jePresseSurLeBoutonPanier() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("je clique sur le bouton remove tshirt")
    public void jeCliqueSurLeBoutonRemoveTshirt() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
    }

    @Then("le produit tshirt est retire du panier")
    public void leProduitTshirtEstRetireDuPanier() {
        WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
        System.out.println("valeur du Badge =" + badge.getText());
        assertEquals("1",badge.getText());
    }

    @When("je clique sur le bouton panier")
    public void jeCliqueSurLeBoutonPanier() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("je clique sur le Checkout button")
    public void jeCliqueSurLeCheckoutButton() throws InterruptedException {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        Thread.sleep(2000);
    }

    @Then("la page your information s affiche")
    public void laPageYourInformationSAffiche() {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/checkout-step-one.html")) {
            System.out.println("Test passed ");
        }else  {
            System.out.println("Test failed ");
        }
    }

    @When("je saisis firstname")
    public void jeSaisisFirstname() {
        WebElement  inputFirstName = driver.findElement(By.id("first-name"));
        inputFirstName.sendKeys("oumaima");
    }

    @And("je saisis lastname")
    public void jeSaisisLastname() {
        WebElement inputLastName = driver.findElement(By.id("last-name"));
        inputLastName.sendKeys("ouelhezi");
    }

    @And("je tape le code postal")
    public void jeTapeLeCodePostal() throws InterruptedException {
        WebElement inputPostalCode = driver.findElement(By.id("postal-code"));
        inputPostalCode.sendKeys("12345");
        Thread.sleep(2000);
    }

    @And("je clique sur le Continue button")
    public void jeCliqueSurLeContinueButton() throws InterruptedException {
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        Thread.sleep(2000);
    }

    @Then("une page Overview s affiche")
    public void unePageOverviewSAffiche() throws InterruptedException {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/checkout-step-two.html")) {
            System.out.println("redirection vers la page checkout step two");
            Thread.sleep(2000);
        }else  {
            System.out.println("Test failed ");
        }
    }

    @When("je clique sur le Finish button")
    public void jeCliqueSurLeFinishButton() throws InterruptedException {
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
        Thread.sleep(2000);
    }

    @Then("la page Checkout complete s affichera")
    public void laPageCheckoutCompleteSAffichera() throws InterruptedException {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/checkout-complete.html")) {
            System.out.println("redirection vers la page checkout complete");
            Thread.sleep(2000);
        }else  {
            System.out.println("Test failed ");
        }
    }

    @When("je clique sur le Back home button")
    public void jeCliqueSurLeBackHomeButton() throws InterruptedException {
        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
        backHomeButton.click();
        Thread.sleep(2000);
    }

    @Then("Redirection vers home")
    public void redirectionVersHome() throws InterruptedException {
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
