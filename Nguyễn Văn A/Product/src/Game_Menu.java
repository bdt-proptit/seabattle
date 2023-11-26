import java.util.Scanner;

public class Game_Menu{
      Scanner sc = new Scanner(System.in);
      public void CreateNewMap(){
            Player player1 = new Player();
            Player player2 = new Player();
            Main.List.add(player1);
            Main.List.add(player2);
            Main.List.get(0).CreatNewBoard();
            Main.List.get(1).CreatNewBoard();
            Main.List.get(0).CreatNewBoard_Enemy();
            Main.List.get(1).CreatNewBoard_Enemy();
      }
      public void CreateBoat(){
            for(int i = 0 ; i <= 1; i++){
                  System.out.println("Create Player " + (i+1) + "'s Board: ");
                  Player tmp = new Player();
                  int check = 0;
                  while(check == 0){
                        check = tmp.Add_PatrolBoat();
                  }
                  check = 0;
                  while(check == 0){
                        check = tmp.Add_PatrolBoat();
                  }
                  check = 0;
                  while(check == 0){
                        check = tmp.Add_DestroyerBoat();
                  }
                  check = 0;
                  while(check == 0){
                        check = tmp.Add_Submarine();
                  }
                  check = 0;
                  while(check == 0){
                        check = tmp.Add_BattleShip();
                  }

                  Main.List.get(i).board_Me = tmp.board_Me;
                  Main.List.get(i).SeeMap();
            }
            // HOW TO XOA MAN HINH ĐỂ NHẬP Player sau
      }
      public void TurnAttack(int i){
            System.out.println("Player " +(i+1) + "'s turn :");
            System.out.println("Show Your Board: ");
            Main.List.get(i).SeeMap();
            System.out.println("Show Attacked Map of Your Enemy: ");
            Main.List.get(i).SeeMap_Enemy();

            System.out.println("Enter your choice to Attack");
            int x = sc.nextInt();
            int y = sc.nextInt();
            Main.List.get(i).Attack(x,y,i); // tk i ATK tk 1 - i;
      }

}
