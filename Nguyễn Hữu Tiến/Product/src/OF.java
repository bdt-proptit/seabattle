import java.io.IOException;
public class OF { // other functions
    public static void clear(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {}
    }

    public static void wait(int ms)
    {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private static final String clr = "\n".repeat(50);
    public static void clrscr(){
        System.out.println(clr);
    }
}