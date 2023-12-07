package Play;

import java.sql.SQLOutput;

public class Manage {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE ="\u001B[34m";
    public static final String ANSI_RED ="\u001B[31m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public void Update(Player player1, Player player2){
        player1.setShipDestroy(player1.getShipDestroy()+1);
        player2.setShipRemain(player2.getShipRemain()-1);
    }
    public void CheckCellFired(int x,int y, String[][] map, String[][] opponentMap, Player player1, Player player2){
        player1.setCellFired(player1.getCellFired()+1);
        if(x<0 || x>9 || y<0 || y>9 ) System.out.println("Tọa độ điểm bắn ngoài Map");
        else if(map[x][y] == ANSI_RED_BACKGROUND + "o" + ANSI_RESET || map[x][y]== ANSI_RED_BACKGROUND +"X" + ANSI_RESET) System.out.println("Trùng tọa độ bắn");
        else{
            if(map[x][y] == ANSI_BLUE + "~" + ANSI_RESET){
                System.out.println("Bạn đã bắn trượt!");
                map[x][y]= ANSI_RED_BACKGROUND + "o" + ANSI_RESET ;
                opponentMap[x][y]= ANSI_RED_BACKGROUND + "o" + ANSI_RESET;
            }
            else{
                if(map[x][y]==ANSI_GREEN + "B" + ANSI_RESET){
                    System.out.println("Bạn đã bắn trúng" + ANSI_GREEN + " Thiết Giáp Hạm!" + ANSI_RESET);
                    player2.setLength_BattleShip(player2.getLength_BattleShip()-1);
                    if(player2.getLength_BattleShip()==0){
                        System.out.println("Bạn đã phá hủy" + ANSI_GREEN + "Thiết Giám Hạm." + ANSI_RESET);
                        Update(player1, player2);
                    }
                }
                else if(map[x][y]== ANSI_YELLOW + "D" + ANSI_RESET){
                    System.out.println("Bạn đã bắn trúng" + ANSI_YELLOW + " Tàu Khu Trục!" + ANSI_RESET);
                    player2.setLength_DestroyedBoat(player2.getLength_DestroyedBoat()-1);
                    if(player2.getLength_DestroyedBoat()==0){
                        System.out.println("Bạn đã phá hủy" + ANSI_YELLOW + " Tàu Khu Trục." + ANSI_RESET);
                        Update(player1, player2);
                    }
                }
                else if(map[x][y]== ANSI_RED + "P" + ANSI_RESET){
                    System.out.println("Bạn đã bắn trúng" + ANSI_RED + " Thuyền tuần tra!" + ANSI_RESET);
                    player2.setLength_PatrolBoat(player2.getLength_PatrolBoat()-1);
                    if(player2.getLength_PatrolBoat()==0 || player2.getLength_PatrolBoat()==-2){
                        System.out.println("Bạn đã phá hủy" + ANSI_RED + " Thuyền tuần tra." + ANSI_RESET);
                        Update(player1, player2);
                    }
                }
                else if(map[x][y]== ANSI_PURPLE + "S" + ANSI_RESET){
                    System.out.println("Bạn đã bắn trúng" + ANSI_PURPLE + " Tàu ngầm!" + ANSI_RESET);
                    player2.setLength_Submarine(player2.getLength_Submarine()-1);
                    if(player2.getLength_Submarine()==0){
                        System.out.println("Bạn đã phá hủy" + ANSI_PURPLE + " Tàu ngầm." + ANSI_RESET);
                        Update(player1, player2);
                    }
                }
                map[x][y]= ANSI_RED_BACKGROUND + "X" + ANSI_RESET;opponentMap[x][y]= ANSI_RED_BACKGROUND + "X" + ANSI_RESET;
            }
            System.out.println("Số lượng tàu đã phá hủy được: " + ANSI_BLUE +  player1.getShipDestroy() + ANSI_RESET);
            System.out.println("Số thuyền chiến còn lại của bạn: " + ANSI_BLUE + player1.getShipRemain() + ANSI_RESET);
        }
    }
    public void setOpponentMap(String[][] opponentMap){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++) opponentMap[i][j] = ANSI_BLUE + "~" + ANSI_RESET;
        }
    }
    public void ShowOpponentMap(String[][] opponentMap){
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for(int i=0;i<10;i++){
            System.out.print((0+i) + " " );
            for(int j=0;j<10;j++) System.out.print(opponentMap[i][j] + " ");
            System.out.print("\n");
        }
    }
    public void Turn(Player player, String[][] map, String[][] opponentMap){
        System.out.println("Số đạn bạn đã bắn ra: " + ANSI_BLUE + player.getCellFired() + ANSI_RESET);
        System.out.println("Số tàu đã phá được: " + ANSI_BLUE + player.getShipDestroy() + ANSI_RESET);
        System.out.println("Số tàu còn lại của bạn: " + ANSI_BLUE + player.getShipRemain() + ANSI_RESET);
        System.out.println("Map của bạn: ");
        player.ShowMyMap(map);
        System.out.println("Map của đối thủ ở dạng mù sương");
        ShowOpponentMap(opponentMap);
    }
    public void CheckWin(Player player1, Player player2, String[][] map1, String[][] map2){
        if(player1.getShipRemain() == 0){
            System.out.println("Người chơi: " + ANSI_CYAN + player2.getPlayerName() + ANSI_RESET + " đã thắng cuộc!");
            System.out.println("Số đạn đã bắn ra: " + ANSI_BLUE + player2.getCellFired() + ANSI_RESET);
            System.out.println("Số thuyền đã phá hủy: " + ANSI_BLUE + "5" + ANSI_RESET);
            System.out.println("Map của người thắng cuộc: ");
            player2.ShowMyMap(map2);
            System.out.println("Người chơi: " + ANSI_CYAN + player1.getPlayerName() + ANSI_RESET + " đã thua cuộc!");
            System.out.println("Số đạn đã bắn ra: " + ANSI_BLUE + player1.getCellFired() + ANSI_RESET);
            System.out.println("Số thuyền đã phá hủy: " + ANSI_BLUE + player1.getShipDestroy() + ANSI_RESET);
            System.out.println("Map của người thua cuộc: ");
            player1.ShowMyMap(map1);
            EndGame();
        }
        else if(player2.getShipRemain() == 0){
            System.out.println("Người chơi: " + ANSI_CYAN+ player1.getPlayerName() + ANSI_RESET + " đã thắng cuộc!");
            System.out.println("Số đạn đã bắn ra: " + ANSI_BLUE + player1.getCellFired() + ANSI_RESET);
            System.out.println("Số thuyền đã phá hủy: " + ANSI_BLUE + "5" + ANSI_RESET);
            System.out.println("Map của người thắng cuộc: ");
            player1.ShowMyMap(map1);
            System.out.println("Người chơi: " + ANSI_CYAN + player2.getPlayerName() + ANSI_RESET + " đã thua cuộc!");
            System.out.println("Số đạn đã bắn ra: " + ANSI_BLUE + player2.getCellFired() + ANSI_RESET);
            System.out.println("Số thuyền đã phá hủy: " + ANSI_BLUE + player2.getShipDestroy() + ANSI_RESET);
            System.out.println("Map của người thua cuộc: ");
            player2.ShowMyMap(map2);
             EndGame();
        }
        else return;
    }
    public void EndGame(){
        System.out.println(ANSI_CYAN +
                " ________       ____  ____      _________              _________     ________      _____________      ________\n" +
                "|\\  _____\\    |\\    \\/|   \\    |\\   ___  \\            |\\   _____\\   |\\   ___  \\   |\\             \\   |\\  _____\\\n" +
                " \\ \\ \\____|_   \\ \\   \\|    \\    \\ \\ \\  \\  \\           \\ \\  \\  ____  \\ \\  \\| \\  \\   \\ \\   _    _   \\   \\ \\ \\____|_\n" +
                "  \\ \\  _____\\   \\ \\         \\    \\ \\ \\  \\  \\           \\ \\  \\ |\\  \\  \\ \\   ___  \\   \\ \\  \\ \\  \\ \\  \\   \\ \\  _____\\\n" +
                "   \\ \\ \\____|_   \\ \\   |\\    \\    \\ \\ \\__\\  \\           \\ \\  \\/_|  \\  \\ \\  \\  \\  \\   \\ \\  \\ \\  \\ \\  \\   \\ \\ \\____|_\n" +
                "    \\ \\_______\\   \\ \\__| \\____\\    \\ \\_______\\           \\ \\________\\  \\ \\__\\  \\__\\   \\ \\__\\ \\__\\ \\__\\   \\ \\_______\\\n" +
                "     \\|________|   \\|__|\\ \\____|    \\|_______|            \\|_________|  \\|___|\\|___|   \\|___|\\___|\\___|   \\|________|\n" +
                ANSI_RESET
        );
    }
}
