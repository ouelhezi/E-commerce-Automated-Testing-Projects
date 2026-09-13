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

public class LoginOutline {

    WebDriver driver;

    @Given("Je suis sur le site SwagLabs")
    public void je_suis_sur_le_site_swag_labs() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @When("Je saisie le username {string}")
    public void jeSaisieLeUsername(String username) {
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.sendKeys(username);
    }

    @And("Je saisie le password {string}")
    public void jeSaisieLePassword(String password) {
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys(password);
    }

    @And("Je clique sur le bouton log in")
    public void jeCliqueSurLeBoutonLogIn() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("Echec de redirection vers la page Produits")
    public void echecDeRedirectionVersLaPageProduits() {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com")) {
            System.out.println("Test passed ");
        }else  {
            System.out.println("Test failed ");
        }
    }

    @And("Le message d erreur {string} s affiche")
    public void leMessageDErreurSAffiche(String message) {
        String messageError = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        assertEquals(message,messageError);
    }
}
