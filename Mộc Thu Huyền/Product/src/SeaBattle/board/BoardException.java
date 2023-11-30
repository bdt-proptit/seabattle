package SeaBattle.board;

public class BoardException extends Exception {
    String msg;

    public BoardException(String msg) {
        super(msg);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
