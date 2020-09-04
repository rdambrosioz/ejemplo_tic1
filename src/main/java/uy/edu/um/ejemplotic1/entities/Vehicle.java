package uy.edu.um.ejemplotic1.entities;


import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
public class Vehicle {


    @Id
    @Column(length = 8)
    private String plate;
    @Column(length = 20)
    private String brand;
    @Column(length = 20)
    private String model;
    private Integer year;


    @ManyToMany
    @JoinTable(
            name = "Vehicle_Owner",
            joinColumns = { @JoinColumn(name = "vehicle_plate") },
            inverseJoinColumns = { @JoinColumn(name = "owner_id") }
    )
    private List<Person> owners;




    public Vehicle(){
        this.owners = new ArrayList<Person>();
    }



    public List<Person> getOwners(){
        if (owners == null)
            return new ArrayList<Person>();
        else
            return owners;
    }


}
