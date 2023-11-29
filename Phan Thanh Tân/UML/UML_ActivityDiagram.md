# Ý tưởng

![Alt text](image-1.png)

# Trong đó: 
+ Lớp Board: 
    - 2 mảng 2 chiều thuộc tính char.
    - Board(): khởi tạo bảng
    - displayMyBoard(): hiển thị bảng của bản thân
    - display(...): hiển thị bảng chơi hiện tại của người chơi hiện tại

+ Lớp Player kế thừa Board để lấy 2 bảng
    - Các thuộc tính private
    - check_ship: mảng 1 chiều int để kiểm tra tàu nào chưa được đặt vào đầu game
    - x1,x2,y1,y2 là tọa độ của 2 tọa độ tàu đầu vào
    - Name_ship: là List lưu tên tàu ở tọa đồ nào
    - Coordinates_X và Coordinates_Y: là 2 list lưu tọa độ của các tàu qua 2 tọa độ đôi 1.
    - setShip() : đặt tàu
    - Player(): nhập tên + đặt tàu
+ Lớp Process:
    - shootEnemy(): phương thức để xác định điểm bắn
    - inforPlayer(): xác định
        1.số ô đã bắn
        2.số tàu đã phá hủy của dịch 
        3.số tàu còn lại của bản thân
        4. Kiểm tra ai đã chiến thắng chưa
    - play(): thực hiện các thao tác gọi phương thức theo luật chơi.