import java.util.Scanner;

public class Manager {
    private Player p1;
    private Player p2;
    private int playing;
    Manager(){
        p1 = new Player();
        p2 = new Player();
        playing = 1;
    }
    public void setUp(){
        int mark = 1;
        ShipType shipType = new ShipType();
        Menu.setUpScreen(p1);
        Menu.outputPlayerBoard(p1);
        while(shipType.getList().size() > 0){
            Ship ship = Menu.inputShip(shipType);
            p1.placeShip(ship, mark);
            Menu.outputPlayerBoard(p1);
            mark++;
        }
        Menu.setUpScreen(p2);
        Menu.outputPlayerBoard(p2);
        mark = 1;
        shipType = new ShipType();
        while(shipType.getList().size() > 0){
            Ship ship = Menu.inputShip(shipType);
            p2.placeShip(ship, mark);
            Menu.outputPlayerBoard(p2);
            mark++;
        }
    }
    public void informationUpdate(){
        p1.setShipRemain();
        p2.setShipRemain();
        p2.setShipDestroyed(5 - p1.getShipRemain());
        p1.setShipDestroyed(5 - p2.getShipRemain());
    }
    public void startTurn(){
        if(playing == 1){
            while(true){
                int func = Menu.inputFunction(p1);
                if(func == 3){
                    playing = 2;
                    Menu.pauseScreen();
                    break;
                }
                if(func == 2){
                    int[] shootLocation = Menu.inputShootLocation();
                    Menu.outputShotBoard(p1);
                    int status = p1.shoots(shootLocation[0], shootLocation[1], p2);
                    p1.setNumberOfShotCell(p1.getNumberOfShotCell() + 1);
                    Menu.shootNoti(status);
                    Menu.pauseScreen();
                    playing = 2;
                    break;
                }else if(func == 1){
                    Menu.outputPlayerBoard(p1);
                    Menu.pauseScreen();
                }
            }
        }else if(playing == 2){
            while(true){
                int func = Menu.inputFunction(p2);
                if(func == 3){
                    playing = 1;
                    Menu.pauseScreen();
                    break;
                }
                if(func == 2){
                    int[] shootLocation = Menu.inputShootLocation();
                    Menu.outputShotBoard(p1);
                    int status = p2.shoots(shootLocation[0], shootLocation[1], p1);
                    p2.setNumberOfShotCell(p2.getNumberOfShotCell() + 1);
                    Menu.shootNoti(status);
                    Menu.pauseScreen();
                    playing = 1;
                    break;
                }else if(func == 1){
                    Menu.outputPlayerBoard(p2);
                    Menu.pauseScreen();
                }
            }
        }
        informationUpdate();
    }
    public int endTurn(){
        int status = 0;
        if(p2.getShipRemain() == 0){
            status = 1;
        }
        if(p1.getShipRemain() == 0){
            status = 2;
        }
        Menu.endGameNoti(status, p1, p2);
        if(status != 0) return 1;
        return 0;
    }
}
