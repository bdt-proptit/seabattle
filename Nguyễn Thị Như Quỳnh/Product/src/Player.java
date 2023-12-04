package Thuyen;

public class Player {
    private final String namePlayer;
    private int wreck;
    private final int numberShip;
    private char[][] board;
    private Ship[] ship;
    private char[][] fog;
    private int point;

    public Player(String namePlayer, int wreck, int numberShip, char[][] board, Ship[] ship, char[][] fog, int point) {
        this.namePlayer = namePlayer;
        this.wreck = wreck;
        this.numberShip = numberShip;
        this.board = board;
        this.ship = ship;
        this.fog = fog;
        this.point = point;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public int getWreck() {
        return wreck;
    }

    public void setWreck(int wreck) {
        this.wreck = wreck;
    }

    public char[][] getBoard() {
        return board;
    }

    public Ship[] getShip() {
        return ship;
    }

    public char[][] getFog() {
        return fog;
    }

    public void setFog(int row, int col, char kt) {
        this.fog[row][col] = kt;
    }
    public void setBoard(int row, int col, char kt) {
        this.board[row][col] = kt;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Boolean winner(){
        return this.wreck == this.numberShip;
    }//kiểm tra đã có người thắng chưa
}
