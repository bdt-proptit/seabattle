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
    protected Player player, opponent;
    protected Display display;
    public Player_Attack(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
        display = new Display();
    }

    public boolean attack(boolean attacked) {
        System.out.println("Chức năng khai hỏa.");
        display.horizontalLine();
        if(attacked) {
            System.out.println("Bạn đã tấn công ở lượt này.");
            display.enterToContinue();
            return true;
        }
        while (!attacked) {
            Coordinate shootingPosition = chooseShootingPosition();
            player.increaseShotCount();
            attacked = !checkShotHit(shootingPosition);
            if (!attacked && !continueAttack()) break;
        }
        return true;
    }
    public boolean continueAttack(){
        while (true) {
            System.out.println("Bạn có muốn bắn tiếp không (y/n)?");
            switch (new Scan().cin()){
                case "y", "Y":
                    display.horizontalLine();
                    System.out.println("Tiếp tục bắn.");
                    return true;
                case "n", "N":
                    display.horizontalLine();
                    System.out.println("Ngừng bắn.");
                    display.enterToContinue();
                    return false;
                default:
                    System.out.println("Không hợp lệ.");

            }
        }
    }
    public boolean checkShotHit(Coordinate shootingPosition) {
        for(Ship ship : opponent.getListShip()) {
            int start = ship.getBowPosition().getX()==ship.getSternPosition().getX() ? Math.min(ship.getBowPosition().getY(), ship.getSternPosition().getY()) : Math.min(ship.getBowPosition().getX(), ship.getSternPosition().getX());
            int end = ship.getBowPosition().getX()==ship.getSternPosition().getX() ? Math.max(ship.getBowPosition().getY(), ship.getSternPosition().getY()) : Math.max(ship.getBowPosition().getX(), ship.getSternPosition().getX());
            if(     (shootingPosition.getX()==ship.getBowPosition().getX() && shootingPosition.getX()==ship.getSternPosition().getX() && start <= shootingPosition.getY() && (shootingPosition.getY() <= end)) ||
                    (shootingPosition.getY()==ship.getBowPosition().getY() && shootingPosition.getY()==ship.getSternPosition().getY() && start <= shootingPosition.getX() && shootingPosition.getX() <= end)) {
                opponent.getPositionShips()[shootingPosition.getX()][shootingPosition.getY()]=2;
                updateResult(opponent, ship);
                return true;
            }
        }
        System.out.println("Bạn đã bắn trượt.");
        opponent.getPositionShips()[shootingPosition.getX()][shootingPosition.getY()]=3;
        display.enterToContinue();
        return false;
    }
    private Coordinate chooseShootingPosition(){
        while(true) {
            System.out.print("Chọn vị trí bắn: ");
            Coordinate shootingPosition = Coordinate.coodinateFromScanner();
            int status = opponent.getPositionShips()[shootingPosition.getX()][shootingPosition.getY()];
            if(status==2 || status==3) {
                display.horizontalLine();
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
        display.horizontalLine();
        System.out.println("Bạn đã bắn trúng " + ship.getType());
        ship.shotHit();
        opponent.decreaseHP();
        if(ship.getHP()==0) {
            opponent.getListShip().remove(ship);
            System.out.println("Tàu đã chìm.");
            if(opponent.getHP()==0) return;
        }
    }
}
