import java.util.ArrayList;

public class Boat {
    private String name;
    private int length;
    private String shape;
    private String[] location = new String[length];
    public void setName (String name) {
        this.name = name;
    }
    public String getName () {
        return this.name;
    }
    public void setLength (int length) {
        this.length = length;
    }
    public int getLength () {
        return this.length;
    }
    public void setShape (String shape) {
        this.shape = shape;
    }
    public String getShape () {
        return this.shape;
    }
    public String checkLocation (Coordinates firstCoordinates, Player player) {
        int ans = 3;
        int tmp = firstCoordinates.column;
        if (firstCoordinates.row - 'a' + this.length > 10) {
            --ans;
        }
        else {
            for (int i = 0; i < this.length; ++i) {
                if (player.getMyBoard()[i + firstCoordinates.row - 'a'][firstCoordinates.column] != 0) {
                    --ans;
                    break;
                }
            }
        }
        firstCoordinates.column = tmp;
        if (firstCoordinates.column + this.length > 10) {
            --ans;
        }
        else {
            for (int i = 0; i < this.length; ++i) {
                if (player.getMyBoard()[firstCoordinates.row - 'a'][i + firstCoordinates.column] != 0) {
                    --ans;
                    break;
                }
                if (i == 1 && ans == 2) {
                    return "Column";
                }
            }
        }
        if (ans == 3) {
            return "Both";
        }
        else if (ans == 2) {
            return "Row";
        }
        else {
            return "None";
        }
    }
}
