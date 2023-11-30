public class Game {
    public void menuGame(){
        System.out.println("Welcome to Sea Battle");
        System.out.println("Một số kí tự trong game:");
        System.out.println("o: Bắn trượt");
        System.out.println("x: Bắn trúng");
        System.out.println("~: Vị trí có tàu");
    }
    public void playGame(){
        Player first = new Player();
        Player second = new Player();
        System.out.println("Xin chào 1st_Player! Hãy đặt các thuyền của bạn.");
        first.setUpBoat();
        System.out.println("Xin chào 2nd_Player! Hãy đặt các thuyền của bạn.");
        second.setUpBoat();
        int turns = 1;
        while(first.check == 0 && second.check == 0){
            if(turns % 2 == 1){
                System.out.println("Đến lượt 1st_Player");
                System.out.println("Nhập tọa độ muốn tấn công");
                second.beAttacked();
            }
            else{
                System.out.println("Đến lượt 2nd_Player");
                System.out.println("Nhập tọa độ muốn tấn công");
                first.beAttacked();
            }
            turns++;
        }
    }
}
