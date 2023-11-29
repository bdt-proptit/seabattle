package Tau;

public class ToaDo {
    private int x, y;
    ToaDo(){}
    public ToaDo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static ToaDo toaDoFromScanner(){
        while (true) {
            String string_toaDo = new Scan().cin();
            if(string_toaDo.length()==2 && string_toaDo.charAt(0)>='a' && string_toaDo.charAt(0)<='z' && string_toaDo.charAt(1)>='0' && string_toaDo.charAt(1)<='9'){
                return new ToaDo(string_toaDo.charAt(0)-'a', string_toaDo.charAt(1)-'0');
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
