package com.ovidiomiranda.framework.hooks;

import static com.ovidiomiranda.framework.core.utils.ScenarioUtils.getPbiTitle;
import static java.lang.String.format;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class containing Common Hooks.
 *
 * @author Ovidio Miranda
 */
public class CommonHooks {

  private static final Logger LOGGER = LogManager.getLogger(CommonHooks.class);

  /**
   * Initializes a new instance of the CommonHooks class.
   */
  public CommonHooks() {
  }

  /**
   * Gets current Scenario name.
   *
   * <p>Order = 3 This runs in order 3, that means the values 0 to 2 run after this hook.
   *
   * @param scenario Current Scenario.
   */
  @Before(order = -1)
  public void getScenarioName(final Scenario scenario) {
    LOGGER.info(format("Scenario is starting --> %s", getPbiTitle(scenario)));
  }

  /**
   * Closes the web driver after the test execution.
   */
  @Before(value = "@Web")
  public void beforeWeb() {
    // DriverManager.getInstance().maximize();
  }

  /**
   * Closes the web driver after the test execution.
   */
  @After(value = "@Web")
  public void logoutWeb() {
    // // [OM] Logout.
    // MainNavbar mainNavbar = new MainNavbar();
    // mainNavbar.selectUserMenu("Logout");
    // // [OM] It is necessary to wait until the Logout is successful.
    // // Improve this section.
    // Pause.pause(10000);
    // DriverManager.getInstance().minimize();
  }

  /**
   * Get the status of a scenario execution.
   *
   * @param scenario instance that was executed.
   */
  @After
  public void afterScenario(Scenario scenario) {
    final String statusScenario = "Scenario finished --> %s: ".concat(getPbiTitle(scenario));
    switch (scenario.getStatus()) {
      case PASSED:
        LOGGER.info(format(statusScenario, "PASSED"));
        break;
      case FAILED:
        LOGGER.info(format(statusScenario, "FAILED"));
        break;
      default:
        break;
    }
  }
}
