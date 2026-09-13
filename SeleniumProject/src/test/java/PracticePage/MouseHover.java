package PracticePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        WebElement mouseHoverBtn = driver.findElement(By.id("mousehover"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", mouseHoverBtn);
        //Thread.sleep(2000);
        // Créer l'objet Actions
        Actions actions = new Actions(driver);
        // Faire le survol de la souris
        actions.moveToElement(mouseHoverBtn).perform();
        // Cliquer sur "Top"
        WebElement top = driver.findElement(By.linkText("Top"));
        top.click();
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", mouseHoverBtn);
        WebElement reload = driver.findElement(By.xpath("//*[@id=\"mouse-hover-example-div\"]/div[1]/fieldset/div/div/a[2]"));
        actions.moveToElement(mouseHoverBtn).moveToElement(reload).click().perform();
        reload.click();

    }
}
