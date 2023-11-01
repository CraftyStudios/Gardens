package me.pillage.garden.storage;

import me.pillage.garden.Enums.Crops;
import me.pillage.garden.Enums.Skins;

public class Reward {
    private int farmingXp;
    private int gardenXp;
    private int playerXp;
    private int visitors;
    private Crops crop;
    private int playerXpMult;
    private int cropGrowthMult;
    private int cropUpgradeLevel;
    private Skins skin;

    public int getFarmingXp() {
        return farmingXp;
    }

    public int getGardenXp() {
        return gardenXp;
    }

    public int getPlayerXp() {
        return playerXp;
    }

    public int getVisitors() {
        return visitors;
    }

    public Crops getCrop() {
        return crop;
    }

    public int getPlayerXpMult() {
        return playerXpMult;
    }

    public int getCropGrowthMult() {
        return cropGrowthMult;
    }

    public int getCropUpgradeLevel() {
        return cropUpgradeLevel;
    }

    public Skins getSkin() {
        return skin;
    }

    class Builder {
        public void farmingXp(int farmingXp) {
            Reward.this.farmingXp = farmingXp;
        }

        public void gardenXp(int gardenXp) {
            Reward.this.gardenXp = gardenXp;
        }

        public void playerXp(int playerXp) {
            Reward.this.playerXp = playerXp;
        }

        public void visitors(int visitors) {
            Reward.this.visitors = visitors;
        }

        public void crop(Crops crop) {
            Reward.this.crop = crop;
        }

        public void playerXpMult(int playerXpMult) {
            Reward.this.playerXpMult = playerXpMult;
        }

        public void cropGrowthMult(int cropGrowthMult) {
            Reward.this.cropGrowthMult = cropGrowthMult;
        }

        public void cropUpgradeLevel(int cropUpgradeLevel) {
            Reward.this.cropUpgradeLevel = cropUpgradeLevel;
        }

        public void skin(Skins skin) {
            Reward.this.skin = skin;
        }

        public Reward build() {
            return Reward.this;
        }
    }
}
