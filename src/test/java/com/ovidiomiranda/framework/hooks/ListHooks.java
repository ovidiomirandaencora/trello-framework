package com.ovidiomiranda.framework.hooks;

import static com.ovidiomiranda.framework.core.api.utils.JsonString.formatJsonString;
import static com.ovidiomiranda.framework.core.utils.DataInterpreter.builtEndPoint;
import static com.ovidiomiranda.framework.hooks.HookOrder.CREATE_BOARD;
import static com.ovidiomiranda.framework.hooks.HookOrder.CREATE_LIST;

import com.ovidiomiranda.framework.core.api.RequestManager;
import com.ovidiomiranda.framework.core.context.Context;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import java.util.Date;

/**
 * The prerequisites related to 'List'.
 *
 * @author Ovidio Miranda
 */
public class ListHooks {

  private Context context;

  /**
   * Initializes a new instance of the ListHooks class.
   *
   * @param contextToSet Context to Set.
   */
  public ListHooks(final Context contextToSet) {
    this.context = contextToSet;
  }

  /**
   * Creates a workspace.
   */
  @Before(value = "@CreateList", order = CREATE_LIST)
  public void createList() {
    final String param = "/boards/[Board.id]/lists";
    final String name = "AUT List ".concat(Long.toString(new Date().getTime()));
    final String body = formatJsonString("{\"name\":\"" + name + "\"}");
    String endpoint = builtEndPoint(param, context);
    final Response response = RequestManager.post(endpoint, body);
    context.saveDataCollection("List", response.jsonPath().getMap(""));
  }
}
