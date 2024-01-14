public class Manager {
    private Player p1;
    private Player p2;

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    Manager(){
        p1 = new Player();
        p2 = new Player();
    }

    public void setUp(){
        int mark = 1;
        ShipType shipType = new ShipType();
        Menu.setUpScreen(p1);
        Menu.outputPlayerBoard(p1);
        while(shipType.getList().size() > 0){
            Ship ship = Menu.inputShip(shipType, p1);
            p1.placeShip(ship, mark);
            Menu.outputPlayerBoard(p1);
            mark++;
        }
        Menu.pauseScreen();
        Menu.setUpScreen(p2);
        Menu.outputPlayerBoard(p2);
        mark = 1;
        shipType = new ShipType();
        while(shipType.getList().size() > 0){
            Ship ship = Menu.inputShip(shipType, p2);
            p2.placeShip(ship, mark);
            Menu.outputPlayerBoard(p2);
            mark++;
        }
        Menu.pauseScreen();
    }
    public void informationUpdate(){
        p1.setShipRemain();
        p2.setShipRemain();
        p2.setShipDestroyed(5 - p1.getShipRemain());
        p1.setShipDestroyed(5 - p2.getShipRemain());
    }
    public void startTurn(Player player, Player opp){
        Menu.outputPlayerBoard(player);
        while(true){
            int func = Menu.inputFunction(player);
            if(func == 2){
                Menu.pauseScreen();
                break;
            }
            if(func == 1){
                int[] shootLocation = Menu.inputShootLocation();
                int status = player.shoots(shootLocation[0], shootLocation[1], opp);
                player.setNumberOfShotCell(player.getNumberOfShotCell() + 1);
                Menu.outputPlayerBoard(player);
                Menu.shootNoti(status);
                Menu.pauseScreen();
                break;
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
