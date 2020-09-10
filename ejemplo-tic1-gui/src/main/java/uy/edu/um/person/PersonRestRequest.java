package uy.edu.um.person;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class PersonRestRequest {

    public Person getFirstPersonFromServer() {
        org.springframework.web.client.RestTemplate template = new org.springframework.web.client.RestTemplate();
        ResponseEntity<String> response
                = template.getForEntity("http://localhost:8080/person/1", String.class);

        Person person = null;
        try {
            person = new ObjectMapper().readValue(response.getBody(), Person.class);
        } catch (JsonProcessingException e) {
            System.out.println("No se pudo encontrar la persona");
        }

        return person;
    }

}

