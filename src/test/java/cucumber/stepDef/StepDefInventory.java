package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefInventory {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User already on the inventory page")
    public void user_already_on_the_inventory_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

//        Click Login

        driver.findElement(By.id("login-button")).click();

    }

    @When("User choose an item")
    public void user_choose_an_item() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

    }

    @Then("The item entered to the cart")
    public void the_item_entered_to_the_cart() {
        String checker = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(checker,"Remove");

        driver.close();
    }

    @When("User already chosen an item")
    public void user_already_chosen_an_item() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @And("User remove the chosen item")
    public void user_remove_the_chosen_item() {
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
    }

    @Then("The item removed from the cart")
    public void the_item_removed_from_the_cart() {
        String checker = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(checker,"Add to cart");

        driver.close();
    }
}
