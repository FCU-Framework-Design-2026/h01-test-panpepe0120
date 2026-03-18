package org.example;

public class Main {
    public static void main(String[] args) {

        ChessGame game = new ChessGame();

        game.generateChess();   // 產生棋子
        game.showAllChess();    // 顯示棋盤
    }
}