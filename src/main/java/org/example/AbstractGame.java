package org.example;

public abstract class AbstractGame {
    public abstract void setPlayers(Player p1, Player p2);
    public abstract boolean gameOver();
    public abstract boolean move(String from, String to, Player player);
    public abstract void generateChess();
    public abstract void showAllChess();
    public abstract Chess getChessAt(String pos);
    public abstract String getWinner();
}