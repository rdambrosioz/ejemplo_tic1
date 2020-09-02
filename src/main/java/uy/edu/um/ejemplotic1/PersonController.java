package uy.edu.um.ejemplotic1;


import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import uy.edu.um.ejemplotic1.entities.Person;
import uy.edu.um.ejemplotic1.entities.Vehicle;

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

        if (personOptional.isPresent()){
            return personOptional.get();
        }

        return null;
    }









}
