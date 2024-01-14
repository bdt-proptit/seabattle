package Player;

import Display.*;
import Ship.*;

public class Player_Prepare {
    private Player player;
    private Display display;
    public Player_Prepare(Player player) {
        this.player = player;
        display = new Display(player, new Player());
    }

    public void prepare(){
        player.setName();
        display.horizontalLine();
        while (true) {
            display.menuSetShipsPosition();
            System.out.print("Chọn chế độ đặt tàu: ");
            int mode = Integer.parseInt(new Scan().cin());
            switch (mode) {
                case 1:
                    display.changeColor();
                    selectShipPosition();
                    return;
                case 2:
                    getRandomShipPosition();
                    return;
                default:
                    System.out.println("Không hợp lệ.");
            }
        }
    }
    public void getRandomShipPosition() {
        while (true){
            player.getListShip().add(GetShip.random("Tàu tuần tra", 2, player.getPositionShips()));
            updateShipPosition(player.getListShip().getLast());
            player.getListShip().add(GetShip.random("Tàu tuần tra", 2, player.getPositionShips()));
            updateShipPosition(player.getListShip().getLast());
            player.getListShip().add(GetShip.random("Tàu ngầm", 3, player.getPositionShips()));
            updateShipPosition(player.getListShip().getLast());
            player.getListShip().add(GetShip.random("Tàu khu trục", 4, player.getPositionShips()));
            updateShipPosition(player.getListShip().getLast());
            player.getListShip().add(GetShip.random("Thiết giáp hạm", 5, player.getPositionShips()));
            updateShipPosition(player.getListShip().getLast());
            int HP_temp=0;
            for (Ship ship : player.getListShip()) {
                if (ship == null) {
                    player.getListShip().clear();
                    continue;
                } else HP_temp += ship.getHP();
            }
            player.setHP(HP_temp);
            display.map();
            break;
        }
    }
    private void selectShipPosition() {
        player.getListShip().add(GetShip.fromScanner("Tàu tuần tra", 2, player.getPositionShips()));
        updateShipPosition(player.getListShip().getLast());
        display.map();
        player.getListShip().add(GetShip.fromScanner("Tàu tuần tra", 2, player.getPositionShips()));
        updateShipPosition(player.getListShip().getLast());
        display.map();
        player.getListShip().add(GetShip.fromScanner("Tàu ngầm", 3, player.getPositionShips()));
        updateShipPosition(player.getListShip().getLast());
        display.map();
        player.getListShip().add(GetShip.fromScanner("Tàu khu trục", 4, player.getPositionShips()));
        updateShipPosition(player.getListShip().getLast());
        display.map();
        player.getListShip().add(GetShip.fromScanner("Thiết giáp hạm", 5, player.getPositionShips()));
        updateShipPosition(player.getListShip().getLast());
        display.map();
        int HP_temp=0;
        for (Ship tau : player.getListShip()) HP_temp+=tau.getHP();
        player.setHP(HP_temp);
    }
    private void updateShipPosition(Ship tau) {
        if(tau==null) return;
        int start = tau.getBowPosition().getX() == tau.getSternPosition().getX() ? Math.min(tau.getBowPosition().getY(), tau.getSternPosition().getY()) : Math.min(tau.getBowPosition().getX(), tau.getSternPosition().getX());
        int   end = tau.getBowPosition().getX() == tau.getSternPosition().getX() ? Math.max(tau.getBowPosition().getY(), tau.getSternPosition().getY()) : Math.max(tau.getBowPosition().getX(), tau.getSternPosition().getX());
        for (int i = start; i <= end; i++) {
            if (tau.getBowPosition().getY() == tau.getSternPosition().getY())
                 player.getPositionShips()[i][tau.getBowPosition().getY()] = 1;
            else player.getPositionShips()[tau.getBowPosition().getX()][i] = 1;
        }
    }
}
