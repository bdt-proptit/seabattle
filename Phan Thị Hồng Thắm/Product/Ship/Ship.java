package Ship;
import java.util.Scanner;
public class Ship {
    Scanner sc = new Scanner(System.in);
    private ToaDo postStart,postEnd;
    private int damagePoint = 0;
    private boolean isRemain = true;
    public void setPostStart(){
        System.out.print("Nhập ví trí bắt đầu: VD A1 B2");
        this.postStart = postStart.scan();
    }
    public void setPostEnd() {
        System.out.print("Nhập vị trí kết thúc: VD A1 B2");
        this.postEnd = postEnd.scan();
    }
    public ToaDo getPostStart(){
        return postStart;
    }
    public ToaDo getPostEnd(){
        return postEnd;
    }
}

