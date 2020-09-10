package uy.edu.um.person;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@FxmlView("personMenu.fxml")
public class PersonController {

    @Autowired
    PersonRestRequest personRestRequest;


    @FXML
    private Button getFirstPerson;

    @FXML
    void getFirstPerson(ActionEvent event) {
        System.out.println(personRestRequest.getFirstPersonFromServer());
    }

}
