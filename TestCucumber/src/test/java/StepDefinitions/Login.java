package StepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {
    WebDriver driver;
    @Given("Je suis sur le site e-commerce Swag Labs")
    public void jeSuisSurLeSiteECommerceSwagLabs() {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com");
    }
    @When("Je saisie le username")
    public void je_saisie_le_username() {
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.sendKeys("standard_user");
    }
    @When("Je saisie le password")
    public void je_saisie_le_password() {
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");
    }
    @When("Je clique sur le bouton login")
    public void je_clique_sur_le_bouton_login() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

    }
    @Then("Redirection vers la page produits")
    public void redirection_vers_la_page_produits() {
        String url_result = driver.getCurrentUrl();
        System.out.println(url_result);
        if (url_result.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Test passed ");
        }else  {
            System.out.println("Test failed ");
        }
    }


}
