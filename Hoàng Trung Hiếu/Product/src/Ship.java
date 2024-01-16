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

}
