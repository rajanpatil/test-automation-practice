package com.test.automation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.test.automation.page.AutomationPracticePage;
import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AutomationPracticeTest {

  private WebDriver driver;
  private AutomationPracticePage automationPracticePage;

  private static String getChromeDriverAbsolutePath() {
    File chromeDriverFile = new File("./driver/chromedriver");
    return chromeDriverFile.getAbsolutePath();
  }

  @BeforeEach
  void beforeAll() {
    System.setProperty("webdriver.chrome.driver",
        getChromeDriverAbsolutePath());
    driver = new ChromeDriver();
    automationPracticePage = new AutomationPracticePage(driver);
  }

  @AfterEach
  void afterAll() {
    driver.quit();
  }

  @Disabled
  @DisplayName("Automation practice site")
  void testAutomationPracticeSite() throws InterruptedException {

    /* 
    Perform following actions:
    Go to http://automationpractice.com/index.php and using Java, write an automated test/s to 
    verify that summer dresses can be added to the cart and it’s possible to proceed to the 
    Sign in section
     */

    // Go to http://automationpractice.com/index.php
    automationPracticePage.openAutomationPracticePage("http://automationpractice.com/index.php");

    // add 2 summer dresses to cart
    automationPracticePage.visitSummerDresses();
    automationPracticePage.addDressToCart(1);
    automationPracticePage.continueShopping();
    automationPracticePage.addDressToCart(2);
    automationPracticePage.continueShopping();

    // verify quantity in cart
    assertEquals(2, automationPracticePage.getCartQuantity());

    // move to sign in section
    automationPracticePage.moveToSignInSection();
  }

}
