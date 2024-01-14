package model;

import graphic.ClearScreen;
import graphic.Color;
import graphic.Delay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    private String name;
    private int shipRemaining;
    private int shipIsSunk;

    private int hit = 0;
    private int shipDestroyed;

    public List<Ship> shipList = new ArrayList<>();

    public static int playerGridSize;
    public final Grid playerGrid = new Grid();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShipRemaining() {
        return shipRemaining;
    }

    public void setShipRemaining(int shipRemaining) {
        this.shipRemaining = shipRemaining;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

//    public int getShipIsSunk() {
//        return shipIsSunk;
//    }
//
//    public void setShipIsSunk(int shipIsSunk) {
//        this.shipIsSunk = shipIsSunk;
//    }

    public int getShipDestroyed() {
        return shipDestroyed;
    }

    public void setShipDestroyed(int shipDestroyed) {
        this.shipDestroyed = shipDestroyed;
    }



    public Player(String name, int shipRemaining, int hit) {
        this.name = name;
        this.shipRemaining = shipRemaining;
        this.hit = hit;
    }

    public Player() {
        shipRemaining = shipList.size();
        shipIsSunk = 0;
    }

    public void placeShip(Ship ship) {
        while (true) {
            System.out.print("Nhập tọa độ đầu thuyền: ");
            String head = sc.nextLine();
            System.out.print("Nhập tọa độ đuôi thuyền: ");
            String tail = sc.nextLine();
            int headXIndex = head.toUpperCase().charAt(0) - 'A';
            int tailXIndex = tail.toUpperCase().charAt(0) - 'A';
            int headYIndex = Integer.parseInt(head.substring(1)) - 1;
            int tailYIndex = Integer.parseInt(tail.substring(1)) - 1;
            if (!ship.checkLength(head, tail)) {
                System.out.println("\nChiều dài không hợp lệ!");
                System.out.println("\nVui lòng nhập lại tọa độ");
                continue;
            }
            if (!playerGrid.checkCoordinates(head) || !playerGrid.checkCoordinates(tail)) {
                System.out.println("\nTọa độ không hợp lệ");
                System.out.println("\nVui lòng nhập lại tọa độ\n");
                continue;
            }
            if (playerGrid.checkExsitShip(head, tail)) {
                System.out.println("\nVị trí đã có thuyền!");
                System.out.println("\nVui lòng nhập lại tọa độ\n");
                continue;
            }
            if (headXIndex == tailXIndex) {
                for (int i = Math.min(headYIndex, tailYIndex); i <= Math.max(headYIndex, tailYIndex); i++) {
                    playerGrid.board[headXIndex][i] = Color.SHIP + "S" + Color.RESET;
                }
                ship.setHead(head);
                ship.setTail(tail);
                shipList.add(ship);
                System.out.println();
                playerGrid.printGrid();
                System.out.println("Đặt thuyền thành công!");
                System.out.println();
                Delay.delay(2000);
                ClearScreen.clrscr();
                break;
            } else if (headYIndex == tailYIndex) {
                for (int i = Math.min(headXIndex, tailXIndex); i <=  Math.max(headXIndex, tailXIndex); i++) {
                    playerGrid.board[i][headYIndex] = Color.SHIP + "S" + Color.RESET;
                }
                ship.setHead(head);
                ship.setTail(tail);
                shipList.add(ship);
                System.out.println();
                playerGrid.printGrid();
                System.out.println("Đặt thuyền thành công!");
                System.out.println();
                Delay.delay(2000);
                ClearScreen.clrscr();
                break;
            } else {
                System.out.println("\nTọa độ không hợp lệ");
                System.out.println("\nVui lòng nhập lại tọa độ");
            }
        }

    }

    public void printPlayerGrid(Grid playerAttackGrid, Grid playerGrid) {
        playerGrid.printAttackAndShipGrid(playerAttackGrid, playerGrid);
    }

    public boolean attack(Grid playerGrid, Grid playerAttackGrid) {
        System.out.print("Nhập tọa độ muốn bắn: ");
        while (true) {
            String attack = sc.nextLine();
            int attackXIndex = attack.toUpperCase().charAt(0) - 'A';
            int attackYIndex = Integer.parseInt(attack.substring(1)) - 1;
            if (playerAttackGrid.checkHit(attack)) {
                System.out.println("\nVị trí đã bắn!");
                System.out.print("Vui lòng nhập lại tọa độ: ");
                continue;
            }
            if (!playerAttackGrid.checkCoordinates(attack)) {
                System.out.println("\nTọa độ không hợp lệ!");
                System.out.print("Vui lòng nhập lại tọa độ: ");
                continue;
            }
            this.setHit(this.getHit() + 1);
            if (playerGrid.board[attackXIndex][attackYIndex].equals(Color.SHIP + "S" + Color.RESET)) {
                playerGrid.board[attackXIndex][attackYIndex] = Color.HIT + "X" + Color.RESET;
                playerAttackGrid.board[attackXIndex][attackYIndex] = Color.HIT + "X" + Color.RESET;
                System.out.println("Bắn trúng!");
                return true;
            } else {
                playerGrid.board[attackXIndex][attackYIndex] = Color.MISS + "*" + Color.RESET;
                playerAttackGrid.board[attackXIndex][attackYIndex] = Color.MISS + "*" + Color.RESET;
                System.out.println("Bắn trượt!");
                return false;
            }
        }
    }

    public int countShipIsSunk(Grid playerGrid) {
        int cntShipIsSunk = 0;
        for (Ship ship : shipList) {
            if (playerGrid.checkShipIsSunk(ship)) {
                cntShipIsSunk++;
            }
        }
        return cntShipIsSunk;
    }

    public void handPlaceShip() {
        ShipType shipType = new ShipType();
        while (!shipType.getList().isEmpty()) {
            System.out.println("Các loại tàu còn lại:");
            int count = 1;
            for (Ship ship : shipType.getList()) {
                System.out.println(count + ". " + ship.getName() + " " + "1x" + ship.getLength());
                count++;
            }
            System.out.print("\nVui lòng chọn tàu: ");
            int choice = Integer.parseInt(sc.nextLine());
            choice--;
            System.out.println();
            playerGrid.printGrid();
            System.out.println("\nĐặt thuyền " + shipType.getList().get(choice).getName() + " " + "1x" + shipType.getList().get(choice).getLength());
            System.out.println();
            Ship ship = shipType.getList().get(choice);
            placeShip(ship);
            shipType.getList().remove(choice);
        }
        System.out.println("\nBản thuyền của bạn\n");
        playerGrid.printGrid();
    }

    public void autoPlaceShip() {
        ShipType shipType = new ShipType();
        while (!shipType.getList().isEmpty()) {
            Ship ship = shipType.getList().get(0);
            while (true) {
                int headXIndex = (int) (Math.random() * Player.playerGridSize - 1); //X đầu
                int headYIndex = (int) (Math.random() * Player.playerGridSize - 1); //Y đầu
                int tailXIndex = -1; //X đuôi
                int tailYIndex = -1; //Y đuôi
                int direction = (int) (Math.random() * 4 + 1);  // 1: right, 2: left, 3: down, 4: up
                switch (direction) {
                    case 1:
                        tailXIndex = headXIndex + ship.getLength() - 1;
                        tailYIndex = headYIndex;
                        break;
                    case 2:
                        tailXIndex = headXIndex - ship.getLength() + 1;
                        tailYIndex = headYIndex;
                        break;
                    case 3:
                        tailXIndex = headXIndex;
                        tailYIndex = headYIndex - ship.getLength() + 1;
                        break;
                    case 4:
                        tailXIndex = headXIndex;
                        tailYIndex = headYIndex + ship.getLength() - 1;
                        break;
                }
                if (tailXIndex < 0 || tailXIndex > Player.playerGridSize - 1 || tailYIndex < 0 || tailYIndex > Player.playerGridSize - 1) {
                    continue;
                }

                String head = (char) ('A' + headXIndex) + String.valueOf(headYIndex + 1);
                String tail = (char) ('A' + tailXIndex) + String.valueOf(tailYIndex + 1);
                if (playerGrid.checkExsitShip(head, tail)) {
                    continue;
                }
                if (headXIndex == tailXIndex) {
                    for (int i = Math.min(headYIndex, tailYIndex); i <= Math.max(tailYIndex, headYIndex); i++) {
                        playerGrid.board[headXIndex][i] = Color.SHIP + "S" + Color.RESET;
                    }
                    ship.setHead(head);
                    ship.setTail(tail);
                    shipList.add(ship);
                    shipType.getList().remove(0);
                    break;
                } else {
                    for (int i = Math.min(headXIndex, tailXIndex); i <= Math.max(tailXIndex, headXIndex); i++) {
                        playerGrid.board[i][headYIndex] = Color.SHIP + "S" + Color.RESET;
                    }
                    ship.setHead(head);
                    ship.setTail(tail);
                    shipList.add(ship);
                    shipType.getList().remove(0);
                    break;
                }

            }
        }
    }

    public boolean autoAttack(Player computer, Grid playerGrid, Grid computerAttackGrid) {
        while (true) {
            int x = (int) (Math.random() * Player.playerGridSize - 1);
            int y = (int) (Math.random() * Player.playerGridSize - 1);
            String postion = (char) ('A' + x) + String.valueOf(y + 1);
            if (computerAttackGrid.checkHit(postion)) {
                continue;
            }
            computer.setHit(computer.getHit() + 1);
            if (playerGrid.board[x][y].equals(Color.SHIP + "S" + Color.RESET)) {
                playerGrid.board[x][y] = Color.HIT + "X" + Color.RESET;
                computerAttackGrid.board[x][y] = Color.HIT + "X" + Color.RESET;
                System.out.println("Bắn trúng!");
                return true;
            } else {
                playerGrid.board[x][y] = Color.MISS + "*" + Color.RESET;
                computerAttackGrid.board[x][y] = Color.MISS + "*" + Color.RESET;
                System.out.println("Bắn trượt!");
                return false;
            }
        }
    }

//    public void resetNextPriorityPostion(Grid playerGrid, Grid computerAttackGrid) {


//
//    }

    public boolean hardModeBotAttack(Player computer, Player player, Grid playerGrid, Grid computerAttackGrid) {
        while (true) {
            // Nếu 1 thuyền đã chìm thì đánh dấu các ô xung quanh nó là . (Ko cần bắn vào các ô này)
            for (Ship ship : player.shipList) {
                if (playerGrid.checkShipIsSunk(ship)) {
                    int headXIndex = ship.getHead().toUpperCase().charAt(0) - 'A';
                    int tailXIndex = ship.getTail().toUpperCase().charAt(0) - 'A';
                    int headYIndex = Integer.parseInt(ship.getHead().substring(1)) - 1;
                    int tailYIndex = Integer.parseInt(ship.getTail().substring(1)) - 1;
                    if (headXIndex == tailXIndex) {
                        if (Math.min(headYIndex, tailYIndex) - 1 >= 0 && playerGrid.board[headXIndex][Math.min(headYIndex, tailYIndex) - 1].equals(Color.WATER + "~" + Color.RESET)) {
                            computerAttackGrid.board[headXIndex][Math.min(headYIndex, tailYIndex) - 1] = ".";
                        }
                        if (Math.max(headYIndex, tailYIndex) + 1 < Player.playerGridSize && playerGrid.board[headXIndex][Math.max(headYIndex, tailYIndex) + 1].equals(Color.WATER + "~" + Color.RESET)) {
                            computerAttackGrid.board[headXIndex][Math.max(headYIndex, tailYIndex) + 1] = ".";
                        }
                        for (int i = Math.min(headYIndex, tailYIndex); i <= Math.max(tailYIndex, headYIndex); i++) {
                            if (headXIndex - 1 >= 0 && playerGrid.board[headXIndex - 1][i].equals(Color.WATER + "~" + Color.RESET)) {
                                computerAttackGrid.board[headXIndex - 1][i] = ".";
                            }
                            if (headXIndex + 1 < Player.playerGridSize && playerGrid.board[headXIndex + 1][i].equals(Color.WATER + "~" + Color.RESET)) {
                                computerAttackGrid.board[headXIndex + 1][i] = ".";
                            }
                        }
                    } else if (headYIndex == tailYIndex) {
                        if (Math.min(headXIndex, tailXIndex) - 1 >= 0 && playerGrid.board[Math.min(headXIndex, tailXIndex) - 1][headYIndex].equals(Color.WATER + "~" + Color.RESET)) {
                            computerAttackGrid.board[Math.min(headXIndex, tailXIndex) - 1][headYIndex] = ".";
                        }
                        if (Math.max(headXIndex, tailXIndex) + 1 < Player.playerGridSize && playerGrid.board[Math.max(headXIndex, tailXIndex) + 1][headYIndex].equals(Color.WATER + "~" + Color.RESET)) {
                            computerAttackGrid.board[Math.max(headXIndex, tailXIndex) + 1][headYIndex] = ".";
                        }
                        for (int i = Math.min(headXIndex, tailXIndex); i <= Math.max(tailXIndex, headXIndex); i++) {
                            if (headYIndex - 1 >= 0 && playerGrid.board[i][headYIndex - 1].equals(Color.WATER + "~" + Color.RESET)) {
                                computerAttackGrid.board[i][headYIndex - 1] = ".";
                            }
                            if (headYIndex + 1 < Player.playerGridSize && playerGrid.board[i][headYIndex + 1].equals(Color.WATER + "~" + Color.RESET)) {
                                computerAttackGrid.board[i][headYIndex + 1] = ".";
                            }
                        }
                    }
                }
            }
            // Tìm priorityPostion
            boolean priority = false;
            int priorityX = -1;
            int priorityY = -1;
            String priorityPostion = "";

            for (int i = 0; i < Player.playerGridSize; i++) {
                for (int j = 0; j < Player.playerGridSize; j++) {
                    if (playerGrid.board[i][j].equals(Color.HIT + "X" + Color.RESET)) {
                        if (i - 1 >= 0 && computerAttackGrid.board[i - 1][j].equals(Color.WATER + "~" + Color.RESET)) {
                            priority = true;
                            priorityX = i - 1;
                            priorityY = j;
                            priorityPostion = (char) ('A' + priorityX) + String.valueOf(priorityY + 1);
                        }
                        if (i + 1 < Player.playerGridSize && computerAttackGrid.board[i + 1][j].equals(Color.WATER + "~" + Color.RESET)) {
                            priority = true;
                            priorityX = i + 1;
                            priorityY = j;
                            priorityPostion = (char) ('A' + priorityX) + String.valueOf(priorityY + 1);
                        }
                        if (j - 1 >= 0 && computerAttackGrid.board[i][j - 1].equals(Color.WATER + "~" + Color.RESET)) {
                            priority = true;
                            priorityX = i;
                            priorityY = j - 1;
                            priorityPostion = (char) ('A' + priorityX) + String.valueOf(priorityY + 1);
                        }
                        if (j + 1 < Player.playerGridSize && computerAttackGrid.board[i][j + 1].equals(Color.WATER + "~" + Color.RESET)) {
                            priority = true;
                            priorityX = i;
                            priorityY = j + 1;
                            priorityPostion = (char) ('A' + priorityX) + String.valueOf(priorityY + 1);
                        }
                    }
                }
                if (priority) {
                    break;
                }
            }
            if (priority) {
                computer.setHit(computer.getHit() + 1);
                if (playerGrid.board[priorityX][priorityY].equals(Color.SHIP + "S" + Color.RESET)) {
                    playerGrid.board[priorityX][priorityY] = Color.HIT + "X" + Color.RESET;
                    computerAttackGrid.board[priorityX][priorityY] = Color.HIT + "X" + Color.RESET;
                    System.out.println("Tọa độ máy bắn: " + priorityPostion);
                    Delay.delay(500);
                    System.out.println("Bắn trúng!");
                    return true;
                } else {
                    playerGrid.board[priorityX][priorityY] = Color.MISS + "*" + Color.RESET;
                    computerAttackGrid.board[priorityX][priorityY] = Color.MISS + "*" + Color.RESET;
                    System.out.println("Tọa độ máy bắn: " + priorityPostion);
                    Delay.delay(500);
                    System.out.println("Bắn trượt!");
                    return false;
                }
            }
            int x = (int) (Math.random() * Player.playerGridSize - 1);
            int y = (int) (Math.random() * Player.playerGridSize - 1);
            String postion = (char) ('A' + x) + String.valueOf(y + 1);
            if (computerAttackGrid.checkHit(postion)) {
                continue;
            }
            computer.setHit(computer.getHit() + 1);
            System.out.println("Tọa độ máy bắn: " + postion);
            Delay.delay(500);
            if (playerGrid.board[x][y].equals(Color.SHIP + "S" + Color.RESET)) {
                playerGrid.board[x][y] = Color.HIT + "X" + Color.RESET;
                computerAttackGrid.board[x][y] = Color.HIT + "X" + Color.RESET;
                System.out.println("Bắn trúng!");

                return true;
            } else {
                playerGrid.board[x][y] = Color.MISS + "*" + Color.RESET;
                computerAttackGrid.board[x][y] = Color.MISS + "*" + Color.RESET;
                System.out.println("Bắn trượt!");
                return false;
            }

        }
    }
}



