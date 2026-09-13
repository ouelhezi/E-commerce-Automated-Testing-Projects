package PracticePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnableDisable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        WebElement input = driver.findElement(By.id("enabled-example-input"));
        if(input.isEnabled()) {
            System.out.println("Enabling");
            input.sendKeys("bonjour");
        }else  {
            System.out.println("champ desactivé");
        }
        WebElement enablebutton = driver.findElement(By.id("enabled-button"));

    }

    /*
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        WebElement input = driver.findElement(By.id("enabled-example-input"));
        // Vérifier si le champ est activé
        if(input.isEnabled()){
            System.out.println("Le champ est activé");
            input.sendKeys("Bonjour");
        } else{
            System.out.println("Le champ est désactivé");
        }
        // Cliquer sur le bouton Disable
        WebElement disableButton = driver.findElement(By.id("disabled-button"));
        disableButton.click();
        // Vérifier à nouveau si le champ est activé
        if(input.isEnabled()){
            System.out.println("Aprés clic sur disable le champ est toujours activé");

        } else{
            System.out.println("Aprés clic sur disable le champ est désactivé");
        }
        // Cliquer sur le bouton Enable
        WebElement enableButton = driver.findElement(By.id("enabled-button"));
        enableButton.click();
        // Vérifier à nouveau si le champ est activé
        if(input.isEnabled()){
            System.out.println("Aprés clic sur enable le champ est  activé de nouveau");
        }
        else{
            System.out.println("Le champ reste désactivé même aprés enable");
        }
    }
    *
    * */
}
