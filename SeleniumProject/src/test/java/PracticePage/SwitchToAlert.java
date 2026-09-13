package PracticePage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SwitchToAlert {
       public static void main(String[] args) throws InterruptedException {

            // Lancer Chrome
            WebDriver driver = new ChromeDriver();

            // Agrandir la fenêtre
            driver.manage().window().maximize();

            // Ouvrir la page
            driver.get("https://www.letskodeit.com/practice");

            // Localiser les éléments
            WebElement input = driver.findElement(By.id("name"));
            WebElement alertButton = driver.findElement(By.id("alertbtn"));
            WebElement confirmButton = driver.findElement(By.id("confirmbtn"));

            // Descendre jusqu'au bouton alert
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", alertButton);
            Thread.sleep(2000);

            /********************************************************
             * Cas 1 : Alert sans saisir de nom
             ********************************************************/

            // Cliquer sur le bouton Alert
            alertButton.click();

            // Basculer vers l'alert
            Alert alert = driver.switchTo().alert();

            // Afficher le texte de l'alert
            System.out.println("Alert Text : " + alert.getText());

            // Cliquer sur OK
            alert.accept();

            Thread.sleep(2000);

            /********************************************************
             * Cas 2 : Confirm sans saisir de nom
             ********************************************************/

            // Cliquer sur le bouton Confirm
            confirmButton.click();

            // Basculer vers la confirmation
            Alert confirm = driver.switchTo().alert();

            // Afficher le texte
            System.out.println("Confirm Text : " + confirm.getText());

            // Cliquer sur Cancel
            confirm.dismiss();

            Thread.sleep(3000);

            /********************************************************
             * Cas 3 : Alert avec le nom "Rami"
             ********************************************************/

            // Saisir le nom
            input.sendKeys("Rami");
            Thread.sleep(3000);

            // Cliquer sur Alert
            alertButton.click();

            // Basculer vers l'alert
            alert = driver.switchTo().alert();

            // Afficher le texte
            System.out.println("Alert with Name : " + alert.getText());

            // Cliquer sur OK
            alert.accept();

            Thread.sleep(3000);

            /********************************************************
             * Cas 4 : Confirm avec le nom "Rami"
             ********************************************************/

            // Cliquer sur Confirm
            confirmButton.click();

            // Basculer vers la confirmation
            confirm = driver.switchTo().alert();

            // Afficher le texte
            System.out.println("Confirm with Name : " + confirm.getText());

            // Cliquer sur OK
            confirm.accept();

            // Fermer le navigateur
            driver.quit();
    }
}
