package uy.edu.um.ejemplotic1.person;


import lombok.*;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private Long id;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;


}


