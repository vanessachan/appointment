package com.agenda;

import com.agenda.model.Person;

public class SecurityUser {

    public static Long getCurrentUserId(){
        return 1L;
    }

    public static Person currentUser() {
        return  new Person(getCurrentUserId(), "Vanessa", "vanessa@gmail.com", null);
    }
}
