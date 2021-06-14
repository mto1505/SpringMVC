/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.security;

import com.mycompany.springmvctest.utils.SecurityUtils;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author MinhTo
 */
@Component // hỗ trợ dependency Injection
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    private RedirectStrategy redirectStragy=new DefaultRedirectStrategy();

    public RedirectStrategy getRedirectStragy() {
        return redirectStragy;
    }

    public void setRedirectStragy(RedirectStrategy redirectStragy) {
        this.redirectStragy = redirectStragy;
    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl=determineTargetUrl(authentication);
        if(response.isCommitted()) // kiểm tra response đã gửi vè client chưa
            {
                return;
            }
      
        redirectStragy.sendRedirect(request, response, targetUrl);
        
    }

    private String determineTargetUrl(Authentication authentication) {
        String url="";
        List<String> roles=SecurityUtils.getAuthorites();
        if(isAdmin(roles))
            {   url="https://localhost:8181/SpringMVCTest/quan-tri/trang-chu";
                return url;
            }
        else if(isUser(roles))
            {
                 url="https://localhost:8181/SpringMVCTest/trang-chu";
                 return url;
            }
        return null;
       
    }
    private boolean isAdmin(List<String> roles)
            {
               return roles.contains("ADMIN");
            }
    private boolean isUser (List<String> roles)
            {
               return roles.contains("USER");
            }

}
