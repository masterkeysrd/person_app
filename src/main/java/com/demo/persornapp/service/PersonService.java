package com.demo.persornapp.service;

import com.demo.persornapp.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll();
    Optional<Person> findById(Long id);
    List<Person> findByName(String name);
    Person save(Person save);
    void delete(Long id);
}
