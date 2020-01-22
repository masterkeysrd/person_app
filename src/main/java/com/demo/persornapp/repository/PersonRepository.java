package com.demo.persornapp.repository;

import com.demo.persornapp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select t from Person t where  t.firstName = :name")
    List<Person> findAllByName(String name);
}
