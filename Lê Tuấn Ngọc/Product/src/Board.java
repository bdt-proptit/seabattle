import java.util.ArrayList;

public class Board {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    SolvePoints solve = new SolvePoints();
    private int rows;
    private int columns;
    private ArrayList<String> listShipPoints = new ArrayList<String>();
    private ArrayList<String> listBeFiredPoints = new ArrayList<String>();
    private ArrayList<String> listFirePoints = new ArrayList<String>();

    //Thêm tọa độ các điểm đã bắn
    public void setListBeFiredPoints(String points) {
        listBeFiredPoints.add(points);
    }
    public void setListFirePoints(String points) {
        listFirePoints.add(points);
    }
    public ArrayList<String> getListFirePoints() {
        return listFirePoints;
    }
    public ArrayList<String> getListShipPoints() {
        return listShipPoints;
    }
    public ArrayList<String> getListBeFiredPoints() {
        return listBeFiredPoints;
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }

    //thêm các tọa độ của tàu vào arraylist
    public void setListShipPoints(ArrayList<String> points) {
        for(String it : points){
            listShipPoints.add(it);
        }
    }

    Board(){
        rows = 10;
        columns = 10;
    }
}
