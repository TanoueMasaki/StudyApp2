package com.example.myapplication;

import java.awt.Button;
import java.awt.Color;

import javax.swing.text.View;

import com.example.myapplication.Calculation.Operator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //フィールド定義
    int initialVal = 0;
    int finalVal = 0;
    Operator ope;

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

        //たし算ボタンが押されたら
        Button buAddition = findViewById(R.id.buAddition);
        buAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	this.ope = addition;
                buAddition.setBackgroundColor(Color.parseColor("#FF0000"));
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
