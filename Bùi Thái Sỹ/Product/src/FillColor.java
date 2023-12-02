import java.util.HashMap;
import java.util.Map;
public class FillColor {
    public Map<String, String> color = new HashMap<String, String>();
    public void initColor(){
        color.put("X", "\u001B[41m");//Hit
        color.put("O", "\u001B[47m");//Miss
        color.put("S", "\u001B[30m");//Ship
        color.put("W", "\u001B[46m");//Water
    }
    public static final String RESET = "\u001B[0m";
    public static final String SHIP = "\u001B[43m";
    //public static final String WIN = "\u001B[32m";
}
