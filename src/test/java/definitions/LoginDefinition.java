package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginDefinition {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\janak\\Documents\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Given("User is on Home page")
    public void userIsOnHomePage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("User enters username as {string}")
    public void userEntersUsernameAs(String userName) {
        driver.findElement(By.name("txtUsername")).sendKeys(userName);
    }

    @And("User enters password as {string}")
    public void userEntersPasswordAs(String password) {
        driver.findElement(By.name("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).submit();
    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
        String loginPageText = driver.findElement(By.id("welcome")).getText();
        Assert.assertTrue(loginPageText.contains("Welcome"));
//        Assert.assertTrue(true);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
