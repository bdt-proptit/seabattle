import java.util.Scanner;

public class Ship extends Player{

    private boolean isSink = false;
    private int numberOfCellleft;
    private int x_begin, y_begin, x_end, y_end;

    public int getNumberOfCellleft() {
        return numberOfCellleft;
    }

    public void setNumberOfCellleft(int numberOfCellleft) {
        this.numberOfCellleft = numberOfCellleft;
    }

    public int getX_begin() {
        return x_begin;
    }

    public void setSink(boolean sink) {
        isSink = sink;
    }

    public boolean getSink() {
        return isSink;
    }

    public void setX_begin(int x_begin) {
        this.x_begin = x_begin;
    }

    public int getY_begin() {
        return y_begin;
    }

    public void setY_begin(int y_begin) {
        this.y_begin = y_begin;
    }

    public int getX_end() {
        return x_end;
    }

    public void setX_end(int x_end) {
        this.x_end = x_end;
    }

    public int getY_end() {
        return y_end;
    }

    public void setY_end(int y_end) {
        this.y_end = y_end;
    }


    public Ship(int x_begin, int x_end, int y_begin, int y_end, int numberOfCellleft){
        this.x_begin = x_begin;
        this.x_end = x_end;
        this.y_begin = y_begin;
        this.y_end = y_end;
        this.numberOfCellleft = numberOfCellleft;
    }


}
