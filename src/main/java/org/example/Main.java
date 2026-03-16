package org.example;

public class Main {
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.generateChess();
        game.showAllChess();

        game.playGame();
    }
}