package com.ccil.vms.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
 
    
 
  //  @Autowired
  //  private LocaleResolver localeResolver;
 
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, 
      HttpServletResponse response, AuthenticationException exception)
      throws IOException, ServletException {
        setDefaultFailureUrl("/login.html?error=true");
 
        super.onAuthenticationFailure(request, response, exception);
 
       // Locale locale = localeResolver.resolveLocale(request);
 
       // String errorMessage = messages.getMessage("message.badCredentials", null, locale);
 
        if (exception.getMessage().equalsIgnoreCase("User is disabled")) {
         //   errorMessage = messages.getMessage("auth.message.disabled", null, locale);
        } else if (exception.getMessage().equalsIgnoreCase("User account has expired")) {
         //   errorMessage = messages.getMessage("auth.message.expired", null, locale);
        }
 
      //  request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorMessage);
    }
}
