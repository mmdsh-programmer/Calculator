package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String num,operator,history,tmp;
    TextView show_result;
    TextView show_main_result;
    double first,second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_result = findViewById(R.id.result);
        show_main_result = findViewById(R.id.mainResult);
        num="";
        history="";
        operator = "";
        second = 0;
    }

    public void checkOperator(){
        if (operator == "+"){
            second += first;
        }
        else if (operator == "-"){
            second -= first;
        }
        else if(operator == "*"){
            second *= first;
        }
        else if (operator == "/"){
            second /= first;
        }
    }

    public void onClick(View view){
        Button button = (Button) view;
        num = show_main_result.getText().toString();
        num += button.getText().toString();
        show_main_result.setText(num);
        first = Double.parseDouble(num);
    }

    public void onSum(View view){
        if (show_main_result.getText().toString().length() != 0) {
            if (operator == "") {
                second += first;
            } else {
                checkOperator();
            }
            operator = "+";
            history += num + " + ";
            show_result.setText(history);
            num = "";
            show_main_result.setText("");
        }
        else{
            Toast err = Toast.makeText(getApplicationContext() , R.string.err , Toast.LENGTH_SHORT);
            err.show();
        }
    }

    public void onMinus(View view){
        if (show_main_result.getText().toString().length() != 0) {
            if (operator == "") {
                second = Double.parseDouble(show_main_result.getText().toString());
            } else {
                checkOperator();
            }
            operator = "-";
            history += num + " - ";
            show_result.setText(history);
            num = "";
            show_main_result.setText("");
        }
        else{
            Toast err = Toast.makeText(getApplicationContext() , R.string.err , Toast.LENGTH_SHORT);
            err.show();
        }
    }

    public void onMultiply(View view){
        if (show_main_result.getText().toString().length() != 0) {
            if (operator == "") {
                second = Double.parseDouble(show_main_result.getText().toString());
            } else {
                checkOperator();
            }
            operator = "*";
            history += num + " * ";
            show_result.setText(history);
            num = "";
            show_main_result.setText("");
        }
        else{
            Toast err = Toast.makeText(getApplicationContext() , R.string.err , Toast.LENGTH_SHORT);
            err.show();
        }
    }

    public void onDivide(View view){
        if (show_main_result.getText().toString().length() != 0) {
            if (operator == "") {
                second = Double.parseDouble(show_main_result.getText().toString());
            } else {
                checkOperator();
            }
            operator = "/";
            history += num + " / ";
            show_result.setText(history);
            num = "";
            show_main_result.setText("");
        }
        else{
            Toast err = Toast.makeText(getApplicationContext() , R.string.err , Toast.LENGTH_SHORT);
            err.show();
        }
    }

    public void onEqual(View view){
        checkOperator();
        show_result.setText(history + first + " = ");
        show_main_result.setText(Double.toString(second));
        operator="";
        first = 0;
    }

    public void onClear(View view){
        first = second = 0;
        operator = "";
        history ="";
        num = "";
        show_result.setText("");
        show_main_result.setText("");
    }

    public void onDot(View view){
        if (show_main_result.getText().toString().length() > 0)
        {
            if ( show_main_result.getText().toString().contains(".")){
                Toast dot_err = Toast.makeText(getApplicationContext() , R.string.dot_err , Toast.LENGTH_SHORT);
                dot_err.show();
            }
            else{
                show_main_result.setText(show_main_result.getText().toString() + ".");
                num += ".";
            }
        }
        else{
            show_main_result.setText(show_main_result.getText().toString() + "0.");
            num += "0.";
        }
    }

    public void onBack(View view){
        if (show_main_result.getText().toString().length() > 1){
            tmp = show_main_result.getText().toString().substring(0, show_main_result.getText().toString().length() - 1);
            show_main_result.setText(tmp);
            num = tmp;
            first = Double.parseDouble(tmp);
        }
        else if (show_main_result.getText().toString().length() == 1){
            show_main_result.setText("");
        }
        else{
            Toast back_err = Toast.makeText(getApplicationContext() , R.string.back_err , Toast.LENGTH_SHORT);
            back_err.show();
        }
    }
}
