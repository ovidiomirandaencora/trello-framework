package com.ovidiomiranda.framework.stepdefinition;

import com.ovidiomiranda.framework.core.utils.Pause;
import com.ovidiomiranda.framework.core.utils.property.PropertiesManager;
import com.ovidiomiranda.framework.pages.login.LoginPage;
import io.cucumber.java.en.And;

/**
 * All the steps related to actions using in the 'Login' page.
 *
 * @author Ovidio Miranda
 */
public class LoginSteps {

  private LoginPage loginPage;

  /**
   * Initializes a new instance of LoginSteps class.
   *
   * @param loginPage the Login page instance, see {@link LoginPage} class.
   */
  public LoginSteps(LoginPage loginPage) {
    this.loginPage = loginPage;
  }

  /**
   * I Login to Trello.
   */
  @And("I login to Trello")
  public void loginToTrello() {
    final String user = PropertiesManager.getInstance().getUser();
    final String password = PropertiesManager.getInstance().getPassword();
    loginPage.logIn(user, password);
    Pause.pause(5000);
  }
}
