package com.ovidiomiranda.framework.core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility functions to get time in different formats.
 *
 * @author Ovidio Miranda
 */
public final class DateUtils {

  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

  /**
   * Default Private Constructor.
   */
  private DateUtils() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  /**
   * Gets the ISO 8601 date format(yyyy-MM-dd). For example: 2022-02-21.
   *
   * @param date the date.
   * @return String with the current date.
   */
  public static String getDateWithIso8601Format(final Date date) {
    return convertDateToString(date, getDateFormat(DEFAULT_DATE_FORMAT));
  }

  /**
   * Gets the Current Date in ISO 8601 date format. For example: 2022-02-21.
   *
   * @return String with the current date.
   */
  public static String getCurrentDateWithIso8601Format() {
    return getDateWithIso8601Format(new Date());
  }

  /**
   * Gets the Date Format set given a string format.
   *
   * @return the date format.
   */
  private static DateFormat getDateFormat(final String dateFormat) {
    return new SimpleDateFormat(dateFormat);
  }

  /**
   * Converts a Date to String given a date format.
   *
   * @param date       the date.
   * @param dateFormat Date format instance to be return.
   * @return the formatted time string.
   */
  private static String convertDateToString(final Date date, final DateFormat dateFormat) {
    return dateFormat.format(date);
  }
}
