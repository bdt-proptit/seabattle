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
import sea_battle.Ship;
import sea_battle.Board;
public class Player {

    Player() {
        board = new Board();
        patrol_boat_1 = new Ship();
        patrol_boat_2 = new Ship();
        destroyer_boat = new Ship();
        submarine = new Ship();
        battle_ship = new Ship();  
        matrix = new char[30][30];
    }
    
    private  String name;
    private int point;
    private int number_of_ships_live;
    private int number_of_ships_destroy;
    private char [][] matrix;
    //chien truong cua nguoi choi
    private Board board;
    //tau cua nguoi choi
    private Ship patrol_boat_1;
    private Ship patrol_boat_2;
    private Ship destroyer_boat;
    private Ship submarine;
    private Ship battle_ship;
    //setter and getter

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
    public char[][] getMatrix() {
        return matrix;
    }
    
    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public Ship getPatrol_boat_1() {
        return patrol_boat_1;
    }

    public void setPatrol_boat_1(Ship patrol_boat_1) {
        this.patrol_boat_1 = patrol_boat_1;
    }

    public Ship getPatrol_boat_2() {
        return patrol_boat_2;
    }

    public void setPatrol_boat_2(Ship patrol_boat_2) {
        this.patrol_boat_2 = patrol_boat_2;
    }
    
    

    public Ship getDestroyer_boat() {
        return destroyer_boat;
    }

    public void setDestroyer_boat(Ship destroyer_boat) {
        this.destroyer_boat = destroyer_boat;
    }

    public Ship getSubmarine() {
        return submarine;
    }

    public void setSubmarine(Ship submarine) {
        this.submarine = submarine;
    }

    public Ship getBattle_ship() {
        return battle_ship;
    }

    public void setBattle_ship(Ship battle_ship) {
        this.battle_ship = battle_ship;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getNumber_of_ships_live() {
        return number_of_ships_live;
    }

    public void setNumber_of_ships_live(int number_of_ships_live) {
        this.number_of_ships_live = number_of_ships_live;
    }

    public int getNumber_of_ships_destroy() {
        return number_of_ships_destroy;
    }

    public void setNumber_of_ships_destroy(int number_of_ships_destroy) {
        this.number_of_ships_destroy = number_of_ships_destroy;
    }
    //chuc nang cua nguoi choi
    void set_up(){
        for (int i = 0; i <= 25; i ++) {
            for (int j = 0; j <= 25; j ++) matrix[i][j] = '.';
        }
    }
    void show_board_of_player(){
        board.Show_board(matrix);
    }
    //Ship patrol_boat[], Ship submarine, Ship destroyer_boat, Ship battle_ship
    int check_Number_Ship(){
        int cnt = 5;
        if (patrol_boat_1.Check_ship(matrix) == 1) --cnt;
        if (patrol_boat_2.Check_ship(matrix) == 1) --cnt;
        if (submarine.Check_ship(matrix) == 1) --cnt;
        if (destroyer_boat.Check_ship(matrix) == 1) --cnt;
        if (battle_ship.Check_ship(matrix) == 1) --cnt;
        return cnt;
    }
    void show_board_lite(){
        board.Show_lite(matrix);
    }
}
