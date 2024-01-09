package com.agenda.model;

import lombok.Getter;

@Getter
public enum RecurrenciesEnum {

    EVERYDAY(1),
    INTWODAYS(2),
    WEEKLY(7),
    MONTHLY(30),

    PERSONALIZED(0);

    private final int recurrency;

    RecurrenciesEnum(int dias) {
        this.recurrency=dias;
    }
}
