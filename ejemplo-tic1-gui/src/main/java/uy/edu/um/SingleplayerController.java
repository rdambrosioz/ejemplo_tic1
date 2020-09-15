package uy.edu.um;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/uy/edu/um/singleplayerScene.fxml")
public class SingleplayerController {

    @Autowired
    JavaFxApplication javaFxApplication;

    @FXML
    private Button cancel;

    @FXML
    void cancel(ActionEvent event) {
        javaFxApplication.cancel();
    }

    public SingleplayerController() {
    }

}
