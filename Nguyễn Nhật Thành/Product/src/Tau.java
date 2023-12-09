public class Tau {
    private int x1, y1, x2, y2;
    private final String ten;
    private final int doDai;
    private boolean daChim = false;
    boolean daChim(){ return daChim; }
    Tau(String ten, int doDai){
        this.ten = ten; this.doDai = doDai;
    }
    public void setToaDo(int x1, int y1, int x2, int y2){
        this.x1 = Integer.min(x1, x2); this.x2 = Integer.max(x1, x2);
        this.y1 = Integer.min(y1, y2); this.y2 = Integer.max(y1, y2);
    }
    public String getTen(){ return ten; }
    public int getDoDai(){ return doDai; }
    void kiemTraChim(char[][] a){
        int cnt = 0;
        if(x1 == x2){
            for(int i=y1; i<=y2; ++i){
                if(a[x1][i] == 'X') ++cnt;
            }
        }
        else{
            for(int i=x1; i<=x2; ++i){
                if(a[i][y1] == 'X') ++cnt;
            }
        }
        if(cnt == doDai) daChim = true;
    }
    void setChim(char[][] a){
        if(x1 == x2){
            for(int i=y1; i<=y2; ++i){
                a[x1][i] = 'C';
            }
        }
        else{
            for(int i=x1; i<=x2; ++i){
                a[i][y1] = 'C';
            }
        }
    }
}