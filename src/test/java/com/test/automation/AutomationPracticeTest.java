package com.test.automation;

import static java.lang.Integer.valueOf;

import java.io.File;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class AutomationPracticeTest {

  private static WebDriver driver;
  private static WebDriverWait wait;

  @BeforeAll
  static void beforeAll() {
    System.setProperty("webdriver.chrome.driver",
        getChromeDriverAbsolutePath());
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  }

  @AfterAll
  static void afterAll() {
    driver.quit();
  }

  @Test
  @DisplayName("Automation practice site")
  void testAutomationPracticeSite() throws InterruptedException {

    /* 
    Perform following actions:
    Go to http://automationpractice.com/index.php and using Java, write an automated test/s to 
    verify that summer dresses can be added to the cart and it’s possible to proceed to the 
    Sign in section
     */
    
    // Go to http://automationpractice.com/index.php
    driver.get("http://automationpractice.com/index.php");

    // click on dresses
    driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]")).click();
    
    // click on summer dresses link
    wait
        .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Summer Dresses"))).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("center_column")));

    // find first dress and add to cart
    WebElement firstDress = driver.findElement(By.xpath("//div[@id='center_column']/ul/li[1]"));
    Actions moveOverFirstDress = new Actions(driver);
    moveOverFirstDress.moveToElement(firstDress).build().perform();
    driver.findElement(By.linkText("Add to cart")).click();
    
    // wait for cart popup
    wait.until(ExpectedConditions
        .presenceOfElementLocated(By.cssSelector("div[id='layer_cart'][style*='display: block']")));
    // continue shopping
    driver
        .findElement(By.xpath("//span[@title='Continue shopping']")).click();

    // find second dress and add to cart
    WebElement secondDress = driver.findElement(By.xpath("//div[@id='center_column']/ul/li[2]"));
    Actions moveOverSecondDress = new Actions(driver);
    moveOverSecondDress.moveToElement(secondDress).build().perform();
    driver.findElement(By.linkText("Add to cart")).click();
    
    // wait for cart popup
    wait.until(ExpectedConditions
        .presenceOfElementLocated(By.cssSelector("div[id='layer_cart'][style*='display: block']")));
    
    // continue shopping
    driver
        .findElement(By.xpath("//span[@title='Continue shopping']")).click();

    // verify quantity in cart
    WebElement cartQuantity = driver.findElement(By.className("ajax_cart_quantity"));
    Assertions.assertEquals(2, valueOf(cartQuantity.getText()));

    // proceed to sign in section
    driver.findElement(By.linkText("Sign in")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("SubmitLogin")));
  }

  private void wait(int seconds) throws InterruptedException {
    synchronized (wait) {
      wait.wait(seconds * 1000);
    }
  }

  private static String getChromeDriverAbsolutePath() {
    File chromeDriverFile = new File("./driver/chrome_89/chromedriver");
    return chromeDriverFile.getAbsolutePath();
  }

}
