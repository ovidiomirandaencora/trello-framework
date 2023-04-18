package com.ovidiomiranda.framework.core.utils.property;

import static com.ovidiomiranda.framework.core.utils.property.PropertiesInput.API_KEY;
import static com.ovidiomiranda.framework.core.utils.property.PropertiesInput.API_TOKEN;
import static com.ovidiomiranda.framework.core.utils.property.PropertiesInput.API_URL;
import static com.ovidiomiranda.framework.core.utils.property.PropertiesInput.BASE_URL;
import static com.ovidiomiranda.framework.core.utils.property.PropertiesInput.PASSWORD;
import static com.ovidiomiranda.framework.core.utils.property.PropertiesInput.SCHEMAS_PATH;
import static com.ovidiomiranda.framework.core.utils.property.PropertiesInput.USER;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The PropertiesManager class to read data from gradle.properties.
 *
 * @author Ovidio Miranda
 */
public final class PropertiesManager {

  private static PropertiesManager propertiesManager;
  private Properties properties;
  private static final Logger LOGGER = LogManager.getLogger(PropertiesManager.class);

  /**
   * Constructor, private to apply singleton pattern.
   */
  private PropertiesManager() {
    init();
  }

  /**
   * Static method to get a class instance.
   *
   * @return the singleton instance.
   */
  public static PropertiesManager getInstance() {
    if (propertiesManager == null) {
      propertiesManager = new PropertiesManager();
    }
    return propertiesManager;
  }

  /**
   * Initialize Properties object.
   */
  private void init() {
    properties = new Properties();
    try (FileInputStream input = new FileInputStream("gradle.properties")) {
      properties.load(input);
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
    }
  }

  /**
   * Gets environment value.
   *
   * @param variable variable obtained of gradle.properties.
   * @return the environment value.
   */
  private String getEnvValue(final String variable) {
    String property = System.getProperty(variable);
    return property == null ? properties.getProperty(variable) : property;
  }

  /**
   * Gets Properties Inputs.
   *
   * @param prop a Enum value.
   * @return the property value.
   */
  public String getProperties(final PropertiesInput prop) {
    return getEnvValue(prop.getPropertiesName());
  }

  /**
   * Gets base url from the Gradle properties.
   *
   * @return the base url in a string object.
   */
  public String getBaseUrl() {
    return getProperties(BASE_URL);
  }

  /**
   * Gets API url from the Gradle properties.
   *
   * @return the API url in a string object.
   */
  public String getApiUrl() {
    return getProperties(API_URL);
  }

  /**
   * Gets API Key from the Gradle properties.
   *
   * @return the API Key in a string object.
   */
  public String getApiKey() {
    return getProperties(API_KEY);
  }

  /**
   * Gets API Token from the Gradle properties.
   *
   * @return the API Token in a string object.
   */
  public String getApiToken() {
    return getProperties(API_TOKEN);
  }

  /**
   * Gets user from the Gradle properties.
   *
   * @return the user url in a string object.
   */
  public String getUser() {
    return getProperties(USER);
  }

  /**
   * Gets password from the Gradle properties.
   *
   * @return the password in a string object.
   */
  public String getPassword() {
    return getProperties(PASSWORD);
  }

  /**
   * Gets Schemas Path from the Gradle properties.
   *
   * @return the schemas path in a string object.
   */
  public String getSchemasPath() {
    return getProperties(SCHEMAS_PATH);
  }
}
