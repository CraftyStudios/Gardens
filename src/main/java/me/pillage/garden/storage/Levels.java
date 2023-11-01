package me.pillage.garden.storage;

public class Levels {
    private int level;
    private int exp;

    public Levels(int level, int exp) {
        this.level = level;
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }
}
