package com.agenda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Column
    private String name;

    private String description;

    @ManyToOne
    Person person;

//    @Column
//    private List<DayOfWeek> days;

    @Column( columnDefinition = "TIME")
    @NotNull
    private LocalTime time;

    @Column
    @NotNull
    private LocalDate startDate;

    @Column
    @NotNull
    private LocalDate stopDate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private RecurrenciesEnum recurrency;

    @Column
    private Integer recurrencyPersonalized;


}
