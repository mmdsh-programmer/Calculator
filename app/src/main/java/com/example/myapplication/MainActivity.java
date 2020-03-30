package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String num,operator,history;
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

    public void onClick(View view){
        Button button = (Button) view;
        num+= button.getText().toString();
        show_main_result.setText(num);
        first = Double.parseDouble(num);
    }

    public void onSum(View view){
        if (operator == ""){
            second = first;
        }
        else{
            if (operator == "+"){
                second += first;
            }
            else if (operator == "-")
            {
                second-= first;
            }
            else if(operator == "*")
            {
                second *= first;
            }
            else if (operator == "/")
            {
                second /= first;
            }
        }
        operator="+";
        history += num + "+";
        show_result.setText(history);
        num="";
        show_main_result.setText("");
    }

    public void onMinus(View view){
        if (operator == ""){
            second = first;
        }
        else{
            if (operator == "+"){
                second += first;
            }
            else if (operator == "-")
            {
                second-= first;
            }
            else if(operator == "*")
            {
                second *= first;
            }
            else if (operator == "/")
            {
                second /= first;
            }
        }
        operator="-";
        history += num + "-";
        show_result.setText(history);
        num="";
        show_main_result.setText("");
    }

    public void onMultiply(View view){
        if (operator == ""){
            second = first;
        }
        else{
            if (operator == "+"){
                second += first;
            }
            else if (operator == "-")
            {
                second-= first;
            }
            else if(operator == "*")
            {
                second *= first;
            }
            else if (operator == "/")
            {
                second /= first;
            }
        }
        operator="*";
        history += num + "*";
        show_result.setText(history);
        num="";
        show_main_result.setText("");
    }

    public void onDivide(View view){
        if (operator == ""){
            second = first;
        }
        else{
            if (operator == "+"){
                second += first;
            }
            else if (operator == "-")
            {
                second-= first;
            }
            else if(operator == "*")
            {
                second *= first;
            }
            else if (operator == "/")
            {
                second /= first;
            }
        }
        operator="/";
        history += num + "/";
        show_result.setText(history);
        num="";
        show_main_result.setText("");
    }

    public void onEqual(View view){
        if (operator == "+"){
            second += first;
        }
        else if (operator == "-")
        {
            second-= first;
        }
        else if(operator == "*")
        {
            second *= first;
        }
        else if (operator == "/")
        {
            second /= first;
        }
        show_result.setText(history + first + "=");
        show_main_result.setText(Double.toString(second));
    }
}
