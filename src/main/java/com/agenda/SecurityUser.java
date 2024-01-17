package com.agenda;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUser {

    public static String getCurrentUserId(){
        return SecurityContextHolder.getContext().getAuthentication().getName();

    }

}
