package SeaBattle.game;

import SeaBattle.board.*;

public class Gameplay {
    private Player pOne;
    private Player pTwo;
    private String COMPUTER = "AI";

    public Gameplay(String name1, String name2) {
        pOne = new Player(name1);
        pTwo = new Player(name2);
    }

    public Gameplay(String name) {
        pOne = new Player(name);
        pTwo = new Player(COMPUTER, true);
    }
    private boolean turn(Player attack, Player defend) throws PositionException {
        Position shoot = null;
        boolean isHit, isAddHit;
        if (attack.hasShipsLive()) {
            do {
                try {
                    shoot = attack.shoot(defend.getBoard().getBoardHideShips());
                    isAddHit = defend.addShoot(shoot);
                }
                catch (BoardException e) {
                    if (!attack.isAI()) Display.printError("Error, you've already shot at this location!");
                    isAddHit = false;
                }
            } while (!isAddHit);
            isHit = defend.getBoard().thereIsHit(shoot);
            if (isHit) attack.registerShoot(shoot);
            Display.printShot(attack, shoot, isHit);

            if (attack.isAI() && defend.isAI()) Display.printAdjacentBoard(attack, defend);
            else if (!attack.isAI()) Display.printAdjacentBoard(attack, defend);
            else if (!defend.isAI()) Display.printAdjacentBoard(defend, attack);

            if (!attack.isAI() && !defend.isAI()) try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
            }
            return true;
        } else return false;
    }

    private void addAllShips() {
        pOne.addAllShips();
        pTwo.addAllShips();
    }

    private void printResultGame() {
        if (pOne.shipsLeft() > pTwo.shipsLeft()) Display.printWinner(pOne);
        else Display.printWinner(pTwo);
    }

    public void run() throws PositionException {
        addAllShips();
        while (turn(pOne, pTwo) && turn(pTwo, pOne)) {
        }
        printResultGame();
    }
}
