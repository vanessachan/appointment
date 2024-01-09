package com.agenda.service.impl;

import com.agenda.model.Person;
import com.agenda.repository.PersonRepository;
import com.agenda.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public void save(Person person) {
        this.personRepository.save(person);

    }
}
