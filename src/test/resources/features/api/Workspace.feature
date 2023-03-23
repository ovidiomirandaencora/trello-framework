@Regression
Feature: Workspace

  @TC-00001 @Smoke @Functional @DeleteWorkspace
  Scenario: Verify that a workspace can be created
    When a POST request to "/organizations" with the following Json data:
      """
      {
          "displayName": "AUT Workspace1"
      }
      """
      And stored as "Organization"
    Then the status code should be 200
      And verifies response body should match with "organization/createWorkspace.json" JSON schema
      And verifies the response contain the following values:
        | displayName | AUT Workspace1 |

  @TC-00002 @Negative
  Scenario: Verify that a Workspace can't be created with an empty display name
    When a POST request to "/organizations" with the following Json data:
      """
      {
          "displayName": ""
      }
      """
    Then the status code should be 400
      And verifies response body should match with "errorResponse.json" JSON schema
      And verifies the response body should be:
        """
        {
            "message": "Display Name must be at least 1 character",
            "error": "ERROR"
        }
        """
