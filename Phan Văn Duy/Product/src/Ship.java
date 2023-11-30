package seabattle;

public class Ship {

//    String name;
    int tinhTrang;
    int length;
    int width;
    int row;
    int col;
    int ngangdoc; // 1 là ngang, 0 là doc

    public Ship(int length, int width, int row, int col, int ngangdoc) {
//        this.name = name;
        this.length = length;
        this.width = width;
        this.row = row;
        this.col = col;
        this.ngangdoc = ngangdoc;
        tinhTrang = length * width;
    }
}
