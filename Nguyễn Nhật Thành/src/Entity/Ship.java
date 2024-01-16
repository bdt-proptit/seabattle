package Entity;

public class Ship {
    public int x1, y1, x2, y2;
    private final String shipName;
    private final int shipLength;
    private boolean drown = false;
    private String shipColor = "";
    String getShipColor(){ return shipColor; }
    boolean getDrown(){ return drown; }
    Ship(String name, int length, String color){
        this.shipName = name; this.shipLength = length; this.shipColor = color;
    }
    public Ship(String name, String length, String x1, String y1, String x2, String y2){
        shipName = name; shipLength = Integer.parseInt(length);
        this.x1 = Integer.parseInt(x1);
        this.y1 = Integer.parseInt(y1);
        this.x2 = Integer.parseInt(x2);
        this.y2 = Integer.parseInt(y2);
    }
    public void setCoordinates(int x1, int y1, int x2, int y2){
        this.x1 = Integer.min(x1, x2); this.x2 = Integer.max(x1, x2);
        this.y1 = Integer.min(y1, y2); this.y2 = Integer.max(y1, y2);
    }
    public String getShipName(){ return shipName; }
    public int getShipLength(){ return shipLength; }
    void checkDrown(char[][] a){
        int cnt = 0;
        if(x1 == x2){
            for(int i=y1; i<=y2; ++i){
                if(a[x1][i] == 'X') ++cnt;
            }
        }
        else{
            for(int i=x1; i<=x2; ++i){
                if(a[i][y1] == 'X') ++cnt;
            }
        }
        if(cnt == shipLength) drown = true;
    }
    void setDrown(char[][] a){
        if(x1 == x2){
            for(int i=y1; i<=y2; ++i){
                a[x1][i] = 'D';
            }
        }
        else{
            for(int i=x1; i<=x2; ++i){
                a[i][y1] = 'D';
            }
        }
    }
}