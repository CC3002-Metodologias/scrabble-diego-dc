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
    private String BinaryValue = "";
    private boolean viewEquationAsEquation;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Scrabble");

        group1 = new Group();
        backgroundGroup = new Group();
        group2 = new Group();

        String stylesheet = getClass().getResource("/Style.css").toExternalForm();
        String stylesheet2 = getClass().getResource("/Style2.css").toExternalForm();


        scene1 = new Scene(group1, 600, 600);
        scene2 = new Scene(backgroundGroup, 1000, 550);

        scene1.getStylesheets().addAll(stylesheet);
        scene2.getStylesheets().addAll(stylesheet2);
        // ---------Start Scene-----------


        setStartScene(stage, group1);

        // ---------Calculation scene---------

        // We set the background
        var background2 =
                new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background_calculator_yellow.jpg")));
        equationLabel.setPrefSize(900, 45);
        equationLabel.setLayoutX(50);
        equationLabel.setLayoutY(20);
        equationLabel.setId("result_label");
        // Then we just adjust group2
        backgroundGroup.getChildren().addAll(background2,equationLabel, group2);

        setStartCalculationScene(stage, group2);

        // -------- Display stage ----------

        stage.setScene(scene1);
        stage.show();
    }




    // ------------- Methods to set different Scenes(groups) ------------

    private void setStartScene(Stage stage, Group group) throws FileNotFoundException {

        var label = new Label("Scrabble");
        label.setLayoutX(200);
        label.setLayoutY(50);


        var background1 =
                new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background1.jpg")));
        background1.fitWidthProperty().bind(stage.widthProperty());
        background1.fitHeightProperty().bind(stage.heightProperty());

        var StartButton = setupButton(205, 520 , "START", "MYID", 200, 50);
        StartButton.setId("start_button");
        StartButton.setOnAction(e -> {
            playSound(e);
            stage.setScene(scene2);
        });

        group.getChildren().addAll(background1, StartButton, label);
    }

    private void setStartCalculationScene(Stage stage, Group group)
    {
        group.getChildren().clear();

        Button bt6 = operationSetupButton(300,475, "Add");
        Button bt7 = operationSetupButton(400,475, "Subtract");
        Button bt8 = operationSetupButton(500,475, "Multiply");
        Button bt9 = operationSetupButton(600,475, "Divide");
        Button bt10 = operationSetupButton(700,475, "Negate");
        Button bt11 = operationSetupButton(800,475, "AND");
        Button bt12 = operationSetupButton(900,475, "OR");

        Button bt13 = transformSetupButton(400,420, "toString");
        Button bt14 = transformSetupButton(500,420, "toBoolean");
        Button bt15 = transformSetupButton(600,420, "toFloat");
        Button bt16 = transformSetupButton(700,420, "toInt");
        Button bt17 = transformSetupButton(800,420, "toBinary");

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
        lb.setId("finalResult_label");
        lb.setLayoutX(380);
        lb.setLayoutY(125);

        Button bt1 = sttypeSetupButton(400,420, "String");
        Button bt2 = sttypeSetupButton(500,420, "Bool");
        Button bt3 = sttypeSetupButton(600,420, "Float");
        Button bt4 = sttypeSetupButton(700,420, "Int");
        Button bt5 = sttypeSetupButton(800,420, "Binary");

        Button bt6 = operationSetupButton(300,475, "Add");
        Button bt7 = operationSetupButton(400,475, "Subtract");
        Button bt8 = operationSetupButton(500,475, "Multiply");
        Button bt9 = operationSetupButton(600,475, "Divide");
        Button bt10 = operationSetupButton(700,475, "Negate");
        Button bt11 = operationSetupButton(800,475, "AND");
        Button bt12 = operationSetupButton(900,475, "OR");

        Button bt13 = transformSetupButton(400,365, "toString");
        Button bt14 = transformSetupButton(500,365, "toBoolean");
        Button bt15 = transformSetupButton(600,365, "toFloat");
        Button bt16 = transformSetupButton(700,365, "toInt");
        Button bt17 = transformSetupButton(800,365, "toBinary");

        Button calculateButton = setupButton( 525, 300, "CALCULATE", "calculate_button", 200, 50);
        Button clearButton = setupButton( 25, 435, "CLEAR", "clear_button", 85, 85);
        Button changeVisualisationBtn = setupButton( 800, 70, "View as an Equation", "changeView_button", 150, 30);

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

        bt13.setOnAction(e -> addOperatorAction(stage, group,e ,"toString") );
        bt14.setOnAction(e -> addOperatorAction(stage, group,e ,"toBoolean") );
        bt15.setOnAction(e -> addOperatorAction(stage, group,e ,"toFloat") );
        bt16.setOnAction(e -> addOperatorAction(stage, group,e ,"toInt") );
        bt17.setOnAction(e -> addOperatorAction(stage, group,e ,"toBinary") );


        calculateButton.setOnAction(e->{lb.setText(controller.getResult());});
        clearButton.setOnAction(e->{
            equationLabel.setText("");
            goToStartingButtons(stage, group, e);
        });
        changeVisualisationBtn.setOnAction(e->{
            playSound(e);
            changeView(changeVisualisationBtn);
        });

        checkCompleteEquation(calculateButton, group);

        group.getChildren().addAll(lb,changeVisualisationBtn, clearButton, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17);
    }

    private void setGetInputSceneForString(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        var Input = new TextField();
        Input.setPrefSize(500,50);
        Input.setLayoutX(425);
        Input.setLayoutY(250);
        var okBtn = setupButton(425,320, "Ok", "ok_button", 500, 70);

        okBtn.setOnAction(e-> {
            controller.addString(Input.getText());
            equationLabel.setText(controller.printEquation(viewEquationAsEquation));
            goToAllButtons(stage, group, e);
        } );

        group.getChildren().addAll(Input, okBtn);

    }

    private void setGetInputSceneForBoolean(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        var falseBtn = setupButton(450, 250, "FALSE", "false_button", 175, 175);
        var trueBtn = setupButton(700, 250, " TRUE", "true_button", 175, 175);

        falseBtn.setOnAction(e-> {
            controller.addBoolean(false);
            equationLabel.setText(controller.printEquation(viewEquationAsEquation));
            goToAllButtons(stage, group, e);
        } );

        trueBtn.setOnAction(e-> {
            controller.addBoolean(true);
            equationLabel.setText(controller.printEquation(viewEquationAsEquation));
            goToAllButtons(stage, group, e);
        } );

        group.getChildren().addAll(falseBtn, trueBtn);
    }

    private void setGetInputSceneForFloat(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        this.currentValue = "";

        var lbl = new Label("");
        lbl.setLayoutX(500);
        lbl.setLayoutY(150);

        var btn0 = calculatorSetupButton(600, 430, "0");
        var btn1 = calculatorSetupButton(450, 250, "1");
        var btn2 = calculatorSetupButton(600, 250, "2");
        var btn3 = calculatorSetupButton(750, 250, "3");
        var btn4 = calculatorSetupButton(450, 310, "4");
        var btn5 = calculatorSetupButton(600, 310, "5");
        var btn6 = calculatorSetupButton(750, 310, "6");
        var btn7 = calculatorSetupButton(450, 370, "7");
        var btn8 = calculatorSetupButton(600, 370, "8");
        var btn9 = calculatorSetupButton(750, 370, "9");
        var okBtn = calculatorSetupButton(750,430,"OK");
        var dotBtn = calculatorSetupButton(450, 430, ".");

        btn0.setOnAction(e -> number_click("0", lbl, e));
        btn1.setOnAction(e -> number_click("1", lbl, e));
        btn2.setOnAction(e -> number_click("2", lbl, e));
        btn3.setOnAction(e -> number_click("3", lbl, e));
        btn4.setOnAction(e -> number_click("4", lbl, e));
        btn5.setOnAction(e -> number_click("5", lbl, e));
        btn6.setOnAction(e -> number_click("6", lbl, e));
        btn7.setOnAction(e -> number_click("7", lbl, e));
        btn8.setOnAction(e -> number_click("8", lbl, e));
        btn9.setOnAction(e -> number_click("9", lbl, e));
        dotBtn.setOnAction(e -> number_click(".", lbl, e));

        okBtn.setOnAction(e-> {
            controller.addFloat(Double.parseDouble(this.currentValue));
            equationLabel.setText(controller.printEquation(viewEquationAsEquation));
            goToAllButtons(stage, group, e);
        } );

        group.getChildren().addAll(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, okBtn, dotBtn, lbl);
    }

    private void setGetInputSceneForInt(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        this.currentValue = "";

        var lbl = new Label("");
        lbl.setLayoutX(500);
        lbl.setLayoutY(150);

        var btn0 = calculatorSetupButton(600, 430, "0");
        var btn1 = calculatorSetupButton(450, 250, "1");
        var btn2 = calculatorSetupButton(600, 250, "2");
        var btn3 = calculatorSetupButton(750, 250, "3");
        var btn4 = calculatorSetupButton(450, 310, "4");
        var btn5 = calculatorSetupButton(600, 310, "5");
        var btn6 = calculatorSetupButton(750, 310, "6");
        var btn7 = calculatorSetupButton(450, 370, "7");
        var btn8 = calculatorSetupButton(600, 370, "8");
        var btn9 = calculatorSetupButton(750, 370, "9");
        var okBtn = calculatorSetupButton(750,430,"OK");


        btn0.setOnAction(e -> number_click("0", lbl, e));
        btn1.setOnAction(e -> number_click("1", lbl, e));
        btn2.setOnAction(e -> number_click("2", lbl, e));
        btn3.setOnAction(e -> number_click("3", lbl, e));
        btn4.setOnAction(e -> number_click("4", lbl, e));
        btn5.setOnAction(e -> number_click("5", lbl, e));
        btn6.setOnAction(e -> number_click("6", lbl, e));
        btn7.setOnAction(e -> number_click("7", lbl, e));
        btn8.setOnAction(e -> number_click("8", lbl, e));
        btn9.setOnAction(e -> number_click("9", lbl, e));

        okBtn.setOnAction(e-> {
            controller.addInt(Integer.parseInt(this.currentValue));
            equationLabel.setText(controller.printEquation(viewEquationAsEquation));
            goToAllButtons(stage, group, e);
        } );

        group.getChildren().addAll(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, okBtn, lbl);
    }

    private void setGetInputSceneForBinary(Stage stage, Group group) throws FileNotFoundException {
        group.getChildren().clear();

        BinaryValue = "";

        var WarningLabel = new Label("Insert a 32bit Binary as a String. Ex: '00000000000000000000000000000000'.");
        WarningLabel.setLayoutX(445);
        WarningLabel.setLayoutY(500);
        WarningLabel.setId("warning_label");

        var currentNum = new Label("");
        currentNum.setPrefSize(500,50);
        currentNum.setLayoutX(440);
        currentNum.setLayoutY(185);
        currentNum.setId("binary_label");

        var countLabel = new Label("CurrentBits: ");
        countLabel.setLayoutX(625);
        countLabel.setLayoutY(225);
        countLabel.setId("wrongCount_label");

        var num0 = setupButton(450,250, "0", "num0_button", 175, 175);
        var num1 = setupButton(700,250, "1", "num1_button", 175, 175);
        var okBtn = setupButton(420,435, "Ok", "ok_button", 500, 60);

        num0.setOnAction(e-> {
            playSound(e);
            BinaryValue = BinaryValue + "0";
            currentNum.setText(BinaryValue);
            checkBinaryCount(countLabel, BinaryValue.length());
        } );

        num1.setOnAction(e-> {
            playSound(e);
            BinaryValue = BinaryValue + "1";
            currentNum.setText(BinaryValue);
            checkBinaryCount(countLabel, BinaryValue.length());
        } );

        okBtn.setOnAction(e-> {
            controller.addBinary(BinaryValue);
            equationLabel.setText(controller.printEquation(viewEquationAsEquation));
            goToAllButtons(stage, group, e);
        } );

        group.getChildren().addAll(currentNum, num0, num1, okBtn, WarningLabel, countLabel);

    }






    // ------------------ Buttons Functionalities ----------------------------

    private void goToStartingButtons(Stage stage, Group group, ActionEvent e)
    {
        playSound(e);
        setStartCalculationScene(stage, group);
    }

    private void StartCalculation(Stage stage, Group group, ActionEvent e, String str)
    {
        playSound(e);

        controller.createCalc(str);
        equationLabel.setText(controller.printEquation(viewEquationAsEquation));

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
        equationLabel.setText(controller.printEquation(viewEquationAsEquation));
        goToAllButtons(stage, group, e);

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

    private void number_click(String myStr, Label lbl, ActionEvent e)
    {
        playSound(e);
        currentValue = currentValue + myStr;
        lbl.setText(currentValue);
    }

    private void checkBinaryCount(Label label, int length)
    {
        if(length > 32 || length < 32)
        {
            label.setId("wrongCount_label");
            label.setText("CurrentBits: " + length);
            return;
        }
        label.setId("correctCount_label");
        label.setText("CurrentBits: " + length);
    }

    private void changeView(Button btn)
    {
        if(viewEquationAsEquation)
        {
            viewEquationAsEquation = false;
            btn.setText("View as an Equation");
            equationLabel.setText(controller.printEquation(viewEquationAsEquation));
            return;
        }
        viewEquationAsEquation = true;
        btn.setText("View as Pseudo-Code");
        equationLabel.setText(controller.printEquation(viewEquationAsEquation));
    }

    private void checkCompleteEquation(Button btn, Group group)
    {
        if(controller.checkCompletedTree())
        {
            group.getChildren().add(btn);
            return;
        }
        group.getChildren().remove(btn);

    }



    // ----------------- Useful Methods for the App -------------------------

    private @NotNull Button setupButton(int x, int y, String myText, String myId, double v, double v1) {
        var button = new Button("" + myText);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefSize(v,v1);
        button.setFocusTraversable(false);
        button.setId(myId);
        return button;
    }

    private @NotNull Button operationSetupButton(int x, int y, String myText) {
        var button = new Button("" + myText);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefSize(90, 40);
        button.setFocusTraversable(false);
        button.setId("operation_button");
        return button;
    }

    private @NotNull Button transformSetupButton(int x, int y, String myText) {
        var button = new Button("" + myText);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefSize(90, 40);
        button.setFocusTraversable(false);
        button.setId("transform_button");
        return button;
    }

    private @NotNull Button sttypeSetupButton(int x, int y, String myText) {
        var button = new Button("" + myText);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefSize(90, 40);
        button.setFocusTraversable(false);
        button.setId("sttype_button");
        return button;
    }

    private @NotNull Button calculatorSetupButton(int x, int y, String myText) {
        var button = new Button("" + myText);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefSize(150, 50);
        button.setFocusTraversable(false);
        button.setId("calculator_button");
        return button;
    }


}