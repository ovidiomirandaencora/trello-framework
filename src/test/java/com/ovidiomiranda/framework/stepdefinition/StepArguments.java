package com.ovidiomiranda.framework.stepdefinition;

import com.ovidiomiranda.framework.core.api.RequestType;
import io.cucumber.java.ParameterType;

public class StepArguments {

  @ParameterType("POST|PUT")
  public RequestType requestType(final String input) {
    return RequestType.valueOf(input);
  }
}
