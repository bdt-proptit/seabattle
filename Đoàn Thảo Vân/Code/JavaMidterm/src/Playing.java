public class Playing {

    static int turn = 1;

    public static void main(String[] args) {
        ShowMenu.menu();
//        Ship a = new Ship(1, 1, 2, 3, 2);
//        Ship b = new Ship(3, 6, 3, 3, 4);
//        Ship c = new Ship(5, 7, 5, 5, 3);
//        Ship d = new Ship(2, 6, 2, 2, 5);
        Player Napoleon = new Player();
        Player NgoQuyen = new Player();
        System.out.println("Hi player Napoleon! Place your ship!");
        Napoleon.placeShip();
        System.out.println("Hi player Ngo Quyen! Place you ship!");
        NgoQuyen.placeShip();
        while(!Napoleon.getWin() && !NgoQuyen.getWin()){
            if(turn % 2 == 1){
                System.out.println();
                System.out.println("Napoleon's turn");
                Napoleon.chooseMode(Napoleon, NgoQuyen);
            }
            else{
                System.out.println();
                System.out.println("NgoQuyen's turn");
                NgoQuyen.chooseMode(NgoQuyen, Napoleon);
            }
            ++turn;
        }
    }
}
