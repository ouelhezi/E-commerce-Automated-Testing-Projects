package PracticePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        WebElement dropdown = driver.findElement(By.id("carselect"));
        Select select = new Select(dropdown);
        // verifier que l'option selectionné par defaut est bien selectionné
        String selectedoption = select.getFirstSelectedOption().getText();
        if (selectedoption.equals("BMW")) {
            System.out.println("BMW is selected");
        }else{
            System.out.println("BMW is not selected, the selected option is: " + selectedoption);
        }
        select.selectByVisibleText("Benz");
        select.selectByValue("honda");
        select.selectByIndex(1);

    }
}
