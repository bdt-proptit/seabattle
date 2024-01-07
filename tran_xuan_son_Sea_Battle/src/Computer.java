import java.util.Random;

public class Computer extends Player{
    Random i1 = new Random();
    Random i2 = new Random();
    Random j1 = new Random();
    Random j2 = new Random();
    public int Add_PatrolBoat(){
        // nhập xong thì check ở Parent
        return super.Check_PatrolBoat(i1.nextInt(size),j1.nextInt(size),i2.nextInt(size),j2.nextInt(size));
    }
    public int Add_DestroyerBoat(){
        // nhập xong thì check ở Parent
        return super.Check_DestroyerBoat(i1.nextInt(size),j1.nextInt(size),i2.nextInt(size),j2.nextInt(size));
    }
    public int Add_Submarine(){
        // nhập xong thì check ở Parent
        return super.Check_Submarine(i1.nextInt(size),j1.nextInt(size),i2.nextInt(size),j2.nextInt(size));
    }
    public int Add_BattleShip(){
        // nhập xong thì check ở Parent
        return super.Check_BattleShip(i1.nextInt(size),j1.nextInt(size),i2.nextInt(size),j2.nextInt(size));
    }

    public void TurnAttack_Computer_Random(int i){
//        System.out.println(" _____                             _              _       _                    \n" +
//                "/  __ \\                           | |            ( )     | |                   \n" +
//                "| /  \\/ ___  _ __ ___  _ __  _   _| |_ ___ _ __  |/ ___  | |_ _   _ _ __ _ __  \n" +
//                "| |    / _ \\| '_ ` _ \\| '_ \\| | | | __/ _ \\ '__|   / __| | __| | | | '__| '_ \\ \n" +
//                "| \\__/\\ (_) | | | | | | |_) | |_| | ||  __/ |      \\__ \\ | |_| |_| | |  | | | |\n" +
//                " \\____/\\___/|_| |_| |_| .__/ \\__,_|\\__\\___|_|      |___/  \\__|\\__,_|_|  |_| |_|\n" +
//                "                      | |                                                      \n" +
//                "                      |_|                                                      ");
//        System.out.println("Show Computer 's Map: ");
//        Main.List.get(i).SeeMap();
//        System.out.println("Show Attacked Map of Your Enemy: ");
//        Main.List.get(i).SeeMap_Enemy();
 //       System.out.println("Show Your & Your Enemy's Map: ");
     //   Main.List.get(i).SeeMap_Full(); // Chơi thật thì không cần SeeMap của bot.
        Random x = new Random();
        Random y = new Random();
        while(true){
            x_id = x.nextInt(size);
            y_id = y.nextInt(size);
            if(Main.List.get(i).board_Enemy[x_id][y_id] == 0) break; // bỏ qua những chỗ đánh bom rồi
        }
       // System.out.println(x_id + " " + y_id);
        check_greedy = Main.List.get(i).Check_Attack(x_id,y_id,i); // tk i ATK tk 1 - i;
    }

   // Ý tưởng Greedy: Nếu đánh bom trúng tàu => đánh những điểm còn lại của 4 hướng.
   // => Tạo 1 biến xét 4 hướng.
    //        - Nếu đánh trúng tàu ở 1 hướng, ta cho qua lượt và lượt sau đi tg tự với ô mới
    //        - Nếu ko qua đc 1 lân lặp= > lặp tiếp, nếu ko qua đc cả vòng, ta cho Ramdom và quay lại greedy ở lượt sau.
    // nếu check = 1 thì mới sử dụng
    public void TurnAttack_Computer_Greedy(int i,int x_id,int y_id){ // id là vị trí trong mảng dx,dy
//        System.out.println("Show Computer 's Map: ");
//        Main.List.get(i).SeeMap();
//        System.out.println("Show Attacked Map of Your Enemy: ");
//        Main.List.get(i).SeeMap_Enemy();
 //           System.out.println("Show Your & Your Enemy's Map: ");

            //System.out.println(x_id + " " + y_id);
            if((x_id <0 || x_id>=size)||(y_id<0 ||y_id>=size)) check_greedy = 0;
            else {
                if(Main.List.get(i).board_Enemy[x_id][y_id] != 0) check_greedy = 0; // bỏ qua những chỗ đánh bom rồi
                else check_greedy = Main.List.get(i).Check_Attack(x_id,y_id,i); // tk i ATK tk 1 - i;
            }
    }

}
