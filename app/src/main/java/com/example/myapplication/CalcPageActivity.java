package com.example.myapplication;

import java.util.ArrayList;
import com.example.myapplication.Calculation.Operator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalcPageActivity extends AppCompatActivity {
	
	//フィールド
	private int leftValue;
    private int rightValue;
    private int answer;
    private int questionNum = 1;
    private Operator ope;
    private ArrayList<Integer> questions;//問題作成用配列
    private String[][] results = new String[5][questions.size() * questions.size()];//解答結果用配列
    
    //クラスのインスタンス化
    MainActivity main = new MainActivity();
    Calculation calculation = new Calculation();
    
    //コンストラクタ
    public CalcPageActivity(){
    //メインページで選択された演算方法を取得してthis.opeに代入する
    this.ope = main.getOpe();
    //メインページで入力された数値を引数で渡してArrayList型配列を取得する
    this.questions = calculation.arraySet(main.getInitialVal(),main.getFinalVal());
    }
    
    //セッター
    public void setLeftValue(int value){
    	this.leftValue = value;
    }
    public void setRightValue(int value){
    	this.rightValue = value;
    }
    public void setAnswer(int ans){
        this.answer = ans;
    }
    public void setQuestionNum(int num){
        this.questionNum = num;
    }
    public void setOpe(Operator ope){
    	this.ope = ope;
    }
    
    //ゲッター
    public int getLeftValue(){
    	return this.leftValue;
    }
    public int getRightValue(){
    	return this.rightValue;
    }
    public int getAnswer(){
    	return this.answer;
    }
    public int getQuestionNum(){
    	return this.questionNum;
    }
    public Operator getOpe(){
    	return this.ope;
    }
    
    //画面が開いたら
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_page);
        
        //画面表示用に各TextViewをインスタンス化しておく
        TextView leftValueText = findViewById(R.id.leftValue);
        TextView rightValueText = findViewById(R.id.rightValue);
        TextView opeText = findViewById(R.id.ope);
        TextView answerText = findViewById(R.id.answer);
        TextView trueOrFalseText = findViewById(R.id.trueOrFalse);
        
        //Operatorの種類で判別して文字列としての演算子を取得、opeTextにセットする
    	String opeStr = calculation.setOpe(this.ope);
    	opeText.setText(opeStr);
        
        	//ユーザーが設定した範囲arrayの総当たり計算
        	//右辺が1週したら左辺を+1する
        	for (int i = 0; i < questions.size(); i++) {
        		//左辺に代入する
        		this.leftValue = questions.get(i);
        		String leftValueStr = String.valueOf(this.getLeftValue());
        		leftValueText.setText(leftValueStr);
        		for (int j = 0; j < questions.size(); j++) {
        			//右辺に代入
        			this.rightValue = questions.get(j);
        			String rightValueStr = String.valueOf(this.getRightValue());
        			rightValueText.setText(rightValueStr);
        			
        			//判定ボタンが押されたら
        	        Button judgment = findViewById(R.id.judgment);
        	        judgment.setOnClickListener(new View.OnClickListener() {
        	            @Override
        	            public void onClick(View view) {
		        	    }
        	        });
        	        
        	        String answerStr = answerText.getText().toString();
        	        this.answer = Integer.parseInt(answerStr);
        	        int answerCalc = calculation.makeCalculation(this.getOpe(),this.getLeftValue(),this.getRightValue());
        	        
        	        //正誤判定後、結果を配列に入れる
        	        if (answerCalc == this.getAnswer()) {
        	        	trueOrFalseText.setText("○");
        	        	this.results[questionNum - 1][1] = "正解";
        	        } else {
        	        	trueOrFalseText.setText("×");
        	        	this.results[questionNum - 1][1] = "不正解";
        	        }
        	        
        	        //問題番号、問題、正解、入力した数値を配列に入れる
        	        this.results[questionNum - 1][0] = questionNum + "問目";
        	        this.results[questionNum - 1][2] = "問題:" + this.getLeftValue() + opeStr + this.getRightValue();
        	        this.results[questionNum - 1][3] = "正解:" + answerCalc;
        	        this.results[questionNum - 1][4] = "入力した数値:" + this.getAnswer();
        	        
        	        //問題番号に+1する
        	        questionNum++;
        	        
        	        //trueOrFalseTextがタップされたら進む
        	       
        		}
        	}
        //トップに戻るボタンが押されたら
        Button buttonFinish = findViewById(R.id.buttonFinish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
