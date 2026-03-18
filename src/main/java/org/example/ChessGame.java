package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class ChessGame {

    ArrayList<Chess> chessList = new ArrayList<>();

    String[] positions = {
        "A1","A2","A3","A4","A5","A6","A7","A8",
        "B1","B2","B3","B4","B5","B6","B7","B8",
        "C1","C2","C3","C4","C5","C6","C7","C8",
        "D1","D2","D3","D4","D5","D6","D7","D8"
    };

    // 生成棋子
    public void generateChess() {

        // 紅方
        chessList.add(new Chess("將", 10, "紅", ""));
        chessList.add(new Chess("士", 9, "紅", ""));
        chessList.add(new Chess("士", 9, "紅", ""));
        chessList.add(new Chess("象", 8, "紅", ""));
        chessList.add(new Chess("象", 8, "紅", ""));
        chessList.add(new Chess("車", 7, "紅", ""));
        chessList.add(new Chess("車", 7, "紅", ""));
        chessList.add(new Chess("馬", 6, "紅", ""));
        chessList.add(new Chess("馬", 6, "紅", ""));
        chessList.add(new Chess("包", 5, "紅", ""));
        chessList.add(new Chess("包", 5, "紅", ""));
        chessList.add(new Chess("兵", 1, "紅", ""));
        chessList.add(new Chess("兵", 1, "紅", ""));
        chessList.add(new Chess("兵", 1, "紅", ""));
        chessList.add(new Chess("兵", 1, "紅", ""));
        chessList.add(new Chess("兵", 1, "紅", ""));

        // 黑方
        chessList.add(new Chess("將", 10, "黑", ""));
        chessList.add(new Chess("士", 9, "黑", ""));
        chessList.add(new Chess("士", 9, "黑", ""));
        chessList.add(new Chess("象", 8, "黑", ""));
        chessList.add(new Chess("象", 8, "黑", ""));
        chessList.add(new Chess("車", 7, "黑", ""));
        chessList.add(new Chess("車", 7, "黑", ""));
        chessList.add(new Chess("馬", 6, "黑", ""));
        chessList.add(new Chess("馬", 6, "黑", ""));
        chessList.add(new Chess("包", 5, "黑", ""));
        chessList.add(new Chess("包", 5, "黑", ""));
        chessList.add(new Chess("兵", 1, "黑", ""));
        chessList.add(new Chess("兵", 1, "黑", ""));
        chessList.add(new Chess("兵", 1, "黑", ""));
        chessList.add(new Chess("兵", 1, "黑", ""));
        chessList.add(new Chess("兵", 1, "黑", ""));

        // 隨機打亂
        Collections.shuffle(chessList);

        // 分配位置
        for (int i = 0; i < chessList.size(); i++) {
            chessList.get(i).loc = positions[i];
        }
    }

    // 顯示棋盤
    public void showAllChess() {

        System.out.println("   1  2  3  4  5  6  7  8");

        String[] rows = {"A","B","C","D"};

        for (String row : rows) {
            System.out.print(row + " ");

            for (int col = 1; col <= 8; col++) {
                String pos = row + col;

                for (Chess c : chessList) {
                    if (c.loc.equals(pos)) {
                        System.out.print(" " + c.toString() + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}