package org.example;

public class Player {
    String name;
    String side; // 紅/黑，第一次翻棋決定

    public Player(String name) {
        this.name = name;
        this.side = null; // 尚未決定
    }
}