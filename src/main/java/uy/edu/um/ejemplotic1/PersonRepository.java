package uy.edu.um.ejemplotic1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import uy.edu.um.ejemplotic1.entities.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
