import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test // Tag untuk running test script
    public void success_login_case() {
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

//        driver.wait(100);

//        Login Checked

        String checker = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText();
        Assert.assertEquals(checker,"Products");

        driver.close();

    }

    @Test
    public void failed_login_case() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);


//        Click Login

        driver.findElement(By.id("login-button")).click();

//        driver.wait(100);

//        Error Login

        String checker = driver.findElement(By.xpath("//html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(checker,"Epic sadface: Username is required");

        driver.close();

    }
}
