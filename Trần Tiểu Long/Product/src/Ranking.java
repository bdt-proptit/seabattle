package sea_battle;

public class Ranking {
    private String playerName;
    private int attackCount;
    private int ship_live;

    public int getShip_live() {
        return ship_live;
    }

    public void setShip_live(int ship_live) {
        ship_live = ship_live;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAttackCount() {
        return attackCount;
    }

    public void setAttackCount(int attackCount) {
        this.attackCount = attackCount;
    }
    public String toString() {
        return playerName + " " + attackCount + " " + ship_live;
    }

    public Ranking(String playerName, int attackCount, int ship_live) {
        this.playerName = playerName;
        this.attackCount = attackCount;
        this.ship_live = ship_live;
    }
}
