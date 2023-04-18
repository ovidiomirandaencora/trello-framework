package com.ovidiomiranda.framework.core.ui;

import com.ovidiomiranda.framework.core.ui.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract Class BasePage implementing Page Object pattern.
 *
 * @author Ovidio Miranda
 */
public abstract class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;


  /**
   * Method for Base for declared DriverManager.
   */
  protected BasePage() {
    driver = DriverManager.getInstance().getDriver();
    wait = DriverManager.getInstance().getWebDriverWait();
    PageFactory.initElements(driver, this);
    waitUntilPageIsLoaded();
  }

  /**
   * Waits until page object is loaded.
   */
  public abstract void waitUntilPageIsLoaded();
}
