package uy.edu.um.ejemplotic1;


import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import uy.edu.um.ejemplotic1.entities.Person;


import java.util.Optional;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {


    PersonRepository personRepository;


    @PostMapping("/new/")
    public void createUser(@RequestBody Person person){

        personRepository.save(person);
    }



    @GetMapping("/{id}")
    public Person getUser(@PathVariable("id") Long id){

        Optional<Person> personOptional = personRepository.findById(id);

        return personOptional.orElse(null);

    }









}
