import java.util.Scanner;

public class Manage {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_BLACK = "\u001B[30m";
    Scanner sc = new Scanner(System.in);
    SolvePoints solve = new SolvePoints();

    public void setUpMap(Player player, Manage manage){
        for(Ships it : player.getListShips()){
            manage.showMyBoard(player);
            String begin;
            String end;
            while (true){
                System.out.println("(Lưu ý khi nhập điểm hãy nhập hàng trước cột sau VD: A1 B1)");
                switch (it.getSize()){
                    case 5:
                        System.out.print("Nhập tọa độ đầu và cuối của thiết giáp hạm 1x5: ");
                        break;
                    case 4:
                        System.out.print("Nhập tọa độ đầu và cuối của thuyền khu vực 1x4: ");
                        break;
                    case 3:
                        System.out.print("Nhập tọa độ đầu và cuối của tàu ngầm 1x3: ");
                        break;
                    case 2:
                        System.out.print("Nhập tọa độ đầu và cuối của thuyền tuần tra 1x2: ");
                        break;
                }
                begin = sc.next();
                end = sc.next();

                //check tọa độ nhập vào có bị out khỏi map ko
                if(solve.rows(begin) >= 1 && solve.rows(begin) <= 10 && solve.columns(begin) >= 1 && solve.columns(begin) <=10
                        && solve.rows(end) >= 1 && solve.rows(end) <= 10 && solve.columns(end) >= 1 && solve.columns(end) <=10){

                    //check tọa độ nhập vào có bị trùng tàu khác ko, có thì checkShip = 1
                    int checkShip = 0;
                    int xBegin = solve.rows(begin);
                    int yBegin = solve.columns(begin);
                    int xEnd = solve.rows(end);
                    int yEnd = solve.columns(end);
                    if(xBegin == xEnd){
                        for(int i=Math.min(yBegin, yEnd) ; i<=Math.max(yBegin,yEnd) ; i++){
                            if(solve.findPoint(player.getMap().getListShipPoints(), solve.points(xBegin,i))){
                                checkShip = 1;
                                break;
                            }
                        }
                    }
                    else {
                        for(int i=Math.min(xBegin, xEnd) ; i<=Math.max(xBegin,xEnd) ; i++){
                            if(solve.findPoint(player.getMap().getListShipPoints(), solve.points(i, yBegin))){
                                checkShip = 1;
                                break;
                            }
                        }
                    }

                    if(checkShip == 0){
                        //check độ dài tàu có hợp lệ k
                        if((Math.abs(xBegin - xEnd) + Math.abs(yBegin - yEnd)) == it.getSize() - 1 || (xBegin == xEnd || yBegin == yEnd)) break;
                        else System.out.println("Độ dài của tàu không phù hợp, vui lòng nhập lại!");
                    }
                    else System.out.println("Tọa độ thuyền bị trùng, vui lòng nhập lại!");
                }
                else System.out.println("Tọa độ thuyền không hợp lệ, vui lòng nhập lại!");
            }
            it.setBeginPoints(begin);
            it.setEndPoints(end);

            it.setShipPoints(begin,end);
            player.getMap().setListShipPoints(it.getListShipPoints()); //cập nhật vị trí của tàu leen map
        }
    }

    public boolean checkFireShip(Player playerFire, Player playerBeFired, String point){
        playerFire.getMap().setListFirePoints(point); //cập nhật điểm bắn trên map player1
        playerBeFired.getMap().setListBeFiredPoints(point); //cập nhật điểm bị bắn trên map player2

        for(int i=1 ; i<=10 ; i++){
            for(int j=1 ; j<=10 ; j++){
                if(solve.findPoint(playerBeFired.getMap().getListShipPoints(), point)){
                    System.out.println("+---------------------------+");
                    System.out.println("|                           |");
                    System.out.println("|     Bạn đã bắn trúng!     |");
                    System.out.println("|                           |");
                    System.out.println("+---------------------------+");
                    return true;
                }
            }
        }
        System.out.println("+---------------------------+");
        System.out.println("|                           |");
        System.out.println("|     Trượt rùi huhu :<     |");
        System.out.println("|                           |");
        System.out.println("+---------------------------+");
        return false;
    }

