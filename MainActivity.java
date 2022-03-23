package com.ayeikurot.myseccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private enum OPERATOR {
        PLUS, SUBSTRACTION, MULTIPLY, DIVIDE, EQUAL;
    }

    TextView txtResult;
    TextView txtCalculations;

    // Instance Variable
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationResult;
    private String calculationString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationResult = 0;
        calculationString = "";

        // Initialization
        txtResult = findViewById(R.id.txtResult);
        txtCalculations = findViewById(R.id.txtCalculations);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSubstract).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnAddition).setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btnDivide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationString += " / ";
                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationString += " * ";
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btnSubstract:
                operatorIsTapped(OPERATOR.SUBSTRACTION);
                calculationString += " - ";
                break;
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btnClear:
                clearTapped();
                break;
            case R.id.btnEqual:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.btnAddition:
                operatorIsTapped(OPERATOR.PLUS);
                calculationString += " + ";
                break;

        }
        txtCalculations.setText(calculationString);
    }

    private void numberIsTapped(int tappedNumber) {
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResult.setText(currentNumber);
        calculationString = currentNumber;
        txtCalculations.setText(calculationString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator) {
        if (currentOperator != null) {

            if (currentNumber != ""){
            stringNumberAtRight = currentNumber;
            currentNumber = "";

            switch (currentOperator) {
                case PLUS:
                    calculationResult = Integer.parseInt(stringNumberAtLeft) +
                            Integer.parseInt(stringNumberAtRight);
                    break;
                case SUBSTRACTION:
                    calculationResult = Integer.parseInt(stringNumberAtLeft) -
                            Integer.parseInt(stringNumberAtRight);
                    break;
                case DIVIDE:
                    calculationResult = Integer.parseInt(stringNumberAtLeft) /
                            Integer.parseInt(stringNumberAtRight);
                    break;
                case MULTIPLY:
                    calculationResult = Integer.parseInt(stringNumberAtLeft) *
                            Integer.parseInt(stringNumberAtRight);
                    break;

            }

            stringNumberAtLeft = String.valueOf(calculationResult);
            txtResult.setText(stringNumberAtLeft);
            txtCalculations.setText(stringNumberAtLeft);
        }
        }
        else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }

    private void clearTapped() {
        stringNumberAtRight = "";
        stringNumberAtLeft = "";
        currentNumber = "";
        calculationResult = 0;
        calculationString = "";
        currentOperator = null;
        txtCalculations.setText("0");
        txtResult.setText("");
    }
}
