import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenChrome {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //EdgeDriver edge = new EdgeDriver();
        // agrandir la page google
        driver.manage().window().maximize();
        // ouvrir google
        driver.get("https://www.google.com");
        //ouvrir youtube
        driver.navigate().to("https://www.youtube.com");
        // retourner à la page precedente
        driver.navigate().back();
        Thread.sleep(2000);
        //avancer à la page suivante
        driver.navigate().forward();
        // recuperer la page html de la source
        String htmlcode = driver.getPageSource();
        System.out.println("code html "+htmlcode);
        // recuperer l'url de la page actuelle
        String url = driver.getCurrentUrl();
        System.out.println("url "+url);
        // actualiser la page
        driver.navigate().refresh();
        driver.quit();

    }
}
