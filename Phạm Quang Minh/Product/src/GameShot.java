public class GameShot {
    public boolean checkShipShot(Player player, Player oppositePlayer, Shot shot, boolean swap) {
        char[][] oppositeBoard = oppositePlayer.getBoard();
        char[][] board = player.getOppositeBoard();
        if (!shot.checkLocation(board)) {
            return swap;
        }
        if (shot.checkHit(oppositeBoard)) {
            board[shot.getRow()][shot.getColumn()] = 'x';
            oppositeBoard[shot.getRow()][shot.getColumn()] = 'x';
            GameShip gameShip = new GameShip();
            gameShip.updateShip(player, oppositePlayer);
        } else {
            board[shot.getRow()][shot.getColumn()] = 'o';
            oppositeBoard[shot.getRow()][shot.getColumn()] = 'o';
            swap = !swap;
        }
        player.setOppositeBoard(board);
        oppositePlayer.setBoard(oppositeBoard);

        // Play play = new Play();
        // play.printNamePlayer(player, oppositePlayer);
        // System.out.println("RESULT");
        // Board boardGame = new Board();
        // boardGame.displayBoardGame(player.getBoard(), player.getOppositeBoard());

        player.setNumberShot(player.getNumberShot() + 1);
        return swap;
    }
}
