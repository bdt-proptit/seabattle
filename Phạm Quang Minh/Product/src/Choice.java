import java.util.Scanner;

public class Choice {
    public static int enterChoice(int maxChoice, Scanner scanner) {
        int choice = 3;
        do {
            System.out.print("Enter function: ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice <= 0 || choice > maxChoice) {
                System.out.println("Enter invalid function! Please enter again!");
            }
        } while (choice <= 0 || choice > maxChoice);
        return choice;
    }
}
