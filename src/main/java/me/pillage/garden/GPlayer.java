package me.pillage.garden;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import me.pillage.garden.Enums.Crops;

public class GPlayer {
    private UUID uuid;
    private int gLevel;
    private int gExp;
    private Map<Crops, Integer> cropLevels = new HashMap<>();

    public GPlayer(UUID uuid, int gLevel, int gExp) {
        this.uuid = uuid;
        this.gLevel = gLevel;
        this.gExp = gExp;
    }
    
    public UUID getUuid() {
        return uuid;
    }

    public int getgLevel() {
        return gLevel;
    }

    public int getgExp() {
        return gExp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        result = prime * result + gLevel;
        result = prime * result + gExp;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GPlayer other = (GPlayer) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        if (gLevel != other.gLevel)
            return false;
        if (gExp != other.gExp)
            return false;
        return true;
    }
}