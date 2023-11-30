package Player;

import Display.Display;
import Ship.*;

public class Player_Prepare {
    private Player player;
    private Display display;
    public Player_Prepare(Player player) {
        this.player = player;
        display = new Display(player, new Player());
    }

    public void prepare(){
        player.setType();
        display.horizontalLine();
        selectShipPosition();
    }
    private void selectShipPosition() {
//        player.getListShip().add(Ship.getShipFromScanner("Tàu tuần tra", 2, player.getPositionShips()));
//        updateShipPosition(player.getListShip().getLast());
//        display.horizontalLine();
//        display.map();
//        player.getListShip().add(Ship.getShipFromScanner("Tàu tuần tra", 2, player.getPositionShips()));
//        updateShipPosition(player.getListShip().getLast());
//        display.horizontalLine();
//        display.map();
//        player.getListShip().add(Ship.getShipFromScanner("Tàu ngầm", 3, player.getPositionShips()));
//        updateShipPosition(player.getListShip().getLast());
//        display.horizontalLine();
//        display.map();
//        player.getListShip().add(Ship.getShipFromScanner("Tàu khu trục", 4, player.getPositionShips()));
//        updateShipPosition(player.getListShip().getLast());
//        display.horizontalLine();
//        display.map();
        player.getListShip().add(Ship.getShipFromScanner("Thiết giáp hạm", 5, player.getPositionShips()));
        updateShipPosition(player.getListShip().getLast());
        display.horizontalLine();
        display.map();
        int HP_temp=0;
        for (Ship tau : player.getListShip()) HP_temp+=tau.getHP();
        player.setHP(HP_temp);
    }
    private void updateShipPosition(Ship tau) {
        int start = tau.getBowPosition().getX() == tau.getSternPosition().getX() ? Math.min(tau.getBowPosition().getY(), tau.getSternPosition().getY()) : Math.min(tau.getBowPosition().getX(), tau.getSternPosition().getX());
        int   end = tau.getBowPosition().getX() == tau.getSternPosition().getX() ? Math.max(tau.getBowPosition().getY(), tau.getSternPosition().getY()) : Math.max(tau.getBowPosition().getX(), tau.getSternPosition().getX());
        for (int i = start; i <= end; i++) {
            if (tau.getBowPosition().getY() == tau.getSternPosition().getY())
                 player.getPositionShips()[i][tau.getBowPosition().getY()] = 1;
            else player.getPositionShips()[tau.getBowPosition().getX()][i] = 1;
        }
    }
}
