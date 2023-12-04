package Ship;
import java.util.Scanner;
public class Ship {
    Scanner sc = new Scanner(System.in);
    private ToaDo postStart = new ToaDo();
    private ToaDo postEnd = new ToaDo();
    public void setPostStart(){
        System.out.print("Nhập ví trí bắt đầu: VD A1 B2 ------ ");
        postStart.scan();
    }
    public void setPostEnd(){
        System.out.print("Nhập vị trí kết thúc: VD A1 B2 ------ ");
        postEnd.scan();
    }
    public ToaDo getPostStart(){
        return postStart;
    }
    public ToaDo getPostEnd(){
        return postEnd;
    }
}

