package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChessGame extends AbstractGame {
    private List<Chess> pieces = new ArrayList<>();
    private Player player1, player2;
    private final int ROWS = 4;
    private final int COLS = 8;
    private final String emptySymbol = "。";
    private final String eatenSymbol = "＊";

    @Override
    public void setPlayers(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    @Override
    public void generateChess() {
        String[] names = {"將","士","象","車","馬","包","兵"};
        int[] weights = {10,4,3,5,5,6,1};

        for(int i=0;i<32;i++){
            String name = names[i%names.length];
            int weight = weights[i%weights.length];
            pieces.add(new Chess(name, weight, null, null));
        }

        Collections.shuffle(pieces);

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                Chess ch = pieces.get(r*COLS + c);
                ch.loc = "" + (char)('A'+r) + (c+1);
            }
        }
    }

    @Override
    public void showAllChess() {
        System.out.print("   ");
        for(int c=1;c<=COLS;c++) System.out.print(" " + c + " ");
        System.out.println();

        for(int r=0;r<ROWS;r++){
            System.out.print((char)('A'+r) + "  ");
            for(int c=0;c<COLS;c++){
                Chess ch = getChessAt("" + (char)('A'+r) + (c+1));
                System.out.print(" " + (ch==null ? emptySymbol : ch.toString()) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public Chess getChessAt(String loc) {
        for(Chess c : pieces){
            if(c.loc.equalsIgnoreCase(loc)) return c;
        }
        return null;
    }

    @Override
    public boolean move(String fromLoc, String toLoc, Player player) {
        Chess from = getChessAt(fromLoc);
        if(from == null){
            System.out.println("起始位置不存在！");
            return false;
        }

        // 翻棋
        if(fromLoc.equals(toLoc)){
            if(from.isOpen){
                System.out.println("該棋子已翻開，請輸入目的位置進行移動或吃子！");
                return false;
            }

            // 第一次翻棋決定玩家陣營
            if(player.side == null){
                player.side = new Random().nextBoolean() ? "紅" : "黑";
            }

            // 設定棋子陣營，翻開
            from.side = player.side;
            from.flip();

            System.out.println(player.name + " 翻開 " + from.side + from.name);
            return true;
        }

        // 移動/吃子
        Chess to = getChessAt(toLoc);
        if(to == null){
            System.out.println("目的位置不存在！");
            return false;
        }

        if(!from.isOpen){
            System.out.println("起始棋子未翻開！");
            return false;
        }

        if(!from.side.equals(player.side)){
            System.out.println("不能操作對方棋子！");
            return false;
        }

        if(!to.isOpen){
            System.out.println("目的位置未翻開！");
            return false;
        }

        if(to.side.equals(from.side)){
            System.out.println("不能吃自己棋子！");
            return false;
        }

        // 吃子
        System.out.println(from.side + from.name + " 吃掉 " + to.side + to.name);
        to.side = from.side;
        to.name = from.name;
        to.isOpen = true;
        from.isEaten = true;
        return true;
    }

    @Override
    public boolean gameOver() {
        boolean redExists=false, blackExists=false;
        boolean anyOpen = false;

        for(Chess c : pieces){
            if(c.isOpen && !c.isEaten){
                anyOpen = true;
                if("紅".equals(c.side)) redExists = true;
                if("黑".equals(c.side)) blackExists = true;
            }
        }

        // 沒有翻開棋子或只有一方翻開棋子 → 遊戲不結束
        if(!anyOpen || !redExists || !blackExists) return false;

        // 當任一方無棋可用時遊戲結束
        return !(redExists && blackExists);
    }

    @Override
    public String getWinner() {
        boolean red=false, black=false;
        for(Chess c : pieces){
            if(c.isOpen && !c.isEaten){
                if("紅".equals(c.side)) red = true;
                if("黑".equals(c.side)) black = true;
            }
        }

        if(red && !black) return "紅方勝利！";
        if(black && !red) return "黑方勝利！";
        return "尚未分出勝負！";
    }
}