package uy.edu.um;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/uy/edu/um/menuMinecraft.fxml")
public class MenuMinecraftController {

    @Autowired
    JavaFxApplication javaFxApplication;

    @FXML
    private Button singleplayer;

    @FXML
    private Button person;

    @FXML
    private Button vehicle;

    @FXML
    void singleplayer(ActionEvent event) {
        javaFxApplication.singleplayer();
    }

    @FXML
    void vehicleMenu(ActionEvent event) { System.out.println("Not available yet!"); }

    @FXML
    void personMenu(ActionEvent event) {javaFxApplication.personMenu();}

    public MenuMinecraftController() {
    }

}
