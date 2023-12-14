import java.util.Random;
import java.util.Scanner;

public class Operation {
    public void displayMenu () {
        System.out.println("        MENU        ");
        System.out.println("--------------------");
        System.out.println("|     1. Play      |");
        System.out.println("--------------------");
        System.out.println("|    2. Cancel     |");
        System.out.println("--------------------");
    }
    public void displayPlayerOptions () {
        System.out.println("    PLAYER OPTIONS    ");
        System.out.println("----------------------");
        System.out.println("|  1. View my board  |");
        System.out.println("----------------------");
        System.out.println("|    2. Open fire    |");
        System.out.println("----------------------");
        System.out.println("|      3. Cancel     |");
        System.out.println("----------------------");
    }
    public void displayBoardOfPlayer (Player player) {
        System.out.println("-> My Board:");
        for (int i = 0; i <= 10; ++i) {
            for (int j = 0; j <= 10; ++j) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                }
                else if (i == 0) {
                    System.out.printf("%-" + 2 + "s", j);
                }
                else if (j == 0) {
                    System.out.printf("%-" + 2 + "s", (char)(i + 'a' - 1));
                }
                else {
                    System.out.printf("%-" + 2 + "s", player.getMyBoard()[i - 1][j - 1]);
                }
                if (j != 10) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            int count = 43;
            while (count-- >0) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println("!! NOTE:");
        System.out.println(" -2 : The enemy's shot was a miss");
        System.out.println(" -1 : The enemy's shot was successful");
        System.out.println("  0 : Empty");
        System.out.println("  1 : Patrol Boat 1");
        System.out.println("  2 : Patrol Boat 2");
        System.out.println("  3 : Destroyer Boat");
        System.out.println("  4 : Submarine");
        System.out.println("  5 : Battle Ship");
    }
    public Coordinates chooseTheFirstSquare (Scanner sc, Player player, Boat boat) {
        String shape;
        String location;
        StringBuilder number;
        int count;
        Coordinates coordinates = new Coordinates();
        System.out.println("Enter the first square of " + boat.getName() + ":");
        location = sc.nextLine();
        coordinates.row = location.charAt(0);
        count = 1;
        number = new StringBuilder();
        while (count < location.length()) {
            number.append(location.charAt(count));
            ++count;
        }
        coordinates.column = Integer.parseInt(number.toString()) - 1;
        while (coordinates.row - 'a' >= 10 || coordinates.column >= 10) {
            System.out.println("Invalid. Please choose another square!");
            location = sc.nextLine();
            coordinates.row = location.charAt(0);
            count = 1;
            number = new StringBuilder();
            while (count < location.length()) {
                number.append(location.charAt(count));
                ++count;
            }
            coordinates.column = Integer.parseInt(number.toString()) - 1;
        }
        while (player.getMyBoard()[coordinates.row - 'a'][coordinates.column] != 0) {
            System.out.println("This square has already been taken. Please choose another square!");
            location = sc.nextLine();
            coordinates.row = location.charAt(0);
            count = 1;
            number = new StringBuilder();
            while (count < location.length()) {
                number.append(location.charAt(count));
                ++count;
            }
            coordinates.column = Integer.parseInt(number.toString()) - 1;
            while (coordinates.row - 'a' >= 10 || coordinates.column >= 10) {
                System.out.println("Invalid. Please choose another square!");
                location = sc.nextLine();
                coordinates.row = location.charAt(0);
                count = 1;
                number = new StringBuilder();
                while (count < location.length()) {
                    number.append(location.charAt(count));
                    ++count;
                }
                coordinates.column = Integer.parseInt(number.toString()) - 1;
            }
        }
        shape = boat.checkLocation(coordinates, player);
        while (shape.equals("None")) {
            System.out.println("Cannot set up the train. Please choose another square!");
            location = sc.nextLine();
            coordinates.row = location.charAt(0);
            count = 1;
            number = new StringBuilder();
            while (count < location.length()) {
                number.append(location.charAt(count));
                ++count;
            }
            coordinates.column = Integer.parseInt(number.toString()) - 1;
            while (coordinates.row - 'a' >= 10 || coordinates.column >= 10) {
                System.out.println("Invalid. Please choose another square!");
                location = sc.nextLine();
                coordinates.row = location.charAt(0);
                count = 1;
                number = new StringBuilder();
                while (count < location.length()) {
                    number.append(location.charAt(count));
                    ++count;
                }
                coordinates.column = Integer.parseInt(number.toString()) - 1;
            }
            while (player.getMyBoard()[coordinates.row - 'a'][coordinates.column] != 0) {
                System.out.println("This square has already been taken. Please choose another square!");
                System.out.println(player.getMyBoard()[coordinates.row - 'a'][coordinates.column]);
                location = sc.nextLine();
                coordinates.row = location.charAt(0);
                count = 1;
                number = new StringBuilder();
                while (count < location.length()) {
                    number.append(location.charAt(count));
                    ++count;
                }
                coordinates.column = Integer.parseInt(number.toString()) - 1;
                while (coordinates.row - 'a' >= 10 || coordinates.column >= 10) {
                    System.out.println("Invalid. Please choose another square!");
                    location = sc.nextLine();
                    coordinates.row = location.charAt(0);
                    count = 1;
                    number = new StringBuilder();
                    while (count < location.length()) {
                        number.append(location.charAt(count));
                        ++count;
                    }
                    coordinates.column = Integer.parseInt(number.toString()) - 1;
                }
            }
            shape = boat.checkLocation(coordinates, player);
        }
        if (shape.equals("Both")) {
            System.out.println("Select the shape of " + boat.getName() + ":");
            System.out.println("-> 1: Row");
            System.out.println("-> 2: Column");
            System.out.println("Enter your choice:");
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                boat.setShape("Row");
            }
            else {
                boat.setShape("Column");
            }
        }
        else {
            boat.setShape(shape);
        }
        return coordinates;
    }
    public void playerSetsUpTheBoat (Scanner sc, Player player) {
        System.out.println("Setting up the boat...");
        player.setMyBoard();
        Boat thePatrolBoat1 = new Boat();
        thePatrolBoat1.setName("The Patrol Boat 1");
        thePatrolBoat1.setLength(2);
        Coordinates coordinates;
        coordinates = chooseTheFirstSquare(sc, player, thePatrolBoat1);
        if (thePatrolBoat1.getShape().equals("Row")) {
            for (int i = 0; i < thePatrolBoat1.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = 1;
            }
        }
        else {
            for (int i = 0; i < thePatrolBoat1.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = 1;
            }
        }
        System.out.println("---> The Patrol Boat 1 has been set up in " + thePatrolBoat1.getShape() + " form <---");
        Boat thePatrolBoat2 = new Boat();
        thePatrolBoat2.setName("The Patrol Boat 2");
        thePatrolBoat2.setLength(2);
        coordinates = chooseTheFirstSquare(sc, player, thePatrolBoat2);
        if (thePatrolBoat2.getShape().equals("Row")) {
            for (int i = 0; i < thePatrolBoat2.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = 2;
            }
        }
        else {
            for (int i = 0; i < thePatrolBoat2.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = 2;
            }
        }
        System.out.println("---> The Patrol Boat 2 has been set up in " + thePatrolBoat2.getShape() + " form <---");
        Boat theDestroyerBoat = new Boat();
        theDestroyerBoat.setName("The Destroyer Boat");
        theDestroyerBoat.setLength(4);
        coordinates = chooseTheFirstSquare(sc, player, theDestroyerBoat);
        if (theDestroyerBoat.getShape().equals("Row")) {
            for (int i = 0; i < theDestroyerBoat.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = 3;
            }
        }
        else {
            for (int i = 0; i < theDestroyerBoat.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = 3;
            }
        }
        System.out.println("---> The Destroyer Boat has been set up in " + theDestroyerBoat.getShape() + " form <---");
        Boat theSubmarine = new Boat();
        theSubmarine.setName("The Submarine");
        theSubmarine.setLength(3);
        coordinates = chooseTheFirstSquare(sc, player, theSubmarine);
        if (theSubmarine.getShape().equals("Row")) {
            for (int i = 0; i < theSubmarine.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = 4;
            }
        }
        else {
            for (int i = 0; i < theSubmarine.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = 4;
            }
        }
        System.out.println("---> The Submarine has been set up in " + theSubmarine.getShape() + " form <---");
        Boat theBattleShip = new Boat();
        theBattleShip.setName("The Battle Ship");
        theBattleShip.setLength(5);
        coordinates = chooseTheFirstSquare(sc, player, theBattleShip);
        if (theBattleShip.getShape().equals("Row")) {
            for (int i = 0; i < theBattleShip.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = 5;
            }
        }
        else {
            for (int i = 0; i < theBattleShip.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = 5;
            }
        }
        System.out.println("---> The Battle Ship has been set up in " + theBattleShip.getShape() + " form. <---");
        System.out.println("All boats have been commissioned. Ready for combat!");
    }
    public boolean playerOpensFireAndCheck (Scanner sc, Player player, Player enemy) {
        System.out.println("Shooting...");
        boolean mark = false;
        String location;
        StringBuilder number;
        int count;
        Coordinates coordinates = new Coordinates();
        while (true) {
            System.out.println("Select a square to open fire: ");
            location = sc.nextLine();
            coordinates.row = location.charAt(0);
            count = 1;
            number = new StringBuilder();
            while (count < location.length()) {
                number.append(location.charAt(count));
                ++count;
            }
            coordinates.column = Integer.parseInt(number.toString()) - 1;
            while (coordinates.row - 'a' >= 10 || coordinates.column >= 10) {
                System.out.println("Invalid. Please choose another square!");
                location = sc.nextLine();
                coordinates.row = location.charAt(0);
                count = 1;
                number = new StringBuilder();
                while (count < location.length()) {
                    number.append(location.charAt(count));
                    ++count;
                }
                coordinates.column = Integer.parseInt(number.toString()) - 1;
            }
            while (enemy.getMyBoard()[coordinates.row - 'a'][coordinates.column] < 0) {
                System.out.println("This square has already been shot. Please choose another square!");
                location = sc.nextLine();
                coordinates.row = location.charAt(0);
                count = 1;
                number = new StringBuilder();
                while (count < location.length()) {
                    number.append(location.charAt(count));
                    ++count;
                }
                coordinates.column = Integer.parseInt(number.toString()) - 1;
                while (coordinates.row - 'a' >= 10 || coordinates.column >= 10) {
                    System.out.println("Invalid. Please choose another square!");
                    location = sc.nextLine();
                    coordinates.row = location.charAt(0);
                    count = 1;
                    number = new StringBuilder();
                    while (count < location.length()) {
                        number.append(location.charAt(count));
                        ++count;
                    }
                    coordinates.column = Integer.parseInt(number.toString()) - 1;
                }
            }
            player.setTheNumberOfSquaresShot(player.getTheNumberOfSquaresShot() + 1);
            if (enemy.getMyBoard()[coordinates.row - 'a'][coordinates.column] == 0) {
                System.out.println("--> You missed your shot <--");
                enemy.getMyBoard()[coordinates.row - 'a'][coordinates.column] = -2;
                break;
            }
            else {
                System.out.println("--> You scored a hit <--");
                int tmp = enemy.getMyBoard()[coordinates.row - 'a'][coordinates.column];
                enemy.getMyBoard()[coordinates.row - 'a'][coordinates.column] = -1;
                boolean mark1 = true;
                for (int i = 0; i < 10; ++i) {
                    for (int j = 0; j < 10; ++j) {
                        if (enemy.getMyBoard()[i][j] == tmp) {
                            mark1 = false;
                            break;
                        }
                    }
                    if (!mark1) {
                        break;
                    }
                }
                if (mark1) {
                    enemy.setTheNumberOfMyRemainingBoats(enemy.getTheNumberOfMyRemainingBoats() - 1);
                    player.setTheNumberOfBoatsHit(player.getTheNumberOfBoatsHit() + 1);
                    if (tmp == 1) {
                        System.out.println("---> The Patrol Boat 1 has been destroyed! <---");
                    }
                    else if (tmp == 2) {
                        System.out.println("---> The Patrol Boat 2 has been destroyed! <---");
                    }
                    else if (tmp == 3) {
                        System.out.println("---> The Destroyed Boat has been destroyed! <---");
                    }
                    else if (tmp == 4) {
                        System.out.println("---> The Submarine has been destroyed! <---");
                    }
                    else {
                        System.out.println("---> The Battle Ship has been destroyed! <---");
                    }
                    if (enemy.getTheNumberOfMyRemainingBoats() == 0) {
                        mark = true;
                        break;
                    }
                }
            }
        }
        return mark;
    }
    public void displayCurrentStatus (Player player) {
        System.out.println("My current status:");
        System.out.println("** The number of squares shot on the enemy front: " + player.getTheNumberOfSquaresShot());
        System.out.println("** The number of boats hit: " + player.getTheNumberOfBoatsHit());
        System.out.println("** The number of my remaining boats: " + player.getTheNumberOfMyRemainingBoats());
    }
    public void displayTheBoardOfEnemy (Player enemy) {
        System.out.println("-> Enemy's board:");
        for (int i = 0; i <= 10; ++i) {
            for (int j = 0; j <= 10; ++j) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                }
                else if (i == 0) {
                    System.out.printf("%-" + 2 + "s", j);
                }
                else if (j == 0) {
                    System.out.printf("%-" + 2 + "s", (char)(i + 'a' - 1));
                }
                else if (enemy.getMyBoard()[i - 1][j - 1] < 0) {
                    System.out.printf("%-" + 2 + "s", enemy.getMyBoard()[i - 1][j - 1]);
                }
                else {
                    System.out.printf("%-" + 2 + "s", 0);
                }
                if (j != 10) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            int count = 43;
            while (count-- >0) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println("!! NOTE:");
        System.out.println(" -1 : Square has been hit");
        System.out.println(" -2 : Square shot missed");
        System.out.println("  0 : Untouched square");
    }
    public void displayTheResults (Player player1, Player player2) {
        System.out.println("Player 1's Board:                                             Player 2's Board:");
        for (int i = 0; i <= 10; ++i) {
            for (int j = 0; j <= 10; ++j) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                }
                else if (i == 0) {
                    System.out.printf("%-" + 2 + "s", j);
                }
                else if (j == 0) {
                    System.out.printf("%-" + 2 + "s", (char)(i + 'a' - 1));
                }
                else {
                    System.out.printf("%-" + 2 + "s", player1.getMyBoard()[i - 1][j - 1]);
                }
                if (j != 10) {
                    System.out.print("| ");
                }
            }
            System.out.print("                    ");
            for (int j = 0; j <= 10; ++j) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                }
                else if (i == 0) {
                    System.out.printf("%-" + 2 + "s", j);
                }
                else if (j == 0) {
                    System.out.printf("%-" + 2 + "s", (char)(i + 'a' - 1));
                }
                else {
                    System.out.printf("%-" + 2 + "s", player2.getMyBoard()[i - 1][j - 1]);
                }
                if (j != 10) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            int count = 43;
            while (count-- >0) {
                System.out.print("-");
            }
            System.out.print("                   ");
            count = 43;
            while (count-- >0) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println("!! NOTE:");
        System.out.println(" -2 : The enemy's shot was a miss");
        System.out.println(" -1 : The enemy's shot was successful");
        System.out.println("  0 : Empty");
        System.out.println("  1 : Patrol Boat 1");
        System.out.println("  2 : Patrol Boat 2");
        System.out.println("  3 : Destroyer Boat");
        System.out.println("  4 : Submarine");
        System.out.println("  5 : Battle Ship");
    }
    public Coordinates autoChooseTheFirstSquare (Player player, Boat boat) {
        Random random = new Random();
        String shape;
        Coordinates coordinates = new Coordinates();
        coordinates.row = (char) random.nextInt('a', 'j');
        coordinates.column = random.nextInt(0, 9);
        shape = boat.checkLocation(coordinates, player);
        while (coordinates.row - 'a' >= 10 || coordinates.column >= 10 || player.getMyBoard()[coordinates.row - 'a'][coordinates.column] != 0 || shape.equals("None")) {
            coordinates.row = (char) random.nextInt('a', 'j');
            coordinates.column = random.nextInt(0, 9);
            shape = boat.checkLocation(coordinates, player);
        }
        if (shape.equals("Both")) {
            int randomOption = random.nextInt(1, 2);
            if (randomOption == 1) {
                boat.setShape("Row");
            }
            else {
                boat.setShape("Column");
            }
        }
        else {
            boat.setShape(shape);
        }
        return coordinates;
    }
    public void autoSetUpTheBoat (Player player) {
        player.setMyBoard();
        Boat thePatrolBoat1 = new Boat();
        thePatrolBoat1.setName("The Patrol Boat 1");
        thePatrolBoat1.setLength(2);
        Coordinates coordinates;
        coordinates = autoChooseTheFirstSquare(player, thePatrolBoat1);
        if (thePatrolBoat1.getShape().equals("Row")) {
            for (int i = 0; i < thePatrolBoat1.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = 1;
            }
        }
        else {
            for (int i = 0; i < thePatrolBoat1.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = 1;
            }
        }
        Boat thePatrolBoat2 = new Boat();
        thePatrolBoat2.setName("The Patrol Boat 2");
        thePatrolBoat2.setLength(2);
        coordinates = autoChooseTheFirstSquare(player, thePatrolBoat2);
        if (thePatrolBoat2.getShape().equals("Row")) {
            for (int i = 0; i < thePatrolBoat2.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = 2;
            }
        }
        else {
            for (int i = 0; i < thePatrolBoat2.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = 2;
            }
        }
        Boat theDestroyerBoat = new Boat();
        theDestroyerBoat.setName("The Destroyer Boat");
        theDestroyerBoat.setLength(4);
        coordinates = autoChooseTheFirstSquare(player, theDestroyerBoat);
        if (theDestroyerBoat.getShape().equals("Row")) {
            for (int i = 0; i < theDestroyerBoat.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = 3;
            }
        }
        else {
            for (int i = 0; i < theDestroyerBoat.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = 3;
            }
        }
        Boat theSubmarine = new Boat();
        theSubmarine.setName("The Submarine");
        theSubmarine.setLength(3);
        coordinates = autoChooseTheFirstSquare(player, theSubmarine);
        if (theSubmarine.getShape().equals("Row")) {
            for (int i = 0; i < theSubmarine.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = 4;
            }
        }
        else {
            for (int i = 0; i < theSubmarine.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = 4;
            }
        }
        Boat theBattleShip = new Boat();
        theBattleShip.setName("The Battle Ship");
        theBattleShip.setLength(5);
        coordinates = autoChooseTheFirstSquare(player, theBattleShip);
        if (theBattleShip.getShape().equals("Row")) {
            for (int i = 0; i < theBattleShip.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = 5;
            }
        }
        else {
            for (int i = 0; i < theBattleShip.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = 5;
            }
        }
        System.out.println("All boats have been commissioned. Ready for combat!");
    }
}