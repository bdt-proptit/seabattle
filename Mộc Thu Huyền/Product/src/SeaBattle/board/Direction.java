package SeaBattle.board;


public enum Direction {
    HORIZONTAL,//Ngang
    VERTICAL;// Dọc

    public static Direction decode(char c) throws DirectionException {
        if (c == 'h' || c == 'H') return HORIZONTAL;
        else if (c == 'v' || c == 'V') return VERTICAL;
        else throw new DirectionException("The character '"+c+"' cannot be converted in a direction");
    }

    public static Direction decode(String str) throws DirectionException {
        if (str.toLowerCase().equals("horizontal")) return HORIZONTAL;
        else if (str.toLowerCase().equals("vertical")) return VERTICAL;
        else throw new DirectionException("The string '"+str+"' cannot be converted in a direction");
    }
}