package com.ovidiomiranda.framework.core.utils.property;

/**
 * Class Enum PropertiesInputs.
 *
 * @author Ovidio Miranda
 */
public enum PropertiesInput {
  BROWSER("browser"),
  BASE_URL("baseUrl"),
  API_URL("apiUrl"),
  API_KEY("apiKey"),
  API_TOKEN("apiToken"),
  USER("user"),
  PASSWORD("password"),
  SCHEMAS_PATH("schemasPath"),
  EXPLICIT_WAIT("explicitWait");

  private String propertiesName;

  /**
   * Constructor.
   *
   * @param propertiesName name.
   */
  PropertiesInput(final String propertiesName) {
    this.propertiesName = propertiesName;
  }

  /**
   * Gets Property name.
   *
   * @return propertiesName the String enum.
   */
  public String getPropertiesName() {
    return propertiesName;
  }
}
