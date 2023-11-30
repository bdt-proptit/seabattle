import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.*;
import java.io.*;
import java.util.Random;
public class NguoiChoi {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    Scanner sc = new Scanner(System.in);
    int kichCoBanDo;
    private ArrayList<Thuyen> thuyen = new ArrayList<>();
    Character BanDo[][] = new Character[50][50];
    Character BanDoDoiThu[][] = new Character[50][50];
    int soLuotChoi = 0;
    String tenNguoiChoi;
    public NguoiChoi(){
        for(int i=1;i<=40;i++){
            for(int j=1;j<=40;j++){
                BanDo[i][j] = '.';
                BanDoDoiThu[i][j] = '.';
            }
        }
        thuyen.add(new Thuyen("Thuyền Tuần Tra", "1x2", 2));
        thuyen.add(new Thuyen("Tàu Khu Trục", "1x4", 1));
        thuyen.add(new Thuyen("Tàu Ngầm", "1x3", 1));
        thuyen.add(new Thuyen("Thiết Giáp Hạm", "1x5",1));
    }
    public void Menu1(){
        System.out.println("------------Người Chơi 1----------------");
        System.out.println("|1. Xem bản đồ hiện tại của mình.      |");
        System.out.println("|2. Thêm thuyền.                       |");
        System.out.println("----------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void Menu2(){
        System.out.println("------------Người Chơi 2----------------");
        System.out.println("|1. Xem bản đồ hiện tại của mình.      |");
        System.out.println("|2. Thêm thuyền.                       |");
        System.out.println("----------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void MenuCT1(){
        System.out.println("------------Người Chơi 1----------------");
        System.out.println("|1. Xem bản đồ hiện tại của mình.      |");
        System.out.println("|2. Xem bản đồ của đối thủ.            |");
        System.out.println("|3. Khai Hỏa.                          |");
        System.out.println("----------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void MenuCT2(){
        System.out.println("------------Người Chơi 2----------------");
        System.out.println("|1. Xem bản đồ hiện tại của mình.      |");
        System.out.println("|2. Xem bản đồ của đối thủ.            |");
        System.out.println("|3. Khai Hỏa.                          |");
        System.out.println("----------------------------------------");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void danhSachHienTai(){
        System.out.println("Đây là danh sách thuyền hiện tại: ");
        System.out.println("------------------------------------------------------------------");
        for(Thuyen it:thuyen){
            System.out.println("Tên thuyền: " + it.getTen() + ", Kích Thước: " + it.getKichThuoc() + ", Số Lượng: " + it.getSoLuong() +".");
        }
        System.out.println("------------------------------------------------------------------");
    }
    public void banDoHienTai(){
        for(int i=0;i<=kichCoBanDo;i++){
            for(int j=0;j<=kichCoBanDo;j++){
                if(i == 0 && j == 0){
                    System.out.print(ANSI_BLUE + "  ");
                }else if(i==0){
                    if(j<=10){
                        System.out.print(j-1+" ");
                    }else{
                        System.out.print((char)(j+54) + " ");
                    }
                }else if(j == 0){
                    if(i<=10){
                        System.out.print(i-1 + " ");
                    }else{
                        System.out.print((char)(i+54) + " ");
                    }
                }else{
                    if(BanDo[i][j] == 'T'){
                        System.out.print(ANSI_YELLOW + BanDo[i][j] + " " + ANSI_BLUE);
                    }else if(BanDo[i][j] == 'X'){
                        System.out.print(ANSI_RED + BanDo[i][j] + " " + ANSI_BLUE);
                    }else if(BanDo[i][j] == '~'){
                        System.out.print(ANSI_GREEN + BanDo[i][j] + " " + ANSI_BLUE);
                    }else{
                        System.out.print(BanDo[i][j] + " ");
                    }
                }
            }
            System.out.print("\n");
        }
        System.out.print(ANSI_CYAN);
    }
    public void banDoCuaDoiThu(){
        for(int i=0;i<=kichCoBanDo;i++){
            for(int j=0;j<=kichCoBanDo;j++){
                if(i == 0 && j == 0){
                    System.out.print(ANSI_BLUE + "  ");
                }else if(i==0){
                    if(j<=10){
                        System.out.print(j-1+" ");
                    }else{
                        System.out.print((char)(j+54) + " ");
                    }
                }else if(j == 0){
                    if(i<=10){
                        System.out.print(i-1 + " ");
                    }else{
                        System.out.print((char)(i+54) + " ");
                    }
                }else{
                    if(BanDoDoiThu[i][j] == 'T'){
                        System.out.print(ANSI_YELLOW + BanDoDoiThu[i][j] + " " + ANSI_BLUE);
                    }else if(BanDoDoiThu[i][j] == 'X'){
                        System.out.print(ANSI_RED + BanDoDoiThu[i][j] + " " + ANSI_BLUE);
                    }else if(BanDoDoiThu[i][j] == '~'){
                        System.out.print(ANSI_GREEN + BanDoDoiThu[i][j] + " " + ANSI_BLUE);
                    }else{
                        System.out.print(BanDoDoiThu[i][j] + " ");
                    }
                }
            }
            System.out.print("\n");
        }
        System.out.print(ANSI_CYAN);
    }
    public boolean kiemTraDanhSachRong(){
        for(Thuyen it: thuyen){
            if(it.getSoLuong() >= 1){
                return false;
            }
        }
        return true;
    }
    public void capNhapBanDoSauKhiThemThuyen(ArrayList<ToaDo> toaDo){
        for(ToaDo it: toaDo){
            BanDo[it.getX()][it.getY()] = 'T';
        }
    }
    public boolean kiemTraDan(int x,int y){
        if(x < 1 || x > kichCoBanDo) return false;
        if(y<1 || y > kichCoBanDo) return false;
        if(BanDoDoiThu[x][y] == '~' || BanDoDoiThu[x][y] == 'X'){
            return false;
        }
        return true;
    }
    // '.' là chưa bắn, '~' là bắn trượt , 'X' là đã trúng -> Có thể cải thiện thêm
    public void capNhapBanDoCuaDoiThu(Character[][] DoiThu, ToaDo toaDo, String type) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Sound sound = new Sound();
        int x,y;
        x = toaDo.getX();
        y = toaDo.getY();
        if(DoiThu[x][y] == '.'){
            DoiThu[x][y] = '~';
            BanDoDoiThu[x][y] = '~';
            if(type.equals("nguoi")){
                System.out.println("Rất tiếc. Vị trí bạn bắn không có thuyền @@");
            }
            sound.Laugh();
            return;
        }
        if(DoiThu[x][y] == 'T'){
            DoiThu[x][y] = 'X';
            BanDoDoiThu[x][y] = 'X';
            if(type.equals("nguoi")) System.out.println("Xin chúc mừng. Bạn đã bắn trúng thuyền !!!");
            sound.Brutality();
            return;
        }
    }
    public boolean kiemTraToaDo(ArrayList<ToaDo> toaDo){
        Collections.sort(toaDo,new ToaDos());
        for(ToaDo it: toaDo){
            int x = it.getX();
            int y = it.getY();
            if(x<1 || x>kichCoBanDo) return false;
            if(y<1 || y>kichCoBanDo) return false;
            if(BanDo[x][y] == 'T') return false;
        }
        if(toaDo.get(0).getX() == toaDo.get(1).getX()){
            for(int i=0;i<toaDo.size()-1;i++){
                if(toaDo.get(i+1).getY() - toaDo.get(i).getY() !=1){
                    return false;
                }
            }
            return true;
        }else if(toaDo.get(0).getY() == toaDo.get(1).getY()){
            for(int i=0;i<toaDo.size()-1;i++){
                if(toaDo.get(i+1).getX() - toaDo.get(i).getX() !=1){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public void chonThuyen() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Sound sound = new Sound();
        String tenChon;
        boolean check = false;
        danhSachHienTai();
        System.out.print("Mời bạn nhập tên thuyền bạn muốn chọn: ");
        tenChon = sc.nextLine();
        sound.Button();
        for(Thuyen it:thuyen){
            if(it.getTen().equals(tenChon) && it.getSoLuong() >= 1){
                it.setSoLuong(it.getSoLuong()-1);
                check = true;
                break;
            }
        }
        if(!check){
            System.out.println("Có thể tên thuyền bạn nhập không có trong danh sách hoặc thuyền bạn nhập đã hết hàng.");
            System.out.println("Chương trình sẽ quay lại Menu.");
            return;
        }
        if(tenChon.equals("Thuyền Tuần Tra")){
            System.out.println("Vì bạn đã chọn Thuyền Tuần Tra có kích thước 1x2 nên hãy nhập 2 tọa độ: ");
            while(true){
                ArrayList<ToaDo> toaDo = new ArrayList<>();
                for(int i=1;i<=2;i++){
                    String x,y;
                    int tmpx,tmpy;
                    while(true) {
                        x = sc.next();
                        y = sc.next();
                        sound.Button();
                        if (Character.isLetter(x.charAt(0))) {
                            tmpx = x.charAt(0) - 55;
                        } else if (Character.isDigit(x.charAt(0)) && x.length() <= 1) {
                            tmpx = x.charAt(0) - 48;
                        } else {
                            System.out.println("Nhập tọa độ sai. Vui lòng nhập lại tọa độ: ");
                            continue;
                        }
                        if (Character.isLetter(y.charAt(0))) {
                            tmpy = y.charAt(0) - 55;
                        } else if (Character.isDigit(y.charAt(0)) && y.length() <= 1) {
                            tmpy = y.charAt(0) - 48;
                        } else {
                            System.out.println("Nhập tọa độ sai. Vui lòng nhập lại tọa độ: ");
                            continue;
                        }
                        break;
                    }
                    toaDo.add(new ToaDo(tmpx+1,tmpy+1));
                }
                if(!kiemTraToaDo(toaDo)){
                    System.out.println("Các tọa độ bạn vừa nhập có thể ra ngoài khỏi bản đồ, hoặc thuyền chồng lên nhau, hoặc thuyền đặt sai vị trí !");
                    System.out.println("Vui lòng nhập lại 2 tọa độ: ");
                    continue;
                }
                capNhapBanDoSauKhiThemThuyen(toaDo);
                break;
            }
        }else if(tenChon.equals("Tàu Khu Trục")) {
            System.out.println("Vì bạn đã chọn Tàu Khu Trục có kích thước 1x4 nên hãy nhập 4 tọa độ: ");
            while(true){
                ArrayList<ToaDo> toaDo = new ArrayList<>();
                for (int i = 1; i <= 4; i++) {
                    String x,y;
                    int tmpx,tmpy;
                    while(true) {
                        x = sc.next();
                        y = sc.next();
                        sound.Button();
                        if (Character.isLetter(x.charAt(0))) {
                            tmpx = x.charAt(0) - 55;
                        } else if (Character.isDigit(x.charAt(0)) && x.length() <= 1) {
                            tmpx = x.charAt(0) - 48;
                        } else {
                            System.out.println("Nhập tọa độ sai. Vui lòng nhập lại tọa độ: ");
                            continue;
                        }
                        if (Character.isLetter(y.charAt(0))) {
                            tmpy = y.charAt(0) - 55;
                        } else if (Character.isDigit(y.charAt(0)) && y.length() <= 1) {
                            tmpy = y.charAt(0) - 48;
                        } else {
                            System.out.println("Nhập tọa độ sai. Vui lòng nhập lại tọa độ: ");
                            continue;
                        }
                        break;
                    }
                    toaDo.add(new ToaDo(tmpx+1, tmpy+1));
                }
                if(!kiemTraToaDo(toaDo)){
                    System.out.println("Các tọa độ bạn vừa nhập có thể ra ngoài khỏi bản đồ, hoặc thuyền chồng lên nhau, hoặc thuyền đặt sai vị trí !");
                    System.out.println("Vui lòng nhập lại 4 tọa độ: ");
                    continue;
                }
                capNhapBanDoSauKhiThemThuyen(toaDo);
                break;
            }
        }else  if(tenChon.equals("Tàu Ngầm")) {
            System.out.println("Vì bạn đã chọn Tàu Ngầm có kích thước 1x3 nên hãy nhập 3 tọa độ: ");
            while(true){
                ArrayList<ToaDo> toaDo = new ArrayList<>();
                for (int i = 1; i <= 3; i++) {
                    String x,y;
                    int tmpx,tmpy;
                    while(true) {
                        x = sc.next();
                        y = sc.next();
                        sound.Button();
                        if (Character.isLetter(x.charAt(0))) {
                            tmpx = x.charAt(0) - 55;
                        } else if (Character.isDigit(x.charAt(0)) && x.length() <= 1) {
                            tmpx = x.charAt(0) - 48;
                        } else {
                            System.out.println("Nhập tọa độ sai. Vui lòng nhập lại tọa độ: ");
                            continue;
                        }
                        if (Character.isLetter(y.charAt(0))) {
                            tmpy = y.charAt(0) - 55;
                        } else if (Character.isDigit(y.charAt(0)) && y.length() <= 1) {
                            tmpy = y.charAt(0) - 48;
                        } else {
                            System.out.println("Nhập tọa độ sai. Vui lòng nhập lại tọa độ: ");
                            continue;
                        }
                        break;
                    }
                    toaDo.add(new ToaDo(tmpx+1, tmpy+1));
                }
                if(!kiemTraToaDo(toaDo)){
                    System.out.println("Các tọa độ bạn vừa nhập có thể ra ngoài khỏi bản đồ, hoặc thuyền chồng lên nhau, hoặc thuyền đặt sai vị trí !");
                    System.out.println("Vui lòng nhập lại 3 tọa độ: ");
                    continue;
                }
                capNhapBanDoSauKhiThemThuyen(toaDo);
                break;
            }
        }else  if(tenChon.equals("Thiết Giáp Hạm")) {
            System.out.println("Vì bạn đã chọn Thiết Giáp Hạm có kích thước 1x5 nên hãy nhập 5 tọa độ: ");
            while(true){
                ArrayList<ToaDo> toaDo = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    String x,y;
                    int tmpx,tmpy;
                    while(true) {
                        x = sc.next();
                        y = sc.next();
                        sound.Button();
                        if (Character.isLetter(x.charAt(0))) {
                            tmpx = x.charAt(0) - 55;
                        } else if (Character.isDigit(x.charAt(0)) && x.length() <= 1) {
                            tmpx = x.charAt(0) - 48;
                        } else {
                            System.out.println("Nhập tọa độ sai. Vui lòng nhập lại tọa độ: ");
                            continue;
                        }
                        if (Character.isLetter(y.charAt(0))) {
                            tmpy = y.charAt(0) - 55;
                        } else if (Character.isDigit(y.charAt(0)) && y.length() <= 1) {
                            tmpy = y.charAt(0) - 48;
                        } else {
                            System.out.println("Nhập tọa độ sai. Vui lòng nhập lại tọa độ: ");
                            continue;
                        }
                        break;
                    }
                    toaDo.add(new ToaDo(tmpx+1, tmpy+1));
                }
                if(!kiemTraToaDo(toaDo)){
                    System.out.println("Các tọa độ bạn vừa nhập có thể ra ngoài khỏi bản đồ, hoặc thuyền chồng lên nhau, hoặc thuyền đặt sai vị trí !");
                    System.out.println("Vui lòng nhập lại 5 tọa độ: ");
                    continue;
                }
                capNhapBanDoSauKhiThemThuyen(toaDo);
                break;
            }
        }
        sc.nextLine();
    }
    public boolean kiemTraThuyenTuDong(int huong, int kichThuoc,int x,int y){
        if(BanDo[x][y] == 'T'){
            return false;
        }
        if(huong == 1){
            for(int i=1;i<kichThuoc;i++){
                x--;
                if(x<=0 || BanDo[x][y] == 'T'){
                    return false;
                }
            }
            return true;
        }else if(huong == 2){
            for(int i=1;i<kichThuoc;i++){
                y++;
                if(y>=kichCoBanDo + 1 || BanDo[x][y] == 'T'){
                    return false;
                }
            }
            return true;

        }else if(huong == 3){
            for(int i=1;i<kichThuoc;i++){
                x++;
                if(x>=kichCoBanDo  + 1 || BanDo[x][y] == 'T'){
                    return false;
                }
            }
            return true;
        }
        for(int i=1;i<kichThuoc;i++){
            y--;
            if(y<=0 || BanDo[x][y] == 'T'){
                return false;
            }
        }
        return true;
    }
    public void setThuyenTuDong(int huong, int kichThuoc,int x,int y){
        BanDo[x][y] = 'T';
        if(huong == 1){
            for(int i=1;i<kichThuoc;i++){
                x--;
                BanDo[x][y] = 'T';
            }
            return;
        }else if(huong == 2){
            for(int i=1;i<kichThuoc;i++) {
                y++;
                BanDo[x][y] = 'T';
            }
            return;
        }else if(huong == 3){
            for(int i=1;i<kichThuoc;i++) {
                x++;
                BanDo[x][y] = 'T';
            }
            return;
        }
        for(int i=1;i<kichThuoc;i++){
            y--;
            BanDo[x][y] = 'T';
        }
    }
    public void tuDongChonThuyen(){
        // Ý tưởng của việc chọn tự động
        // B1: Chọn ngẫu nhiên 1 ô trong 100 ô của bản đồ, nếu ô ý có thuyền rồi thì chọn lại.
        // B2: Sẽ có 4 hướng - tượng trưng cho 4 số.
        // Lên trên: 1
        // Sang phải: 2
        // Xuống dưới: 3
        // Sang Trái: 4
        // Chọn ngẫu nhiên hướng, xong rồi coi điểm B1 chọn được là phần đuôi tàu rồi kéo dài ra.
        // Nếu kéo ra trong 1 hướng mà đụng phải thuyền khác hoặc ra khỏi bản đồ thì quay lại B1


        // Chọn 2 thuyền kích cỡ 1x2
        while(true){
            Random generator = new Random();
            int x = generator.nextInt(kichCoBanDo) + 1;
            int y = generator.nextInt(kichCoBanDo) + 1;
            int huong = generator.nextInt(4) + 1;
            if(!kiemTraThuyenTuDong(huong,2,x,y)){
                continue;
            }
            setThuyenTuDong(huong,2,x,y);
            break;
        }
        while(true){
            Random generator = new Random();
            int x = generator.nextInt(kichCoBanDo) + 1;
            int y = generator.nextInt(kichCoBanDo) + 1;
            int huong = generator.nextInt(4) + 1;
            if(!kiemTraThuyenTuDong(huong,2,x,y)){
                continue;
            }
            setThuyenTuDong(huong,2,x,y);
            break;
        }
        // Chon 1 thuyen 1x4
        while(true){
            Random generator = new Random();
            int x = generator.nextInt(kichCoBanDo) + 1;
            int y = generator.nextInt(kichCoBanDo) + 1;
            int huong = generator.nextInt(4) + 1;
            if(!kiemTraThuyenTuDong(huong,4,x,y)){
                continue;
            }
            setThuyenTuDong(huong,4,x,y);
            break;
        }
        // Chon 1 thuyen 1x3
        while(true){
            Random generator = new Random();
            int x = generator.nextInt(kichCoBanDo) + 1;
            int y = generator.nextInt(kichCoBanDo) + 1;
            int huong = generator.nextInt(4) + 1;
            if(!kiemTraThuyenTuDong(huong,3,x,y)){
                continue;
            }
            setThuyenTuDong(huong,3,x,y);
            break;
        }
        // Chon 1 thuyen 1x5
        while(true){
            Random generator = new Random();
            int x = generator.nextInt(kichCoBanDo) + 1;
            int y = generator.nextInt(kichCoBanDo) + 1;
            int huong = generator.nextInt(4) + 1;
            if(!kiemTraThuyenTuDong(huong,5,x,y)){
                continue;
            }
            setThuyenTuDong(huong,5,x,y);
            break;
        }
    }
    // Đã Test
    public boolean dieuKienThang(){
        int dem = 0;
        for(int i=1;i<=kichCoBanDo;i++){
            for(int j=1;j<=kichCoBanDo;j++){
                if(BanDoDoiThu[i][j] == 'X'){
                    dem++;
                }
            }
        }
        return dem == 16;
    }
}
class NguoiChois implements Comparator<NguoiChoi> {
    @Override
    public int compare(NguoiChoi a, NguoiChoi b) {
        if(a.kichCoBanDo == b.kichCoBanDo){
            return a.soLuotChoi - b.soLuotChoi;
        }else{
            return a.kichCoBanDo - b.kichCoBanDo;
        }
    }
}
