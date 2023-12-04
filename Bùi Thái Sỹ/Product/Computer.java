import java.util.Objects;
import java.util.Random;
public class Computer extends Player{
    public void hitHardMode() {
        ClearScreen.clrscr();
        oppBoard.printOppBoard();
        Position posHited = findPointHit();
        if (Objects.equals(oppBoard.getCell(posHited), "S")) {
            ClearScreen.clrscr();
            System.out.println("Boom! Computer Hit Point: " + posHited.getY() + " " + posHited.getX() + "! ☠");
            oppBoard.setCell(posHited, "☠");
            oppBoard.printOppBoard();
            Wait.wait(3);
            oppBoard.setCell(posHited, "X");
            if (checkWinner()) {
                ClearScreen.clrscr();
                printBoard(yourBoard, oppBoard);
                System.out.println("Congratulations!!! Computer is Winner!!!");
                return;
            }
            // Check for ship destruction and Win
            System.out.println("Continue Computer's Turn!");
            Wait.wait(3);
            hitHardMode();
        } else {
            System.out.println("Computer Hit Point: " + posHited.getY() + " " + posHited.getX() + "! Computer Miss!");
            oppBoard.setCell(posHited, "M");
            System.out.println("Change Turn!");
            Wait.wait(3);
            ClearScreen.clrscr();
        }
    }
    public Position findUnexploredPoint(){
        Controller controller = new Controller();
        Random rand = new Random();
        int x1, y1;
        do{
            x1 = rand.nextInt(10) + 1;
            y1 = rand.nextInt(10) + 1;
        }while(!controller.checkAutoHit(oppBoard, new Position(y1, x1)));

        return new Position(y1, x1);
    }
    public Position[] getSurroundingPoints(Position pos) {
        // Trả về mảng các điểm xung quanh của một điểm
        return new Position[]{
                new Position(pos.getX() - 1, pos.getY()),
                new Position(pos.getX() + 1, pos.getY()),
                new Position(pos.getX(), pos.getY() - 1),
                new Position(pos.getX(), pos.getY() + 1)
        };
    }
    public Position findPointHit() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Position pos = new Position(i, j);
                if (Objects.equals(oppBoard.getCell(pos), "X")) {
                    Position[] surroundingPoints = getSurroundingPoints(pos);
                    for (Position surroundingPos : surroundingPoints) {
                        if(oppBoard.isInsideBoard(surroundingPos) &&
                                oppBoard.getCell(surroundingPos)==null) {
                            return surroundingPos;
                        }
                    }
                }
            }
        }
        return findUnexploredPoint();
    }
    public void hitEasyMode(){
        ClearScreen.clrscr();
        oppBoard.printOppBoard();
        Random rand = new Random();
        Controller controller = new Controller();
        Position posHited = new Position(0,0);
        do{
            int x1 = rand.nextInt(10) + 1;
            int y1 = rand.nextInt(10) + 1;
            posHited.setPosition(y1, x1);
        }while(!controller.checkAutoHit(oppBoard, posHited));
        if(Objects.equals(oppBoard.getCell(posHited), "S" )){
            ClearScreen.clrscr();
            System.out.println("Boom! Computer Hit Point: " + posHited.getY() + " "+ posHited.getX() + " ! ☠");
            oppBoard.setCell(posHited, "☠");
            oppBoard.printOppBoard();
            Wait.wait(3);
            oppBoard.setCell(posHited, "X");
            if(checkWinner()){
                ClearScreen.clrscr();
                printBoard(yourBoard, oppBoard);
                System.out.println("Congratulations!!!Computer is Winner!!!");
                return;
            }
            //checkShipDestroyed and Win
            System.out.println("Continue Computer's Turn!");
            Wait.wait(3);
            hitEasyMode();
        }else{
            System.out.println("Computer Hit Point: " + posHited.getY() + " " +  posHited.getX() + " !Computer Miss!");
            oppBoard.setCell(posHited, "M");
            System.out.println("Change Turn!");
            Wait.wait(3);
            ClearScreen.clrscr();
        }
    }
}
