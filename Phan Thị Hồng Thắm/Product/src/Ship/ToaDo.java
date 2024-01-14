package Ship;

import java.util.Scanner;
public class ToaDo {
    Scanner sc = new Scanner(System.in);
    private int x,y;
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
    public void scan(){
        while(true){
            String toaDo = sc.nextLine();
            if(toaDo.length()==2 && toaDo.charAt(0)>='A' && toaDo.charAt(0)<='Z' && toaDo.charAt(1)>='0' && toaDo.charAt(1)<='9'){
                setY(toaDo.charAt(0)-'A');
                setX(toaDo.charAt(1)-'0');
                return;
            }
            else System.out.print("Tọa độ không hợp lệ! Vui lòng nhập lại ");
        }
    }
}

