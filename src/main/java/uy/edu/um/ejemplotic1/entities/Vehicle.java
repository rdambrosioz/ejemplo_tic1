package uy.edu.um.ejemplotic1.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {


    @Id
    private String plate;

    private String brand;
    private String model;
    private Integer year;

//    @Embedded
//    private Person owner;

}
