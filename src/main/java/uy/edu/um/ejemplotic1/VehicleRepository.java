package uy.edu.um.ejemplotic1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uy.edu.um.ejemplotic1.entities.Vehicle;


@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {

}
