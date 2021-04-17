package com.test.automation.page;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticePage {

  private final WebDriver driver;
  private final WebDriverWait wait;

  public AutomationPracticePage(final WebDriver webDriver) {
    this.driver = webDriver;
    this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
  }

  public void openAutomationPracticePage(String siteURL) {
    driver.get(siteURL);
  }

  public void visitSummerDresses() {
    // click on dresses
    driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]")).click();

    // click on summer dresses link
    wait
        .until(presenceOfElementLocated(By.linkText("Summer Dresses"))).click();
    wait.until(presenceOfElementLocated(By.id("center_column")));
  }

  public void addDressToCart(final int dressLocationOnPage) {
    // find dress at location and add to cart
    WebElement dress = driver
        .findElement(
            By.xpath(String.format("//div[@id='center_column']/ul/li[%d]", dressLocationOnPage)));
    Actions dressAction = new Actions(driver);
    dressAction.moveToElement(dress).build().perform();
    wait.until(presenceOfElementLocated(By.linkText("Add to cart"))).click();
    // wait for cart popup show up
    wait.until(presenceOfElementLocated(
        By.xpath("//div[@id='layer_cart'][contains(@style,'display: block')]")));
  }

  public void continueShopping() {
    // continue shopping
    driver
        .findElement(By.xpath("//span[@title='Continue shopping']")).click();
    // wait for cart popup to close
    wait.until(presenceOfElementLocated(
        By.xpath("//div[@id='layer_cart'][contains(@style,'display: none')]")));
  }


  public int getCartQuantity() {
    // verify quantity in cart
    WebElement cartQuantity = driver.findElement(By.className("ajax_cart_quantity"));
    return parseInt(cartQuantity.getText());
  }

  public void moveToSignInSection() {
    // proceed to sign in section
    driver.findElement(By.linkText("Sign in")).click();
    wait.until(presenceOfElementLocated(By.id("SubmitLogin")));
  }

  public void closeBrowser() {
    driver.quit();
  }
}
