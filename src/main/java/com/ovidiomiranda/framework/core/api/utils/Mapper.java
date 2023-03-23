package com.ovidiomiranda.framework.core.api.utils;

import static com.ovidiomiranda.framework.core.api.utils.JsonString.convertMapToJsonString;
import static com.ovidiomiranda.framework.core.utils.DataInterpreter.getValueFromContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ovidiomiranda.framework.core.context.Context;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Define the mapper class.
 *
 * @author Ovidio Miranda
 */
public final class Mapper {

  private static final Logger LOGGER = LogManager.getLogger(Mapper.class);

  /**
   * Mapper constructor.
   */
  private Mapper() {
  }

  /**
   * Mappers Map values to JSON String.
   *
   * @param value        the value.
   * @param storedValues the map.
   * @return the Json String.
   */
  public static String mapValueNew(final String value, final Map<String, Object> storedValues) {
    String val = value;
    // [OM] Replaces all matching values.
    for (Map.Entry<String, Object> entry : storedValues.entrySet()) {
      // [OM] Replaces a value inside '{id}' with a value stored in the context.
      val = val.replace("{" + entry.getKey() + "}", String.format("%s", entry.getValue()));
    }
    return val;
  }

  /**
   * Mappers HashMap values to JSON String.
   *
   * @param map the map values.
   * @param context Context.
   * @return the Json String.
   */
  public static String mapValues(final Map<String, String> map, final Context context) {
    String key;
    String value;
    String newValue;
    Map<String, String> expectedValues = new HashMap<>(map);
    for (Map.Entry<String, String> entry : expectedValues.entrySet()) {
      // [OM] If contains a bracket '[' e.g. [Organization.id].
      if (entry.getValue().contains("[")) {
        key = entry.getKey();
        value = entry.getValue();
        // [OM] Get value from context.
        newValue = getValueFromContext(value, context);
        // [OM] Replace the previous value with the value obtained from Context.
        expectedValues.replace(key, newValue);
      }
    }
    return convertMapToJsonString(expectedValues);
  }

  /**
   * Mappers JSON String values to a HashMap.
   *
   * @param jsonString the Json String.
   * @return the map values.
   */
  public static Map<String, Object> mapValues(final String jsonString) {
    Map<String, Object> mapValues = null;
    try {
      mapValues = new ObjectMapper().readValue(jsonString, HashMap.class);
    } catch (JsonProcessingException e) {
      LOGGER.error("Exception when executing a pause", e);
    }
    return mapValues;
  }
}
