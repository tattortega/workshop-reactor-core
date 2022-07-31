package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Mono<Person> post(@RequestBody Person personMono) {
        return personService.insert(personMono);
    }

    @GetMapping
    public Flux<Person> list() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable("id") String id) {
        return personService.get(id);
    }

    @PutMapping
    public Mono<Person> update(@RequestBody Mono<Person> personMono) {
        return personService.update(personMono);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return personService.delete(id);
    }

}
