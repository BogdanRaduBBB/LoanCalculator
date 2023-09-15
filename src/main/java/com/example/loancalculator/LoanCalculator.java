package com.example.loancalculator;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoanCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Text tInvestmentAmount = new Text("Investment Amount: ");
        Text tNumberOfYears = new Text("Number of Years: ");
        Text tAnnualInterestRate = new Text("Annual Interest Rate: ");
        Text tFutureValue = new Text("Future Value: ");

        TextField tfInvestmentAmount = new TextField();
        TextField tfNumberOfYears = new TextField();
        TextField tfAnnualInterestRate = new TextField();
        TextField tfFutureValue = new TextField();
        tfFutureValue.setEditable(false);

        Button btCalculate = new Button("Calculate");
        btCalculate.setOnAction(event -> {
            double a = getDoubleFromTextField(tfInvestmentAmount);
            double b = getDoubleFromTextField(tfAnnualInterestRate)/1200;
            double c = getDoubleFromTextField(tfNumberOfYears)*12;
            tfFutureValue.setText(String.format("$%.2f", a*Math.pow(1+b,c)));
        });

        GridPane pane = new GridPane();
        pane.addRow(0,tInvestmentAmount,tfInvestmentAmount);
        pane.addRow(1,tNumberOfYears, tfNumberOfYears);
        pane.addRow(2,tAnnualInterestRate,tfAnnualInterestRate);
        pane.addRow(3,tFutureValue,tfFutureValue);
        pane.add(btCalculate,1,4);
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        stage.setTitle("Loan Calculator");
        stage.setScene(scene);
        stage.show();

    }

    private static double getDoubleFromTextField(TextField t) {
        return Double.parseDouble(t.getText());
    }

    public static void main(String[] args) {
        launch();
    }
}