/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.config;

import javax.ws.rs.core.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author MinhTo
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {
    @Bean
    public AuditorAware auditorProvider()
            {
                return new AuditorAwareImpl();
                
            }

    private static class AuditorAwareImpl implements AuditorAware<String> {
        @Override
        public String getCurrentAuditor() {
            Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
            if(authentication==null)
            {
                return null;
            }
            return authentication.getName();
            
            
        }
    }
    
}
