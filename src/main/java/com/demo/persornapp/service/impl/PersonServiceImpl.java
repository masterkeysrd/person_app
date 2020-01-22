package com.demo.persornapp.service.impl;

import com.demo.persornapp.domain.Person;
import com.demo.persornapp.repository.PersonRepository;
import com.demo.persornapp.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        logger.info("Request to findAll");
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        logger.info("Request to findById id={}", id);
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findAllByName(name);
    }

    @Override
    public Person save(Person entity) {
        logger.info("Request to save : {}", entity);
        return personRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        logger.info("Request to delete id={}", id);
        personRepository.deleteById(id);
    }
}
