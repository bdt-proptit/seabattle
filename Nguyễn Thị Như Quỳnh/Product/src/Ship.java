package Thuyen;

public class Ship {
    private String nameShip;
    private int lengthShip;
    private String coorDinate1, coorDinate2;
    private Boolean shot;
    private int shotPoint;

    public Ship(String nameShip, int lengthShip, String coorDinate1, String coorDinate2, Boolean shot, int shotPoint) {
        this.nameShip = nameShip;
        this.lengthShip = lengthShip;
        this.coorDinate1 = coorDinate1;
        this.coorDinate2 = coorDinate2;
        this.shot = shot;
        this.shotPoint = shotPoint;
    }

    public String getNameShip() {
        return nameShip;
    }

    public int getLengthShip() {
        return lengthShip;
    }

    public Boolean getShot() {
        return shot;
    }

    public void setShot(Boolean shot) {
        this.shot = shot;
    }
    public Boolean testShank(){
        return this.shotPoint == this.lengthShip;
    }
    public void testShot(String coorDinate, Player player, Player enermy){
        char[] toaDo1 = coorDinate1.toCharArray();
        char[] toaDo2 = coorDinate2.toCharArray();
        if (toaDo1[0] == toaDo2[0]) {
            int a = Boards.row(coorDinate1);
            int b = Boards.col(coorDinate1);
            int c = Boards.col(coorDinate2);
            if (c < b) {
                int temp = b;
                b = c;
                c = temp;
            }
            int t1 = Boards.row(coorDinate);
            int t2 = Boards.col(coorDinate);
            for (int i = b; i <= c; i++) {
                if(a==t1&&i==t2 && enermy.getBoard()[t1][t2]=='S' && player.getFog()[t1][t2]=='~'){
                    player.setFog(t1, t2, 'X');
                    enermy.setBoard(t1, t2, 'X');
                    this.shotPoint++;
                }
            }
        } else if (toaDo1[1] == toaDo2[1] && toaDo1.length == toaDo2.length) {
            int a = Boards.col(coorDinate1);
            int b = Boards.row(coorDinate1);
            int c = Boards.row(coorDinate2);
            if (c < b) {
                int temp = b;
                b = c;
                c = temp;
            }
            int t1 = Boards.row(coorDinate);
            int t2 = Boards.col(coorDinate);
            for (int i = b; i <= c; i++) {
                if(t2==a && t1==i && enermy.getBoard()[t1][t2]=='S') {
                    player.setFog(t1, t2, 'X');
                    player.setBoard(t1, t2, 'X');
                    this.shotPoint++;
                }
            }
        }
    }
}