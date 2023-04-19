package com.ovidiomiranda.framework.core.utils;

import static com.ovidiomiranda.framework.core.utils.Constants.TODAY_DATE;
import static com.ovidiomiranda.framework.core.utils.DateUtils.getCurrentDateWithIso8601Format;

/**
 * Utility functions to get string for different cases.
 *
 * @author Ovidio Miranda
 */
public final class StringUtils {

  /**
   * Default Private Constructor.
   */
  private StringUtils() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  /**
   * Deletes the last character of a given string.
   *
   * @param value the string value.
   * @return the new string.
   */
  public static String deleteLastCharacter(final String value) {
    return value.substring(0, value.length() - 1);
  }

  /**
   * Replaces 'Today_Date' by the current date. For example: 2022-02-21.
   *
   * @param value is a string that contains(Today_Date).
   * @return string updated with the current date.
   */
  public static String replaceTodayDate(final String value) {
    if (value.contains(TODAY_DATE.getStringValue())) {
      return value.replace(TODAY_DATE.getStringValue(), getCurrentDateWithIso8601Format());
    } else {
      return value;
    }
  }
}
