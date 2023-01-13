package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textResult;
    Button btnAC;
    Button btnPlusMinus;
    Button btnPercentage;
    Button btnSplit;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnX;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btnMinus;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btnPlus;
    Button btnZero;
    Button btnPoint;
    Button btnResult;
    Float value = null;
    Float resultValue = null;
    Boolean valuePoint;
    Boolean newString = Boolean.FALSE;
    Operation operationValue = null;
    String textValue;

    public static enum Operation {
        SPLIT,
        X,
        MINUS,
        PLUS
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // найдем View-элементы
        textResult = (TextView) findViewById(R.id.resultText);
        btnAC = (Button) findViewById(R.id.buttonAC);
        btnPlusMinus = (Button) findViewById(R.id.buttonPlusMinus);
        btnPercentage = (Button) findViewById(R.id.buttonPercentage);
        btnSplit = (Button) findViewById(R.id.buttonSplit);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btnX = (Button) findViewById(R.id.buttonX);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btnMinus = (Button) findViewById(R.id.buttonMinus);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnZero = (Button) findViewById(R.id.buttonZero);
        btnPoint = (Button) findViewById(R.id.buttonPoint);
        btnResult = (Button) findViewById(R.id.buttonResult);

        // создание обработчика
        View.OnClickListener oclBtnFigure = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = ((Button)v).getText().toString();
                if (valuePoint == Boolean.TRUE) {
                    textResult.setText(textResult.getText().toString() + ".");
                    valuePoint = Boolean.FALSE;
                }
                if (textResult.getText().equals("0")||(newString == Boolean.TRUE))
                    textResult.setText("");
                textResult.setText(textResult.getText() + t);
                newString = Boolean.FALSE;
            }
        };

        btn1.setOnClickListener(oclBtnFigure);
        btn2.setOnClickListener(oclBtnFigure);
        btn3.setOnClickListener(oclBtnFigure);
        btn4.setOnClickListener(oclBtnFigure);
        btn5.setOnClickListener(oclBtnFigure);
        btn6.setOnClickListener(oclBtnFigure);
        btn7.setOnClickListener(oclBtnFigure);
        btn8.setOnClickListener(oclBtnFigure);
        btn9.setOnClickListener(oclBtnFigure);
        btnZero.setOnClickListener(oclBtnFigure);

        View.OnClickListener oclBtnOperation = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonAC:
                        value = null;
                        operationValue = null;
                        textResult.setText("0");
                        break;
                    case R.id.buttonPlusMinus:
                        if (textResult.getText().toString().charAt(0)=='-'){
                            textResult.setText(textResult.getText().toString().replace("-", ""));
                        }
                        else {
                            textResult.setText("-" +textResult.getText().toString());
                        };
//                        System.out.println(Float.parseFloat(textResult.getText().toString()));
                        break;
                    case R.id.buttonPercentage:
                        textResult.setText(String.valueOf(Float.parseFloat(textResult.getText().toString())/100));
                        break;
                    case R.id.buttonPoint:
                        if (textResult.getText().toString().contains(".")) break;
                            else valuePoint = Boolean.TRUE;
                        break;
                    case R.id.buttonSplit:
                        if (value == null) break;
                        else{
                            value = Float.parseFloat(textResult.getText().toString());
                            operationValue = Operation.SPLIT;
                            newString = Boolean.TRUE;
                            break;
                        }
                    case R.id.buttonX:
                        if (value == null) break;
                        else{
                            value = Float.parseFloat(textResult.getText().toString());
                            operationValue = Operation.X;
                            newString = Boolean.TRUE;
                            break;
                        }
                    case R.id.buttonMinus:
                        if (value == null) break;
                        else{
                            value = Float.parseFloat(textResult.getText().toString());
                            operationValue = Operation.MINUS;
                            newString = Boolean.TRUE;
                            break;
                        }
                    case R.id.buttonPlus:
                        value = Float.parseFloat(textResult.getText().toString());
                        operationValue = Operation.PLUS;
                        newString = Boolean.TRUE;
                            break;
                }

            }
        };

        btnAC.setOnClickListener(oclBtnOperation);
        btnPlusMinus.setOnClickListener(oclBtnOperation);
        btnPercentage.setOnClickListener(oclBtnOperation);
        btnPoint.setOnClickListener(oclBtnOperation);
        btnSplit.setOnClickListener(oclBtnOperation);
        btnX.setOnClickListener(oclBtnOperation);
        btnMinus.setOnClickListener(oclBtnOperation);
        btnPlus.setOnClickListener(oclBtnOperation);

        View.OnClickListener oclBtnResult = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float value2 = Float.parseFloat(textResult.getText().toString());
                Float result = null;
                switch (operationValue){
                    case MINUS:
                        result = value - value2;
                        break;
                    case PLUS:
                        result = value + value2;
                        break;
                    case SPLIT:
                        result = value/value2;
                        break;
                    case X:
                        result = value*value2;
                        break;
                }
                value = result;
                operationValue = null;
                textResult.setText(result.toString());

            }
        };

        btnResult.setOnClickListener(oclBtnResult);

    }
}