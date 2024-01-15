import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BotMode{
    Scanner sc = new Scanner(System.in);
    Manage manage = new Manage();
    SolvePoints solve = new SolvePoints();
    public void playGame(Player player, Player bot){

        System.out.println(player.getName() + ": 1");
        System.out.println(bot.getName() + ": 2");
        System.out.print("Chọn người chơi bắt đầu: ");
        int choice = sc.nextInt();
        int vertical = 0; // 1 la thuyền đặt dọc, 2 la ngang
        Stack<String> stFirePoints = new Stack<>();
        ArrayList<Integer> numbers = new ArrayList<>(); // chua cac so de random
        int check = 1; // de xem bot ban trung ko

        gameLoop: while(true){
            if(choice == 1){
                while (true){
                    System.out.println("Đến lượt " + player.getName() + " !");
                    if(manage.menu(player, manage)){ //hiện menu lựa chọn, khi nào lựa chọn bắn mới đc
                        manage.showEnemyBoard(player, bot.getMap());

                        String firePoint = manage.fire(player);
                        if(manage.checkFireShip(player, bot, firePoint)){ //kiểm tra điểm bắn từ player1 đến player2
                            if(!manage.checkLiveShip(bot, firePoint)){ //kiểm tra tàu còn sống k
                                manage.updateNumberOfShips(player, bot); //cập nhật số lượng tàu sống chết trên 2 player
                                if(manage.checkWin(player)) break gameLoop;
                            }
                        }
                        else break;
                    }
                }
            }
            choice = 1;

            while (true){
                System.out.println("Đến lượt " + bot.getName() + " !");
                manage.showEnemyBoard(bot, player.getMap());

                String firePoint;
                if(stFirePoints.empty()){
                    while (true){
                        firePoint = manage.fireBot(bot);
                        if(!solve.findPoint(bot.getMap().getListFirePoints(), firePoint)) break; //nếu tạo độ trùng thì phải rand lại
                    }
                    System.out.println("Tọa độ khai Hỏa: " + firePoint);
                    stFirePoints.push(firePoint);
                }
                else {
                    while (true){
                        int xFire = solve.rows(stFirePoints.peek());
                        int yFire = solve.columns(stFirePoints.peek());
                        int nextXFire = 0;
                        int nextYFire = 0;

                        if(vertical == 0 && check == 1){
                            numbers.add(1);
                            numbers.add(2);
                            numbers.add(3);
                            numbers.add(4);
                        }
                        else if(vertical == 1  && check == 1){
                            numbers.add(2);
                            numbers.add(4);
                        }
                        else if(vertical == 2 && check == 1){
                            numbers.add(1);
                            numbers.add(3);
                        }

                        // Sử dụng lớp Random để tráo đổi vị trí của các số
                        Collections.shuffle(numbers);
                        while (!numbers.isEmpty()) { // tim toa do diem ban
                            if (numbers.get(0).equals(1)) { //trai
                                nextXFire = xFire;
                                nextYFire = yFire - 1;
                            } else if (numbers.get(0).equals(2)) { // tren
                                nextXFire = xFire - 1;
                                nextYFire = yFire;
                            } else if (numbers.get(0).equals(3)) { // phải
                                nextXFire = xFire;
                                nextYFire = yFire + 1;
                            } else if (numbers.get(0).equals(4)) { // duoi
                                nextXFire = xFire + 1;
                                nextYFire = yFire;
                            }
                            numbers.remove(0);
                            if (solve.findPoint(bot.getMap().getListFirePoints(), solve.points(nextXFire, nextYFire)) || nextXFire > bot.getMap().getRows() || nextYFire > bot.getMap().getRows() || nextXFire <= 0 || nextYFire <= 0){
                                nextXFire = xFire;
                                nextYFire = yFire;
                                continue ;
                            } // nếu tạo độ trùng or out map thì chọn lai
                            else break ;
                        }

                        if(xFire == nextXFire && yFire == nextYFire){ // ko tim dc diem ban tiep theo ptu dau cua stack
                            stFirePoints.pop();
                            check = 1;
                            continue ;
                        }
                        else{
                            firePoint = solve.points(nextXFire, nextYFire);
                            System.out.println("Tọa độ khai Hỏa: " + firePoint);
                            stFirePoints.push(firePoint);
                            break ;
                        }
                    }

                }

                if(manage.checkFireShip(bot, player, firePoint)){
                    try {
                        Thread.sleep(3000); // Dừng lại 1 giây (1000 milliseconds)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(!manage.checkLiveShip(player, firePoint)){
                        vertical = 0;
                        numbers.clear();
                        stFirePoints.clear();
                        manage.updateNumberOfShips(bot, player);
                        if(manage.checkWin(bot)) break gameLoop;
                    }

                    if(stFirePoints.size() > 1){
                        String tmp = stFirePoints.pop();
                        if(solve.rows(tmp) == solve.rows(stFirePoints.peek())) vertical = 2;
                        else vertical = 1;
                        stFirePoints.push(tmp);
                    }
                    numbers.clear();
                    check = 1;
                }
                else{
                    stFirePoints.pop();
                    check = 0;
                    break ; // ban truot thi doi luot
                }
            }
        }
    }
}
