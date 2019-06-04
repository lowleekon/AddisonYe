package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.util.ArrayList;
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptEngine;
//import javax.script.ScriptException;

public class Controller {
    public Label display;
    private String temp = "";
    private ArrayList<Double> numeros = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();

    public void pressSeven(ActionEvent actionEvent) {
        temp += 7;
        display.setText(display.getText() + "7");
    }

    public void pressEight(ActionEvent actionEvent) {
        temp += 8;
        display.setText(display.getText() + "8");
    }

    public void pressNine(ActionEvent actionEvent) {
        temp += 9;
        display.setText(display.getText() + "9");
    }

    public void pressFour(ActionEvent actionEvent) {
        temp += 4;
        display.setText(display.getText() + "4");
    }

    public void pressFive(ActionEvent actionEvent) {
        temp += 5;
        display.setText(display.getText() + "5");
    }

    public void pressSix(ActionEvent actionEvent) {
        temp += 6;
        display.setText(display.getText() + "6");
    }

    public void pressOne(ActionEvent actionEvent) {
        temp += 1;
        display.setText(display.getText() + "1");
    }

    public void pressTwo(ActionEvent actionEvent) {
        temp += 2;
        display.setText(display.getText() + "2");
    }

    public void pressThree(ActionEvent actionEvent) {
        temp += 3;
        display.setText(display.getText() + "3");
    }

    public void pressPlus(ActionEvent actionEvent) {
        operators.add("+");
        numeros.add(Double.valueOf(temp));
        temp = "";
        display.setText(display.getText() + "+");
    }

    public void pressZero(ActionEvent actionEvent) {
        temp += 0;
        display.setText(display.getText() + "0");
    }

    public void pressMinus(ActionEvent actionEvent) {
        operators.add("-");
        numeros.add(Double.valueOf(temp));
        temp = "";
        display.setText(display.getText() + "-");
    }

    public void pressMultiply(ActionEvent actionEvent) {
        operators.add("*");
        numeros.add(Double.valueOf(temp));
        temp = "";
        display.setText(display.getText() + "*");
    }

    public void pressDivide(ActionEvent actionEvent) {
        operators.add("/");
        numeros.add(Double.valueOf(temp));
        temp = "";
        display.setText(display.getText() + "/");
    }

    public void pressClear(ActionEvent actionEvent) {
        String temp = "";
        display.setText("");
        numeros = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public void pressDecimal(ActionEvent actionEvent) {
        temp += ".";
        display.setText(display.getText() + ".");
    }

    public void pressEqual(ActionEvent actionEvent) {
        /*ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String infix = display.getText();
        try {
            display.setText(engine.eval(infix).toString());
        }catch(ScriptException e){
            e.printStackTrace();
        }*/
        numeros.add(Double.valueOf(temp));
        temp = "";
        ArrayList<Integer> pos = new ArrayList<>();
        for (String s: operators){
            if (s.equals("*") | s.equals("/")){
                pos.add(operators.indexOf(s));
            }
        }
        for (Integer po : pos) {
            double temp = 0;
            switch (operators.get(po)) {
                case "*":
                    temp = numeros.get(po) * numeros.get(po + 1);
                    break;
                case "/":
                    temp = numeros.get(po) / numeros.get(po + 1);
                    break;
            }
            numeros.remove((int)po);
            numeros.remove((int)po);
            operators.remove((int)po);
            numeros.add(temp);
            operators.add("+");
        }
        double answer = numeros.get(0);
        for (int i = 1; i < numeros.size(); i ++){
            switch (operators.get(i - 1)) {
                case "+":
                    answer += numeros.get(i);
                    break;
                case "-":
                    answer -= numeros.get(i);
                    break;
            }
        }
        display.setText(String.valueOf(answer));
    }
}
