package com.ovidiomiranda.framework.core.api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Class to manage the requests.
 *
 * @author Ovidio Miranda
 */
public class RequestManager {

  private static final RequestSpecification REQUEST = Connection.getInstance()
      .getRequestSpecification();

  /**
   * Private constructor for the Request Manager utility class.
   */
  private RequestManager() {
  }

  /**
   * This method perform a GET request.
   *
   * @param endpoint the specified end point.
   * @param body     the body content.
   * @return a response object.
   */
  public static Response get(final String endpoint, final String body) {
    return given().spec(REQUEST).when().body(body).get(endpoint);
  }

  /**
   * This method perform a POST request.
   *
   * @param endpoint the specified end point.
   * @param body     the body content.
   * @return a response object.
   */
  public static Response post(final String endpoint, final String body) {
    return given().spec(REQUEST).when().body(body).post(endpoint);
  }

  /**
   * This method perform a POST request.
   *
   * @param endpoint the specified end point.
   * @param body     the body content.
   * @return a response object.
   */
  public static Response put(final String endpoint, final String body) {
    return given().spec(REQUEST).when().body(body).put(endpoint);
  }

  /**
   * This method perform a DELETE request.
   *
   * @param endpoint is the specified end point.
   * @return a response object.
   */
  public static Response delete(final String endpoint) {
    return given().spec(REQUEST).when().delete(endpoint);
  }
}
