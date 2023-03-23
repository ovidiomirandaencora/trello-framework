package com.ovidiomiranda.framework.core.ui.driver;

import com.ovidiomiranda.framework.core.ui.browser.Browser;
import com.ovidiomiranda.framework.core.ui.browser.Chrome;
import com.ovidiomiranda.framework.core.ui.browser.ChromeHeadless;
import com.ovidiomiranda.framework.core.ui.browser.Firefox;
import java.util.EnumMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

/**
 * Class created in order to recognize the Driver type.
 *
 * @author Ovidio Miranda
 */
public final class DriverFactory {

  /**
   * Private Constructor for the DriverFactory utility class.
   */
  private DriverFactory() {
  }

  /**
   * Return the WebDriver instance specified by the environment properties.
   *
   * @param driverType Enum value specified from DriverType.
   * @return a WebDriver instance.
   */
  public static WebDriver getDriverManager(final DriverType driverType) {
    Map<DriverType, Browser> map = new EnumMap<>(DriverType.class);
    map.put(DriverType.CHROME, new Chrome());
    map.put(DriverType.CHROME_HEADLESS, new ChromeHeadless());
    map.put(DriverType.FIREFOX, new Firefox());
    return map.get(driverType).getBrowser();
  }
}
