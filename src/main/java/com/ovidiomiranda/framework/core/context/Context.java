package com.ovidiomiranda.framework.core.context;

import static com.ovidiomiranda.framework.core.api.utils.Mapper.mapValues;

import java.util.HashMap;
import java.util.Map;

/**
 * Define the Context class.
 *
 * @author Ovidio Miranda
 */
public class Context {

  private Map<String, Object> mapData;
  private Map<String, Map<String, String>> dataCollection;

  /**
   * Constructor for the Context.
   */
  public Context() {
    mapData = new HashMap<>();
    dataCollection = new HashMap<>();
  }

  /**
   * Saves the data.
   *
   * @param inputJson String
   */
  public void saveData(final String inputJson) {
    mapData = mapValues(inputJson);
  }

  /**
   * Gets the value of key given.
   *
   * @param key to get value.
   * @return value of key.
   */
  public String getValueData(final String key) {
    String value = "";
    if (mapData.containsKey(key)) {
      value = String.format("%s", mapData.get(key));
    }
    return value;
  }

  /**
   * Gets data map.
   *
   * @return data map.
   */
  public Map<String, Object> getData() {
    return mapData;
  }

  /**
   * Saves the data in to data collection.
   *
   * @param key     the key.
   * @param dataMap the data map.
   */
  public void saveDataCollection(final String key, final Map<String, String> dataMap) {
    dataCollection.put(key, dataMap);
  }

  /**
   * Gets data map collection.
   *
   * @param key the key.
   * @return dataCollection the data collection.
   */
  public Map<String, String> getDataCollection(final String key) {
    return dataCollection.getOrDefault(key, new HashMap<>());
  }
}
