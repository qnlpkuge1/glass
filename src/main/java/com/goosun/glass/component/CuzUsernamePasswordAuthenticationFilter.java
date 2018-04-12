package com.goosun.glass.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component("cuzUsernamePasswordAuthenticationFilter")
public class CuzUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    			Authentication auth = super.attemptAuthentication(request, response);
    			
            System.out.println("验证通过");
            
            return auth;
        
    }

}
