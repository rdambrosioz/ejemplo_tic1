package uy.edu.um.ejemplotic1.vehicle;


import lombok.*;
import uy.edu.um.ejemplotic1.person.Person;


import javax.persistence.*;
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
    private Long estimatedPrice;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Vehicle_Owner",
            joinColumns = { @JoinColumn(name = "vehicle_plate") },
            inverseJoinColumns = { @JoinColumn(name = "owner_id") }
    )
    private Set<Person> owners;



}
