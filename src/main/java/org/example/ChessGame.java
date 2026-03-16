package org.example;

import java.util.*;

public class ChessGame extends AbstractGame {
    private Player player1;
    private Player player2;
    private Chess[][] board = new Chess[4][8];
    private List<Chess> chessList = new ArrayList<>();
    private Map<String, Integer> colMap = Map.of(
            "A", 0, "B", 1, "C", 2, "D", 3);

    public void setPlayers(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    // 隨機產生棋子並放到棋盤
    public void generateChess() {
        String[] names = { "兵", "車", "象", "士", "馬", "包", "將", "X" };
        int[] weights = { 1, 5, 3, 2, 4, 5, 10, 0 };
        String[] sides = { "紅", "黑" };

        // 32 個棋子
        Random rand = new Random();
        for (int i = 0; i < 32; i++) {
            String name = names[rand.nextInt(names.length)];
            int weight = weights[rand.nextInt(weights.length)];
            String side = sides[rand.nextInt(sides.length)];
            chessList.add(new Chess(name, weight, side, ""));
        }

        // 隨機排到 4x8 棋盤
        List<int[]> positions = new ArrayList<>();
        for (int r = 0; r < 4; r++)
            for (int c = 0; c < 8; c++)
                positions.add(new int[] { r, c });
        Collections.shuffle(positions);

        for (int i = 0; i < chessList.size(); i++) {
            int r = positions.get(i)[0];
            int c = positions.get(i)[1];
            board[r][c] = chessList.get(i);
            board[r][c].setLoc("" + (char) ('A' + r) + (c + 1));
        }
    }

    public void showAllChess() {
        System.out.print("   ");
        for (int c = 1; c <= 8; c++)
            System.out.print(c + "  ");
        System.out.println();
        for (int r = 0; r < 4; r++) {
            System.out.print((char) ('A' + r) + "  ");
            for (int c = 0; c < 8; c++) {
                Chess ch = board[r][c];
                System.out.print((ch == null ? "＿" : ch.toString()) + "  ");
            }
            System.out.println();
        }
    }

    private int[] parseLocation(String loc) {
        loc = loc.toUpperCase();
        if (loc.length() < 2)
            return null;
        char rowC = loc.charAt(0);
        int row = rowC - 'A';
        int col;
        try {
            col = Integer.parseInt(loc.substring(1)) - 1;
        } catch (Exception e) {
            return null;
        }
        if (row < 0 || row >= 4 || col < 0 || col >= 8)
            return null;
        return new int[] { row, col };
    }

    public boolean move(String from, String to) {
        int[] f = parseLocation(from);
        int[] t = parseLocation(to);
        if (f == null || t == null)
            return false;

        Chess src = board[f[0]][f[1]];
        Chess dest = board[t[0]][t[1]];

        if (src == null || !src.isFlipped()) {
            System.out.println("來源位置沒有翻開的棋子");
            return false;
        }

        if (dest != null && !dest.isFlipped()) {
            System.out.println("目標棋子未翻開，無法移動");
            return false;
        }

        // 交換或吃子
        board[t[0]][t[1]] = src;
        board[f[0]][f[1]] = null;
        src.setLoc(to);
        return true;
    }

    public boolean gameOver() {
        // 簡單判斷: 只要有將死棋子
        boolean hasKing = false;
        for (int r = 0; r < 4; r++)
            for (int c = 0; c < 8; c++) {
                Chess ch = board[r][c];
                if (ch != null && "將".equals(ch.getName()) && ch.isFlipped())
                    hasKing = true;
            }
        return !hasKing;
    }

    // console 操作
    public void playGame() {
        Scanner sc = new Scanner(System.in);
        while (!gameOver()) {
            showAllChess();
            System.out.print("輸入翻棋位置 (例: A1): ");
            String input = sc.nextLine();
            int[] pos = parseLocation(input);
            if (pos == null || board[pos[0]][pos[1]] == null) {
                System.out.println("位置錯誤，重新輸入");
                continue;
            }
            Chess ch = board[pos[0]][pos[1]];
            if (!ch.isFlipped()) {
                ch.flip();
                System.out.println(ch.getName() + " 翻開了!");
            } else {
                System.out.print("棋子已翻開，輸入移動到的位置: ");
                String to = sc.nextLine();
                if (!move(input, to))
                    System.out.println("移動失敗!");
            }
        }
        System.out.println("遊戲結束!");
    }
}