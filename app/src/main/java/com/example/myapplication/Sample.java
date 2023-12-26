/*
package com.example.myapplication;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.myapplication.SetCalc.Operator;

public class Sample {

	public static void main(String[] args) {
		//*アプリ用に要改修
		//アプリ画面表示用のサンプル
		
		//各クラスをインスタンス化する
		Scanner stdin = new Scanner(System.in);
		SetCalc setCalc = new SetCalc();
		Calculation calc = new Calculation();
		
		//数値の範囲を決定する
		//初期値から最終値までをarraySetに引数として渡す
		//引数はユーザーが決めれるようにする
		ArrayList<Integer> array = setCalc.arraySet(1,3);
		
		//解答結果を入れる配列を用意する
		String[][] result = new String[5][array.size() * array.size()];
		
		System.out.println(array);//消す
		
		//どの演算にするか決定する
		//実際にはボタンを押して決定する
		int ope = 0;
		do {
		System.out.println("計算方法を入力してください");
		System.out.println("たし算:1,ひき算:2,かけ算:3,わり算:4");
		ope = stdin.nextInt();
		}while (!(ope == 1 || ope == 2 || ope == 3 || ope == 4));
		
		switch(ope) {
			case 1:
				result = calc.calcDecision(array,Operator.addition);
				break;
			case 2:
				result = calc.calcDecision(array,Operator.subtraction);
				break;
			case 3:
				result = calc.calcDecision(array,Operator.multiplication);
				break;
			case 4:
				result = calc.calcDecision(array,Operator.division);
				break;
		}
		stdin.close();//スキャナー終了
		
		//解答結果を表示する
		for(int i = 0;i < result.length;i++) {
			for(int j = 0;j < 5;j++) {
			System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
}
*/
