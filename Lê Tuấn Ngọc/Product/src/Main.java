import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("+---------------------------------------+");
        System.out.println("|                                       |");
        System.out.println("|     Welcome to battelship game :>     |");
        System.out.println("|                                       |");
        System.out.println("+---------------------------------------+");
        Player player1 = new Player();
        Player player2 = new Player();
        Manage manage = new Manage();
        int checkout = 0;

        while (true){
            LogIn login = new LogIn();
            checkout = login.logIn(sc, player1, player2, manage);
            if(checkout == 3 || checkout == 1) continue;
            else if(checkout == 4) break;

            System.out.println(player1.getName() + ": 1");
            System.out.println(player2.getName() + ": 2");
            System.out.print("Chọn người chơi bắt đầu: ");
            int choice = sc.nextInt();

            gameLoop: while(true){
                if(choice == 1){
                    while (true){
                        System.out.println("Đến lượt " + player1.getName() + " !");
                        if(manage.menu(player1, manage)){ //hiện menu lựa chọn, khi nào lựa chọn bắn mới đc
                            manage.showEnemyBoard(player1, player2.getMap());

                            String firePoint = manage.fire(player1);
                            if(manage.checkFireShip(player1, player2, firePoint)){ //kiểm tra điểm bắn từ player1 đến player2
                                if(!manage.checkLiveShip(player2, firePoint)){ //kiểm tra tàu còn sống k
                                    manage.updateNumberOfShips(player1, player2); //cập nhật số lượng tàu sống chết trên 2 player
                                    if(manage.checkWin(player1)) break gameLoop;
                                }
                            }
                            else break;
                        }
                    }
                }
                choice = 1;

                while (true){
                    System.out.println("Đến lượt " + player2.getName() + " !");
                    if(manage.menu(player2, manage)){
                        manage.showEnemyBoard(player2, player1.getMap());

                        String firePoint = manage.fire(player2);
                        if(manage.checkFireShip(player2, player1, firePoint)){
                            if(!manage.checkLiveShip(player1, firePoint)){
                                manage.updateNumberOfShips(player2, player1);
                                if(manage.checkWin(player2)) break gameLoop;
                            }
                        }
                        else break;
                    }
                }
            }
        }
    }
}

//* cho người chơi đc chọn thuyền để nhập
//- giới hạn lại cách nhập tọa độ của người chơi : DONE
//- kiểm tra tọa độ bắn có out khỏi bản đồ hay trùng ko : DONE
//- kiểm tra người chơi đặt tàu có bị out hay trùng, đúng size ko : DONE
//- cập nhật thuyền của bản thân bị bắn để nhìn trên map : DONE
//- đổi các cách nhập lựa chọn thành String lỡ có người nhập ký tự vào : DONE
//- sủa lại manage (chuyển showmap vào và có thể chuyển solvePoint vào) : DONE
//- còn time thì sửa lại đồ họa cho pro : gần DONE

//- sửa cách tìm điểm trong solve
//- có hay ko việc ném mịa fire từ player vào manage : DONE
//- làm màu cho các ô bắn, chỉnh lại phần map để hiển thị màu khi bắn trúng hay trượt : DONE
//- có hay ko việc chỉnh lại chế độ show map?
//- thêm tính năng dynamic map
//- SETUP TÀU ĐANG LỖI NHẬP, SỬA GẤP ?? WTF Đ BIẾT LỖI CHỖ NÀO LUÔN


