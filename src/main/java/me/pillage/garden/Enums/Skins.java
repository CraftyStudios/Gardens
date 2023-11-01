package me.pillage.garden.Enums;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import static me.pillage.garden.Enums.Rarity.*;

public enum Skins {
    DEFAULT(COMMON, 0),
    BEE(UNCOMMON, 300),
    PUMPKIN(RARE, 600),
    SKELETON(EPIC, 1200),
    SNOWMAN(LEGENDARY, 2400),
    SANTA(MYTHIC, 4800);

    private Rarity rarity;
    private int price;
    Skins(Rarity rarity, int price) {
        this.rarity = rarity;
        this.price = price;
    }

    public Rarity getRarity() {
        return rarity;
    }

    @Contract(pure = true)
    public @Nullable Object getPrice() {
        return null;
    }
}
