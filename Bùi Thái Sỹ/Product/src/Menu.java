import org.w3c.dom.ls.LSOutput;

public class Menu {
    public void printMenu(){
        System.out.println("Welcome to Sea War!!!");
        System.out.println("Press number to select mode");
        System.out.println("1. Start");
        System.out.println("2. How to play");
        System.out.println("3. Exit");
    }
    public void menuSelectModePlay(){
        System.out.println("Select Mode Play");
        System.out.println("1. One Player");
        System.out.println("2. Two Player");
        System.out.println("3. Back");
    }
    public void menuSelectModeComputer(){
        System.out.println("Select Mode Computer");
        System.out.println("1. Easy Mode");
        System.out.println("2. Hard Mode");
    }
    // Mode cho người chơi mỗi lượt chọn 1 mystical card
    //Các mystical card sẽ có chức năng:
    //- Xóa hết các điểm bắn của mình đã bắn vào thuyền trên field của đối thủ
    //- Nếu bắn trượt được bắn thêm 1 lần nữa
    //- Phá huỷ 1 điểm tàu ngẫu nhiên của bạn mà nó vẫn tồn tại trên bảng
    //- Xóa hết các điểm mà đối phương đã bắn trúng thuyền trên field của mình
    public void menuSelectSpecialMode(){
        System.out.println("1. Yes");
        System.out.println("2. No");
    }
    public void menuToSetShipAuto(){
        System.out.println("1. Set Ship Auto");
        System.out.println("2. Set Ship By Hand");
    }
}
