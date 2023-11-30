public class Player {
    private String name;
    private Board gameBoard = new Board(10);
    private Ship patrolBoat1 = new Ship("Patrol Boat 1", 2, 'P');
    private Ship patrolBoat2 = new Ship("Patrol Boat 2", 2, 'P');
    private Ship destroyerBoat = new Ship("Destroyer Boat", 4, 'D');
    private Ship submarine = new Ship("Submarine", 3, 'S');
    private Ship battleShip = new Ship("Battle Ship", 5, 'B');

    public void setName(String name){
        this.name = name;
    }
    public  String getName(){
        return this.name;
    }
    public void setUpGameBoard(){
        gameBoard.setUpCellStatus();
    }


    public boolean setPositionPB1(Position position){
        if (gameBoard.checkposition(position)==false) return false;
        patrolBoat1.setPosition(position);
        return true;
    }
    public boolean setOrientationPB1(String orientationPB1){
        Position position = patrolBoat1.getPosition();

        if (!gameBoard.checkOrientation(orientationPB1, position, patrolBoat1.getSize())) return false;

        patrolBoat1.setOrientation(orientationPB1);
        return true;
    }
    public boolean setPositionPB2(Position position){
        if (gameBoard.checkposition(position)==false) return false;
        patrolBoat2.setPosition(position);
        return true;
    }
    public boolean setOrientationPB2(String orientationPB2){
        Position position = patrolBoat2.getPosition();

        if (gameBoard.checkOrientation(orientationPB2, position, patrolBoat2.getSize())) return false;

        patrolBoat2.setOrientation(orientationPB2);
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
        return true;
    }
    public boolean setPositionSM(Position position){
        if (gameBoard.checkposition(position)==false) return false;
        submarine.setPosition(position);
        return true;
    }
    public boolean setOrientationSM(String orientationSM){
        Position position = submarine.getPosition();

        if (!gameBoard.checkOrientation(orientationSM, position, submarine.getSize())) return false;

        submarine.setOrientation(orientationSM);
        return true;
    }
    public boolean setPositionBS(Position position){
        if (gameBoard.checkposition(position)==false) return false;
        battleShip.setPosition(position);
        return true;
    }
    public boolean setOrientationBS(String orientationBS){
        Position position = battleShip.getPosition();

        if (!gameBoard.checkOrientation(orientationBS, position, battleShip.getSize())) return false;

        battleShip.setOrientation(orientationBS);
        return true;
    }


    public boolean gameOver(){
        return gameBoard.areAllCraftsDestroyed();
    }

    public void displayC(){
        gameBoard.show(false);
    }
    public void displayUC(){
        gameBoard.show(true);
    }
    public boolean attack(Position position){
        if (gameBoard.checkposition(position)){
            gameBoard.setHitCell(position);
            if (patrolBoat1.isHit(position)){
                patrolBoat1.setHP();
                if (patrolBoat1.isShotDown()){
                    gameBoard.setDestroyedCrafts();
                }
                return true;
            }
            else if (patrolBoat2.isHit(position)){
                patrolBoat2.setHP();
                if (patrolBoat2.isShotDown()){
                    gameBoard.setDestroyedCrafts();
                }
                return true;
            }
            else if (destroyerBoat.isHit(position)){
                destroyerBoat.setHP();
                if (destroyerBoat.isShotDown()){
                    gameBoard.setDestroyedCrafts();
                }
                return true;
            }
            else if (submarine.isHit(position)){
                submarine.setHP();
                if (submarine.isShotDown()){
                    gameBoard.setDestroyedCrafts();
                }
                return true;
            }
            else if (battleShip.isHit(position)){
                battleShip.setHP();
                if (battleShip.isShotDown()){
                    gameBoard.setDestroyedCrafts();
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
