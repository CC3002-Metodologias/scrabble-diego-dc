package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.controller.SystemInfo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * JavaFX App
 */
public class ScrabbleApp extends Application {
    private static final String RESOURCE_PATH = "src/main/resources/";

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Scrabble");
        var group1 = new Group();
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(group1, 1000, 550);

        var background =
                new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background_calculator_yellow.jpg")));
        group1.getChildren().add(background);
        group1.getChildren().add(setupButton(375,400));
        group1.getChildren().add(setupButton(450,400));
        group1.getChildren().add(setupButton(525,400));
        group1.getChildren().add(setupButton(600,400));
        group1.getChildren().add(setupButton(675,400));
        stage.setScene(scene);
        stage.show();
    }

    private @NotNull Button setupButton(int x, int y) {
        var button = new Button("Play sound");
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setFocusTraversable(false);
        button.setOnAction(ScrabbleApp::playSound);
        return button;
    }


    private static void playSound(ActionEvent event) {
        String audioFilePath = RESOURCE_PATH + "buttonSound0.wav";
        try {
            var sound = AudioSystem.getClip();
            try (var audioInputStream = AudioSystem.getAudioInputStream(
                    new File(audioFilePath))) {
                sound.open(audioInputStream);
                sound.start();
            }
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}