import java.util.Objects;
import java.util.Random;
public class Computer extends Player{
    public void hitHardMode(){
        //Thuật toán loang
    }
    public void hitEasyMode(){
        ClearScreen.clrscr();
        printBoard(yourBoard, oppBoard);
        Random rand = new Random();
        Controller controller = new Controller();
        Position posHited = new Position(0,0);
        do{
            int x1 = rand.nextInt(10) + 1;
            int y1 = rand.nextInt(10) + 1;
            posHited.setPosition(y1, x1);
        }while(!controller.checkAutoHit(oppBoard, posHited));
        if(Objects.equals(oppBoard.getCell(posHited), "S" )){
            System.out.println("Boom! Computer Hit!");
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
            System.out.println("Computer Miss!");
            oppBoard.setCell(posHited, "O");
            System.out.println("Change Turn!");
            Wait.wait(3);
            ClearScreen.clrscr();
        }
    }
}
