package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.controller.ScrabbleController;
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
    private ScrabbleController controller = new ScrabbleController();
    private Group group1;
    private Group backgroundGroup;
    private Group group2;
    private Scene scene1;
    private Scene scene2;
    private Label equationLabel = new Label("");
    private String currentValue = "";


    public static void main(String[] args) {
        launch();
    }

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
        equationLabel.setLayoutX(500);
        equationLabel.setLayoutY(50);
        // Then we just adjust group2
        backgroundGroup.getChildren().addAll(background2,equationLabel, group2);

        setStartCalculationScene(stage, group2);

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

    private void setStartCalculationScene(Stage stage, Group group)
    {
        group.getChildren().clear();

        Button bt6 = setupButton(300,450, "Add");
        Button bt7 = setupButton(400,450, "Subtract");
        Button bt8 = setupButton(500,450, "Multiply");
        Button bt9 = setupButton(600,450, "Divide");
        Button bt10 = setupButton(700,450, "Negate");
        Button bt11 = setupButton(800,450, "AND");
        Button bt12 = setupButton(900,450, "OR");

        Button bt13 = setupButton(400,400, "toString");
        Button bt14 = setupButton(500,400, "toBoolean");
        Button bt15 = setupButton(600,400, "toFloat");
        Button bt16 = setupButton(700,400, "toInt");
        Button bt17 = setupButton(800,400, "toBinary");

        bt6.setOnAction(e -> StartCalculation(stage,group,e,"+"));
        bt7.setOnAction(e -> StartCalculation(stage,group,e, "-"));
        bt8.setOnAction(e -> StartCalculation(stage,group,e,"*"));
        bt9.setOnAction(e -> StartCalculation(stage,group,e,"/"));
        bt10.setOnAction(e -> StartCalculation(stage,group,e,"~"));
        bt11.setOnAction(e -> StartCalculation(stage,group,e,"AND"));
        bt12.setOnAction(e -> StartCalculation(stage,group,e,"OR"));

        bt13.setOnAction(e -> StartCalculation(stage,group,e,"toString"));
        bt14.setOnAction(e -> StartCalculation(stage,group,e,"toBoolean"));
        bt15.setOnAction(e -> StartCalculation(stage,group,e,"toFloat"));
        bt16.setOnAction(e -> StartCalculation(stage,group,e,"toInt"));
        bt17.setOnAction(e -> StartCalculation(stage,group,e,"toBinary"));

        group.getChildren().addAll(bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17);
    }


    private void setScrabbleTypeScene(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        Label lb = new Label("");
        lb.setLayoutX(500);
        lb.setLayoutY(100);

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

        Button bt13 = setupButton(400,350, "toString");
        Button bt14 = setupButton(500,350, "toBoolean");
        Button bt15 = setupButton(600,350, "toFloat");
        Button bt16 = setupButton(700,350, "toInt");
        Button bt17 = setupButton(800,350, "toBinary");

        Button calculateButton = setupButton( 700, 200, "CALCULATE");

        bt1.setOnAction(e -> goToGetInputString(stage,group,e));
        bt2.setOnAction(e -> goToGetInputBoolean(stage,group,e));
        bt3.setOnAction(e -> goToGetInputFloat(stage,group,e));
        bt4.setOnAction(e -> goToGetInputInt(stage,group,e));
        bt5.setOnAction(e -> goToGetInputBinary(stage,group,e));

        bt6.setOnAction(e -> addOperatorAction(stage, group,e ,"+") );
        bt7.setOnAction(e -> addOperatorAction(stage, group,e ,"-") );
        bt8.setOnAction(e -> addOperatorAction(stage, group,e ,"*") );
        bt9.setOnAction(e -> addOperatorAction(stage, group,e ,"/") );
        bt10.setOnAction(e -> addOperatorAction(stage, group,e ,"~") );
        bt11.setOnAction(e -> addOperatorAction(stage, group,e ,"AND") );
        bt12.setOnAction(e -> addOperatorAction(stage, group,e ,"OR") );


        calculateButton.setOnAction(e->{lb.setText(controller.getResult());});

        group.getChildren().addAll(lb,calculateButton, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17);
    }

    private void setGetInputSceneForString(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        var Input = new TextField();
        Input.setLayoutX(600);
        Input.setLayoutY(400);
        var okBtn = setupButton(600,500, "Ok");

        okBtn.setOnAction(e-> {
            controller.addString(Input.getText());
            equationLabel.setText(controller.printEquation());
            goToAllButtons(stage, group, e);
        } );

        group.getChildren().addAll(Input, okBtn);

    }

    private void setGetInputSceneForBoolean(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        var falseBtn = setupButton(500, 300, "FALSE");
        var trueBtn = setupButton(700, 300, " TRUE");

        falseBtn.setOnAction(e-> {
            controller.addBoolean(false);
            equationLabel.setText(controller.printEquation());
            goToAllButtons(stage, group, e);
        } );

        trueBtn.setOnAction(e-> {
            controller.addBoolean(true);
            equationLabel.setText(controller.printEquation());
            goToAllButtons(stage, group, e);
        } );

        group.getChildren().addAll(falseBtn, trueBtn);
    }

    private void setGetInputSceneForFloat(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        this.currentValue = "";

        var lbl = new Label("");
        lbl.setLayoutX(600);
        lbl.setLayoutY(50);

        var btn0 = setupButton(600, 350, "0");
        var btn1 = setupButton(500, 200, "1");
        var btn2 = setupButton(600, 200, "2");
        var btn3 = setupButton(700, 200, "3");
        var btn4 = setupButton(500, 250, "4");
        var btn5 = setupButton(600, 250, "5");
        var btn6 = setupButton(700, 250, "6");
        var btn7 = setupButton(500, 300, "7");
        var btn8 = setupButton(600, 300, "8");
        var btn9 = setupButton(700, 300, "9");
        var okBtn = setupButton(700,350,"OK");
        var dotBtn = setupButton(500, 350, ".");

        btn0.setOnAction(e -> number_click("0", lbl));
        btn1.setOnAction(e -> number_click("1", lbl));
        btn2.setOnAction(e -> number_click("2", lbl));
        btn3.setOnAction(e -> number_click("3", lbl));
        btn4.setOnAction(e -> number_click("4", lbl));
        btn5.setOnAction(e -> number_click("5", lbl));
        btn6.setOnAction(e -> number_click("6", lbl));
        btn7.setOnAction(e -> number_click("7", lbl));
        btn8.setOnAction(e -> number_click("8", lbl));
        btn9.setOnAction(e -> number_click("9", lbl));
        dotBtn.setOnAction(e -> number_click(".", lbl));

        okBtn.setOnAction(e-> {
            controller.addFloat(Double.parseDouble(this.currentValue));
            equationLabel.setText(controller.printEquation());
            goToAllButtons(stage, group, e);
        } );

        group.getChildren().addAll(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, okBtn, dotBtn, lbl);
    }

    private void setGetInputSceneForInt(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        this.currentValue = "";

        var lbl = new Label("");
        lbl.setLayoutX(600);
        lbl.setLayoutY(50);

        var btn0 = setupButton(600, 350, "0");
        var btn1 = setupButton(500, 200, "1");
        var btn2 = setupButton(600, 200, "2");
        var btn3 = setupButton(700, 200, "3");
        var btn4 = setupButton(500, 250, "4");
        var btn5 = setupButton(600, 250, "5");
        var btn6 = setupButton(700, 250, "6");
        var btn7 = setupButton(500, 300, "7");
        var btn8 = setupButton(600, 300, "8");
        var btn9 = setupButton(700, 300, "9");
        var okBtn = setupButton(700,350,"OK");

        btn0.setOnAction(e -> number_click("0", lbl));
        btn1.setOnAction(e -> number_click("1", lbl));
        btn2.setOnAction(e -> number_click("2", lbl));
        btn3.setOnAction(e -> number_click("3", lbl));
        btn4.setOnAction(e -> number_click("4", lbl));
        btn5.setOnAction(e -> number_click("5", lbl));
        btn6.setOnAction(e -> number_click("6", lbl));
        btn7.setOnAction(e -> number_click("7", lbl));
        btn8.setOnAction(e -> number_click("8", lbl));
        btn9.setOnAction(e -> number_click("9", lbl));

        okBtn.setOnAction(e-> {
            controller.addInt(Integer.parseInt(this.currentValue));
            equationLabel.setText(controller.printEquation());
            goToAllButtons(stage, group, e);
        } );

        group.getChildren().addAll(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, okBtn, lbl);
    }

    private void setGetInputSceneForBinary(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        var WarningLabel = new Label("Insert a 32bit Binary as a String. Ex: '00000000000000000000000000000000'.");
        WarningLabel.setLayoutX(600);
        WarningLabel.setLayoutY(350);

        var Input = new TextField();
        Input.setLayoutX(600);
        Input.setLayoutY(400);
        var okBtn = setupButton(600,500, "Ok");

        okBtn.setOnAction(e-> {
            controller.addBinary(Input.getText());
            equationLabel.setText(controller.printEquation());
            goToAllButtons(stage, group, e);
        } );

        group.getChildren().addAll(Input, okBtn, WarningLabel);

    }






    private void goToStartingButtons(Stage stage, Group group, ActionEvent e)
    {
        playSound(e);
        setStartCalculationScene(stage, group);
    }

    private void StartCalculation(Stage stage, Group group, ActionEvent e, String str)
    {
        playSound(e);

        controller.createCalc(str);
        equationLabel.setText(controller.printEquation());

        try {
            setScrabbleTypeScene(stage, group);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private void goToAllButtons(Stage stage, Group group, ActionEvent e)
    {
        playSound(e);
        try {
            setScrabbleTypeScene(stage, group);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }


    private void goToGetInputString(Stage stage, Group group, ActionEvent e)
    {
        playSound(e);
        try {
            setGetInputSceneForString(stage, group);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private void goToGetInputBoolean(Stage stage, Group group, ActionEvent e)
    {
        playSound(e);
        try {
            setGetInputSceneForBoolean(stage, group);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private void goToGetInputInt(Stage stage, Group group, ActionEvent e)
    {
        playSound(e);
        try {
            setGetInputSceneForInt(stage, group);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private void goToGetInputFloat(Stage stage, Group group, ActionEvent e)
    {
        playSound(e);
        try {
            setGetInputSceneForFloat(stage, group);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private void goToGetInputBinary(Stage stage, Group group, ActionEvent e)
    {
        playSound(e);
        try {
            setGetInputSceneForBinary(stage, group);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private void addOperatorAction(Stage stage, Group group, ActionEvent e, String str)
    {
        controller.addOperator(str);
        goToAllButtons(stage, group, e);
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

    private void number_click(String myStr, Label lbl)
    {

        currentValue = currentValue + myStr;
        lbl.setText(currentValue);
    }


}