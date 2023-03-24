package com.ovidiomiranda.framework.hooks;

import static com.ovidiomiranda.framework.core.api.utils.JsonString.formatJsonString;
import static com.ovidiomiranda.framework.hooks.HookOrder.CREATE_WORKSPACE;
import static com.ovidiomiranda.framework.hooks.HookOrder.DELETE_WORKSPACE;

import com.ovidiomiranda.framework.core.api.RequestManager;
import com.ovidiomiranda.framework.core.context.Context;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import java.util.Date;

/**
 * The prerequisites related to 'Workspace'.
 *
 * @author Ovidio Miranda
 */
public class WorkspaceHooks {

  private Context context;

  /**
   * Initializes a new instance of the ClientHooks class.
   *
   * @param contextToSet Context to set.
   */
  public WorkspaceHooks(final Context contextToSet) {
    this.context = contextToSet;
  }

  /**
   * Creates a workspace.
   */
  @Before(value = "@CreateWorkspace", order = CREATE_WORKSPACE)
  public void createWorkspace() {
    final String endpoint = "/organizations";
    final String name = "AUT Workspace".concat(Long.toString(new Date().getTime()));
    final String body = formatJsonString("{\"displayName\":\"" + name + "\"}");
    final Response response = RequestManager.post(endpoint, body);
    context.saveDataCollection("Organization", response.jsonPath().getMap(""));
  }

  /**
   * Deletes a workspace.
   */
  @After(value = "@DeleteWorkspace", order = DELETE_WORKSPACE)
  public void deleteWorkspace() {
    final String idOrganizations = context.getDataCollection("Organization").get("id");
    final String endpoint = "/organizations/" + idOrganizations;
    RequestManager.delete(endpoint);
  }
}
