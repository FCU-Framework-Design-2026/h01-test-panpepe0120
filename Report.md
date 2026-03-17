# H1 Report

* Name : 潘姵蓁
* ID : D1388259
* 系級 : 資訊二丁

---
## 題目：暗棋遊戲
撰寫一個簡單版、非 GUI 介面的 Chess 系統。使用者可以在 console 介面輸入所要選擇的棋子的位置 (例如 A2, B3)，若該位置的棋子未翻開則翻開，若以翻開則系統要求輸入目的的位置進行移動或吃子，如果不成功則系統提示錯誤回到原來狀態。每個動作都會重新顯示棋盤狀態。


## 設計方法概述
考慮一個象棋翻棋遊戲，32 個棋子會隨機的落在 4*8的棋盤上。透過 Chess 的建構子產生這些棋子並隨機編排位置，再印出這些棋子的名字、位置
ChessGame
void showAllChess();
void generateChess();
Chess:
Chess(name, weight, side, loc);
String toString();
同上，
ChessGame 繼承一個抽象的 AbstractGame; AbstractGame 宣告若干抽象的方法：
setPlayers(Player, Player)
boolean gameOver()
boolean move(int location)

## 程式、執行畫面及其說明
Chess = 一顆棋子
名稱（車、馬、兵…）
大小（誰能吃誰）
陣營（紅 / 黑）
位置（A1, B3…）
是否翻開（很重要🔥）

public class Chess {

    String name;    // 棋子名稱（車、馬…）
    int weight;     // 棋子大小（用來判斷吃子）
    String side;    // 陣營（紅 / 黑）
    String loc;     // 位置（A1, B2）
    boolean isOpen; // 是否翻開

}



每一次，i 的值會變化。執行的畫面如下：

![](img/image.png)

# AI 使用狀況與心得
1. github新手:之前有學過github如何clone push等功能，但因為大二上的作業基本上都沒有需要這項技能，因此差不多都忘光光的，我有請AI教我如何使用github的功能，也了解到了版本控制的方便(可以在不同裝置寫程式)及重要性(修改後可以回朔)
2.

## 心得
我學到的迴圈的使用。
1.github
2.maven轉用vscode 其中差別??
3.如何git我有下載了新軟體??
