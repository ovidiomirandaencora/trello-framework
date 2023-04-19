package com.ovidiomiranda.framework.core.utils;

/**
 * This class contains all the strings that will be used in ERROR messages.
 *
 * @author Ovidio Miranda
 */
public final class Messages {

  /**
   * Default Private Constructor.
   */
  private Messages() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  /**
   * Displays the message : "Expected is:{Expect} But Actual is :{actual}".
   */
  public static final String VALUES_ARE_NOT_EQUAL = "Expected is: '%s' But Actual is : '%s'";
}
