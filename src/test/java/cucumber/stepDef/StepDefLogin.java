package cucumber.stepDef;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefLogin {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User already on the website's login form")
    public void user_already_on_the_website_s_login_form(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @When("User fill username field with correct username")
    public void user_fill_username_field_with_correct_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User fill password field with correct password")
    public void user_fill_password_field_with_correct_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User will be directed to Inventory page")
    public void user_will_be_directed_to_inventory_page() {
        String checker = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText();
        Assert.assertEquals(checker,"Products");
        driver.close();
    }

    @Then("User will be shown error message")
    public void user_will_be_shown_error_message() {
        String checker = driver.findElement(By.xpath("//html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(checker,"Epic sadface: Username is required");
        driver.close();
    }
}
