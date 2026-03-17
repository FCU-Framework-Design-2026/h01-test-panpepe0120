package org.example;
//棋子藍圖
public class Chess{
    String name; //棋子名稱(將、士、象、車、馬、炮、兵)
    int weight; //棋子權重(判斷吃子優先順序)
    String side; // 陣營(紅、黑)
    String loc; //棋子位置(例如: A1、B2)
    boolean isOpen; //棋子是否翻開

    //constructor = 建立物件時用
    public Chess(String name, int weight, String side, String loc) {
        this.name = name;
        this.weight = weight;
        this.side = side;
        this.loc = loc;
        this.isOpen = false; // 一開始全部蓋著
    }

    //印出棋子
    @Override
    public String toString() {
        if (!isOpen) {
            return "X"; // 沒翻開
        }
        return side + name + "(" + loc + ")";
    }

    //翻開棋子
    public void flip() {
        isOpen = true;
    }

    }

