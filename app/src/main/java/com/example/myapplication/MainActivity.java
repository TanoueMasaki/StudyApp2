package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","HelloWorld");
        TextView doroid = findViewById(R.id.textView);
        String text = "1+2";
        doroid.setText(text);


        Button button = findViewById(R.id.button);
//        リスナーを定義する
        button.setOnClickListener(new View.OnClickListener() {
            //        リスナーの中身
            @Override
            public void onClick(View view) {
                Log.d("MainActivity","Clicked!");
                //文字カラーを変更する
                doroid.setTextColor(Color.parseColor("#FF0000"));
                //文字フォントを変更する
                doroid.setTypeface(Typeface.DEFAULT_BOLD);
                //エディットテキストを取得する
                EditText editText = findViewById(R.id.editText);
                //エディットテキスト内のテキストを取得して文字列型に変換、変数に代入する
                String editText2 = editText.getText().toString();
                //doroid変数にeditText2をセットする
                doroid.setText(editText2);
            }
        });
        /*画面を遷移させる*/
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,CalcPage.class);
                startActivity(intent);

            }
        });
    }
}