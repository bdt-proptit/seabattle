package Tool;
import java.util.List;

public class Table {
    static public int numberOfColumn = 4;
    static int underLine = 0;
    static void drawUnderline(){
        System.out.println();
        for(int j=0; j<underLine + 2*numberOfColumn; ++j) System.out.print("-");
        System.out.println();
    }
    public static void draw(List<String> title, List<String> content, int[] columnSize){
        for(int x : columnSize) underLine += x;
        numberOfColumn = title.size();
        System.out.print("|");
        for(int i=0; i<numberOfColumn; ++i){
            System.out.printf("%" + -columnSize[i] + "s| ", title.get(i));
        }
        drawUnderline();
        for(int i=0; i<=content.size()-numberOfColumn; i+=numberOfColumn){
            System.out.print("|");
            for(int j=i; j<i+numberOfColumn; ++j){
                System.out.printf("%" + -columnSize[j-i] + "s| ", content.get(j));
            }
            drawUnderline();
        }
        underLine = 0;
    }
}
