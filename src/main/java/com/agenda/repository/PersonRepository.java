package com.agenda.repository;

import com.agenda.model.Person;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Long>,ListPagingAndSortingRepository<Person, Long> {
}
