import java.util.ArrayList;

public class Board {
    private int rows;
    private int columns;
    private ArrayList<String> listShipPoints = new ArrayList<String>();
    private ArrayList<String> listBeFiredPoints = new ArrayList<String>();
    private ArrayList<String> listFirePoints = new ArrayList<String>();
    public void setSize(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
    }
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
}
