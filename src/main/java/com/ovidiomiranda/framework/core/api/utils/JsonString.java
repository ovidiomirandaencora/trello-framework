package com.ovidiomiranda.framework.core.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility functions to get JSON string for different cases.
 *
 * @author Ovidio Miranda
 */
public class JsonString {

  private static final Logger LOGGER = LogManager.getLogger(JsonString.class);

  /**
   * Converts a map to a JSON String.
   *
   * @param map the map values.
   * @return a JSON string.
   */
  public static String convertMapToJsonString(final Map<String, String> map) {
    String json = null;
    try {
      json = new ObjectMapper().writeValueAsString(map);
    } catch (JsonProcessingException e) {
      LOGGER.error(e);
    }
    return json;
  }

  /**
   * Gets the body as a pretty formatted string.
   *
   * @param json the json string.
   * @return the body as a string.
   */
  public static String formatJsonString(final String json) {
    String prettyJson = "";
    ObjectMapper mapper = new ObjectMapper();
    try {
      Object jsonObject = mapper.readValue(json, Object.class);
      prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return prettyJson;
  }

}
