package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication.SetCalc.Operator;
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
    //解答を取得して格納用
    private int answer;
    public int getAnswer(){
        return this.answer;
    }
    public void setAnswer(int ans){
        this.answer = ans;
    }
    //正誤判定後に○×を表示させる
    public void setJudgment(String judgment){
        TextView setJudgment = findViewById(R.id.judgment);
        setJudgment.setText(judgment);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_page);
        switch(ope) {
            case 1:
                result = calc.calcDecision(array, Operator.addition);
                break;
            case 2:
                result = calc.calcDecision(array, Operator.subtraction);
                break;
            case 3:
                result = calc.calcDecision(array, Operator.multiplication);
                break;
            case 4:
                result = calc.calcDecision(array, Operator.division);
                break;
        }
        /*判定ボタン*/
        Button hantei1 = findViewById(R.id.hantei1);
        hantei1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView ans = findViewById(R.id.answer);
                String ansStr = ans.getText().toString();
                setAnswer(Integer.parseInt(ansStr));
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
}