    public boolean checkLiveShip(Player player, String firePoint){ // Kiểm tra xem tàu nào bị bắn, tàu bị bắn còn sống ko
        for(Ships it : player.getListShips()){
            for(String it2 : it.getListShipPoints()){
                if(firePoint.equals(it2)){
                    it.setNumberOfDamagePoints(it.getNumberOfDamagePoints() + 1);
                    if(it.getNumberOfDamagePoints() == it.getSize()){
                        System.out.println("");
                        System.out.println("--------------------------------");
                        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + "Tàu " + it.getName() + "đã bị hạ!" + ANSI_RESET);
                        System.out.println("--------------------------------");
                        System.out.println("");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkWin(Player player){
        if(player.getNumberOfKilledShip() == 5){
            System.out.println("");
            System.out.println("--------------------------------");
            System.out.println("Chúc mừng " + player.getName() + " đã thắng, bạn là nhất! siuuuuuuuuu");
            return true;
        }
        else return false;
    }
    public void updateNumberOfShips(Player playerFire, Player playerBeFired){
        playerBeFired.setNumberOfLiveShips(playerBeFired.getNumberOfLiveShips() - 1);
        playerFire.setNumberOfKilledShip(playerFire.getNumberOfKilledShip() + 1);
    }

    public boolean menu(Player player, Manage manage){
        System.out.println("------------------------------");
        System.out.println("Số lần bạn đã khai hỏa: " + player.getNumberOfFire());
        System.out.println("Số tàu bạn đã bắn hạ: " + player.getNumberOfKilledShip());
        System.out.println("Số tàu của bạn còn sống: " + player.getNumberOfLiveShips());
        System.out.println("------------------------------");
        System.out.printf("");
        System.out.println("Xem thuyền của bản thân: 1");
        System.out.println("Khai hỏa: 2");
        String choice;

        while (true){
            System.out.print("Nhập lựa chọn: ");
            choice = sc.next();
            if(choice.equals("1") || choice.equals("2")) break;
            else System.out.println("Lựa chọn không phù hợp, mời nhập lại lựa chọn!");
        }

        switch (choice){
            case "1":
                manage.showMyBoard(player);
                return false;
            case "2":
                return true;
        }
        return true;
    }

    public String fire(Player player){
        player.setNumberOfFire(player.getNumberOfFire() + 1);
        String firePoint;
        while (true){
            System.out.print("Nhập tọa độ khai hỏa: ");
            firePoint = sc.next();
            if(solve.rows(firePoint) >=1 && solve.rows(firePoint) <= 10 && solve.columns(firePoint) >= 1 && solve.columns(firePoint) <= 10){
                if(!solve.findPoint(player.getMap().getListFirePoints(), firePoint)) break;
                else System.out.println("Tọa độ đã được bắn từ trước, vui lòng nhập lại!");
            }
            else System.out.println("Tọa độ không hợp lệ, vui lòng nhập lại!");
        }
        return firePoint;
    }

    public void showMyBoard(Player player){
        for(int i=0 ; i<=player.getMap().getRows() ; i++){
            for(int j=0 ; j<=player.getMap().getColumns() ; j++){
                if(i == 0 && j == 0) System.out.printf("%5s|"," ");
                else if (i == 0 && j > 0 && j<10) System.out.printf("%2s%d%2s|"," ",j," ");
                else if (i == 0 && j>=10) System.out.printf("%1s%d%2s|"," ",j," ");
                else if (j == 0 && i > 0) System.out.printf("%2s%c%2s|"," ",i + 'A' - 1," ");

                else if(solve.findPoint(player.getMap().getListBeFiredPoints(), solve.points(i,j))){
                    if(solve.findPoint(player.getMap().getListShipPoints(), solve.points(i,j)))
                        System.out.printf("%s%2sX%2s%s|",ANSI_RED_BACKGROUND," "," ",ANSI_RESET);
                    else System.out.printf("%s%2sX%2s%s|",ANSI_YELLOW_BACKGROUND," "," ",ANSI_RESET);
                }
                else if(solve.findPoint(player.getMap().getListShipPoints(), solve.points(i,j))){
                    System.out.printf("%s%2s#%2s%s|",ANSI_BLUE_BACKGROUND," "," ",ANSI_RESET);
                }
                else System.out.printf("%5s|"," ");
            }

            System.out.println("");
            for(int j=1 ; j<=(player.getMap().getColumns()+1)*6 ; j++){
                if(i == player.getMap().getRows()) System.out.print("-");
                else if(j % 6 == 0 && j != (player.getMap().getColumns()+1)*6) System.out.print("+");
                else if(j == (player.getMap().getColumns()+1)*6) System.out.print("|");
                else System.out.print("-");
            }
            System.out.println("");
        }
    }

    public void showEnemyBoard(Player player, Board enemyMap){
        for(int i=0 ; i<=player.getMap().getRows() ; i++){
            for(int j=0 ; j<=player.getMap().getColumns() ; j++){
                if(i == 0 && j == 0) System.out.printf("%5s|"," ");
                else if (i == 0 && j > 0 && j<10) System.out.printf("%2s%d%2s|"," ",j," ");
                else if (i == 0 && j>=10) System.out.printf("%1s%d%2s|"," ",j," ");
                else if (j == 0 && i > 0) System.out.printf("%2s%c%2s|"," ",i + 'A' - 1," ");

                else if(solve.findPoint(player.getMap().getListFirePoints(), solve.points(i,j))){
                    if(solve.findPoint(enemyMap.getListShipPoints(), solve.points(i,j)))
                        System.out.printf("%s%2sX%2s%s|",ANSI_RED_BACKGROUND," "," ",ANSI_RESET);
                    else System.out.printf("%s%2sX%2s%s|",ANSI_YELLOW_BACKGROUND," "," ",ANSI_RESET);
                }
                else System.out.printf("%5s|"," ");
            }

            System.out.println("");
            for(int j=1 ; j<=(player.getMap().getColumns()+1)*6 ; j++){
                if(i == player.getMap().getRows()) System.out.print("-");
                else if(j % 6 == 0 && j != (player.getMap().getColumns()+1)*6) System.out.print("+");
                else if(j == (player.getMap().getColumns()+1)*6) System.out.print("|");
                else System.out.print("-");
            }
            System.out.println("");
        }
    }
}
