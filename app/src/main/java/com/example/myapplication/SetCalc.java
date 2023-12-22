package com.example.myapplication;

import java.util.ArrayList;

public class SetCalc {
	//計算準備用

    private int leftValue;
    private int rightValue;
    private int answer;
    private String ope;
    
    //ゲッター
    public int getLeftValue() {
    	return this.leftValue;
    }
    public int getRightValue() {
    	return this.rightValue;
    }
    public int getAnswer() {
    	return this.answer;
    }
    public String getOpe() {
    	return this.ope;
    }

//列挙型で演算子を限定する
    public enum Operator {
        addition,
        subtraction,
        multiplication,
        division
    }

    public void setOpe(Operator ope){
        switch (ope){
            case addition :
                this.ope = "+";
                this.answer = leftValue + rightValue;
                break;
            case subtraction:
                this.ope = "-";
                this.answer = leftValue - rightValue;
                break;
            case multiplication:
                this.ope = "×";
                this.answer = leftValue * rightValue;
                break;
            case division:
                this.ope = "÷";
                this.answer = leftValue / rightValue;//余りを未定義
                break;
        }
    }
    //引数（初期値から最終値）までが入った配列ArrayList型arrayを作成して返す
    public ArrayList<Integer> arraySet(int initialVal,int finalVal) {
    	
    	ArrayList<Integer> array = new ArrayList<>();
    	for(int i = initialVal;i <= finalVal;i++) {
    		array.add(i);
    	}
		return array;
	}
    public void leftValueSet(int l){
        this.leftValue = l;
    }
    public void rightValueSet(int r){
        this.rightValue = r;
    }
}
