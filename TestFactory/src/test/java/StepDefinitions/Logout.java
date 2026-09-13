package StepDefinitions;

import PageFactory.LoginPage;
import PageFactory.LogoutPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Logout {

    WebDriver driver;
    LogoutPage logoutPage;
    LoginPage loginPage;

    @Given("Je suis sur le site Swag_Labs")
    public void je_suis_sur_le_site_swag_labs() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
    }


    @When("Je saisie username")
    public void jeSaisieUsername() throws InterruptedException {
        loginPage.setUserName("standard_user");
        Thread.sleep(2000);
    }

    @And("Je saisie password")
    public void jeSaisiePassword() {
        loginPage.setPassword("secret_sauce");
    }

    @And("Je clique sur login")
    public void jeCliqueSurLogin() throws InterruptedException {
        loginPage.clickLoginButton();
        Thread.sleep(2000);
    }

    @Then("Redirection vers la page listProduits")
    public void redirectionVersLaPageListProduits() {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Test passed ");
        }else  {
            System.out.println("Test failed ");
        }
    }

    @When("Je clique sur le bouton open menu")
    public void jeCliqueSurLeBoutonOpenMenu() throws InterruptedException {
        logoutPage.clickMenuButton();
        //Thread.sleep(2000);
    }

    @And("Je clique sur le bouton logout")
    public void jeCliqueSurLeBoutonLogout() throws InterruptedException {
        Thread.sleep(2000);
        logoutPage.clickLogoutButton();
        Thread.sleep(2000);
    }

    @Then("Redirection vers la page login")
    public void redirectionVersLaPageLogin() {
        String resultatAttendu = driver.getCurrentUrl();
        if (resultatAttendu.equals("https://www.saucedemo.com/")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

    }
}
