package Ship;

import java.util.Scanner;
public class ToaDo {
    Scanner sc = new Scanner(System.in);
    private int x,y;
    public ToaDo(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public ToaDo scan(){
        while(true){
            String toaDo = sc.nextLine();
            if(toaDo.length()==2 && toaDo.charAt(0)>='A' && toaDo.charAt(0)<='Z' && toaDo.charAt(1)>='0' && toaDo.charAt(1)<='9'){
                return new ToaDo(toaDo.charAt(0)-'A',toaDo.charAt(1)-'0');
            }
            else System.out.println("Tọa độ không hợp lệ! Vui lòng nhập lại");
        }
    }
}

