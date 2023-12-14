package Ship;

import java.util.Scanner;

public class Scan {
    private Scanner sc;
    public Scan() {
        this.sc = new Scanner(System.in);
    }
    public String cin() {
        return sc.nextLine();
    }
}
