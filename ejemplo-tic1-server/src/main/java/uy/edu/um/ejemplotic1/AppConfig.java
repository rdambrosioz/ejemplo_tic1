package uy.edu.um.ejemplotic1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uy.edu.um.ejemplotic1.vehicle.VehiclePriceCalculator;
import uy.edu.um.ejemplotic1.vehicle.VehiclePriceCalculatorImpl;

@Configuration
@ComponentScan("uy.edu.um.ejemplotic1")
public class AppConfig {

    @Bean
    public VehiclePriceCalculator vehiclePriceCalculator(){
        return new VehiclePriceCalculatorImpl();
    }

}
