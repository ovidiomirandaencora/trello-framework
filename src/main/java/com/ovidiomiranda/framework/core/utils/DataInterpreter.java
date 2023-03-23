package com.ovidiomiranda.framework.core.utils;

import com.ovidiomiranda.framework.core.context.Context;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class containing Data Interpreter.
 */
public final class DataInterpreter {



  /**
   * Private constructor for the Data Builder utility class.
   */
  private DataInterpreter() {

  }

  /**
   * This method built an end point based in a string line parameter.
   *
   * <p>Note: Replaces the key and value identifiers enclosed in brackets with the corresponding
   * value.
   *
   * @param line the original string line parameter.
   * @return the built end point.
   */
  public static String builtEndPoint(final String line, final Context context) {
    final String SLASH = "/";
    String[] parts = line.split(SLASH);
    for (int i = 0; i < parts.length; i++) {
      parts[i] = getValueFromContext(parts[i], context);
    }
    return String.join(SLASH, parts);
  }

  /**
   * This method return the value of a key stored in the Shared Variables List. Receives a String
   * where the key and value are enclosed in brackets "[key.value]".
   *
   * @param text is the String parameter to process.
   * @return the key value.
   */
  public static String getValueFromContext(final String text, final Context context) {
    final String REGEX_BRACKETS_INSIDE = "(?<=\\[)(.*?)(?=])";
    Pattern pattern = Pattern.compile(REGEX_BRACKETS_INSIDE);
    Matcher matcher = pattern.matcher(text);
    if (matcher.find()) {
      // Split [key.value]
      String[] keys = matcher.group(1).split("\\.");
      return keys.length > 1 ? context.getDataCollection(keys[0]).get(keys[1]) : "";
    }
    return text;
  }
}
