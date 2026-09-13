package PracticePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HideShow {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.letskodeit.com/practice");

        WebElement input = driver.findElement(By.id("displayed-text"));
        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        WebElement showButton = driver.findElement(By.id("show-textbox"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", hideButton);

        // attendre que le bouton soit cliquable
        wait.until(ExpectedConditions.elementToBeClickable(hideButton)).click();

        // attendre que l'input disparaisse
        wait.until(ExpectedConditions.invisibilityOf(input));

        System.out.println("Input caché");

        showButton.click();

        wait.until(ExpectedConditions.visibilityOf(input));

        input.sendKeys("bonjour");
        System.out.println("Input affiché et texte saisi");

        //driver.quit();

        /*
        public class HideShow {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        WebElement input = driver.findElement(By.id("displayed-text"));
        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        WebElement showButton = driver.findElement(By.id("show-textbox"));
        // Descendre jusqu'au bouton Hide
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", hideButton);
        Thread.sleep(2000);
        // Cliquer sur le bouton Hide
        hideButton.click();
        Thread.sleep(2000);
        if(!input.isDisplayed()){
            showButton.click();
        }
        // Vérifier si le champ texte est visible
        if(input.isDisplayed()){
            input.sendKeys("Hello");
            System.out.println("Le champ est affiché et le texte est saisi");
        } else{
            System.out.println("Le champ est masqué");
        }
    }
}
         */
    }


}


