package uy.edu.um.ejemplotic1;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uy.edu.um.ejemplotic1.entities.Person;
import uy.edu.um.ejemplotic1.entities.Vehicle;

import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor
public class VehicleController {

    VehicleRepository vehicleRepository;

    @Autowired
    PersonController personController;


    @PostMapping("/new")
    public void createVehicle(@RequestBody Vehicle vehicle){

        vehicleRepository.save(vehicle);
    }



    @GetMapping("/{plate}")
    public Vehicle getVehicle(@PathVariable("plate") String plate){

        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(plate);

        if (vehicleOptional.isPresent()){
            return vehicleOptional.get();
        }

        return null;
    }

    @GetMapping("/owner/{plate}")
    public Person getOwner(@PathVariable("plate") String plate){

        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(plate);
        Vehicle vehicle = null;

        if (vehicleOptional.isPresent()){
            vehicle = vehicleOptional.get();
        } else{
            return null;
        }

        Long owner_id = null;
        Optional<Person> ownerOptional = vehicle.getOwners().stream().findFirst();
        if (ownerOptional.isPresent()){
            owner_id = ownerOptional.get().getId();
        } else{
            return null;
        }

        Person owner = personController.getUser(owner_id);


        return owner;
    }



    @GetMapping("/add_owner/{plate}")
    public Person addOwner(@PathVariable("plate") String plate, @RequestParam Long id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(plate);
        Vehicle vehicle = null;

        if (vehicleOptional.isPresent()) {
            vehicle = vehicleOptional.get();
        } else {
            return null;
        }

        Person owner = personController.getUser(id);

        vehicle.getOwners().add(owner);

        vehicleRepository.save(vehicle);

        return owner;
    }


}
