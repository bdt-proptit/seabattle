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

        player.setNumberShot(player.getNumberShot() + 1);
        return swap;
    }
}
