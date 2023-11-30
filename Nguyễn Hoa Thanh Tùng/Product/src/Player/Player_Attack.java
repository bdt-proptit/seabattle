package Player;

import Display.Display;
import Ship.*;
/*
        Qui ước hiển thị:
            0: không có tàu
            1: tàu chưa bị bắn
            2: tàu đã bị bắn
            3: vị trí bị bắn nhưng không có tàu (bắn trượt)
 */
public class Player_Attack {
    private Player player, opponent;
    private Display display;
    public Player_Attack(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
        display = new Display();
    }

    public void attack(boolean attacked) {
        System.out.println("Chức năng khai hỏa.");
        display.horizontalLine();
        if(attacked) {
            System.out.println("Bạn đã tấn công ở lượt này.");
            display.enterToContinue();
            return;
        }
        Coordinate shootingPosition = chooseShootingPosition();
        player.increaseShotCount();
        boolean shotHit = false;
        for(Ship ship : opponent.getListShip()) {
            int start = ship.getBowPosition().getX()==ship.getSternPosition().getX() ? Math.min(ship.getBowPosition().getY(), ship.getSternPosition().getY()) : Math.min(ship.getBowPosition().getX(), ship.getSternPosition().getX());
            int end = ship.getBowPosition().getX()==ship.getSternPosition().getX() ? Math.max(ship.getBowPosition().getY(), ship.getSternPosition().getY()) : Math.max(ship.getBowPosition().getX(), ship.getSternPosition().getX());
            if(     (shootingPosition.getX()==ship.getBowPosition().getX() && shootingPosition.getX()==ship.getSternPosition().getX() && start <= shootingPosition.getY() && (shootingPosition.getY() <= end)) ||
                    (shootingPosition.getY()==ship.getBowPosition().getY() && shootingPosition.getY()==ship.getSternPosition().getY() && start <= shootingPosition.getX() && shootingPosition.getX() <= end)) {
                opponent.getPositionShips()[shootingPosition.getX()][shootingPosition.getY()]=2;
                updateResult(opponent, ship);
                shotHit = true;
                return;
            }
            if(!shotHit) {
                System.out.println("Bạn đã bắn trượt.");
                attacked=true;
                display.enterToContinue();
            }
            opponent.getPositionShips()[shootingPosition.getX()][shootingPosition.getY()]=3;
        }
    }
    private Coordinate chooseShootingPosition(){
        while(true) {
            System.out.print("Chọn vị trí bắn: ");
            Coordinate shootingPosition = Coordinate.coodinateFromScanner();
            int status = opponent.getPositionShips()[shootingPosition.getX()][shootingPosition.getY()];
            if(status==2 || status==3) {
                System.out.println("Bạn đã bắn ở vị trí này.");
                display.enterToContinue();
                display.horizontalLine();
            }
            else {
                display.horizontalLine();
                return shootingPosition;
            }
        }
    }
    private void updateResult(Player opponent, Ship ship) {
        System.out.println("Bạn đã bắn trúng tàu.");
        ship.shotHit();
        opponent.decreaseHP();
        if(ship.getHP()==0) {
            opponent.getListShip().remove(ship);
            System.out.println("Tàu đã chìm.");
            if(opponent.getHP()==0) return;
        }
        display.enterToContinue();
        display.horizontalLine();
    }
}
