package com.example.myapplication;

public class Calculation {

    public int leftValue;
    public int rightValue;
    public int answer;
    public String ope;

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


    public int leftValueSet(int l){
        this.leftValue = l;
        return this.leftValue;
    }

    public int rightValueSet(int r){
        this.rightValue = r;
        return this.rightValue;
    }

    //足し算
    public int addition(){
        this.answer = leftValue+rightValue;
        return this.answer;
    }

}
