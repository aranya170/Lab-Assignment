package com.example.demo4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button closeButton;
    @FXML
    private TextField field;
    @FXML
    private Label label;
    @FXML
    protected void binaryCon() {
        try {
            String m = field.getText();
            int n = Integer.parseInt(m);
            int[] binaryNum = new int[32];
            int i = 0;
            while (n > 0) {
                binaryNum[i] = n % 2;
                n = n / 2;
                i++;
            }
            int p = 0;
            for (int j = i - 1; j >= 0; j--)
                p = p*10+binaryNum[j];
            label.setText(Integer.toString(p));
        }
        catch (NumberFormatException e){
            try {
                String m = field.getText();
                double number = Double.parseDouble(m);
                label.setText("No Input Given");
            }catch (NumberFormatException e2){
                label.setText("Not a Number!");
            }
        }
    }
    @FXML
    protected void hexaCon() {
        String m = field.getText();
        try {
            int decimal = Integer.parseInt(m);
            int rem;
            int temp = (int) decimal;
            String hex = "";
            char hexchars[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            while (decimal > 0) {
                rem = decimal % 16;
                hex = hexchars[rem] + hex;
                decimal = decimal / 16;
            }
            label.setText(hex);
        }
        catch (NumberFormatException e)
        {
            try {
                double number = Double.parseDouble(m);
                label.setText("No Input Given");
            }catch (NumberFormatException e2){
                label.setText("Not a Number!");
            }
        }
    }
    @FXML
    protected void octalCon() {
        try {
            String m = field.getText();
            int decimal = Integer.parseInt(m);
            int rem;
            String octal="";
            char octalchars[]={'0','1','2','3','4','5','6','7'};
            while(decimal>0)
            {
                rem=decimal%8;
                octal=octalchars[rem]+octal;
                decimal=decimal/8;
            }
            label.setText(octal);
        }catch (NumberFormatException e){
            try {
                String m = field.getText();
                double number = Double.parseDouble(m);
                label.setText("No Input Given");
            }catch (NumberFormatException e2){
                label.setText("Not a Number!");
            }
        }
    }
    @FXML
    protected void exit() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    protected void nextScreen(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        Parent scene2 = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene displayScene = new Scene(scene2);
        Stage window = (Stage)((Node)(event.getSource())).getScene().getWindow();
        window.setScene(displayScene);
        window.show();
    }
}