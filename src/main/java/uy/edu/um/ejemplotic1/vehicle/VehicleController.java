package uy.edu.um.ejemplotic1.vehicle;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uy.edu.um.ejemplotic1.person.Person;
import uy.edu.um.ejemplotic1.person.PersonController;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor
@NoArgsConstructor
class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    PersonController personController;
    @Autowired
    VehiclePriceCalculator vehiclePriceCalculator;

    @PostMapping("/new")
    public void createVehicle(@RequestBody Vehicle vehicle){
        //        vehicle.getOwners().stream().forEach((owner) -> {
        //            if (personController.getUser(owner.getId()) == null){
        //                personController.createUser(owner);
        //            }
        //        });

        if (vehicle.getEstimatedPrice() == null){
            vehicle.setEstimatedPrice(vehiclePriceCalculator.calculatePrice(vehicle));
        }
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
    public Set<Person> getOwner(@PathVariable("plate") String plate){

        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(plate);
        Vehicle vehicle = null;

        if (vehicleOptional.isPresent()){
            vehicle = vehicleOptional.get();
        } else{
            return null;
        }

        Set<Person> ownersList = new LinkedHashSet<>();

        vehicle.getOwners().stream().forEach((owner) -> {
            ownersList.add(personController.getUser(owner.getId()));
        });


        return ownersList;
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