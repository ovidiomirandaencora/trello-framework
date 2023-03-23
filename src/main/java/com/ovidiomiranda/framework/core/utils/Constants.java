package com.ovidiomiranda.framework.core.utils;

/**
 * This class contains all the parameters of the constants.
 *
 * @author Ovidio Miranda
 */
public enum Constants {
  EMPTY_STRING(""),
  TODAY_DATE("Today_Date");

  private String stringValue;

  /**
   * Create a new instance with String as parameter.
   *
   * @param stringValue string value.
   */
  Constants(final String stringValue) {
    this.stringValue = stringValue;
  }

  /**
   * Gets string value.
   *
   * @return actual value in enum.
   */
  public String getStringValue() {
    return stringValue;
  }
}
