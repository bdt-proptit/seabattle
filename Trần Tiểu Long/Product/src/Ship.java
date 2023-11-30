/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sea_battle;

/**
 *
 * @author Admin
 */
import java.util.Scanner;
public class Ship {
    private String name_ship;
    private int x_begin;
    private int x_end;
    private int y_begin;
    private int y_end;
    private String check;

    public String getName_ship() {
        return name_ship;
    }

    public void setName_ship(String name_ship) {
        this.name_ship = name_ship;
    }

    public int getX_begin() {
        return x_begin;
    }

    public void setX_begin(int x_begin) {
        this.x_begin = x_begin;
    }

    public int getX_end() {
        return x_end;
    }

    public void setX_end(int x_end) {
        this.x_end = x_end;
    }

    public int getY_begin() {
        return y_begin;
    }

    public void setY_begin(int y_begin) {
        this.y_begin = y_begin;
    }

    public int getY_end() {
        return y_end;
    }

    public void setY_end(int y_end) {
        this.y_end = y_end;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
    //thiet lap tau tren ban do
    void set_up_ship(char[][] matrix) {
        for (int i = x_begin; i <= x_end; i ++) {
            for (int j = y_begin; j <=  y_end; j ++) {
                matrix[i][j] = '#';
            }
        }
    }
    //kiem tra xem tau co bi dat chong nhau ko
    int check_Ship_position(char[][] matrix, int len, int length) {
        if (x_begin <= 0 || x_end <= 0 || x_begin > len || x_end > len || y_begin <= 0 || y_end <= 0 || y_begin > len || y_end > len || (x_end - x_begin + 1) > length || ((x_end - x_begin + 1) < length && (x_end - x_begin + 1) > 1) || (y_end - y_begin + 1) > length || ((y_end - y_begin + 1) < length && (y_end - y_begin + 1) > 1)) return 0;
        for (int i = x_begin; i <= x_end; i++) {
            for (int j = y_begin; j <= y_end; j++) {
                if (matrix[i][j] == '#') return 0;
            }
        }
        return 1;
    }
    //kiem tra tau con song khong
    int Check_ship(char[][] matrix) {
        for (int i = x_begin; i <= x_end; i ++) {
            for (int j = y_begin; j <=  y_end; j ++) {
                if (matrix[i][j] == '#') return 0;
            }
        }
        return  1;
    }
   
    
}
