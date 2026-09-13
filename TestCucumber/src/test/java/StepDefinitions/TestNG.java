package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        System.out.println("start test");

    }

    @Test(timeOut = 3000)
    public void test1() {
        driver.get("https://www.google.com/");
        System.out.println("test 1");
    }

    @Test(timeOut = 3000)
    public void test2() {
        driver.get("https://www.saucedemo.com/");
        System.out.println("test 2");
    }

    @AfterTest
    public void test3() {
        System.out.println("finish test");
    }


}
