package uy.edu.um;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uy.edu.um.person.PersonRestRequest;

@Component
@FxmlView("/uy/edu/um/mainMenu.fxml")
public class MainMenuController {

    @Autowired
    JavaFxApplication javaFxApplication;

    @FXML
    private Button personsMenu;

    @FXML
    private Button vehicleMenu;

    @FXML
    private Button buttonPito;

    @FXML
    void personsMenu(ActionEvent event) {
        javaFxApplication.personMenu();
    }

    @FXML
    void vehicleMenu(ActionEvent event) { System.out.println("Not available yet!"); }

    @FXML
    void buttonPito(ActionEvent event) {javaFxApplication.pitoPressed();}


    public MainMenuController() {

    }
}
