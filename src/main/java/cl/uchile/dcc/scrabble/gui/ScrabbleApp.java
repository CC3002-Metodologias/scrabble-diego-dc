package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Group group1;
    private Group backgroundGroup;
    private Group group2;
    private Scene scene1;
    private Scene scene2;


    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Scrabble");

        group1 = new Group();
        backgroundGroup = new Group();
        group2 = new Group();

        group2.setStyle("-fx-background-color: transparent;");

        scene1 = new Scene(group1, 600, 600);
        scene2 = new Scene(backgroundGroup, 1000, 550);

        // ---------Start Scene-----------

        setStartScene(stage, group1);

        // ---------Calculation scene---------

        // We set the background
        var background2 =
                new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background_calculator_yellow.jpg")));
        // Then we just adjust group2
        backgroundGroup.getChildren().addAll(background2 ,group2);

        setScrabbleTypeScene(stage, group2);

        // -------- Display stage ----------

        stage.setScene(scene1);
        stage.show();
    }

    private void setStartScene(Stage stage, Group group) throws FileNotFoundException {

        var label = new Label("Scrabble");
        label.setLayoutX(300);
        label.setLayoutY(100);

        var background1 =
                new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background1.jpg")));
        background1.fitWidthProperty().bind(stage.widthProperty());
        background1.fitHeightProperty().bind(stage.heightProperty());

        var StartButton = setupButton(300, 550 , "START");
        StartButton.setOnAction(e -> stage.setScene(scene2));

        group.getChildren().addAll(background1, StartButton, label);
    }

    private void setScrabbleTypeScene(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        Button bt1 = setupButton(400,400, "String");
        Button bt2 = setupButton(500,400, "Bool");
        Button bt3 = setupButton(600,400, "Float");
        Button bt4 = setupButton(700,400, "Int");
        Button bt5 = setupButton(800,400, "Binary");

        Button bt6 = setupButton(300,450, "Add");
        Button bt7 = setupButton(400,450, "Subtract");
        Button bt8 = setupButton(500,450, "Multiply");
        Button bt9 = setupButton(600,450, "Divide");
        Button bt10 = setupButton(700,450, "Negate");
        Button bt11 = setupButton(800,450, "AND");
        Button bt12 = setupButton(900,450, "OR");

        bt1.setOnAction(e -> goToGetInput(stage,group,e));
        bt2.setOnAction(e -> goToGetInput(stage,group,e));
        bt3.setOnAction(e -> goToGetInput(stage,group,e));
        bt4.setOnAction(e -> goToGetInput(stage,group,e));
        bt5.setOnAction(e -> goToGetInput(stage,group,e));

        group.getChildren().addAll(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12);
    }

    private void setScrabbleGetInputScene(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        String stringInput;

        var Input = new TextField();
        Input.setLayoutX(600);
        Input.setLayoutY(400);
        var okBtn = setupButton(600,500, "Ok");

        //okBtn.setOnAction(e -> stringInput = Input.getText());
        okBtn.setOnAction(e-> {
            playSound(e);
            backToSTT(stage, group);
        } );

        group.getChildren().addAll(Input, okBtn);

    }

    private void backToSTT(Stage stage, Group group)
    {
        try {
            setScrabbleTypeScene(stage, group);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private void goToGetInput(Stage stage, Group group, ActionEvent e)
    {
        playSound(e);
        try {
            setScrabbleGetInputScene(stage, group);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private @NotNull Button setupButton(int x, int y, String myText) {
        var button = new Button("" + myText);
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