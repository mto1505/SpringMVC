/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

/**
 *
 * @author MinhTo
 */
/*public class CustomFailureHandler  extends SimpleUrlAuthenticationFailureHandler {
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {
    // Login failed by max session
    if (exception.getClass().isAssignableFrom(SessionAuthenticationException.class)) {
     // response.sendRedirect(request.getContextPath() + "/login?message=max_session");
      return;
    }
    //response.sendRedirect(request.getContextPath() + "/login?message=error");
  }
}*/