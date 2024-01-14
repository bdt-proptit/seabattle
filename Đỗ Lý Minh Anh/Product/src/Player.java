import java.util.Scanner;

public class Player {
    Operation operation = new Operation();
    private int[][] myBoard = new int[10][10];
    private int theNumberOfSquaresShot = 0;
    private int theNumberOfBoatsHit = 0;
    private int theNumberOfMyRemainingBoats = 5;
    public int getTheNumberOfSquaresShot () {
        return theNumberOfSquaresShot;
    }
    public void setTheNumberOfSquaresShot (int theNumberOfSquaresShot) {
        this.theNumberOfSquaresShot = theNumberOfSquaresShot;
    }
    public int getTheNumberOfBoatsHit () {
        return theNumberOfBoatsHit;
    }
    public void setTheNumberOfBoatsHit (int theNumberOfBoatsHit) {
        this.theNumberOfBoatsHit = theNumberOfBoatsHit;
    }
    public int getTheNumberOfMyRemainingBoats () {
        return theNumberOfMyRemainingBoats;
    }
    public void setTheNumberOfMyRemainingBoats (int theNumberOfMyRemainingBoats) {
        this.theNumberOfMyRemainingBoats = theNumberOfMyRemainingBoats;
    }
    public int[][] getMyBoard () {
        return myBoard;
    }
    public void setMyBoard () {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                this.myBoard[i][j] = 0;
            }
        }
    }
    public void setUpBoats (Scanner sc) {
        operation.playerSetsUpTheBoat(sc, this);
    }
    public boolean openFireAndCheck (Scanner sc, Player enemy) {
        return operation.playerOpensFireAndCheck(sc, this, enemy);
    }
}