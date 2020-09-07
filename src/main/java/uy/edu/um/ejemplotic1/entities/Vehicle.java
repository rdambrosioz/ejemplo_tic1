package uy.edu.um.ejemplotic1.entities;


import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {


    @Id
    @Column(length = 8)
    private String plate;
    @Column(length = 20)
    private String brand;
    @Column(length = 20)
    private String model;
    private Integer year;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Vehicle_Owner",
            joinColumns = { @JoinColumn(name = "vehicle_plate") },
            inverseJoinColumns = { @JoinColumn(name = "owner_id") }
    )
    private Set<Person> owners;



}
