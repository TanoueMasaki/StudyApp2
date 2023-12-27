package com.example.myapplication;

import java.util.ArrayList;
//計算用クラス
public class Calculation {
	
	
	
	
	
	//列挙型で演算子を限定する
    public enum Operator {
        addition,
        subtraction,
        multiplication,
        division
    }
    
  //演算子を判定して文字列で返す
    public String setOpe(Operator ope){
    	String opeStr = "エラー";
        switch (ope){
            case addition :
                opeStr = "+";
            case subtraction:
                opeStr = "-";
            case multiplication:
                opeStr = "×";
            case division:
                opeStr = "÷";
        }
        return opeStr;
    }
    
    //計算して答えを返す
    public int makeCalculation(Operator ope,int leftValue,int rightValue){
    	int answer = 0;
        switch (ope){
            case addition :
                answer = leftValue + rightValue;
            case subtraction:
                answer = leftValue - rightValue;
            case multiplication:
                answer = leftValue * rightValue;
            case division:
                answer = leftValue / rightValue;//余りを未定義
        }
        return answer;
    }
   
    //引数（初期値から最終値）までが入った配列ArrayList型arrayを作成して返す
    public ArrayList<Integer> arraySet(int initialVal,int finalVal) {
    	ArrayList<Integer> array = new ArrayList<>();
    	for(int i = initialVal;i <= finalVal;i++) {
    		array.add(i);
    	}
		return array;
	}
}
