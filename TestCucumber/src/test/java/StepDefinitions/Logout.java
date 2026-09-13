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

public class Logout {

    WebDriver driver;

    @Given("Je suis sur le site Swag_Labs")
    public void je_suis_sur_le_site_swag_labs() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }


    @When("Je saisie username")
    public void jeSaisieUsername() throws InterruptedException {
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.sendKeys("standard_user");
        Thread.sleep(2000);
    }

    @And("Je saisie password")
    public void jeSaisiePassword() {
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");
    }

    @And("Je clique sur login")
    public void jeCliqueSurLogin() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
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
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        //Thread.sleep(2000);
    }

    @And("Je clique sur le bouton logout")
    public void jeCliqueSurLeBoutonLogout() throws InterruptedException {
        Thread.sleep(2000);
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
        Thread.sleep(2000);
    }

    @Then("Redirection vers la page login")
    public void redirectionVersLaPageLogin() {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com")) {
            System.out.println("Test passed ");
        }else  {
            System.out.println("Test failed ");
        }
    }
}
