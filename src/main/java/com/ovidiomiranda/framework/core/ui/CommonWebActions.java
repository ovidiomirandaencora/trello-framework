package com.ovidiomiranda.framework.core.ui;

import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import com.ovidiomiranda.framework.core.ui.driver.DriverManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class containing Common Web Actions.
 *
 * @author Ovidio Miranda
 */
public final class CommonWebActions {

  private static final Logger LOGGER = LogManager.getLogger(CommonWebActions.class);
  private static final WebDriverWait WEB_DRIVER_WAIT = DriverManager.getInstance()
      .getWebDriverWait();
  private static final WebDriver WEB_DRIVER = DriverManager.getInstance().getDriver();
  private static final JavascriptExecutor JAVASCRIPT_EXECUTOR = (JavascriptExecutor) WEB_DRIVER;

  /**
   * This is the constructor for the utility class.
   */
  private CommonWebActions() {
  }

  /**
   * Enters a value in the WebElement.
   *
   * @param element the WebElement.
   * @param text    the text value.
   */
  public static void enterTextField(final WebElement element, final String text) {
    waitVisibleOf(element);
    element.sendKeys(text);
    LOGGER.info(format("Text set: '%s' on locator: '%s' text field.", text,
        getLocatorFromWebElement(element)));
  }

  /**
   * Enters a value in the WebElement.
   *
   * @param element the WebElement.
   * @param text    the text value.
   */
  public static void enterTextFieldAndPressEnter(final WebElement element, final String text) {
    enterTextField(element, text);
    element.sendKeys(Keys.ENTER);
  }

  /**
   * Method for wait WebElement.
   *
   * @param webElement WebElement.
   * @return the element received in param.
   */
  public static WebElement waitVisibleOf(final WebElement webElement) {
    return WEB_DRIVER_WAIT.until(ExpectedConditions.visibilityOf(webElement));
  }

  /**
   * Method for wait WebElement.
   *
   * @param element WebElement.
   * @return the element received in param.
   */
  public static WebElement waitElementToBeClickable(final WebElement element) {
    return WEB_DRIVER_WAIT.until(elementToBeClickable(element));
  }

  /**
   * Method to get any element but wait until it is visible.
   *
   * @param element to wait for.
   * @return the element.
   */
  public static WebElement getElement(final WebElement element) {
    waitVisibleOf(element);
    return element;
  }

  /**
   * Method to click any element.
   *
   * @param element to click.
   */
  public static void clickElement(final WebElement element) {
    waitVisibleOf(element);
    waitElementToBeClickable(element);
    element.click();
    LOGGER.info(format("Click on locator: '%s' button.", getLocatorFromWebElement(element)));
  }

  /**
   * Clicks on the webElement using By option.
   *
   * @param by By value to locate the WebElement.
   */
  public static void clickElement(final By by) {
    clickElement(getWebElement(by));
  }

  /**
   * Gets Web element given by a locator.
   *
   * @param locator locator value to find an element.
   * @return the web element.
   */
  public static WebElement getWebElement(final By locator) {
    WEB_DRIVER_WAIT.until(ExpectedConditions.presenceOfElementLocated(locator));
    return WEB_DRIVER.findElement(locator);
  }

  /**
   * Method to JClick any element.
   *
   * @param element to click.
   */
  public static void jsClickElement(final WebElement element) {
    waitElementToBeClickable(element);
    jsExecutorScript(element);
  }

  /**
   * Method to JClick any element.
   *
   * @param element to click.
   */
  public static void jsExecutorScript(final WebElement element) {
    JAVASCRIPT_EXECUTOR.executeScript("arguments[0].click();", element);
  }

  /**
   * Sets CheckBox.
   *
   * @param element a checkbox element.
   * @param value   a boolean value.
   */
  public static void setCheckBox(final WebElement element, boolean value) {
    if (!element.isSelected() && value) {
      clickElement(element);
    }
    if (element.isSelected() && !value) {
      clickElement(element);
    }
  }

  /**
   * Clears the WebElement.
   *
   * @param element WebElement to wait and clear.
   */
  public static void clearTextField(final WebElement element) {
    element.clear();
  }

  /**
   * Selects an item from ListBox by its value.
   *
   * @param element ListBox WebElement.
   * @param value   value to select in the ListBox.
   */
  public static void selectDropdownByValue(final WebElement element, final String value) {
    Select dropdown = new Select(element);
    dropdown.selectByValue(value);
  }

  /**
   * Gets Locator from WebElement.
   *
   * @param element the WebElement.
   * @return the locator string.
   */
  private static String getLocatorFromWebElement(final WebElement element) {
    String result = "";
    String original = element.toString();
    System.out.println(original);
    // [OM] Extract all word inside apostrophes('').
    // Proxy element for: DefaultElementLocator 'By.cssSelector: button.btn-primary'
    Pattern pattern = Pattern.compile("'(.*?)'");
    Matcher matcher = pattern.matcher(original);
    if (matcher.find()) {
      result = matcher.group(1);
    }
    // [OM] If a value is not found within the apostrophes.
    if (result.length() == 0) {
      // )] -> css selector: #login]
      // )] -> id: user]
      // [OM] Start first '> ' and ends inside ']'.
      result = original.substring(original.indexOf(">") + 2, original.lastIndexOf("]"));
    }
    // Se puede crear un unit test.
    return result;
  }
}
