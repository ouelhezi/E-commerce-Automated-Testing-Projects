package PracticePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AutoSuggest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        WebElement input = driver.findElement(By.id("autosuggest"));
        input.sendKeys("auto"); // chercher tous les element dans la page contenant le mot auto
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.tagName("li"));
        for (WebElement option : options) {
            if(option.getText().equals("Cypress Automation")){
                option.click();
                break;
            }
        }

    }
}
