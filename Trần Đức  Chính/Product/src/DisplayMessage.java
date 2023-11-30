public class DisplayMessage {
    public DisplayMessage() {
    }
    public void printMessage(String message) {
        System.out.print(message);
    }
    public void printMenu() {
        System.out.println("Menu Game:");
        System.out.println("1. PVP\n2. PVE\n3. Luật Chơi\n4. Exit");
        System.out.print("Vui lòng chọn: ");
    }
    public void printRules() {
        System.out.println("Luật chơi:");
        System.out.println("1 tàu sẽ bị phá huỷ chỉ sau khi toàn bộ điểm bị phá hết. Ví dụ tàu 1x5 thì ít nhất 5 phát bắn trúng đích toàn bộ để phá.\n" +
                "Khi bên nào bị phá hết tàu trước lập tức thua cuộc và hiển thị màn hình kết quả bảng của cả 2 bên\n" +
                "Bắn trúng sẽ hiện " + Color.HIT + "X" + Color.RESET + " và bắn trượt sẽ hiện " + Color.MISS + "*" + Color.RESET + "\n");
    }
}
