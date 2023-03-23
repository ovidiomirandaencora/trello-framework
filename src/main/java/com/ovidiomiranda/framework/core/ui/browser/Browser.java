package com.ovidiomiranda.framework.core.ui.browser;

import org.openqa.selenium.WebDriver;

/**
 * Interface browser.
 *
 * @author Ovidio Miranda
 */
public interface Browser {

  /**
   * This method return a Web Driver instance of a specified browser.
   *
   * @return the Web Driver instance.
   */
  WebDriver getBrowser();
}
