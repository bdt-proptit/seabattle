// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game {
    public static void main(String[] args) {
        while(true){
            System.out.println("Chào mừng bạn đến với seaBattle");
            Menu.pauseScreen();
            Manager manager = new Manager();
            manager.setUp();
            while(true){
                manager.startTurn();
                int  status = manager.endTurn();
                if(status == 1) break;
            }
            int restartGame = Menu.restartGame();
            if(restartGame == 1) break;
        }
    }
}