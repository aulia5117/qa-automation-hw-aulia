import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
    @Test // Tag untuk running test script
    public void case_example() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement ele1 = driver.findElement(By.id("username"));
        WebElement ele2 = driver.findElement(By.className("button"));

        ele1.click();
        ele1.sendKeys("email.com");
        ele1.getText();

        ele2.isDisplayed();
        ele2.click();

        driver.findElement(By.xpath("/*contains")).isDisplayed();
        driver.findElement(By.cssSelector("#button")).isDisplayed();

        driver.close();
    }
}
