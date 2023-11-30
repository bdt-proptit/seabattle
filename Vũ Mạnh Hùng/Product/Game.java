package Product;

public class Game {
    private Player player1;
    private Player player2;

    // Constructor
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    // Getter
    public Player getPlayer1() {return player1;}
    public Player getPlayer2() {return player2;}

    public boolean isGameOver() {
        return player1.getBoard().isAllShipsSunk() || player2.getBoard().isAllShipsSunk();
    }
}























//-----------------Player1 Board-----------------------------------Player2 Board-----------------
//
//_______________________________________________________________________________________________
//|  | A | B | C | D | E | F | G | H | I | J |~~~~~~~|  | A | B | C | D | E | F | G | H | I | J |
//| 1|   |   |   |   |   |   |   |   |   |   |~~~~~~~|  |   |   |   |   |   |   |   |   |   |   |
//| 2|   |   |   |   |   |   |   |   |   |   |~~~~~~~|  |   |   |   |   |   |   |   |   |   |   |
//| 3|   | h |   |   |   |   |   |   |   |   |~~~~~~~|  |   | x |   |   |   |   |   |   |   |   |
//| 4|   | h |   |   |   |   |   |   |   |   |~~~~~~~|  |   | x |   |   |   |   |   |   |   |   |
//| 5|   |   | x | x |   |   |   |   |   |   |~~~~~~~|  |   | h |   |   |   |   |   |   |   |   |
//| 6|   |   |   |   |   |   |   |   |   |   |~~~~~~~|  |   |   |   |   |   |   |   |   |   |   |
//| 7|   |   |   |   |   |   |   |   |   |   |~~~~~~~|  |   |   |   |   |   |   |   |   |   |   |
//| 8|   |   |   |   |   |   |   |   |   |   |~~~~~~~|  |   |   |   |   |   |   |   |   |   |   |
//| 9|   |   |   |   |   |   |   |   |   |   |~~~~~~~|  |   |   |   |   |   |   |   |   |   |   |
//|10|   |   |   |   |   |   |   |   |   |   |~~~~~~~|  |   |   |   |   |   |   |   |   |   |   |
//-----------------------------------------------------------------------------------------------
