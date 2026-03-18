package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        Player player1 = new Player("玩家1");
        Player player2 = new Player("玩家2");

        game.setPlayers(player1, player2);
        game.generateChess();

        Scanner sc = new Scanner(System.in);
        Player currentPlayer = player1;
        Player nextPlayer = player2;

        while (!game.gameOver()) {
            System.out.println("\n========== 當前棋盤 ==========");
            game.showAllChess();
            System.out.println("\n" + currentPlayer.name + " 的回合（陣營：" + 
                (currentPlayer.side==null ? "尚未決定" : currentPlayer.side) + "）");

            System.out.print("輸入棋子位置進行翻棋/移動（格式 A1~D8）：");
            String from = sc.nextLine().trim().toUpperCase();

            System.out.print("輸入目的位置（翻棋請與起始位置相同）：");
            String to = sc.nextLine().trim().toUpperCase();

            boolean success = game.move(from, to, currentPlayer);
            if(!success){
                System.out.println("操作失敗，請重新輸入！");
                continue; // 失敗不換玩家
            }

            // 換玩家
            Player temp = currentPlayer;
            currentPlayer = nextPlayer;
            nextPlayer = temp;
        }

        System.out.println("\n========== 遊戲結束 ==========");
        game.showAllChess();
        System.out.println("勝利者：" + game.getWinner());
        sc.close();
    }
}