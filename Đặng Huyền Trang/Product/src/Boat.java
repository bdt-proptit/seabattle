public class Boat extends BattleField{

    private String name;
    private int x_begin, y_begin, x_end, y_end, sizeBoat;

    public Boat(String name, int x_begin, int y_begin, int x_end, int y_end, int sizeBoat) {
        this.name = name;
        this.x_begin = x_begin;
        this.y_begin = y_begin;
        this.x_end = x_end;
        this.y_end = y_end;
        this.sizeBoat = sizeBoat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void checkBoat(int x, int y){
        int check = 0;
        for(int i = x_begin; i <= x_end; i++){
            for(int j = y_begin; i <= y_end; j++){
                if(getBoard(i, y) == 'o') check++;
            }
        }
        if(check == (x_end - x_begin + 1) * (y_end - y_begin + 1)) System.out.printf("%s đã bị bắn chìm", getName());
    }

    public int getX_begin() {
        return x_begin;
    }

    public int getY_begin() {
        return y_begin;
    }

    public int getX_end() {
        return x_end;
    }

    public int getY_end() {
        return y_end;
    }

    public int getSizeBoat() {
        return sizeBoat;
    }

    public void setSizeBoat(int sizeBoat) {
        this.sizeBoat = sizeBoat;
    }
}
