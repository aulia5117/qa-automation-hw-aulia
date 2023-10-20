import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Inventory {
    @Test
    public void add_inventory() {
            WebDriver driver;
            String baseUrl = "https://www.saucedemo.com/";

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);

//        Input Username & Password

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");

//        Click Login

            driver.findElement(By.id("login-button")).click();

//        Choose Item
//            String checker1 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).getText();
//            Assert.assertEquals(checker1,"Add to cart");
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

//        Assertion

            String checker2 = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).getText();
            Assert.assertEquals(checker2,"Remove");

            driver.close();
    }

    @Test
    public void remove_inventory() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

//        Input Username & Password

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

//        Click Login

        driver.findElement(By.id("login-button")).click();

//        Choose Item

        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

//        Remove Item

        String checker2 = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(checker2,"Remove");
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();

//        Assertion

        String checker = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(checker,"Add to cart");

//        driver.close();
    }

}
