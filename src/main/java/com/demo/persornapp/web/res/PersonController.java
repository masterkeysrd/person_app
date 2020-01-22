package com.demo.persornapp.web.res;

import com.demo.persornapp.domain.Person;
import com.demo.persornapp.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("")
    public ResponseEntity<List<Person>> findAll(@RequestParam(required = false) String name) {
        List<Person> result;
        if (name != null) {
            result = personService.findByName(name);
        } else {
            result = personService.findAll();
        }

        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        Optional<Person> result = personService.findById(id);

        HttpHeaders headers = new HttpHeaders();
        if (result.isPresent()) {
            return ResponseEntity.ok().headers(headers).body(result.get());
        }

        return (ResponseEntity<Person>) ResponseEntity.notFound();
    }

    @PostMapping("")
    public ResponseEntity<Person> save(@RequestBody Person data) throws URISyntaxException {
        Person result = personService.save(data);

        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.created(new URI("/person" + result.getId()))
                .headers(headers)
                .body(result);
    }
    //void delete(Long id);
}
