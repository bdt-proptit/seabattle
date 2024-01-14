package Tool;
import Entity.Board;
public class Checker {
    static public boolean checkShotCoordinate(int x, int y, char[][] a){
        int n = Board.Size;
        return x>=0 && y>=0 && x<n && y<n && a[x][y] != 'X' && a[x][y] != 'O' && a[x][y] != 'D';
    }
    static public boolean checkShipCoordinate(int x, int y, char[][] a){
        int n = Board.Size;
        return x>=0 && y>=0 && x<n && y<n && a[x][y] != 'S';
    }
    static public boolean check2coordinate(int x1, int y1, int x2, int y2, char[][] a, int len){
        if(x1 == x2){
            if(Math.abs(y1-y2) != len - 1) return false;
            for(int i=Integer.min(y1, y2); i<=Integer.max(y1, y2); ++i){
                if(!checkShipCoordinate(x1, i, a)) return false;
            }
        }
        else if(y1 == y2){
            if(Math.abs(x1-x2) != len - 1) return false;
            for(int i=Integer.min(x1, x2); i<=Integer.max(x1, x2); ++i){
                if(!checkShipCoordinate(i, y1, a)) return false;
            }
        }
        else return false;
        return true;
    }
    static public boolean checkInRange(int left, int right, String input){
        int cs = 0, tmp = right;
        while(tmp > 0){
            tmp /= 10;
            ++cs;
        }
        if(input.isEmpty() || input.length() > cs) return false;
        tmp = 0;
        for(int i=0; i<input.length(); ++i){
            if(Character.isAlphabetic(input.charAt(i))) return false;
            tmp = tmp*10 + input.codePointAt(i) - '0';
            if(tmp > right) return false;
        }
        return tmp >= left;
    }
    static public boolean inputCheck(String s){
        if(s.length() < 2 || s.length() > 3) return false;
        char a = s.charAt(0), b = s.charAt(1), c = '0';
        if(s.length() == 3) c = s.charAt(2);
        return Character.isAlphabetic(a) && Character.isDigit(b) && Character.isDigit(c);
    }
}
