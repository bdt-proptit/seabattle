package Play;

import java.sql.SQLOutput;

public class Manage {
    public void Update(Player player1, Player player2){
        player1.setShipDestroy(player1.getShipDestroy()+1);
        player2.setShipRemain(player2.getShipRemain()-1);
    }
    public void CheckCellFired(int x,int y, char[][] map,char[][] opponentMap, Player player1, Player player2){
        player1.setCellFired(player1.getCellFired()+1);
        if(x<0 || x>9 || y<0 || y>9 ) System.out.println("Tọa độ điểm bắn ngoài Map");
        else if(map[x][y]=='o' || map[x][y]=='X') System.out.println("Trùng tọa độ bắn");
        else{
            if(map[x][y] == '~'){
                System.out.println("Bạn đã bắn trượt!");
                map[x][y]='o';
                opponentMap[x][y]='o';
            }
            else{
                if(map[x][y]=='B'){
                    System.out.println("Bạn đã bắn trúng Thiết Giáp Hạm!");
                    player2.setLength_BattleShip(player2.getLength_BattleShip()-1);
                    if(player2.getLength_BattleShip()==0){
                        System.out.println("Bạn đã phá hủy Thiết Giám Hạm.");
                        Update(player1, player2);
                    }
                }
                else if(map[x][y]=='D'){
                    System.out.println("Bạn đã bắn trúng Tàu Khu Trục!");
                    player2.setLength_DestroyedBoat(player2.getLength_DestroyedBoat()-1);
                    if(player2.getLength_DestroyedBoat()==0){
                        System.out.println("Bạn đã phá hủy Tàu Khu Trục.");
                        Update(player1, player2);
                    }
                }
                else if(map[x][y]=='P'){
                    System.out.println("Bạn đã bắn trúng Thuyền tuần tra!");
                    player2.setLength_PatrolBoat(player2.getLength_PatrolBoat()-1);
                    if(player2.getLength_PatrolBoat()==0 || player2.getLength_PatrolBoat()==-2){
                        System.out.println("Bạn đã phá hủy Thuyền tuần tra.");
                        Update(player1, player2);
                    }
                }
                else if(map[x][y]=='S'){
                    System.out.println("Bạn đã bắn trúng Tàu ngầm!");
                    player2.setLength_Submarine(player2.getLength_Submarine()-1);
                    if(player2.getLength_Submarine()==0){
                        System.out.println("Bạn đã phá hủy Tàu ngầm.");
                        Update(player1, player2);
                    }
                }
                map[x][y]='X';opponentMap[x][y]='X';
            }
            System.out.println("Số lượng tàu đã phá hủy được: " + player1.getShipDestroy());
            System.out.println("Số thuyền chiến còn lại của bạn: " + player1.getShipRemain());
        }
    }
    public void setOpponentMap(char[][] opponentMap){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++) opponentMap[i][j] = '~';
        }
    }
    public void ShowOpponentMap(char[][] opponentMap){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++) System.out.print(opponentMap[i][j] + " ");
            System.out.print("\n");
        }
    }
    public void Turn(Player player, char[][] map, char[][] opponentMap){
        System.out.println("Số đạn bạn đã bắn ra: " + player.getCellFired());
        System.out.println("Số tàu đã phá được: " + player.getShipDestroy());
        System.out.println("Số tàu còn lại của bạn: " + player.getShipRemain());
        System.out.println("Map của bạn: ");
        player.ShowMyMap(map);
        System.out.println("Map của đối thủ ở dạng mù sương");
        ShowOpponentMap(opponentMap);
    }
    public void CheckWin(int check,Player player1, Player player2, char[][] map1, char[][] map2){
        if(player1.getShipRemain() == 4){
            System.out.println("Người chơi: " + player2.getPlayerName() + " đã thắng cuộc!");
            System.out.println("Số đạn đã bắn ra: " + player2.getCellFired());
            System.out.println("Số thuyền đã phá hủy: 5");
            System.out.println("Map của người thắng cuộc: ");
            player2.ShowMyMap(map2);
            System.out.println("Người chơi: " + player1.getPlayerName() + " đã thua cuộc!");
            System.out.println("Số đạn đã bắn ra: " + player1.getCellFired());
            System.out.println("Số thuyền đã phá hủy: " + player1.getShipDestroy());
            System.out.println("Map của người thua cuộc: ");
            player1.ShowMyMap(map1);
            System.exit(0);
        }
        else if(player2.getShipRemain() == 4){
            System.out.println("Người chơi: " + player1.getPlayerName() + " đã thắng cuộc!");
            System.out.println("Số đạn đã bắn ra: " + player1.getCellFired());
            System.out.println("Số thuyền đã phá hủy: 5");
            System.out.println("Map của người thắng cuộc: ");
            player1.ShowMyMap(map1);
            System.out.println("Người chơi: " + player2.getPlayerName() + " đã thua cuộc!");
            System.out.println("Số đạn đã bắn ra: " + player2.getCellFired());
            System.out.println("Số thuyền đã phá hủy: " + player2.getShipDestroy());
            System.out.println("Map của người thua cuộc: ");
            player2.ShowMyMap(map2);
            System.exit(0);
        }
        else return;
    }

}
