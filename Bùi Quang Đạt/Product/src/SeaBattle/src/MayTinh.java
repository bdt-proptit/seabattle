import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;
public class MayTinh{
    Scanner sc = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private int choice;
    public static int[] dx4= {-1, 0, 0, 1};
    public static int[] dy4 = {0, -1, 1, 0};
    public static boolean[][] visited = new boolean[55][55];
    public static boolean[][] visited2 = new boolean[55][55];
    public MayTinh(){
        for(int i=1;i<=50;i++){
            for(int j=1;j<=50;j++){
                visited[i][j] = false;
                visited2[i][j] = false;
            }
        }
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void hienThi(){
        System.out.println("----------------------Máy Tính----------------------");
        System.out.println("|1. Martin - Cấp độ dễ (Elo: 800).                 |");
        System.out.println("|2. AlphaZero - Cấp độ khó (Elo: 2000).            |");
        System.out.println("|3. Stockfish - Cấp độ bất khả thi (Elo: 3200).    |");
        System.out.println("----------------------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void MenuChien(){
        System.out.println("------------Người Chơi------------------");
        System.out.println("|1. Xem bản đồ hiện tại của mình.      |");
        System.out.println("|2. Xem bản đồ của máy tính.           |");
        System.out.println("|3. Khai Hỏa.                          |");
        System.out.println("----------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void MenuLuaChon(){
        System.out.println("------------Người Chơi--------------");
        System.out.println("|1. Đặt thuyền thủ công.           |");
        System.out.println("|2. Tự động đặt thuyền.            |");
        System.out.println("------------------------------------");
        System.out.print("Lựa chọn của bạn là: ");
    }
    public void MenuNguoiChoi(){
        System.out.println("------------Người Chơi------------------");
        System.out.println("|1. Xem bản đồ hiện tại của mình.      |");
        System.out.println("|2. Thêm thuyền.                       |");
        System.out.println("----------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void MenuMT1(){
        System.out.println("----------------------Máy Tính 1--------------------");
        System.out.println("|1. Martin - Cấp độ dễ (Elo: 800).                 |");
        System.out.println("|2. AlphaZero - Cấp độ khó (Elo: 2000).            |");
        System.out.println("|3. Stockfish - Cấp độ bất khả thi (Elo: 3200).    |");
        System.out.println("----------------------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void MenuMT2(){
        System.out.println("----------------------Máy Tính 2--------------------");
        System.out.println("|1. Martin - Cấp độ dễ (Elo: 800).                 |");
        System.out.println("|2. AlphaZero - Cấp độ khó (Elo: 2000).            |");
        System.out.println("|3. Stockfish - Cấp độ bất khả thi (Elo: 3200).    |");
        System.out.println("----------------------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void banDo2MT(NguoiChoi mayTinh1, NguoiChoi mayTinh2){
        Character[][] BanDo1 = new Character[50][50];
        Character[][] BanDo2 = new Character[50][50];
        int kichCo = mayTinh1.kichCoBanDo;
        for(int i=1;i<=kichCo ;i++){
            for(int j=1;j<=kichCo ;j++){
                BanDo1[i][j] = mayTinh1.BanDo[i][j];
                BanDo2[i][j] = mayTinh2.BanDo[i][j];
            }
        }
        System.out.println("Đây là bản đồ của hai máy tính: ");
        switch (kichCo){
            case 5:
                System.out.println(ANSI_BLUE+ "-----------Máy-Tính-1--------------------Máy-Tính-2----------");
                break;
            case 6:
                System.out.println(ANSI_BLUE+ "------------Máy-Tính-1----------------------Máy-Tính-2-----------");
                break;
            case 7:
                System.out.println(ANSI_BLUE+ "-------------Máy-Tính-1------------------------Máy-Tính-2------------");
                break;
            case 8:
                System.out.println(ANSI_BLUE+ "--------------Máy-Tính-1--------------------------Máy-Tính-2-------------");
                break;
            case 9:
                System.out.println(ANSI_BLUE+ "--------------Máy-Tính-1----------------------------Máy-Tính-2---------------");
                break;
            case 10:
                System.out.println(ANSI_BLUE+ "-----------------Máy-Tính-1-------------------------------Máy-Tính-2-------------");
                break;
            case 11:
                System.out.println(ANSI_BLUE+ "------------------Máy-Tính-1--------------------------------Máy-Tính-2---------------");
                break;
            case 12:
                System.out.println(ANSI_BLUE+ "------------------Máy-Tính-1----------------------------------Máy-Tính-2-----------------");
                break;
            case 13:
                System.out.println(ANSI_BLUE+ "--------------------Máy-Tính-1-----------------------------------Máy-Tính-2------------------");
                break;
            case 14:
                System.out.println(ANSI_BLUE+ "-------------------Máy-Tính-1--------------------------------------Máy-Tính-2--------------------");
                break;
            case 15:
                System.out.println(ANSI_BLUE+ "--------------------Máy-Tính-1-----------------------------------------Máy-Tính-2--------------------");
                break;
            case 16:
                System.out.println(ANSI_BLUE+ "-----------------------Máy-Tính-1-----------------------------------------Máy-Tính-2---------------------");
                break;
            case 17:
                System.out.println(ANSI_BLUE+ "----------------------Máy-Tính-1----------------------------------------------Máy-Tính-2---------------------");
                break;
            case 18:
                System.out.println(ANSI_BLUE+ "------------------------Máy-Tính-1-----------------------------------------------Máy-Tính-2----------------------");
                break;
            case 19:
                System.out.println(ANSI_BLUE+ "-------------------------Máy-Tính-1-------------------------------------------------Máy-Tính-2-----------------------");
                break;
            case 20:
                System.out.println(ANSI_BLUE+ "-------------------------Máy-Tính-1--------------------------------------------------Máy-Tính-2--------------------------");
                break;
            default:
                break;
        }

        for(int i=0;i<=kichCo ;i++) {
            for (int j = 0; j <= kichCo; j++) {
                if (j == 0) {
                    System.out.print(ANSI_BLUE + "|         ");
                }
                if (i == 0 && j == 0) {
                    System.out.print(ANSI_BLUE + "  ");
                } else if (i == 0) {
                    if (j == kichCo) {
                        if (j <= 10) {
                            System.out.print(j - 1 + "         |           ");
                        } else {
                            System.out.print((char) (j + 54) + "         |           ");
                        }
                        for (int k = 0; k < kichCo; k++) {
                            if (k == kichCo - 1) {
                                if (k <= 9) {
                                    System.out.print(k + "         |");
                                } else {
                                    System.out.print((char) (k + 55) + "         |");
                                }
                            } else {
                                if (k <= 9) {
                                    System.out.print(k + " ");
                                } else {
                                    System.out.print((char) (k + 55) + " ");
                                }
                            }
                        }
                    } else {
                        if (j <= 10) {
                            System.out.print(j - 1 + " ");
                        } else {
                            System.out.print((char) (j + 54) + " ");
                        }
                    }
                } else if (j == 0) {
                    if (i <= 10) {
                        System.out.print(i - 1 + " ");
                    } else {
                        System.out.print((char) (i + 54) + " ");
                    }
                } else {
                    if (BanDo1[i][j] == 'T') {
                        if (j == kichCo) {
                            System.out.print(ANSI_YELLOW + BanDo1[i][j] + ANSI_BLUE + "         |         ");
                            for (int k = 0; k <= kichCo; k++) {
                                if (k == 0) {
                                    if (i <= 10) {
                                        System.out.print(i - 1 + " ");
                                    } else {
                                        System.out.print((char) (i + 54) + " ");
                                    }
                                } else {
                                    if (k == kichCo) {
                                        if (BanDo2[i][k] == 'T')
                                            System.out.print(ANSI_YELLOW + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else if (BanDo2[i][k] == '.')
                                            System.out.print(ANSI_BLUE + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else if (BanDo2[i][k] == 'X')
                                            System.out.print(ANSI_RED + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else {
                                            System.out.print(ANSI_GREEN + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        }
                                    } else {
                                        if (BanDo2[i][k] == 'T')
                                            System.out.print(ANSI_YELLOW + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else if (BanDo2[i][k] == '.')
                                            System.out.print(ANSI_BLUE + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else if (BanDo2[i][k] == 'X')
                                            System.out.print(ANSI_RED + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else {
                                            System.out.print(ANSI_GREEN + BanDo2[i][k] + ANSI_BLUE + " ");
                                        }
                                    }
                                }
                            }
                        } else System.out.print(ANSI_YELLOW + BanDo1[i][j] + " " + ANSI_BLUE);
                    } else if (BanDo1[i][j] == 'X') {
                        if (j == kichCo) {
                            System.out.print(ANSI_RED + BanDo1[i][j] + ANSI_BLUE + "         |         ");
                            for (int k = 0; k <= kichCo; k++) {
                                if (k == 0) {
                                    if (i <= 10) {
                                        System.out.print(i - 1 + " ");
                                    } else {
                                        System.out.print((char) (i + 54) + " ");
                                    }
                                } else {
                                    if (k == kichCo) {
                                        if (BanDo2[i][k] == 'T')
                                            System.out.print(ANSI_YELLOW + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else if (BanDo2[i][k] == '.')
                                            System.out.print(ANSI_BLUE + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else if (BanDo2[i][k] == 'X')
                                            System.out.print(ANSI_RED + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else {
                                            System.out.print(ANSI_GREEN + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        }
                                    } else {
                                        if (BanDo2[i][k] == 'T')
                                            System.out.print(ANSI_YELLOW + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else if (BanDo2[i][k] == '.')
                                            System.out.print(ANSI_BLUE + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else if (BanDo2[i][k] == 'X')
                                            System.out.print(ANSI_RED + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else {
                                            System.out.print(ANSI_GREEN + BanDo2[i][k] + ANSI_BLUE + " ");
                                        }
                                    }
                                }
                            }
                        } else System.out.print(ANSI_RED + BanDo1[i][j] + " " + ANSI_BLUE);
                    } else if (BanDo1[i][j] == '~') {
                        if (j == kichCo) {
                            System.out.print(ANSI_GREEN + BanDo1[i][j] + ANSI_BLUE + "         |         ");
                            for (int k = 0; k <= kichCo; k++) {
                                if (k == 0) {
                                    if (i <= 10) {
                                        System.out.print(i - 1 + " ");
                                    } else {
                                        System.out.print((char) (i + 54) + " ");
                                    }
                                } else {
                                    if (k == kichCo) {
                                        if (BanDo2[i][k] == 'T')
                                            System.out.print(ANSI_YELLOW + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else if (BanDo2[i][k] == '.')
                                            System.out.print(ANSI_BLUE + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else if (BanDo2[i][k] == 'X')
                                            System.out.print(ANSI_RED + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else {
                                            System.out.print(ANSI_GREEN + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        }
                                    } else {
                                        if (BanDo2[i][k] == 'T')
                                            System.out.print(ANSI_YELLOW + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else if (BanDo2[i][k] == '.')
                                            System.out.print(ANSI_BLUE + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else if (BanDo2[i][k] == 'X')
                                            System.out.print(ANSI_RED + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else {
                                            System.out.print(ANSI_GREEN + BanDo2[i][k] + ANSI_BLUE + " ");
                                        }
                                    }
                                }
                            }
                        } else System.out.print(ANSI_GREEN + BanDo1[i][j] + " " + ANSI_BLUE);
                    } else {
                        if (j == kichCo) {
                            System.out.print(ANSI_BLUE + BanDo1[i][j] + ANSI_BLUE + "         |         ");
                            for (int k = 0; k <= kichCo; k++) {
                                if (k == 0) {
                                    if (i <= 10) {
                                        System.out.print(i - 1 + " ");
                                    } else {
                                        System.out.print((char) (i + 54) + " ");
                                    }
                                } else {
                                    if (k == kichCo) {
                                        if (BanDo2[i][k] == 'T')
                                            System.out.print(ANSI_YELLOW + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else if (BanDo2[i][k] == '.')
                                            System.out.print(ANSI_BLUE + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else if (BanDo2[i][k] == 'X')
                                            System.out.print(ANSI_RED + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        else {
                                            System.out.print(ANSI_GREEN + BanDo2[i][k] + ANSI_BLUE + "         |");
                                        }
                                    } else {
                                        if (BanDo2[i][k] == 'T')
                                            System.out.print(ANSI_YELLOW + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else if (BanDo2[i][k] == '.')
                                            System.out.print(ANSI_BLUE + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else if (BanDo2[i][k] == 'X')
                                            System.out.print(ANSI_RED + BanDo2[i][k] + ANSI_BLUE + " ");
                                        else {
                                            System.out.print(ANSI_GREEN + BanDo2[i][k] + ANSI_BLUE + " ");
                                        }
                                    }
                                }
                            }
                        } else System.out.print(ANSI_BLUE + BanDo1[i][j] + " " + ANSI_BLUE);
                    }
                }
            }
            System.out.print("\n");
        }
        switch (kichCo){
            case 5:
                System.out.println("-------------------------------------------------------------");
                break;
            case 6:
                System.out.println("-----------------------------------------------------------------");
                break;
            case 7:
                System.out.println("---------------------------------------------------------------------");
                break;
            case 8:
                System.out.println("-------------------------------------------------------------------------");
                break;
            case 9:
                System.out.println("-----------------------------------------------------------------------------");
                break;
            case 10:
                System.out.println("---------------------------------------------------------------------------------");
                break;
            case 11:
                System.out.println("-------------------------------------------------------------------------------------");
                break;
            case 12:
                System.out.println("-----------------------------------------------------------------------------------------");
                break;
            case 13:
                System.out.println("---------------------------------------------------------------------------------------------");
                break;
            case 14:
                System.out.println("-------------------------------------------------------------------------------------------------");
                break;
            case 15:
                System.out.println("-----------------------------------------------------------------------------------------------------");
                break;
            case 16:
                System.out.println("---------------------------------------------------------------------------------------------------------");
                break;
            case 17:
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                break;
            case 18:
                System.out.println("-----------------------------------------------------------------------------------------------------------------");
                break;
            case 19:
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                break;
            case 20:
                System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                break;
            default:
                break;
        }
        System.out.print(ANSI_CYAN);
    }
    public void mayTinhDe(NguoiChoi nguoiChoi, NguoiChoi mayTinh) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int kichCo = nguoiChoi.kichCoBanDo;
        int x,y;
        while(true){
            Random generator = new Random();
            x = generator.nextInt(kichCo) + 1;
            y = generator.nextInt(kichCo) + 1;
            if(mayTinh.BanDoDoiThu[x][y] == '.'){
                ToaDo toaDo = new ToaDo(x,y);
                mayTinh.capNhapBanDoCuaDoiThu(nguoiChoi.BanDo,toaDo,"may");
                break;
            }
        }
    }
    public void BFS(NguoiChoi nguoiChoi, NguoiChoi mayTinh,ToaDo toaDo){
        int kichCo = nguoiChoi.kichCoBanDo;
        Queue<ToaDo> q = new LinkedList<>();
        q.add(toaDo);
        visited[toaDo.getX()][toaDo.getY()] = true;
        while(q.peek() != null){
            ToaDo it = q.remove();
            for(int k=0;k<4;k++){
                int i1 = it.getX() + dx4[k];
                int j1 = it.getY() + dy4[k];
                if(i1>=1 && i1<=kichCo && j1>=1 && j1<=kichCo && nguoiChoi.BanDo[i1][j1] == 'T' && !visited[i1][j1]){
                    visited[i1][j1] = true;
                    q.add(new ToaDo(i1,j1));
                }
            }
        }

    }
    public void BFS2(NguoiChoi nguoiChoi, NguoiChoi mayTinh,ToaDo toaDo){
        int kichCo = nguoiChoi.kichCoBanDo;
        Queue<ToaDo> q = new LinkedList<>();
        q.add(toaDo);
        visited2[toaDo.getX()][toaDo.getY()] = true;
        while(q.peek() != null){
            ToaDo it = q.remove();
            for(int k=0;k<4;k++){
                int i1 = it.getX() + dx4[k];
                int j1 = it.getY() + dy4[k];
                if(i1>=1 && i1<=kichCo  && j1>=1 && j1<=kichCo  && nguoiChoi.BanDo[i1][j1] == 'T' && !visited2[i1][j1]){
                    visited2[i1][j1] = true;
                    q.add(new ToaDo(i1,j1));
                }
            }
        }

    }
    public void mayTinhKho(NguoiChoi nguoiChoi, NguoiChoi mayTinh,int type) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int kichCo = nguoiChoi.kichCoBanDo;
        // Duyệt qua bản đồ xem có điểm nào mà visited = true và chưa được bắn hay không
        for(int i=1;i<=kichCo;i++){
            for(int j=1;j<=kichCo;j++){
                if(type == 1){
                    if(visited[i][j] && mayTinh.BanDoDoiThu[i][j] == '.'){
                        ToaDo toaDo = new ToaDo(i,j);
                        mayTinh.capNhapBanDoCuaDoiThu(nguoiChoi.BanDo,toaDo,"may");
                        return;
                    }
                }else{
                    if(visited2[i][j] && mayTinh.BanDoDoiThu[i][j] == '.'){
                        ToaDo toaDo = new ToaDo(i,j);
                        mayTinh.capNhapBanDoCuaDoiThu(nguoiChoi.BanDo,toaDo,"may");
                        return;
                    }
                }
            }
        }
        // Chọn 1 điểm ngẫu nhiên trên bản đồ. Nếu điểm ý không có thuyền thì thôi, còn nếu điểm ý có thuyền thì gọi BFS
        // Nếu điểm ý bắn rồi thì gọi lại
        int x,y;
        while(true){
            Random generator = new Random();
            x = generator.nextInt(kichCo) + 1;
            y = generator.nextInt(kichCo) + 1;
            if(mayTinh.BanDoDoiThu[x][y] == '.'){
                if(nguoiChoi.BanDo[x][y] == '.'){
                    ToaDo toaDo = new ToaDo(x,y);
                    mayTinh.capNhapBanDoCuaDoiThu(nguoiChoi.BanDo,toaDo,"may");
                    return;
                }else{
                    // Trường hợp có thuyền
                    ToaDo toaDo = new ToaDo(x,y);
                    mayTinh.capNhapBanDoCuaDoiThu(nguoiChoi.BanDo,toaDo,"may");
                    if(type == 1) BFS(nguoiChoi,mayTinh,toaDo);
                    else{
                        BFS2(nguoiChoi,mayTinh,toaDo);
                    }
                    return;
                }
            }
        }
    }
    public void mayTinhBatKhaThi(NguoiChoi nguoiChoi, NguoiChoi mayTinh) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int kichCo = nguoiChoi.kichCoBanDo;
        for(int i=1;i<=kichCo ;i++){
            for(int j=1;j<=kichCo ;j++){
                if(nguoiChoi.BanDo[i][j] == 'T' && mayTinh.BanDoDoiThu[i][j] == '.'){
                    ToaDo toaDo = new ToaDo(i,j);
                    mayTinh.capNhapBanDoCuaDoiThu(nguoiChoi.BanDo,toaDo,"may");
                    return;
                }
            }
        }
    }
    public void nguoivsMayTinh(NguoiChoi nguoiChoi, NguoiChoi mayTinh, int luaChonNguoiChoi, String typemayTinh) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Sound sound = new Sound();
        while(true){
            MenuLuaChon();
            luaChonNguoiChoi = sc.nextInt();
            sound.Button();
            if(luaChonNguoiChoi == 1){
                System.out.println("Bắt đầu đặt thuyền thủ công !!!");
                while(true){
                    MenuNguoiChoi();
                    luaChonNguoiChoi = sc.nextInt();
                    sc.nextLine();
                    sound.Button();
                    if(luaChonNguoiChoi == 1){
                        nguoiChoi.banDoHienTai();
                    }else if(luaChonNguoiChoi == 2){
                        nguoiChoi.chonThuyen();
                    }else{
                        System.out.println("Lựa chọn của bạn ko có ở trên !");
                        System.out.println("Chương trình sẽ quay lại Menu");
                        continue;
                    }
                    if(nguoiChoi.kiemTraDanhSachRong()){
                        System.out.println("Bạn đã nhập xong hết thuyền !!!!");
                        break;
                    }
                }
            }else if(luaChonNguoiChoi == 2){
                nguoiChoi.tuDongChonThuyen();
                System.out.println("Đã chọn thuyền xong cho người chơi !!!!");
            }else{
                System.out.println("Bạn nhập sai rồi. Chương trình sẽ quay trở về Menu.");
                continue;
            }
            break;
        }
        // Bản đồ của máy tính sẽ được điền tự động
        mayTinh.tuDongChonThuyen();
        System.out.println("Bắt đầu đếm ngược đồng hồ !!!!");
        sound.CountDown();
        for(int i=10;i>=1;i--){
            slowPrint(430,i + "\n");
        }
        slowPrint(1500,"-");
        sound.Fight();
        System.out.println(" CUỘC CHIẾN BẮT ĐẦU !!!!!");
        // Xứ lý Chiến Tranh
        while(true){
            // Lượt của người chơi
            while(true){
                MenuChien();
                luaChonNguoiChoi = sc.nextInt();
                sound.Button();
                if(luaChonNguoiChoi == 1){
                    nguoiChoi.banDoHienTai();
                }else if(luaChonNguoiChoi == 2){
                    nguoiChoi.banDoCuaDoiThu();
                }else if(luaChonNguoiChoi == 3){
                    System.out.println("Nhập tọa độ bạn muốn khai hỏa: ");
                    int x,y;
                    while(true){
                        x = sc.nextInt();
                        y = sc.nextInt();
                        sound.Button();
                        x++;y++;
                        sound.Bomb();
                        slowPrint(2500,"-");
                        if(!nguoiChoi.kiemTraDan(x,y)){
                            System.out.println("Đạn bay ra ngoài bản đồ hoặc bạn đã bắn vị trí đó rồi. Vui lòng nhập lại tọa độ: ");
                            continue;
                        }
                        break;
                    }
                    ToaDo toaDo = new ToaDo(x,y);
                    nguoiChoi.capNhapBanDoCuaDoiThu(mayTinh.BanDo,toaDo,"nguoi");
                    break;
                }else{
                    System.out.println("Lựa chọn của bạn ko có ở trên !");
                    System.out.println("Chương trình sẽ quay lại Menu");
                }
            }
            if(nguoiChoi.dieuKienThang()){
                slowPrint(2500,"-");
                sound.Wining();
                if(typemayTinh.equals("de")){
                    System.out.println("Chúc mừng người chơi đã dành chiến thắng trước máy tính Martin !!!");
                }else if(typemayTinh.equals("kho")){
                    System.out.println("Chúc mừng người chơi đã dành chiến thắng trước máy tính AlphaZero !!!");
                }else{
                    System.out.println("Chúc mừng người chơi đã dành chiến thắng trước máy tính Stockfish !!!");
                }
                Main.BXH.add(nguoiChoi);
                return;
            }
            nguoiChoi.soLuotChoi++;
            // Lượt của máy tính
            System.out.println("Máy tính đang thực hiện nước đi");
            slowPrint(350, "..................");
            sound.Bomb();
            if(typemayTinh.equals("de")){
                mayTinhDe(nguoiChoi,mayTinh);
            }else if(typemayTinh.equals("kho")){
                mayTinhKho(nguoiChoi,mayTinh,1);
            }else{
                mayTinhBatKhaThi(nguoiChoi,mayTinh);
            }
            System.out.println();
            if(mayTinh.dieuKienThang()){
                slowPrint(2500,"-");
                sound.Losing();
                if(typemayTinh.equals("de")){
                    System.out.println("Bạn đã thua cuộc. Máy tính Martin đã chiến thắng !");
                }else if(typemayTinh.equals("kho")){
                    System.out.println("Bạn đã thua cuộc. Máy tính AlphaZero đã chiến thắng !");
                }else{
                    System.out.println("Bạn đã thua cuộc. Máy tính Stockfish đã chiến thắng !");
                }
                Main.BXH.add(mayTinh);
                return;
            }
            System.out.println("Máy tính đã đi xong ! Đến lượt của bạn.");
            mayTinh.soLuotChoi++;
        }
    }
    public void hoatDong() throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        Sound sound = new Sound();
        NguoiChoi nguoiChoi = new NguoiChoi();
        NguoiChoi mayTinh = new NguoiChoi();
        while(true){
            System.out.print("Hãy nhập kích cỡ bản đồ bạn muốn chơi (kích cỡ từ 5x5 -> 20x20): ");
            int kichCo = sc.nextInt();
            sc.nextLine();
            sound.Button();
            if(kichCo >= 5 && kichCo <=20){
                nguoiChoi.kichCoBanDo = kichCo;
                mayTinh.kichCoBanDo = kichCo;
                break;
            }else{
                System.out.print("Bạn nhập sai kích cỡ rồi, vui lòng nhập lại. ");
            }
        }
        System.out.print("Nhập tên người chơi: ");
        nguoiChoi.tenNguoiChoi = sc.nextLine();
        sound.Button();
        int luaChonNguoiChoi = 0;
        while(true){
            hienThi();
            choice = sc.nextInt();
            sound.Button();
            if(choice == 1){
                mayTinh.tenNguoiChoi = "Martin";
                sound.Martin();
                slowPrint(400,"MÁY TÍNH MARTIN ĐANG KHỞI ĐỘNG");
                System.out.println();
                System.out.println("----------------------------------------THÔNG---TIN---MÁY---TÍNH------------------------------------------");
                System.out.println("|- Martin được ra đời vào năm 1990, là 1 trong những máy tính đầu tiên được áp dụng AI.                  |");
                System.out.println("|- Thuật toán của Martin rất đơn giản, nó sẽ chỉ chọn ngẫu nhiên 1 trong 100 ô trên bản đồ để khai hỏa.  |");
                System.out.println("|- Bất cứ ai chơi lần đầu tiên cũng có thể thắng được Martin.                                            |");
                System.out.println("|- Nếu bạn thua thì bạn lên xem lại chỉ số IQ của mình.                                                  |");
                System.out.println("----------------------------------------------------------------------------------------------------------");
                System.out.println();
                // Xử lý người chơi và máy tính
                nguoivsMayTinh(nguoiChoi,mayTinh,luaChonNguoiChoi,"de");
                return;
            }else if(choice == 2){
                mayTinh.tenNguoiChoi = "AlphaZero";
                sound.AlphaZero();
                slowPrint(270,"MÁY TÍNH ALPHAZERO ĐANG KHỞI ĐỘNG");
                System.out.println();
                System.out.println("----------------------------------------THÔNG---TIN---MÁY---TÍNH----------------------------------------------------");
                System.out.println("|- AlphaZero được ra đời vào năm 2010, đánh dấu bước phát triển nhảy vọt của lĩnh vực AI.                          |");
                System.out.println("|- Thuật toán của AlphaZero dựa trên thuật toán BFS, một trong những thuật toán kinh điển trong lý thuyết đồ thị.  |");
                System.out.println("|- Nó chỉ cần bắn trúng 1 ô là có thể loang rộng ra các ô khác, từ đó biết được thông tin các ô ý.                 |");
                System.out.println("|- Để thắng được AlphaZero thì ít nhất IQ của bạn phải trên 130.                                                   |");
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                nguoivsMayTinh(nguoiChoi,mayTinh,luaChonNguoiChoi,"kho");
                return;
            }else if(choice == 3){
                mayTinh.tenNguoiChoi = "Stockfish";
                sound.StockFish();
                slowPrint(400,"MÁY TÍNH STOCKFISH ĐANG KHỞI ĐỘNG");
                System.out.println();
                System.out.println("----------------------------------------THÔNG---TIN---MÁY---TÍNH----------------------------------------------------");
                System.out.println("|- Stockfish được ra đời vào năm 2020, cột mốc lịch sử khi lần đầu tiên AI đánh bại con người.                     |");
                System.out.println("|- Thuật toán của Stockfish là xem được bản đồ của bạn, điều đó khiến cho nó trở nên bất bại.                      |");
                System.out.println("|- Stockfish chỉ cần 16 lượt đi là dành chiến thắng.                                                               |");
                System.out.println("|- Nếu bạn đi trước thì bạn phải bắn trúng thuyền trong tất cả các lượt đi của mình thì mới thắng Stockfish.       |");
                System.out.println("|- Nếu bạn đi sau thì coi như bạn chơi cho vui cũng được.                                                          |");
                System.out.println("|- Fact: Xác suất để bạn chiến thắng Stockfish là 2,24.10^(-143) % ~~ 0 % nên nếu bạn thắng thì bạn gian lận.      |");
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                nguoivsMayTinh(nguoiChoi,mayTinh,luaChonNguoiChoi,"bat kha thi");
                return;
            }else{
                System.out.println("Bạn nhập sai rồi. Chương trình sẽ quay trờ về Menu.");
            }
        }
    }
    public void haiMayTinh() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Sound sound = new Sound();
        NguoiChoi mayTinh1 = new NguoiChoi();
        NguoiChoi mayTinh2 = new NguoiChoi();
        while(true){
            System.out.print("Hãy nhập kích cỡ bản đồ hai máy tính chơi (kích cỡ từ 5x5 -> 20x20): ");
            int kichCo = sc.nextInt();
            sound.Button();
            if(kichCo >= 5 && kichCo <=20){
                mayTinh1.kichCoBanDo = kichCo;
                mayTinh2.kichCoBanDo = kichCo;
                break;
            }else{
                System.out.print("Bạn nhập sai kích cỡ rồi, vui lòng nhập lại. ");
            }
        }
        int choice_mayTinh1, choice_mayTinh2;
        while(true){
            MenuMT1();
            choice_mayTinh1 = sc.nextInt();
            sound.Button();
            if(choice_mayTinh1 != 1 && choice_mayTinh1 !=2 && choice_mayTinh1 !=3){
                System.out.println("Bạn nhập sai rồi. Chương trình sẽ trở lại Menu");
                continue;
            }
            break;
        }
        if(choice_mayTinh1 == 1){
            sound.Martin();
            slowPrint(380,"MÁY TÍNH MARTIN 1 ĐANG KHỞI ĐỘNG");
            System.out.println();
            System.out.println("----------------------------------------THÔNG---TIN---MÁY---TÍNH------------------------------------------");
            System.out.println("|- Martin được ra đời vào năm 1990, là 1 trong những máy tính đầu tiên được áp dụng AI.                  |");
            System.out.println("|- Thuật toán của Martin rất đơn giản, nó sẽ chỉ chọn ngẫu nhiên 1 trong 100 ô trên bản đồ để khai hỏa.  |");
            System.out.println("|- Bất cứ ai chơi lần đầu tiên cũng có thể thắng được Martin.                                            |");
            System.out.println("|- Nếu bạn thua thì bạn lên xem lại chỉ số IQ của mình.                                                  |");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println();
        }else if(choice_mayTinh1 == 2){
            sound.AlphaZero();
            slowPrint(250,"MÁY TÍNH ALPHAZERO 1 ĐANG KHỞI ĐỘNG");
            System.out.println();
            System.out.println("----------------------------------------THÔNG---TIN---MÁY---TÍNH----------------------------------------------------");
            System.out.println("|- AlphaZero được ra đời vào năm 2010, đánh dấu bước phát triển nhảy vọt của lĩnh vực AI.                          |");
            System.out.println("|- Thuật toán của AlphaZero dựa trên thuật toán BFS, một trong những thuật toán kinh điển trong lý thuyết đồ thị.  |");
            System.out.println("|- Nó chỉ cần bắn trúng 1 ô là có thể loang rộng ra các ô khác, từ đó biết được thông tin các ô ý.                 |");
            System.out.println("|- Để thắng được AlphaZero thì ít nhất IQ của bạn phải trên 130.                                                   |");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.println();
        }else{
            sound.StockFish();
            slowPrint(430,"MÁY TÍNH STOCKFISH 1 ĐANG KHỞI ĐỘNG");
            System.out.println();
            System.out.println("----------------------------------------THÔNG---TIN---MÁY---TÍNH----------------------------------------------------");
            System.out.println("|- Stockfish được ra đời vào năm 2020, cột mốc lịch sử khi lần đầu tiên AI đánh bại con người.                     |");
            System.out.println("|- Thuật toán của Stockfish là xem được bản đồ của bạn, điều đó khiến cho nó trở nên bất bại.                      |");
            System.out.println("|- Stockfish chỉ cần 16 lượt đi là dành chiến thắng.                                                               |");
            System.out.println("|- Nếu bạn đi trước thì bạn phải bắn trúng thuyền trong tất cả các lượt đi của mình thì mới thắng Stockfish.       |");
            System.out.println("|- Nếu bạn đi sau thì coi như bạn chơi cho vui cũng được.                                                          |");
            System.out.println("|- Fact: Xác suất để bạn chiến thắng Stockfish là 2,24.10^(-143) % ~~ 0 % nên nếu bạn thắng thì bạn gian lận.      |");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.println();
        }
        while(true){
            MenuMT2();
            choice_mayTinh2 = sc.nextInt();
            sound.Button();
            if(choice_mayTinh2 != 1 && choice_mayTinh2 !=2 && choice_mayTinh2 !=3){
                System.out.println("Bạn nhập sai rồi. Chương trình sẽ trở lại Menu");
                continue;
            }
            break;
        }
        if(choice_mayTinh2 == 1){
            sound.Martin();
            slowPrint(380,"MÁY TÍNH MARTIN 2 ĐANG KHỞI ĐỘNG");
            System.out.println();
            System.out.println("----------------------------------------THÔNG---TIN---MÁY---TÍNH------------------------------------------");
            System.out.println("|- Martin được ra đời vào năm 1990, là 1 trong những máy tính đầu tiên được áp dụng AI.                  |");
            System.out.println("|- Thuật toán của Martin rất đơn giản, nó sẽ chỉ chọn ngẫu nhiên 1 trong 100 ô trên bản đồ để khai hỏa.  |");
            System.out.println("|- Bất cứ ai chơi lần đầu tiên cũng có thể thắng được Martin.                                            |");
            System.out.println("|- Nếu bạn thua thì bạn lên xem lại chỉ số IQ của mình.                                                  |");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println();
        }else if(choice_mayTinh2 == 2){
            sound.AlphaZero();
            slowPrint(250,"MÁY TÍNH ALPHAZERO 2 ĐANG KHỞI ĐỘNG");
            System.out.println();
            System.out.println("----------------------------------------THÔNG---TIN---MÁY---TÍNH----------------------------------------------------");
            System.out.println("|- AlphaZero được ra đời vào năm 2010, đánh dấu bước phát triển nhảy vọt của lĩnh vực AI.                          |");
            System.out.println("|- Thuật toán của AlphaZero dựa trên thuật toán BFS, một trong những thuật toán kinh điển trong lý thuyết đồ thị.  |");
            System.out.println("|- Nó chỉ cần bắn trúng 1 ô là có thể loang rộng ra các ô khác, từ đó biết được thông tin các ô ý.                 |");
            System.out.println("|- Để thắng được AlphaZero thì ít nhất IQ của bạn phải trên 130.                                                   |");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.println();
        }else{
            sound.StockFish();
            slowPrint(430,"MÁY TÍNH STOCKFISH 2 ĐANG KHỞI ĐỘNG");
            System.out.println();
            System.out.println("----------------------------------------THÔNG---TIN---MÁY---TÍNH----------------------------------------------------");
            System.out.println("|- Stockfish được ra đời vào năm 2020, cột mốc lịch sử khi lần đầu tiên AI đánh bại con người.                     |");
            System.out.println("|- Thuật toán của Stockfish là xem được bản đồ của bạn, điều đó khiến cho nó trở nên bất bại.                      |");
            System.out.println("|- Stockfish chỉ cần 16 lượt đi là dành chiến thắng.                                                               |");
            System.out.println("|- Nếu bạn đi trước thì bạn phải bắn trúng thuyền trong tất cả các lượt đi của mình thì mới thắng Stockfish.       |");
            System.out.println("|- Nếu bạn đi sau thì coi như bạn chơi cho vui cũng được.                                                          |");
            System.out.println("|- Fact: Xác suất để bạn chiến thắng Stockfish là 2,24.10^(-143) % ~~ 0 % nên nếu bạn thắng thì bạn gian lận.      |");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.println();
        }
        System.out.println("Bắt đầu đếm ngược đồng hồ !!!!");
        sound.CountDown();
        for(int i=10;i>=1;i--){
            slowPrint(430,i + "\n");
        }
        slowPrint(1500,"-");
        sound.Fight();
        System.out.println(" CUỘC CHIẾN BẮT ĐẦU !!!!!");
        // Xứ lý chiến tranh
        mayTinh1.tuDongChonThuyen();
        mayTinh2.tuDongChonThuyen();
        banDo2MT(mayTinh1,mayTinh2);
        // 9 trường hợp có thể (1,1); (1,2);(1,3) (2,1) (2,2) (2,3) (3,1) (3,2) (3,3)
        while(true){
            System.out.println("Máy tính 1 đang thực hiện nước đi");
            slowPrint(350, "..................");
            sound.Bomb();
            if(choice_mayTinh1 == 1){
                mayTinhDe(mayTinh2,mayTinh1);
                mayTinh1.tenNguoiChoi = "Martin";
            }
            else if(choice_mayTinh1 == 2){
                mayTinhKho(mayTinh2,mayTinh1,1);
                mayTinh1.tenNguoiChoi = "AlphaZero";
            }
            else{
                mayTinhBatKhaThi(mayTinh2,mayTinh1);
                mayTinh1.tenNguoiChoi = "Stockfish";
            }
            System.out.println();
            System.out.println("Máy tính 1 đã đi xong !");
            mayTinh1.soLuotChoi++;
            banDo2MT(mayTinh1,mayTinh2);
            if(mayTinh1.dieuKienThang()){
                slowPrint(2500,"-");
                sound.Wining();
                System.out.println("Máy tính 1 đã dành chiến thắng !!!!");
                Main.BXH.add(mayTinh1);
                return;
            }
            System.out.println("Máy tính 2 đang thực hiện nước đi");
            slowPrint(350, "..................");
            sound.Bomb();
            if(choice_mayTinh2 == 1){
                mayTinhDe(mayTinh1,mayTinh2);
                mayTinh2.tenNguoiChoi = "Martin";
            }
            else if(choice_mayTinh2 == 2){
                mayTinhKho(mayTinh1,mayTinh2,2);
                mayTinh2.tenNguoiChoi = "AlphaZero";
            }
            else{
                mayTinhBatKhaThi(mayTinh1,mayTinh2);
                mayTinh2.tenNguoiChoi = "Stockfish";
            }
            System.out.println();
            System.out.println("Máy tính 2 đã đi xong !");
            mayTinh2.soLuotChoi++;
            banDo2MT(mayTinh1,mayTinh2);
            if(mayTinh2.dieuKienThang()){
                slowPrint(2500,"-");
                sound.Wining();
                System.out.println("Máy tính 2 đã dành chiến thắng !!!!");
                Main.BXH.add(mayTinh2);
                return;
            }
        }
    }
    public static void slowPrint(int time, String toPrint){

        char[] toPrintC = toPrint.toCharArray();// Create a char array and assign that to a string converted to a char array
        for(int i = 0; i < toPrintC.length;i++){ // Create a for loop
            System.out.print(toPrintC[i]);// Print the char
            try{
                Thread.sleep(time);// Stop printing for the amount of milliseconds specified(in the variable time)
            }catch(Exception e){
                e.printStackTrace();
            }
            // We surround in try/catch because Thread.sleep throws an exception
        }
    }
}
