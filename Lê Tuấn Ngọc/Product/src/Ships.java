import java.util.ArrayList;

public class Ships {
    private String beginPoints;
    private String endPoints;
    private int size;
    private String name;
    private int numberOfDamagePoints;
    private ArrayList<String> listShipPoints = new ArrayList<String>();

    Ships(){
        numberOfDamagePoints = 0;
    }

    public void setBeginPoints(String beginPoints) {
        this.beginPoints = beginPoints;
    }

    public void setEndPoints(String endPoints) {
        this.endPoints = endPoints;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNumberOfDamagePoints(int numberOfDamagePoints) {
        this.numberOfDamagePoints = numberOfDamagePoints;
    }
    public int getNumberOfDamagePoints() {
        return numberOfDamagePoints;
    }

    public ArrayList<String> getListShipPoints() {
        return listShipPoints;
    }

    public void setShipPoints(String begin, String end) {
        SolvePoints solve = new SolvePoints();
        int xBegin = solve.rows(begin);
        int yBegin = solve.columns(begin);
        int xEnd = solve.rows(end);
        int yEnd = solve.columns(end);

        if(xBegin == xEnd){
            for(int i=Math.min(yBegin, yEnd) ; i<=Math.max(yBegin,yEnd) ; i++){
                listShipPoints.add(solve.points(xBegin,i));
            }
        }
        else {
            for(int i=Math.min(xBegin, xEnd) ; i<=Math.max(xBegin,xEnd) ; i++){
                listShipPoints.add(solve.points(i,yBegin));
            }
        }
    }
}
