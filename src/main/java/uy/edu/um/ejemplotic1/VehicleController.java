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

//    @GetMapping("{plate}/owner")
//    public Person getOwner(@PathVariable("plate") String plate){
//
//        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(plate);
//        Vehicle vehicle = null;
//
//        if (vehicleOptional.isPresent()){
//            vehicle = vehicleOptional.get();
//        } else{
//            return null;
//        }
//
//        Long owner_id = vehicle.getOwner().getId();
//
//        Person owner = personController.getUser(owner_id);
//
//
//        return owner;
//    }




}
