import java.util.Comparator;

public class ToaDo {
    private int x,y;

    public ToaDo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
class ToaDos implements Comparator<ToaDo> {
    @Override
    public int compare(ToaDo a, ToaDo b) {
        if(a.getX() == b.getX()){
            return a.getY() - b.getY();
        }else{
            return a.getX() - b.getX();
        }
    }
}
