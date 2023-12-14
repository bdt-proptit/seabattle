/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seabattle_mvp;

import java.util.Scanner;

public class Process {
    private Player player1;
    private Player player2;
    private int check_win = 0;
    public void displayRule(){
        System.out.println("------------------------------------RULE---------------------------------");
        System.out.println(" -  This is a 2-player game on a 10x10 board each player is given 5 boats");
        System.out.println("including two 1x2 Patrol Boats, one 1x3 Submarine, one 1x4 Destroyer and ");
        System.out.println("one 1x5 Battleship.Players take turns placing their boats in position    ");
        System.out.println("ready to engage in battle.                                               ");
        System.out.println(" -  Each player's screen will only show his ownboard and his opponent's  ");
        System.out.println("foggy view board.After each shot, the box will display an 'X' if the shot");
        System.out.println("is successful, the box will display a '.' if you miss and empty box if   ");
        System.out.println("not yet fired. GoodLuck!                                                 ");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("");
    }
    
    public void displayMenu(String NamePlayer1,String NamePlayer2) {
        //in dòng chữ Sea Battle
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("-                          Welcome to SeaBattle!                        -");
        System.out.println("-------------------------------------------------------------------------");
        // in tên của player1 -> qui định nhập tên không quá 33 ký tự
        System.out.print(NamePlayer1);
        int sizeNamePlayer1 = NamePlayer1.length();
        int remainChar = 33 - sizeNamePlayer1;
        
        for(int column = 0;column < remainChar;++column) {
            System.out.print(" ");
        }
        // khoảng trống giữa 2 bảng
        System.out.print("       ");
        // in tên của player2
        System.out.print(NamePlayer2);
        int sizeNamePlayer2 = NamePlayer2.length();
        remainChar = 33 - sizeNamePlayer2;
        
        for(int column = 0;column < remainChar;++column) {
            System.out.print(" ");
        }
        System.out.println("");
        // in tiếp bảng
        System.out.println("");
        //System.out.println("-------------------------------------------------------------------------");
        System.out.print("-  ");
        for(int column = 1;column<=10;++column){ // in số cột của bảng của bản thân
            if(column < 10) System.out.print(column + "  ");
            else System.out.print(column + "|");
        }
        System.out.print("~~~~~| -  ");
        
        for(int column = 1;column<=10;++column){ // in số cột của bảng của đối thủ
            if(column < 10) System.out.print(column + "  ");
            else System.out.println(column + "|");
        }
        
        //System.out.println("  -------------------------------");
        // in hàng
        for(int row = 0;row < 10;++row){
            int row_present = row + 1;
            // cột của player1
            if(row < 9) System.out.print(row_present + " |");
            else System.out.print(row_present + "|");
            
            for(int column = 0;column < 10 ;++column) {
                System.out.print(this.player1.MyBoard[row][column] + " |");
            }
            System.out.print("~~~~~| ");
            // cột của player2
            if(row < 9) System.out.print(row_present + " |");
            else System.out.print(row_present + "|");
            
            for(int column = 0;column < 10 ;++column) {
                System.out.print(this.player2.MyBoard[row][column] + " |");
            }
            
            System.out.println("");
            //System.out.println("  -------------------------------");
        }
        System.out.println("-------------------------------------------------------------------------");
    }
    public void shootEnemy(Player currentPlayer,Player remainPlayer) {
        // nhập tọa độ để bắn
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the coordinates (x,y) you want to shoot: ");
        System.out.print("x = "); int x = Integer.parseInt(sc.nextLine());
        System.out.print("y = "); int y = Integer.parseInt(sc.nextLine());
        
        // check tại đó đã bắn chưa
        if(currentPlayer.EnemyBoard[x-1][y-1] != ' ') System.out.println("This box has been shot, you lose your turn!");
        else{
            if(remainPlayer.MyBoard[x-1][y-1] == 'X'){ // nếu tại đó có thuyền của địch
                System.out.println("Hit the enemy's boat!");
                currentPlayer.EnemyBoard[x-1][y-1] = 'X';
                currentPlayer.setBullet();
            } else {
                currentPlayer.EnemyBoard[x-1][y-1] = '.';
                currentPlayer.setBullet();
            }
        }
    }
    
