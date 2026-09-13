package StepDefinitions;

import PageFactory.LoginPage;
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
    LoginPage loginPage;

    @Given("Je suis sur le site e-commerce Swag Labs")
    public void je_suis_sur_le_site_e_commerce_swag_labs() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
    }
    @When("Je saisie le username")
    public void je_saisie_le_username() {
        loginPage.setUserName("standard_user");
    }
    @When("Je saisie le password")
    public void je_saisie_le_password() {
        loginPage.setPassword("secret_sauce");
    }
    @When("Je clique sur le bouton login")
    public void je_clique_sur_le_bouton_login() {
        loginPage.clickLoginButton();
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
