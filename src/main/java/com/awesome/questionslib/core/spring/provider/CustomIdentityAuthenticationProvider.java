package com.awesome.questionslib.core.spring.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomIdentityAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = isValidUser(username, password);
        Object authDetailsObj = authentication.getDetails();
        WebAuthenticationDetails authenticationDetails;
        if (authDetailsObj instanceof WebAuthenticationDetails) {
            authenticationDetails = (WebAuthenticationDetails) authDetailsObj;
            log.info("The IP address is: '{}'", authenticationDetails.getRemoteAddress());
        }

        if (userDetails != null) {
            return new UsernamePasswordAuthenticationToken(
                    username,
                    password,
                    userDetails.getAuthorities());
        } else {
            throw new BadCredentialsException("Incorrect user credentials!!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private UserDetails isValidUser(String username, String password) {
        if (username.equalsIgnoreCase("bevis") && password.equals("password")) {
            return User
                    .withUsername(username)
                    .password("NOT_DISCLOSED")
                    .roles("Admin", "User")
                    .authorities("read")
                    .build();
        }
        return null;
    }
}
