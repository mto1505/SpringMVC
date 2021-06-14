/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.utils;

import com.mycompany.springmvctest.dto.MyUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author MinhTo
 */
public class SecurityUtils {
    public static List<String> getAuthorites()
            {
                List<String> results=new ArrayList<>();
                List<GrantedAuthority> authorities=(List<GrantedAuthority> )SecurityContextHolder.getContext().getAuthentication().getAuthorities();
                for (GrantedAuthority authority : authorities) {
                    results.add(authority.getAuthority());
                }
                return results;
            }
    public static MyUser getPrincipal()
            {
                MyUser myUser=(MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                return myUser;
            }
    
    
}
