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

import java.util.ArrayList;
import java.util.Objects;

public class CalcPage extends AppCompatActivity {
    //インスタンス化する
    Calculation calc = new Calculation();
    SetCalc setCalc = new SetCalc();

    //数値の範囲を決定する
    //初期値から最終値までをarraySetに引数として渡す
    //引数はユーザーが決めれるようにする
    ArrayList<Integer> array = setCalc.arraySet(1,3);

    //解答結果を入れる配列を用意する
    String[][] result = new String[5][array.size() * array.size()];

    //演算選択に必要
    private int ope = 0;
    public void setOpe(int ope){
        this.ope = ope;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_page);

        switch(ope) {
            case 1:
                result = calc.calcDecision(array, SetCalc.Operator.addition);
                break;
            case 2:
                result = calc.calcDecision(array, SetCalc.Operator.subtraction);
                break;
            case 3:
                result = calc.calcDecision(array, SetCalc.Operator.multiplication);
                break;
            case 4:
                result = calc.calcDecision(array, SetCalc.Operator.division);
                break;
        }

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