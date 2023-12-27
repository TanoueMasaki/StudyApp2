package com.example.myapplication;

import static com.example.myapplication.Calculation.Operator.addition;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.Calculation.Operator;

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

        //たし算ボタンが押されたら
        Button buAddition = findViewById(R.id.buAddition);
        buAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	setOpe(addition);
                buAddition.setBackgroundColor(Color.parseColor("#F441B9"));
            }
        });
        
        //ひき算ボタンが押されたら
        //かけ算ボタンが押されたら
        //わり算ボタンが押されたら

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
