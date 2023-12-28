package com.example.myapplication;

import java.awt.Button;
import java.awt.Color;

import javax.swing.text.View;

import com.example.myapplication.Calculation.Operator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //フィールド定義
    private int initialVal = 0;
    private int finalVal = 0;
    private Operator ope;

    //セッター
    public void setInitialVal(int value){
        this.initialVal = value;
    }
    public void setFinalVal(int value){
        this.finalVal = value;
    }
    public void setOpe(Operator ope){
        this.ope = ope;
    }
    //ゲッター
    public int getInitialVal() {
		return this.initialVal;
	}
    public int getFinalVal() {
		return this.finalVal;
	}
    public Operator getOpe() {
		return this.ope;
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //左スピナーを設定
        String[] array = new String[100];
        for(int i = 0;i < 100;i++){
             array[i] = String.valueOf(i);
        }
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //演算子ボタンのインスタンス化
        Button buAddition = findViewById(R.id.buAddition);
        Button buSubtraction = findViewById(R.id.buSubtraction);
        Button buMultiplication = findViewById(R.id.buMultiplication);
        Button buDivision = findViewById(R.id.buDivision);
        //足し算ボタンが押されたら
        buAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	setOpe(addition);
                buAddition.setBackgroundColor(Color.parseColor("#F441B9"));
                buSubtraction.setBackgroundColor(Color.parseColor("#A37DFD"));
                buMultiplication.setBackgroundColor(Color.parseColor("#A37DFD"));
                buDivision.setBackgroundColor(Color.parseColor("#A37DFD"));
            }
        });
        
        //ひき算ボタンが押されたら
        buSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	setOpe(addition);
                buAddition.setBackgroundColor(Color.parseColor("#A37DFD"));
                buSubtraction.setBackgroundColor(Color.parseColor("#F441B9"));
                buMultiplication.setBackgroundColor(Color.parseColor("#A37DFD"));
                buDivision.setBackgroundColor(Color.parseColor("#A37DFD"));
            }
        });
        //かけ算ボタンが押されたら
        buMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	setOpe(addition);
                buAddition.setBackgroundColor(Color.parseColor("#A37DFD"));
                buSubtraction.setBackgroundColor(Color.parseColor("#A37DFD"));
                buMultiplication.setBackgroundColor(Color.parseColor("#F441B9"));
                buDivision.setBackgroundColor(Color.parseColor("#A37DFD"));
            }
        });
        //わり算ボタンが押されたら
        buDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	setOpe(addition);
                buAddition.setBackgroundColor(Color.parseColor("#A37DFD"));
                buSubtraction.setBackgroundColor(Color.parseColor("#A37DFD"));
                buMultiplication.setBackgroundColor(Color.parseColor("#A37DFD"));
                buDivision.setBackgroundColor(Color.parseColor("#F441B9"));
            }
        });

        //スタートボタンが押されたら
        Button buStart = findViewById(R.id.buStart);
        buStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalcPageActivity.class);
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
