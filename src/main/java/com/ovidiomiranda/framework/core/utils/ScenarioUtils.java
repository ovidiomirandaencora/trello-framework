package com.ovidiomiranda.framework.core.utils;

import static com.ovidiomiranda.framework.core.utils.Constants.EMPTY_STRING;
import static java.lang.String.format;

import io.cucumber.java.Scenario;

/**
 * All support functions related with scenario actions.
 *
 * @author Ovidio Miranda
 */
public final class ScenarioUtils {

  /**
   * Default Private Constructor.
   */
  private ScenarioUtils() {
    throw new UnsupportedOperationException("ScenarioUtils class and cannot be instantiated");
  }

  /**
   * Gets the current Scenario TC example TC-00003.
   *
   * @param scenario Current Scenario.
   * @return the TC id.
   */
  public static String getPbiId(final Scenario scenario) {
    final String pbiId = scenario.getSourceTagNames().stream().filter(tag -> tag.startsWith("@TC-"))
        .findFirst().orElse("Scenario without TC ID");
    return pbiId.replace("@", EMPTY_STRING.getStringValue());
  }

  /**
   * Gets the current Scenario id plus scenario title example: TC-00003 Scenario title.
   *
   * @param scenario represents the current scenario.
   * @return the TC id plus scenario title.
   */
  public static String getPbiTitle(final Scenario scenario) {
    final String pbiTitle = scenario.getName();
    return format("%s %s", getPbiId(scenario), pbiTitle);
  }
}
