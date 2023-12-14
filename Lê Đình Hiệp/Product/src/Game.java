// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game {
    public static void main(String[] args) {
        while(true){
            System.out.println("Chào mừng bạn đến với seaBattle");
            Menu.pauseScreen();
            Manager manager = new Manager();
            int mode = Menu.inputGameMode();
            if(mode == 1){
                manager.setUp();
                while(true){
                    manager.startTurn(manager.getP1(), manager.getP2());
                    int  status = manager.endTurn();
                    if(status == 1) break;
                    manager.startTurn(manager.getP2(), manager.getP1());
                    status = manager.endTurn();
                    if(status == 1) break;
                }
                int restartGame = Menu.restartGame();
                if(restartGame == 1) continue;
                break;
            }else if(mode == 2){
                System.out.println("Vỹnh biệt");
                int restartGame = Menu.restartGame();
                if(restartGame == 1) continue;
                break;
            }

        }
    }
}