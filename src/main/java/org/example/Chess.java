package org.example;

import java.util.HashMap;
import java.util.Map;

public class Chess {
    String name;
    int weight;
    String side; // 紅/黑
    String loc;
    boolean isOpen;
    boolean isEaten;

    public Chess(String name, int weight, String side, String loc) {
        this.name = name;
        this.weight = weight;
        this.side = side;
        this.loc = loc;
        this.isOpen = false;
        this.isEaten = false;
    }

    public void flip() {
        isOpen = true;
    }

    @Override
    public String toString() {
        if (isEaten) return "＊";
        if (!isOpen) return "。";

        Map<String,String> map = new HashMap<>();
        map.put("紅將","帥"); map.put("紅士","仕"); map.put("紅象","相");
        map.put("紅車","俥"); map.put("紅馬","傌"); map.put("紅包","炮"); map.put("紅兵","卒");
        map.put("黑將","將"); map.put("黑士","士"); map.put("黑象","象");
        map.put("黑車","車"); map.put("黑馬","馬"); map.put("黑包","包"); map.put("黑兵","兵");

        return map.getOrDefault(side + name, "＊");
    }
}