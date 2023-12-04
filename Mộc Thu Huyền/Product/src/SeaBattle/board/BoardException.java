package SeaBattle.board;

public class BoardException extends Exception { // Các trường hợp ngoại lệ
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