    public void inforPlayer(Player currentPlayer,Player remainPlayer) {
        currentPlayer.display(currentPlayer.getName(), remainPlayer.getName());
        System.out.println("Your current status:                    Enemy current status:");
        System.out.println("Number of cells that were fired: " + currentPlayer.getBullet() + "      number of cells that were fired: " + remainPlayer.getBullet()); // số ô bị bắn ở mặt trận địch
        System.out.print("The number of ships I destroyed: ");
        // so sánh bảng dùng để bắn của người hiện tại và bảng cá nhân của người chơi còn lại theo tọa độ các tàu 
        int number = 0;
        for(int pos = 0;pos < remainPlayer.Coordinates_X.size();++pos) {
            // lấy tọa độ của từng thuyền
            int x1 = remainPlayer.Coordinates_X.get(pos);
            int y1 = remainPlayer.Coordinates_Y.get(pos);
            ++pos;
            int x2 = remainPlayer.Coordinates_X.get(pos);
            int y2 = remainPlayer.Coordinates_Y.get(pos);
            if(x1 == x2) { // nếu cùng tọa độ hành => thuyền nằm ngang
                int check = 0; // biến kiểm tra
                for(int Pos = y1-1;Pos<=y2-1;++Pos) { // kiểm tra đã bắn thủng tàu tại tọa độ đó hay chưa
                    if(currentPlayer.EnemyBoard[x1-1][Pos] == ' '){
                        check = 1;
                        break;
                    }
                }
                if(check == 0) ++number; // nếu tại đó tàu bị bắn thủng
            } else { // nếu tọa độ tung => thuyền nằm dọc
                int check = 0; // biến kiểm tra
                for(int Pos = x1-1;Pos<=x2-1;++Pos) { // kiểm tra đã bắn thủng tàu tại tọa độ đó hay chưa
                    if(currentPlayer.EnemyBoard[Pos][y1-1] == ' '){
                        check = 1;
                        break;
                    }
                }
                if(check == 0) ++number; // nếu tại đó tàu bị bắn thủng
            }
        }
        
        System.out.print(number);
        System.out.print("      The number of ships I destroyed: ");
        // tương tự với tàu phá được đối với địch
        int number_1 = 0;
        for(int pos = 0;pos < currentPlayer.Coordinates_X.size();++pos) {
            // lấy tọa độ của từng thuyền
            int x1 = currentPlayer.Coordinates_X.get(pos);
            int y1 = currentPlayer.Coordinates_Y.get(pos);
            ++pos;
            int x2 = currentPlayer.Coordinates_X.get(pos);
            int y2 = currentPlayer.Coordinates_Y.get(pos);
            
            if(x1 == x2) { // nếu cùng tọa độ hành => thuyền nằm ngang
                int check = 0; // biến kiểm tra
                for(int Pos = y1-1;Pos<=y2-1;++Pos) { // kiểm tra đã bắn thủng tàu tại tọa độ đó hay chưa
                    if(remainPlayer.EnemyBoard[x1-1][Pos] == ' '){
                        check = 1;
                        break;
                    }
                }
                if(check == 0) ++number_1; // nếu tại đó tàu bị bắn thủng
            } else {
                int check = 0; // biến kiểm tra
                for(int Pos = x1-1;Pos<=x2-1;++Pos) { // kiểm tra đã bắn thủng tàu tại tọa độ đó hay chưa
                    if(remainPlayer.EnemyBoard[Pos][y1-1] == ' '){
                        check = 1;
                        break;
                    }
                }
                if(check == 0) ++number_1; // nếu tại đó tàu bị bắn thủng
            }
        }
        
        System.out.println(number_1);
        
        // hiển thị số tàu còn lại của bản thân
        
        System.out.print("My remaining ships: ");
        int remain_current = 5 - number;
        System.out.print(remain_current);
        System.out.print("                   Enemy remaining ships: ");
        int remain_remain = 5- number_1;
        System.out.println(remain_remain);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("");
        // check win
        if(remain_current == 0) {
            System.out.println("Congratulations " + remainPlayer.getName() + " for winning");
            remainPlayer.display(remainPlayer.getName(),currentPlayer.getName());
            this.check_win = 1;
        } else if(remain_remain == 0) {
            System.out.println("Congratulations " + currentPlayer.getName() + " for winning");
            currentPlayer.display(currentPlayer.getName(),remainPlayer.getName());
            this.check_win = 1;
        }
    }
    
    public void play() {
        displayRule(); // hiển thị luật chơi
        System.out.print("You are player 1, tell me your name( <= 33 characters): ");
        this.player1 = new Player();
        System.out.print("You are player 2, tell me your name( <= 33 characters): ");
        this.player2 = new Player();
        displayMenu(this.player1.getName(), this.player2.getName()); // hiển thị menu
        System.out.println("");
        // CHƠI
        Player currentPlayer = this.player1; // người chơi hiện tại
        Player remainPlayer = this.player2; // người chơi còn lại
        while(true) {
            System.out.println("It's " + currentPlayer.getName() + "'s turn!");
            currentPlayer.display(currentPlayer.getName(), remainPlayer.getName());
 
            shootEnemy(currentPlayer, remainPlayer); // bắt đầu bắn
            inforPlayer(currentPlayer, remainPlayer); // đưa ra thông tin người chơi sau khi bắn và kiểm tra đã chiến thắng hay chưa
            if(this.check_win == 1) { // kiểm tra kết thúc trò chơi chưa
                System.out.println("End Game!");
            }
            if(currentPlayer == this.player1){ // đổi lượt chơi cho người còn lại
                currentPlayer = this.player2;
                remainPlayer = this.player1;
            } else if(currentPlayer == this.player2){
                currentPlayer = this.player1;
                remainPlayer = this.player2;
            }
        }
    }
}
