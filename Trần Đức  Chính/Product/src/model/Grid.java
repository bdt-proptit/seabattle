package model;

import graphic.Color;

public class Grid {

    public String[][] board;

    public Grid() {
        board = new String[Player.playerGridSize][Player.playerGridSize];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < Player.playerGridSize; i++) {
            for (int j = 0; j < Player.playerGridSize; j++) {
                board[i][j] = Color.WATER + "~" + Color.RESET;
            }
        }
    }

    public void printGrid() {
        System.out.print(" ");
        for (int i = 1; i <= Player.playerGridSize; i++) {
            if (i <= 10)
                System.out.print("  " + i);
            else System.out.print(" " + i);
        }
        System.out.println();
        System.out.println("  " + "-".repeat(3 * Player.playerGridSize));
        for (int i = 0; i < Player.playerGridSize; i++) {
            System.out.print((char) ('A' + i) + "| ");
            for (int j = 0; j < Player.playerGridSize; j++) {
                if (j == Player.playerGridSize - 1)
                    System.out.print(board[i][j] + " |");
                else
                    System.out.print(board[i][j] + "  ");

            }
            System.out.println();
        }
        System.out.println("  " + "-".repeat(3 * Player.playerGridSize ));
    }

    public boolean checkExsitShip(String head, String tail) {
        int headXIndex = head.toUpperCase().charAt(0) - 'A';
        int tailXIndex = tail.toUpperCase().charAt(0) - 'A';
        int headYIndex = Integer.parseInt(head.substring(1)) - 1;
        int tailYIndex = Integer.parseInt(tail.substring(1)) - 1;
        if (checkCoordinates(head) && checkCoordinates(tail)) {
            if (headXIndex == tailXIndex) {
                for (int i = Math.min(headYIndex, tailYIndex); i <= Math.max(tailYIndex, headYIndex); i++) {
                    if (board[headXIndex][i].equals(Color.SHIP + "S" + Color.RESET)) {
                        return true;
                    }
                }
            } else if (headYIndex == tailYIndex) {
                for (int i = Math.min(headXIndex, tailXIndex); i <= Math.max(tailXIndex, headXIndex); i++) {
                    if (board[i][headYIndex].equals(Color.SHIP + "S" + Color.RESET)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkHit(String attack) {
        int attackXIndex = attack.toUpperCase().charAt(0) - 'A';
        int attackYIndex = Integer.parseInt(attack.substring(1)) - 1;
        if (checkCoordinates(attack)) {
            return board[attackXIndex][attackYIndex].equals(Color.HIT + "X" + Color.RESET) || board[attackXIndex][attackYIndex].equals(Color.MISS + "*" + Color.RESET);
        }
        return false;
    }

    public boolean checkCoordinates(String coordinates) {
        int xIndex = coordinates.toUpperCase().charAt(0) - 'A';
        int yIndex = Integer.parseInt(coordinates.substring(1)) - 1;
        return (xIndex >= 0 && xIndex < Player.playerGridSize) && (yIndex >= 0 && yIndex < Player.playerGridSize);
    }

    public boolean checkShipIsSunk(Ship ship) {
        int headXIndex = ship.getHead().toUpperCase().charAt(0) - 'A';
        int tailXIndex = ship.getTail().toUpperCase().charAt(0) - 'A';
        int headYIndex = Integer.parseInt(ship.getHead().substring(1)) - 1;
        int tailYIndex = Integer.parseInt(ship.getTail().substring(1)) - 1;
        int cntHit = 0;
        if (headXIndex == tailXIndex) {
            for (int i = Math.min(headYIndex, tailYIndex); i <= Math.max(tailYIndex, headYIndex); i++) {
                if (board[headXIndex][i].equals(Color.HIT + "X" + Color.RESET)) {
                    cntHit++;
                }
            }
        } else if (headYIndex == tailYIndex) {
            for (int i = Math.min(headXIndex, tailXIndex); i <= Math.max(tailXIndex, headXIndex); i++) {
                if (board[i][headYIndex].equals(Color.HIT + "X" + Color.RESET)) {
                    cntHit++;
                }
            }
        }
        return cntHit == ship.getLength();
    }

    public void printAttackAndShipGrid(Grid playerAttackGrid, Grid playerGrid) {
        System.out.printf("%-25s" + "%" + (Player.playerGridSize * 3 - 3) + "s\n", "   Bảng tấn công", "Bảng thuyền");
        System.out.print(" ");
        for (int i = 1; i <= Player.playerGridSize; i++) {
            if (i <= 10)
                System.out.print("  " + i);
            else System.out.print(" " + i);
        }
        System.out.print(" ".repeat(7));
        for (int i = 1; i <= Player.playerGridSize; i++) {
            if (i <= 10)
                System.out.print("  " + i);
            else System.out.print(" " + i);
        }
        System.out.println();
        System.out.printf("%-25s%-25s\n", "  " + "-".repeat(3 * Player.playerGridSize), " ".repeat(8) + "-".repeat(3 * Player.playerGridSize));
        for (int i = 0; i < Player.playerGridSize; i++) {
            System.out.print((char) ('A' + i) + "| ");
            for (int j = 0; j < Player.playerGridSize; j++) {
                if (j == Player.playerGridSize - 1)
                    System.out.print(playerAttackGrid.board[i][j] + " |");
                else
                    System.out.print(playerAttackGrid.board[i][j] + "  ");
            }
            System.out.printf("%6c| ", (char) ('A' + i));
            for (int j = 0; j < Player.playerGridSize; j++) {
                if (j == Player.playerGridSize - 1)
                    System.out.print(playerGrid.board[i][j] + " |");
                else
                    System.out.print(playerGrid.board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.printf("%-25s%-25s\n", "  " + "-".repeat(3 * Player.playerGridSize), " ".repeat(8) + "-".repeat(3 * Player.playerGridSize));
    }

}




