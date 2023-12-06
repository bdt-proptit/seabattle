import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ManChoiMoi sys = new ManChoiMoi();
        sys.manHinhBatDau();
    }
    public static void xoaManHinh() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}