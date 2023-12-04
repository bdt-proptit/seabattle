public class ShowMenu {
    public static void menu(){
        System.out.println("WELCOME TO SEA BATTLE!");
        System.out.println("Some symbols in the game: ");
        System.out.println("P: Your ships' locations");
        System.out.println("o: Location where a ship was hit");
        System.out.println("x: Location where the ships weren't hit");
        System.out.println("Let's get started!");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
    }

    public static void showMode(){
        System.out.println("Modes:");
        System.out.println("   1.Show your board");
        System.out.println("   2.Attack");
        System.out.println("   3.End turn");
        System.out.print("Enter mode: ");
    }
}
