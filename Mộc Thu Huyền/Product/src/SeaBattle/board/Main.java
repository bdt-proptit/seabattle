package SeaBattle.board;

import SeaBattle.game.Display;
import SeaBattle.game.Gameplay;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PositionException {
        Scanner sc = new Scanner(System.in);
        Gameplay game;
        String name = "";
        String name1 = "";
        String name2 = "";
        int opt;
        boolean hasName = false;

        try {
            do {
                opt = Display.printMenu();

                switch (opt) {
                    case 1 ->{
                        if (!hasName) {
                            System.out.print("\nEnter your name playOne: ");
                            name1 = sc.nextLine();
                            System.out.println("\nEnter your name playTwo: ");
                            name2 = sc.nextLine();
                            hasName = true;
                        }
                        game = new Gameplay(name1,name2);
                        game.run();
                    }
                    case 2 -> {
                        if (!hasName) {
                            System.out.print("\nEnter your name: ");
                            name = sc.next();
                            hasName = true;
                        }
                        game = new Gameplay(name);
                        game.run();
                    }
                    case 3 -> {
                        Display.printRuleAndLegend();
                    }
                }
            } while (opt != 0);
        } catch (InputMismatchException e) {
        }
        Display.printCredits();
    }
}