package com.example.myapplication;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.myapplication.Calculation.Operator;

public class Sample {

	public static void main(String[] args) {
		//各クラスをインスタンス化する
		Scanner stdin1 = new Scanner(System.in);
		Calculation calc1 = new Calculation();
		
		//数値の範囲を決定する
		//初期値から最終値までをarraySetに引数として渡す
		//引数はユーザーが決めれるようにする
		ArrayList<Integer> array = calc1.arraySet(1,3);
		
		//解答結果を入れる配列を用意する
		ArrayList<ArrayList<String>> results = new ArrayList<>();
		
		System.out.println(array);//消す
		
		//どの演算にするか決定する
		int ope = 0;
		do {
		System.out.println("計算方法を入力してください");
		System.out.println("たし算:1,ひき算:2,かけ算:3,わり算:4");
		ope = stdin1.nextInt();
		}while (!(ope == 1 || ope == 2 || ope == 3 || ope == 4));
		
		switch(ope) {
			case 1:
				results = calcDecision(array,Operator.addition);
				break;
			case 2:
				results = calcDecision(array,Operator.subtraction);
				break;
			case 3:
				results = calcDecision(array,Operator.multiplication);
				break;
			case 4:
				results = calcDecision(array,Operator.division);
				break;
		}
		stdin1.close();//スキャナー１終了
		
		
		System.out.println(results);
	
	}
	public static ArrayList<ArrayList<String>> calcDecision(ArrayList<Integer> array,Operator operator) {
		Scanner stdin2 = new Scanner(System.in);
		Calculation calc2 = new Calculation();
		
		String[][] results = String[array.size()][5];
		
		
		
		int questionNum = 1;
		
		for(int i = 0;i < array.size();i++) {
			calc2.leftValueSet(array.get(i));
			ArrayList<String> result = new ArrayList<>();
			for(int j = 0;j < array.size();j++) {
				calc2.rightValueSet(array.get(j));
				int leftVal = calc2.getLeftValue();
				int rightVal = calc2.getRightValue();
				calc2.setOpe(operator);
				String ope = calc2.getOpe();
				System.out.print(leftVal + ope + rightVal + "=");
					result.add(questionNum+"問");
					int answer = stdin2.nextInt();
					if(calc2.getAnswer() == answer) {
						System.out.println("正解");
						result.add("正解");
					}else {
						System.out.println("不正解");
						result.add("不正解");
					}
					result.add(leftVal+ope+rightVal);
					result.add(String.valueOf(calc2.getAnswer()));
					result.add(String.valueOf(answer));
					
					questionNum++;
					results.add(result);
					result.clear();
			}
		}
		stdin2.close();//スキャナー２終了
		return results;
	}
}
