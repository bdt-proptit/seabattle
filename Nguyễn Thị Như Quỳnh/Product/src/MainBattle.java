package Thuyen;

import java.util.Scanner;

public class MainBattle {
    private static void menuGame() {
        while(true){
            System.out.println("   ...     .......     ...           .....        ...     ..................  .       .......");
            System.out.println("^#@&#&@#^ ~@@&###&^   ?@@@&         Y@@&#&&&!    #@@@?   ?&#&@@&#&G#&&@@@&&B.&@#     ~@@&###&~");
            System.out.println("P@@       !@@        ~@@:&@#        P@@   @@5   B@P!@@!     J@@7     .@@#    @@&     ~@@");
            System.out.println(" ~YPB&@&Y !@@&BBBG  :@@G:Y@@G       P@@#G#@#~  P@@   @@^    ?@@!     .@@B    @@&     ~@@&BBBG");
            System.out.println("      @@& !@@      .@@&BBB#@@5      P@@   @@@ Y@@BBBB@@@:   ?@@!     .@@#    @@@     ~@@");
            System.out.println("!!5GGGY~  :P5PPPPG:!P5     JPP.     ~P5PPPY7..5P!    :PP?   ^PP:      5P7    YPPPPPG^.P5PPPPG^");
            System.out.println("  ...     .......     ...           .....        ...     ..................  .       .......");
            System.out.println("Menu:");
            System.out.println("1. Bat dau");
            System.out.println("2. Thoat");
            Scanner sc = new Scanner(System.in);
            int press = sc.nextInt();
            if (press == 1) Start();
            else if (press == 2) break;
            else System.out.println("Ban da nhap sai cu phap!\nMoi nhap lai!");
            }
    }
    private static void Start(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi nguoi choi thu nhat nhap ten: ");
        String namePlayer = sc.nextLine();
        char[][] board1 = Boards.createBoard('~');
        char[][] fog = Boards.createBoard('~');
        String[] ships = new String[6];
        ships[1] = "Thiet Giap Ham";
        ships[2] = "Tau Khu Truc";
        ships[3] = "Tau Ngam";
        ships[4] = ships[5] = "Thuyen Tuan Tra";
        int[] length = new int[6];
        length[1]=5;
        length[2]=4;
        length[3]=3;
        length[4]=length[5]=2;
        Ship[] ship = new Ship[6];
        System.out.printf("Moi %s dat thuyen!\n", namePlayer);
        System.out.println("Chu y: Nhap toa do dung cu phap va sao cho khoang cach 2 diem bang do dai thuyen!");
        Boards.showBoard(board1);
        for (int i=1;i<=5;i++){
            ship[i]=new Ship(ships[i], length[i], "", "", false, 0);
            System.out.printf("Moi nhap toa do cho %s co do dai la %d\n", ships[i], length[i]);
            String coorDinate1, coorDinate2;
            while (true) {
                System.out.print("Toa do diem dau (VD: A1, B4,...): ");
                coorDinate1 = sc.nextLine();
                String[] th = new String[5];
                int number = 0;
                if (Boards.checkSetShip(ship[i], board1, coorDinate1, Boards.up(coorDinate1, length[i]))){
                    number++;
                    th[number]=Boards.up(coorDinate1, length[i]);
                }
                if (Boards.checkSetShip(ship[i], board1, coorDinate1, Boards.down(coorDinate1, length[i]))){
                    number++;
                    th[number]=Boards.down(coorDinate1, length[i]);
                }
                if (Boards.checkSetShip(ship[i], board1, coorDinate1, Boards.left(coorDinate1, length[i]))){
                    number++;
                    th[number]=Boards.left(coorDinate1, length[i]);
                }
                if (Boards.checkSetShip(ship[i], board1, coorDinate1, Boards.right(coorDinate1, length[i]))){
                    number++;
                    th[number]=Boards.right(coorDinate1, length[i]);
                }
                if(number==0&&!Boards.checkPoint1(board1, coorDinate1)) {
                    System.out.println("Diem ban nhap co the da sai cu phap, ngoai vung dat thuyen hoac khong the dat do se chong lan len thuyen khac!");
                    System.out.println("Moi nhap lai!");
                }
                else{
                    System.out.print("Cac diem cuoi co the dat la: ");
                    for (int j=1;j<=number;j++){
                        if(j<number) System.out.printf("%s, ", th[j]);
                        else System.out.printf("%s\n", th[j]);
                    }
                    System.out.print("Toa do diem cuoi (VD: A1, B4,...): ");
                    coorDinate2 = sc.nextLine();
                    if(Boards.checkSetShip(ship[i], board1, coorDinate1, coorDinate2)) break;
                    else System.out.println("Diem cuoi cua ban khong hop le!\nMoi nhap lai tu diem dau!");
                }
            }
            ship[i]=new Ship(ships[i], length[i], coorDinate1, coorDinate2, false, 0);
            Boards.setShip(board1, coorDinate1, coorDinate2);
            Boards.showBoard(board1);
        }
        Player player1 = new Player(namePlayer, 0, 5, board1, ship, fog, 0);
        for (int i=1;i<=30;i++) System.out.println(":>");
        System.out.print("Moi nguoi choi thu hai nhap ten: ");
        namePlayer = sc.nextLine();
        board1 = Boards.createBoard('~');
        fog = Boards.createBoard('~');
        ship = new Ship[6];
        System.out.printf("Moi %s dat thuyen!\n", namePlayer);
        System.out.println("Chu y: Nhap toa do dung cu phap va sao cho khoang cach 2 diem bang do dai thuyen!");
        Boards.showBoard(board1);
        for (int i=1;i<=5;i++){
            ship[i]=new Ship(ships[i], length[i], "", "", false, 0);
            System.out.printf("Moi nhap toa do cho %s co do dai la %d\n", ships[i], length[i]);
            String coorDinate1, coorDinate2;
            while (true) {
                System.out.print("Toa do diem dau (VD: A1, B4,...): ");
                coorDinate1 = sc.nextLine();
                String[] th = new String[5];
                int number = 0;
                if (Boards.checkSetShip(ship[i], board1, coorDinate1, Boards.up(coorDinate1, length[i]))){
                    number++;
                    th[number]=Boards.up(coorDinate1, length[i]);
                }
                if (Boards.checkSetShip(ship[i], board1, coorDinate1, Boards.down(coorDinate1, length[i]))){
                    number++;
                    th[number]=Boards.down(coorDinate1, length[i]);
                }
                if (Boards.checkSetShip(ship[i], board1, coorDinate1, Boards.left(coorDinate1, length[i]))){
                    number++;
                    th[number]=Boards.left(coorDinate1, length[i]);
                }
                if (Boards.checkSetShip(ship[i], board1, coorDinate1, Boards.right(coorDinate1, length[i]))){
                    number++;
                    th[number]=Boards.right(coorDinate1, length[i]);
                }
                if(number==0&&!Boards.checkPoint1(board1, coorDinate1)) {
                    System.out.println("Diem ban nhap co the da sai cu phap, ngoai vung dat thuyen hoac khong the dat do se chong lan len thuyen khac!");
                    System.out.println("Moi nhap lai!");
                }
                else{
                    System.out.print("Cac diem cuoi co the dat la: ");
                    for (int j=1;j<=number;j++){
                        if(j<number) System.out.printf("%s, ", th[j]);
                        else System.out.printf("%s\n", th[j]);
                    }
                    System.out.print("Toa do diem cuoi (VD: A1, B4,...): ");
                    coorDinate2 = sc.nextLine();
                    if(Boards.checkSetShip(ship[i], board1, coorDinate1, coorDinate2)) break;
                    else System.out.println("Diem cuoi cua ban khong hop le!\nMoi nhap lai tu diem dau!");
                }
            }
            ship[i]=new Ship(ships[i], length[i], coorDinate1, coorDinate2, false, 0);
            Boards.setShip(board1, coorDinate1, coorDinate2);
            Boards.showBoard(board1);
        }
        Player player2 = new Player(namePlayer, 0, 5, board1, ship, fog, 0);
        System.out.println("Da dat thuyen xong!\nTran chien bat dau!");
        Player player;
        int ktt=0;
        do {
            for (int i = 1; i <= 30; i++) System.out.println(":>");
            System.out.printf("Luot cua %s!\n", player1.getNamePlayer());
            int kt = 0;
            while (true) {
                System.out.printf("So diem da ban: %d\n", player1.getPoint());
                System.out.printf("So tau da pha: %d\n", player2.getWreck());
                System.out.printf("So tau con lai cua ban than: %d\n", 5 - player1.getWreck());
                System.out.println("1. Xem bang cua ban than");
                if (kt == 0) System.out.println("2. Ban!");
                System.out.println("3. Ket thuc luot");
                byte press = sc.nextByte();
                if (press == 1) Boards.showBoard(player1.getBoard());
                else if (press == 2) {
                    if (kt == 0) {
                        Boards.showBoard(player1.getFog());
                        System.out.print("Nhap toa do muon ban(VD: A1, C4,..): ");
                        String coorDinate = new Scanner(System.in).nextLine();
                        while (!Boards.checkPoint1(player1.getFog(), coorDinate)) {
                            System.out.print("Toa do ban nhap khong ton tai hoac toa do nay da tung ban!\nMoi nhap lai(VD: A1, C4,..): ");
                            coorDinate = new Scanner(System.in).nextLine();
                        }
                        int check = 0;
                        if (Boards.checkShoot(coorDinate, player1, player2)) {
                            check = 1;
                        } else kt = 1;
                        Boards.shoot(coorDinate, player1, player2);
                        player1.setPoint(player1.getPoint() + 1);
                        if (check == 1) {
                            if (player2.winner()) {
                                ktt = 1;
                                endGame(player1.getNamePlayer());
                                break;
                            }
                        }
                    } else System.out.println("Sai cu phap! Moi nhap lai!");
                } else if (press == 3) {
                    player = player1;
                    player1 = player2;
                    player2 = player;
                    break;
                }
            }
        } while (ktt != 1);
    }
    private static void endGame(String namePlayer){
        System.out.printf("Tau cua doi thu da bi chim het!\nChuc mung %s da chien thang!!!\n", namePlayer);
        for (int i=1;i<=30;i++) System.out.println(":>");
    }
    public static void main(String[] args) {
        menuGame();
    }
}
