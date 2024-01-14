class Ship {
    private int size;
    private Cell[] cells; // Mảng lưu trữ thông tin các ô trên tàu

    public Ship(int size) {
        this.size = size;
        this.cells = new Cell[size];
        for (int i = 0; i < size; i++) {
            this.cells[i] = new Cell();
            this.cells[i].setShip(this);
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int index) {
        if (index >= 0 && index < size) {
            return cells[index];
        }
        return null;
    }

    public boolean isSunk() {
        for (Cell cell : cells) {
            if (!cell.isHit()) {
                return false; // Nếu có ô trên tàu chưa bị bắn trúng, tàu chưa bị phá hủy
            }
        }
        return true; // Nếu tất cả các ô trên tàu đã bị bắn trúng, tàu đã bị phá hủy
    }
    public boolean isSunkAllCellsOfShip() {
        for (Cell cell : cells) {
            if (!cell.isHit()) {
                return false;
            }
        }
        return true;
    }
    public void updateHitStatus() {
        boolean allCellsHit = true;
        for (Cell cell : cells) {
            if (!cell.isHit()) {
                allCellsHit = false;
                break;
            }
        }

        if (allCellsHit) {
            System.out.println("Đối thủ đã bắn hết các ô của tàu của bạn!");
            // Gọi các hành động cần thiết khi tàu bị bắn hết các ô ở đây
        } else {
            System.out.println("Đối thủ đã bắn trúng phần của tàu của bạn!");
            // Gọi các hành động cần thiết khi tàu bị bắn trúng một phần ở đây
        }
    }
}
