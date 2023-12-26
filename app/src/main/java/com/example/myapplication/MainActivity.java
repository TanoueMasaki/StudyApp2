package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //フィールド定義
    int initialVal = 0;
    int finalVal = 0;
    int ope = 0;

    public void setInitialVal(int value){
        this.initialVal = value;
    }
    public void setFinalVal(int value){
        this.finalVal = value;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //たし算ボタンが押されたら
        Button buAddition = findViewById(R.id.buAddition);
        buAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //文字カラーを変更する
                //doroid.setTextColor(Color.parseColor("#FF0000"));
                //文字フォントを変更する
                //doroid.setTypeface(Typeface.DEFAULT_BOLD);
                //エディットテキストを取得する

                //エディットテキスト内のテキストを取得して文字列型に変換、変数に代入する
                //String editText2 = editText.getText().toString();

            }
        });

        //スタートボタンが押されたら
        Button buStart = findViewById(R.id.buStart);
        buStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalcPage.class);
                startActivity(intent);

                //initialValを取得してフィールドに代入
                EditText initialVal = findViewById(R.id.initialVal);
                String initialValStr = initialVal.getText().toString();
                int initialValInt = Integer.parseInt(initialValStr);
                setInitialVal(initialValInt);
                //finalValを取得してフィールドに代入
                EditText finalVal = findViewById(R.id.finalVal);
                String finalValStr = finalVal.getText().toString();
                int finalValInt = Integer.parseInt(finalValStr);
                setFinalVal(finalValInt);
            }
        });
    }
    
}