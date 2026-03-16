package org.example;

public class Chess {
    private String name;
    private int weight;
    private String side;
    private String loc;
    private boolean isFlipped;

    public Chess(String name, int weight, String side, String loc) {
        this.name = name;
        this.weight = weight;
        this.side = side;
        this.loc = loc;
        this.isFlipped = false;
    }

    public void flip() {
        isFlipped = true;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getSide() {
        return side;
    }

    @Override
    public String toString() {
        return isFlipped ? name : "＿";
    }
}
