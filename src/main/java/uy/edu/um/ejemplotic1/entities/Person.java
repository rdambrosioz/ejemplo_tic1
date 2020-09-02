package uy.edu.um.ejemplotic1.entities;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private Long id;
    private String firstName;
    private String lastName;



}


