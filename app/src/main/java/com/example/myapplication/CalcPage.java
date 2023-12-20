package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import com.example.study.Calculation.*;

import java.util.Objects;

public class CalcPage extends AppCompatActivity {

    int l =1;
    int r =1;

    //インスタンス化する
    Calculation calc = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_page);

        leftValue(l);
        rightValue(r);

        /*判定ボタン*/
        Button hantei1 = findViewById(R.id.hantei1);
        hantei1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calc.addition();
                int answer = calc.answer;

                EditText edNum1 = findViewById(R.id.edNum1);
                int i = edNum1.length();

                //Object.nonNull()だと上手くいかない
                if (i != 0) {
                    String edNum1_1 = edNum1.getText().toString();
                    //↑String edNum1_1 = String.valueOf(edNum1);だとエラーになる
                    int edNum1_2 = Integer.parseInt(edNum1_1);

                    if (edNum1_2 == answer) {
                        System.out.println("正解");
                        addLeftRight();
                        edNum1.setText(null);
                    } else {
                        System.out.println("不正解");
                        addLeftRight();
                        edNum1.setText(null);
                    }

                    leftValue(l);
                    rightValue(r);

                } else {
                    System.out.println("入力して下さい");
                }
            }
        });

        /*トップに戻るボタン*/
        Button buttonFinish = findViewById(R.id.buttonFinish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void leftValue(int l) {

        calc.leftValueSet(l);
        int left = calc.leftValue;

        int leftValueInt = left;
        String leftValueStr = String.valueOf(leftValueInt);
        TextView leftValue = findViewById(R.id.leftValue);
        leftValue.setText(leftValueStr);
    }
    public void rightValue(int r) {

        calc.rightValueSet(r);
        int right = calc.rightValue;

        int rightValueInt = right;
        String rightValueStr = String.valueOf(rightValueInt);
        TextView rightValue = findViewById(R.id.rightValue);
        rightValue.setText(rightValueStr);
    }
    public void addLeftRight(){
        if (r < 9) {
            r++;
        } else if(l < 9) {
            l++;
            r = 1;
        } else {
            System.out.println("計算を終了します");
            finish();
        }
    }
}