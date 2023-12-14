public enum Direction {
    NORTH (-1, 0, "Bắc"), SOUTH(1, 0, "Nam"),  EAST(0, 1, "Đông"), WEST(0, -1,  "Tây");
    public final int dx;
    public final int dy;
    public final String vietnammese;
    private Direction(int dx, int dy, String vietnammese){
        this.dx = dx;
        this.dy = dy;
        this.vietnammese = vietnammese;
    }
}