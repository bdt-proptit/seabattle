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

    public boolean isSunk() {
        for (Cell cell : cells) {
            if (!cell.isHit()) {
                return false; // Nếu có ô trên tàu chưa bị bắn trúng, tàu chưa bị phá hủy
            }
        }
        return true; // Nếu tất cả các ô trên tàu đã bị bắn trúng, tàu đã bị phá hủy
    }

}
