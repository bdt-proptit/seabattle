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
                Stack<String> stFirePoints = new Stack<>();
                if(manage.menu(bot, manage)){
                    manage.showEnemyBoard(bot, player.getMap());

                    String firePoint;
                    if(stFirePoints.empty()){
                        firePoint = manage.fireBot(bot);
                    }
                    else {
                        if (stFirePoints.size() == 1) {
                            int xFire = solve.rows(stFirePoints.peek());
                            int yFire = solve.columns(stFirePoints.peek());
                            int nextXFire = 0;
                            int nextYFire = 0;
                            ArrayList<Integer> numbers = new ArrayList<>();
                            for (int i = 1; i <= 4; i++) {
                                numbers.add(i);
                            }
                            // Sử dụng lớp Random để tráo đổi vị trí của các số
                            Collections.shuffle(numbers);
                            while (!numbers.isEmpty()) {
                                if (numbers.get(0).equals(1)) {
                                    nextXFire = xFire;
                                    nextYFire = yFire - 1;
                                } else if (numbers.get(0).equals(2)) {
                                    nextXFire = xFire - 1;
                                    nextYFire = yFire;
                                } else if (numbers.get(0).equals(3)) {
                                    nextXFire = xFire;
                                    nextYFire = yFire + 1;
                                } else if (numbers.get(0).equals(4)) {
                                    nextXFire = xFire + 1;
                                    nextYFire = yFire;
                                }
                                numbers.remove(0);
                                firePoint = solve.points(nextXFire, nextYFire);
                                if(solve.findPoint(player.getMap().getListFirePoints(), firePoint)) continue ;

                                stFirePoints.push(firePoint);
                                if(manage.checkFireShip(bot, player, firePoint)){
                                    if(!manage.checkLiveShip(player, firePoint)){
                                        manage.updateNumberOfShips(bot, player);
                                        if(manage.checkWin(bot)) break gameLoop;
                                    }
                                }
                                else break;
                            }
                        }
                    }
                }
            }
        }
    }
}
