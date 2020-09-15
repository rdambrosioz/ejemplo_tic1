package uy.edu.um;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import uy.edu.um.person.PersonController;

@Component
public class JavaFxApplication extends Application {

    private static ConfigurableApplicationContext applicationContext;

    @Autowired
    private PersonController personController;

    static Stage primaryStage;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(EjemploTICGui.class)
                .run(args);
    }

    @Override
    public void start(Stage primaryStage) {

        JavaFxApplication.primaryStage = primaryStage;
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(MenuMinecraftController.class);
        root.getStylesheets().add("/uy/edu/um/menuStyle.css");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }


    public void personMenu() {
        Stage stage = new Stage();
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(PersonController.class);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void singleplayer() {

        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(SingleplayerController.class);
        root.getStylesheets().add("/uy/edu/um/singleplayerStyle.css");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
