package com.example.myapplication;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.myapplication.SetCalc.Operator;

public class Calculation {
	//*アプリ用に要改修
	//計算用クラス
	
	public String[][] calcDecision(ArrayList<Integer> array,Operator operator) {
		//実際には不要
		Scanner stdin = new Scanner(System.in);
		
		SetCalc calc = new SetCalc();
		
		//解答結果を入れる配列を用意する
		String[][] result = new String[array.size() * array.size()][5];
		
		//問題番号の初期化
		int questionNum = 1;
		
		//ユーザーが設定した範囲arrayの総当たり計算
		//右辺が1週したら左辺を+1する
		for(int i = 0;i < array.size();i++) {
			//左辺に代入する
			//xmlのid:leftValueにsetが必要
			calc.leftValueSet(array.get(i));
			
			for(int j = 0;j < array.size();j++) {
				//右辺に代入
				calc.rightValueSet(array.get(j));
				int leftVal = calc.getLeftValue();
				int rightVal = calc.getRightValue();
				calc.setOpe(operator);
				String ope = calc.getOpe();
				System.out.print(leftVal + ope + rightVal + "=");
				//問題番号を配列に入れる
				result[questionNum - 1][0] = questionNum + "問目";
				//入力結果を解答用の変数answerに入れる
				//実際にはxmlからfindViewでid:answerから取得する
				int answer = stdin.nextInt();
				//正誤判定後、結果を配列に入れる
				if(calc.getAnswer() == answer) {
					System.out.println("正解");
					result[questionNum - 1][1] = "正解";
				}else {
					System.out.println("不正解");
					result[questionNum - 1][1] = "不正解";
				}
				//問題、正解、入力した数値を配列に入れる
				result[questionNum - 1][2] = "問題:" + leftVal + ope + rightVal;
				result[questionNum - 1][3] = "正解:" + calc.getAnswer();
				result[questionNum - 1][4] = "入力した数値:" + answer;
				//問題番号に+1する
				questionNum++;
			}
		}
		stdin.close();//スキャナー終了
		return result;//解答結果配列を返す
	}

}
