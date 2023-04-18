package com.ovidiomiranda.framework.core.log;

import static java.lang.String.format;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Define the RestAssured Request Filter class.
 *
 * @author Ovidio Miranda
 */
public class RestAssuredRequestFilter implements Filter {

  private static final Logger LOGGER = LogManager.getLogger(RestAssuredRequestFilter.class);

  @Override
  public Response filter(FilterableRequestSpecification requestSpec,
      FilterableResponseSpecification responseSpec, FilterContext ctx) {
    Response response = ctx.next(requestSpec, responseSpec);

    final String requestMethod = requestSpec.getMethod();
    final String requestUrl = requestSpec.getURI();
    final String requestBody = requestSpec.getBody();
    final int responseStatus = response.getStatusCode();
    final String responseBody = response.getBody().asPrettyString();

    final String requestMessage = format(
        "%n======== Request ========%nMethod: %s%nURL: %s%nBody:%n%s", requestMethod, requestUrl,
        requestBody);
    final String responseMessage = format("%n======== Response ========%nStatus: %s%nBody:%n%s",
        responseStatus, responseBody);
    final String message = requestMessage.concat(responseMessage);
    if (responseStatus != 200) {
      LOGGER.error(message);
    }
    LOGGER.info(message);
    return response;
  }
}
