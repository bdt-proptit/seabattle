import java.util.ArrayList;

public class SolvePoints {
    public String points(int x, int y){ // chuyển tọa độ tung hoành từ số thành điểm (1,1 -> A1)
        x = x - 1 +'A';
        char xTmp = (char)x;
        String X = "" + xTmp;
        String Y = "" + y;
        return X + Y;
    }

    public int rows(String point){
        return point.codePointAt(0) - 'A' + 1;
    } //Trả về trục hoành của điểm (B1 -> 2)
    public int columns(String point){ // Trả về trục tung của điểm (B1 -> 1)
        int column = 0;
        for(int i=1 ; i<point.length() ; i++){
            column = column*10 + point.codePointAt(i) - '0';
        }
        return column;
    }

    public boolean findPoint(ArrayList<String> allPoints, String points){ // tìm điểm trong arraylist
        for(String it : allPoints){
            if(points.equals(it)) return true;
        }
        return false;
    }
}
