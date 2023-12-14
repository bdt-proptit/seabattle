import java.security.PublicKey;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    private String name;
    private int sizeOfBoard;
    private Board gameBoard = new Board();
    private Ship patrolBoat1 = new Ship("Patrol Boat 1", 2);
    private Ship patrolBoat2 = new Ship("Patrol Boat 2", 2);
    private Ship destroyerBoat = new Ship("Destroyer Boat", 4);
    private Ship submarine = new Ship("Submarine", 3);
    private Ship battleShip = new Ship("Battle Ship", 5);

    public Ship getPatrolBoat1(){
        return this.patrolBoat1;
    }
    public Ship getPatrolBoat2(){
        return this.patrolBoat2;
    }
    public Ship getDestroyerBoat(){
        return this.destroyerBoat;
    }
    public Ship getBattleShip(){
        return this.battleShip;
    }
    public Ship getSubmarine(){
        return this.submarine;
    }
    public Board getGameBoard(){
        return this.gameBoard;
    }
    public boolean setSizeOfBoard(int sizeOfBoard){
        if (sizeOfBoard >= 10 && sizeOfBoard <= 20) {
            this.sizeOfBoard = sizeOfBoard;
            gameBoard.setSize(sizeOfBoard);
            return true;
        }
        return false;
    }
    public int getSizeOfBoard(){
        return this.sizeOfBoard;
    }
    public void setName(String name){
        this.name = name;
    }
    public  String getName(){
        return this.name;
    }
    public void setUpGameBoard(){
        gameBoard.setUpAllCellStatus();
    }


    public boolean setPositionPB1(Position position){
        if (!gameBoard.checkposition(position)) return false;
        patrolBoat1.setPosition(position);
        return true;
    }
    public boolean setOrientationPB1(String orientationPB1){
        Position position = patrolBoat1.getPosition();

        if (!gameBoard.checkOrientation(orientationPB1, position, patrolBoat1.getSize())) return false;
        patrolBoat1.setOrientation(orientationPB1);
        gameBoard.markLocation(patrolBoat1.getPosition(),orientationPB1,patrolBoat1.getSize(),CellStatus.PatrolBoat);
        return true;
    }
    public boolean setPositionPB2(Position position){
        if (!gameBoard.checkposition(position)) return false;
        patrolBoat2.setPosition(position);
        return true;
    }
    public boolean setOrientationPB2(String orientationPB2){
        Position position = patrolBoat2.getPosition();

        if (!gameBoard.checkOrientation(orientationPB2, position, patrolBoat2.getSize())) return false;

        patrolBoat2.setOrientation(orientationPB2);
        gameBoard.markLocation(patrolBoat2.getPosition(),orientationPB2,patrolBoat2.getSize(),CellStatus.PatrolBoat);
        return true;
    }
    public boolean setPositionDB(Position position){
        if (!gameBoard.checkposition(position)) return false;
        destroyerBoat.setPosition(position);
        return true;
    }
    public boolean setOrientationDB(String orientationDB){
        Position position = destroyerBoat.getPosition();

        if (!gameBoard.checkOrientation(orientationDB, position, destroyerBoat.getSize())) return false;

        destroyerBoat.setOrientation(orientationDB);
        gameBoard.markLocation(destroyerBoat.getPosition(),orientationDB,destroyerBoat.getSize(),CellStatus.DestroyerBoat);
        return true;
    }
    public boolean setPositionSM(Position position){
        if (!gameBoard.checkposition(position)) return false;
        submarine.setPosition(position);
        return true;
    }
    public boolean setOrientationSM(String orientationSM){
        Position position = submarine.getPosition();

        if (!gameBoard.checkOrientation(orientationSM, position, submarine.getSize())) return false;

        submarine.setOrientation(orientationSM);
        gameBoard.markLocation(submarine.getPosition(),orientationSM,submarine.getSize(),CellStatus.Submarine);
        return true;
    }
    public boolean setPositionBS(Position position){
        if (!gameBoard.checkposition(position)) return false;
        battleShip.setPosition(position);
        return true;
    }
    public boolean setOrientationBS(String orientationBS){
        Position position = battleShip.getPosition();

        if (!gameBoard.checkOrientation(orientationBS, position, battleShip.getSize())) return false;

        battleShip.setOrientation(orientationBS);
        gameBoard.markLocation(battleShip.getPosition(),orientationBS,battleShip.getSize(),CellStatus.BattleShip);
        return true;
    }


    public boolean gameOver(){
        return gameBoard.areAllCraftsDestroyed();
    }

    public void displayVeil(){
        gameBoard.show(false);
    }
    public void displayUnVeil(){
        gameBoard.show(true);
    }
    public void AISetUp(){
        //Random rand = new Random();

        setUpGameBoard();

        int x,y;
        Position position = new Position();
        String orientation;

        while (true){
            //System.out.print("Chon toa do cua thuyen tuan tra 1: ");
            x = ThreadLocalRandom.current().nextInt(1,sizeOfBoard+1);
            y = ThreadLocalRandom.current().nextInt(1,sizeOfBoard+1);
            position.setX(x);
            position.setY(y);
            int check =0;
            if (setPositionPB1(position)){
                int d=0;
                int[] tik = new int[5];
                while(true) {
                    //System.out.print("Chon huong cua thuyen tuan tra 1 (NORTH, SOUTH, EAST, WEST): ");
                    int rand = ThreadLocalRandom.current().nextInt(1,5);
                    switch (rand){
                        case 1:
                            orientation = "NORTH";
                            if (tik[1]==0){
                                tik[1]=1;
                                d++;
                            }
                            break;
                        case 2:
                            orientation = "EAST";
                            if (tik[2]==0){
                                tik[2]=1;
                                d++;
                            }
                            break;
                        case 3:
                            orientation = "SOUTH";
                            if (tik[3]==0){
                                tik[3]=1;
                                d++;
                            }
                            break;
                        default:
                            orientation = "WEST";
                            if (tik[4]==0){
                                tik[4]=1;
                                d++;
                            }
                            break;
                    }
                    if (setOrientationPB1(orientation)) {
                        check=1;
                        break;
                    }
                    if (d==4) break;
                }
                if (check == 1) break;
            }
        }

        while(true) {
            x = ThreadLocalRandom.current().nextInt(1,sizeOfBoard+1);
            y = ThreadLocalRandom.current().nextInt(1,sizeOfBoard+1);
            position.setX(x);
            position.setY(y);
            int check =0;
            if (setPositionPB2(position)) {
                int d=0;
                int[] tik = new int[5];
                while(true) {
                    int rand = ThreadLocalRandom.current().nextInt(1,5);
                    switch (rand) {
                        case 1 -> {
                            orientation = "NORTH";
                            if (tik[1] == 0) {
                                tik[1] = 1;
                                d++;
                            }
                        }
                        case 2 -> {
                            orientation = "EAST";
                            if (tik[2] == 0) {
                                tik[2] = 1;
                                d++;
                            }
                        }
                        case 3 -> {
                            orientation = "SOUTH";
                            if (tik[3] == 0) {
                                tik[3] = 1;
                                d++;
                            }
                        }
                        default -> {
                            orientation = "WEST";
                            if (tik[4] == 0) {
                                tik[4] = 1;
                                d++;
                            }
                        }
                    }
                    if (setOrientationPB2(orientation)) {
                        check=1;
                        break;
                    }
                    if (d==4) break;
                }
                if (check == 1) break;
            }
        }

        while (true) {
            x = ThreadLocalRandom.current().nextInt(1,sizeOfBoard+1);
            y = ThreadLocalRandom.current().nextInt(1,sizeOfBoard+1);
            position.setX(x);
            position.setY(y);
            int check =0;
            if (setPositionDB(position)) {
                int d=0;
                int[] tik = new int[5];
                while (true) {
                    int rand = ThreadLocalRandom.current().nextInt(1,5);
                    switch (rand){
                        case 1:
                            orientation = "NORTH";
                            if (tik[1]==0){
                                tik[1]=1;
                                d++;
                            }
                            break;
                        case 2:
                            orientation = "EAST";
                            if (tik[2]==0){
                                tik[2]=1;
                                d++;
                            }
                            break;
                        case 3:
                            orientation = "SOUTH";
                            if (tik[3]==0){
                                tik[3]=1;
                                d++;
                            }
                            break;
                        default:
                            orientation = "WEST";
                            if (tik[4]==0){
                                tik[4]=1;
                                d++;
                            }
                            break;
                    }
                    if (setOrientationDB(orientation)) {
                        check = 1;
                        break;
                    }
                    if (d==4) break;
                }
                if (check == 1) break;
            }
        }

        while (true) {
            x = ThreadLocalRandom.current().nextInt(1,sizeOfBoard+1);
            y = ThreadLocalRandom.current().nextInt(1,sizeOfBoard+1);
            position.setX(x);
            position.setY(y);
            int check =0;
            if (setPositionSM(position)) {
                int d=0;
                int[] tik = new int[5];
                while(true) {
                    int rand = ThreadLocalRandom.current().nextInt(1,5);
                    switch (rand){
                        case 1:
                            orientation = "NORTH";
                            if (tik[1]==0){
                                tik[1]=1;
                                d++;
                            }
                            break;
                        case 2:
                            orientation = "EAST";
                            if (tik[2]==0){
                                tik[2]=1;
                                d++;
                            }
                            break;
                        case 3:
                            orientation = "SOUTH";
                            if (tik[3]==0){
                                tik[3]=1;
                                d++;
                            }
                            break;
                        default:
                            orientation = "WEST";
                            if (tik[4]==0){
                                tik[4]=1;
                                d++;
                            }
                            break;
                    }
                    if (setOrientationSM(orientation)) {
                        check = 1;
                        break;
                    }
                    if (d==4) break;
                }
                if (check == 1)break;
            }
        }

        while (true) {
            x = ThreadLocalRandom.current().nextInt(1,sizeOfBoard+1);
            y = ThreadLocalRandom.current().nextInt(1,sizeOfBoard+1);
            position.setX(x);
            position.setY(y);
            int check =0;
            if (setPositionBS(position)) {
                int d=0;
                int[] tik = new int[5];
                while (true) {
                    int rand = ThreadLocalRandom.current().nextInt(1,5);
                    switch (rand){
                        case 1:
                            orientation = "NORTH";
                            if (tik[1]==0){
                                tik[1]=1;
                                d++;
                            }
                            break;
                        case 2:
                            orientation = "EAST";
                            if (tik[2]==0){
                                tik[2]=1;
                                d++;
                            }
                            break;
                        case 3:
                            orientation = "SOUTH";
                            if (tik[3]==0){
                                tik[3]=1;
                                d++;
                            }
                            break;
                        default:
                            orientation = "WEST";
                            if (tik[4]==0){
                                tik[4]=1;
                                d++;
                            }
                            break;
                    }
                    if (setOrientationBS(orientation)) {
                        check = 1;
                        break;
                    }
                    if (d==4) break;
                }
                if (check == 1) break;
            }
        }
    }
    public boolean attack(Player opponent, Position position){
        Ship PB1 = opponent.getPatrolBoat1();
        Ship PB2 = opponent.getPatrolBoat2();
        Ship DB = opponent.getDestroyerBoat();
        Ship SM = opponent.getSubmarine();
        Ship BS = opponent.getBattleShip();
        Board map = opponent.getGameBoard();

        if (map.checkMap(position)){
            map.setSeeCell(position);
            if (PB1.isHit(position)){
                PB1.setHP();
                map.setHitCell(position);
                if (PB1.isShotDown()){
                    map.setDestroyedCrafts();
                }
                return true;
            }
            else if (PB2.isHit(position)){
                PB2.setHP();
                map.setHitCell(position);
                if (PB2.isShotDown()){
                    map.setDestroyedCrafts();
                }
                return true;
            }
            else if (DB.isHit(position)){
                DB.setHP();
                map.setHitCell(position);
                if (DB.isShotDown()){
                    map.setDestroyedCrafts();
                }
                return true;
            }
            else if (SM.isHit(position)){
                SM.setHP();
                map.setHitCell(position);
                if (SM.isShotDown()){
                    map.setDestroyedCrafts();
                }
                return true;
            }
            else if (BS.isHit(position)){
                BS.setHP();
                map.setHitCell(position);
                if (BS.isShotDown()){
                    map.setDestroyedCrafts();
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
