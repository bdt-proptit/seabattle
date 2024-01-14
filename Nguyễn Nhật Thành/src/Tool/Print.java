package Tool;

public class Print {
    public static final String colorReset = "\u001B[0m";
    public static String letterColor = "\u001B[33m";
    static public String getColor(String name){
        return switch (name) {
            case "Red" -> "\033[1;31m";
            case "Green" -> "\033[1;32m";
            case "Blue" -> "\033[1;34m";
            case "Black" -> "\033[1;30m";
            case "White" -> "\033[1;37m";
            case "Cyan" -> "\033[1;36m";
            case "Yellow" -> "\033[1;33m";
            case "Purple" -> "\033[1;35m";
            default -> "\u001B[0m";
        };
    }
    public static String setColor(String s, String color){
        letterColor = getColor(color);
        return letterColor + s + colorReset;
    }
}