package com.ovidiomiranda.framework.core.api.utils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import io.restassured.response.Response;
import java.io.File;
import java.util.Map;
import org.testng.Assert;

/**
 * Defines utility methods for response body validation.
 *
 * @author Ovidio Miranda
 */
public final class ResponseBodyValidator {

  /**
   * Private constructor for {@link ResponseBodyValidator} utility class.
   */
  private ResponseBodyValidator() {
  }

  /**
   * Validates a response from a given JsonSchema file.
   *
   * @param response       the response obtained from the server.
   * @param schemaFilePath the path of the JsonSchema file.
   */
  public static void validateSchema(final Response response, final String schemaFilePath) {
    File schemaFile = new File(schemaFilePath);
    response.then().assertThat().body(matchesJsonSchema(schemaFile));
  }

  /**
   * Validates response body values.
   *
   * @param actualValues   actual values.
   * @param expectedValues expected values.
   */
  public static void validateBodyValues(final Map<String, Object> actualValues,
      final Map<String, String> expectedValues) {
    for (Map.Entry<String, String> entry : expectedValues.entrySet()) {
      String actualValue = actualValues.get(entry.getKey()).toString();
      String expectedValue = entry.getValue();
      Assert.assertEquals(actualValue, expectedValue);
    }
  }
}
