package Steps;

import Pages.HomepagePage;
import Pages.LogInPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class StepDefinition {

    private static final Logger log = LoggerFactory.getLogger(StepDefinition.class);
    public static WebDriver driver;
    LogInPage logInPage;
    HomepagePage homepagePage;


    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        logInPage = new LogInPage();
        homepagePage = new HomepagePage();

    }

//----------------------------GIVEN

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to("https://www.saucedemo.com/");
    }


    @When("user inputs valid username")
    public void userInputsValidUsername() {
        logInPage.inputUsername("standard_user");

    }


    @And("user inputs valid password")
    public void userInputsValidPassword() {
        logInPage.inputPassword("secret_sauce");
    }


    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {

        logInPage.clickOnLoginButton();

    }


    @Then("user is logged in")
    public void userIsLoggedIn() {
        Assert.assertTrue(homepagePage.cartButton.isDisplayed());

    }

    @And("redirected to homepage")
    public void redirectedToHomepage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

}
