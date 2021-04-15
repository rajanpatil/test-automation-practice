package com.test.automation.page;

import static java.lang.Integer.parseInt;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticePage {

  private final WebDriver driver;
  private final WebDriverWait wait;

  public AutomationPracticePage(final WebDriver webDriver) {
    this.driver = webDriver;
    this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
  }

  public void openAutomationPracticePage() {
    driver.get("http://automationpractice.com/index.php");
  }

  public void visitSummerDresses() {
    // click on dresses
    driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]")).click();

    // click on summer dresses link
    wait
        .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Summer Dresses"))).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("center_column")));
  }

  public void addDressToCartAndContinueShopping(final int dressLoc) {
    // find first dress and add to cart
    WebElement dress = driver
        .findElement(By.xpath(String.format("//div[@id='center_column']/ul/li[%d]", dressLoc)));
    Actions dressAction = new Actions(driver);
    dressAction.moveToElement(dress).build().perform();
    driver.findElement(By.linkText("Add to cart")).click();
    // wait for cart popup
    wait.until(ExpectedConditions
        .presenceOfElementLocated(By.cssSelector("div[id='layer_cart'][style*='display: block']")));
    // continue shopping
    driver
        .findElement(By.xpath("//span[@title='Continue shopping']")).click();
  }

  public int getCartQuantity() {
    // verify quantity in cart
    WebElement cartQuantity = driver.findElement(By.className("ajax_cart_quantity"));
    return parseInt(cartQuantity.getText());
  }

  public void moveToSignInSection() {
    // proceed to sign in section
    driver.findElement(By.linkText("Sign in")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("SubmitLogin")));
  }
}