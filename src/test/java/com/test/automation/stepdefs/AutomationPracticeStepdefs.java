package com.test.automation.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.test.automation.page.AutomationPracticePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPracticeStepdefs {

  private AutomationPracticePage automationPracticePage;

  @Before
  public void beforeScenario() {
    System.setProperty("webdriver.chrome.driver",
        getChromeDriverAbsolutePath());
    WebDriver driver = new ChromeDriver();
    automationPracticePage = new AutomationPracticePage(driver);
  }

  @After
  public void afterScenario() {
    automationPracticePage.closeBrowser();
  }

  @Given("open automation practice site")
  public void openAutomationPracticeSite() {
    automationPracticePage.openAutomationPracticePage();
  }

  @And("browse to summer dresses")
  public void browseToSummerDresses() {
    automationPracticePage.visitSummerDresses();
  }

  @When("Add summer dress from location {int} on page to cart")
  public void summerDressAddedToCartAndContinueShopping(int dressLocationOnPage) {
    automationPracticePage.addDressToCart(dressLocationOnPage);
  }

  @And("Continue shopping")
  public void continueShopping() {
    automationPracticePage.continueShopping();
  }

  @Then("cart has {int} dresses")
  public void cartHasDresses(int expectedQuantityInCart) {
    // verify quantity in cart
    assertEquals(expectedQuantityInCart, automationPracticePage.getCartQuantity());
  }

  @And("proceed to sign in section")
  public void proceedToSignInSection() {
    automationPracticePage.moveToSignInSection();
  }

  private static String getChromeDriverAbsolutePath() {
    File chromeDriverFile = new File("./driver/chrome_89/chromedriver");
    return chromeDriverFile.getAbsolutePath();
  }
}
