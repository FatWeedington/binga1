package btx.prog.one.rationalnumber;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorFxApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TextField num1 = createTextField();
        TextField den1 = createTextField();
        VBox vBoxleft = new VBox(num1,den1);

        Label operatorlbl = new Label("");
        operatorlbl.setPrefWidth(60);
        operatorlbl.setAlignment(Pos.CENTER);
        StackPane spOp = new StackPane(operatorlbl);

        TextField num2 = createTextField();
        TextField den2 = createTextField();
        VBox vBoxcenter = new VBox(num2,den2);

        Label equallbl = new Label("=");
        equallbl.setPrefWidth(60);
        equallbl.setAlignment(Pos.CENTER);
        StackPane spEq = new StackPane(equallbl);

        TextField num3 = createTextField();
        TextField den3 = createTextField();
        num3.setEditable(false);
        den3.setEditable(false);
        VBox vBoxRight = new VBox(num3,den3);

        Label lblError = new Label("Error: tried to Divide by 0");
        lblError.setVisible(false);
        HBox hBoxError = new HBox(lblError);
        hBoxError.setAlignment(Pos.BASELINE_CENTER);

        HBox hBoxTop = new HBox(vBoxleft,spOp,vBoxcenter,spEq,vBoxRight);
        hBoxTop.setAlignment(Pos.CENTER);


        num1.setOnKeyTyped(e->{
            operatorlbl.setText("");
            num3.setText("");
            den3.setText("");
            lblError.setVisible(false);
        });

        den1.setOnKeyTyped(e->{
            operatorlbl.setText("");
            num3.setText("");
            den3.setText("");
            lblError.setVisible(false);
        });

        num2.setOnKeyTyped(e->{
            operatorlbl.setText("");
            num3.setText("");
            den3.setText("");
            lblError.setVisible(false);
        });

        den2.setOnKeyTyped(e->{
            operatorlbl.setText("");
            num3.setText("");
            den3.setText("");
            lblError.setVisible(false);
        });

        Button addBtn = createBtn("+");
        addBtn.setOnAction(ẹ -> {
            try {
                num3.setText(String.valueOf(setButtonAction(num1, den1, num2, den2, 0).getNumerator()));
                den3.setText(String.valueOf(setButtonAction(num1, den1, num2, den2, 0).getDenominator()));
            }
            catch(ArithmeticException e){
                lblError.setVisible(true);
            }
            operatorlbl.setText("+");

        });
        Button subtractBtn = createBtn("-");
        subtractBtn.setOnAction(ẹ -> {
            try {
                num3.setText(String.valueOf(setButtonAction(num1, den1, num2, den2, 1).getNumerator()));
                den3.setText(String.valueOf(setButtonAction(num1, den1, num2, den2, 1).getDenominator()));
            }
            catch(ArithmeticException e){
                lblError.setVisible(true);
            }
            operatorlbl.setText("-");

        });
        Button multiplyBtn = createBtn("*");
        multiplyBtn.setOnAction(ẹ -> {
            try {
                num3.setText(String.valueOf(setButtonAction(num1, den1, num2, den2, 2).getNumerator()));
                den3.setText(String.valueOf(setButtonAction(num1, den1, num2, den2, 2).getDenominator()));
            }
            catch(ArithmeticException e){
                lblError.setVisible(true);
            }
            operatorlbl.setText("*");

        });
        Button divideBtn = createBtn(":");
        divideBtn.setOnAction(ẹ -> {
            try {
                num3.setText(String.valueOf(setButtonAction(num1, den1, num2, den2, 3).getNumerator()));
                den3.setText(String.valueOf(setButtonAction(num1, den1, num2, den2, 3).getDenominator()));
            }
            catch(ArithmeticException e){
                lblError.setVisible(true);
            }
            operatorlbl.setText(":");

        });

        HBox hBoxBottom= new HBox(addBtn,subtractBtn,multiplyBtn,divideBtn);
        hBoxBottom.setAlignment(Pos.BASELINE_CENTER);
        hBoxBottom.setSpacing(4);
        hBoxBottom.setPadding(new Insets(10,0,10,0));

        VBox vBoxMain = new VBox(hBoxTop,hBoxBottom,hBoxError);
        vBoxMain.setAlignment(Pos.CENTER);

        var scene = new Scene(vBoxMain, 300, 150);
        stage.setScene(scene);
        stage.setTitle("CalculatorApp");
        stage.show();
    }

    private static Button createBtn(String buttontext){
        Button b = new Button(buttontext);
        b.setPrefWidth(30);
        return b;
    }

    private static TextField createTextField(){
        TextField t = new TextField();
        t.setPrefWidth(50);
        return t;
    }

    private static RationalNumber setButtonAction(TextField num1,TextField den1, TextField num2, TextField den2, int operator) {
            RationalNumber r1 = new RationalNumber(Long.valueOf(num1.getText()), Long.valueOf(den1.getText()));
            RationalNumber r2 = new RationalNumber(Long.valueOf(num2.getText()), Long.valueOf(den2.getText()));

        switch (operator) {
            case 0:
                return r1.add(r2);
            case 1:
                return r1.subtract(r2);
            case 2:
                return r1.multiply(r2);
            case 3:
                return r1.divide(r2);
            default:
                return RationalNumber.ZERO;
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
