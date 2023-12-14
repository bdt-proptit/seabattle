package Ship;

public class Coordinate {
    private int x, y;
    Coordinate(){}
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static Coordinate coodinateFromScanner(){
        while (true) {
            String string_position = new Scan().cin();
            if(string_position.length()==2 && string_position.charAt(0)>='a' && string_position.charAt(0)<='z' && string_position.charAt(1)>='0' && string_position.charAt(1)<='9'){
                return new Coordinate(string_position.charAt(0)-'a', string_position.charAt(1)-'0');
            } else System.out.println("Tọa độ không hợp lệ");
        }
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
