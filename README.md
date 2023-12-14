# Sea Battle

Sea Battle is a game for two players. The game is played on four grids, two for each player. The grids are typically square – usually 10×10 – and the individual squares in the grid are identified by letter and number. On one grid the player arranges ships and records the shots by the opponent. On the other grid the player records their own shots.

The project was done by [Bùi Thái Sỹ](https://github.com/sybui2004), in the course of Object Oriented Programming at [ProPTIT](https://proptit.com/).


## Tech Stack
=======
## Nội dung thêm

Đây là một dự án bài tập giữa khoá cho kì Java Core của ProPTIT, thực hiện bởi BDT Khoá 9 dành cho khoá D22 CLB. Các thành viên đã hoàn thành cơ bản về Java Syntax, 3 trong 4 tính chất OOP, và có thể sử dụng Git cơ bản.


## Tổng kết sản phẩm:

- Hoàng Hải Long: 
    - Github: [Source Code](https://github.com/long20102004/Mid-Practice-ProPTIT)
    - Demo: [Youtube](https://www.youtube.com/watch?v=tb_TnbMt_PM&ab_channel=D22BCCN496-Ho%C3%A0ngH%E1%BA%A3iLong)
- Bùi Thế Vĩnh Nguyên:
    - Github: [Source Code](https://github.com/NguyenBui256/ShipBattle---JavaGame)
    - Demo: [Youtube](https://www.youtube.com/watch?v=YQpjQqdZBkE&feature=youtu.be)
- Nguyễn Nhật Thành:
    - Github: [Source Code](https://github.com/NgNhatThanh/SeaBattle-JavaGame)
    - Demo: [Youtube](https://www.youtube.com/watch?v=Hit3bYx5FKI&feature=youtu.be)
- Phan Thanh Tân:
    - Github: [Source Code](https://github.com/TanaKeKe/SeaBattle--Console)
    - Demo: [Youtube](https://www.youtube.com/watch?v=uJ4Bco0oErA)
- Trần Xuân Sơn:
    - Github: [Source Code](https://github.com/Yamaaaaaaaa/BTGK_SeaBattle_d22_tran_xuan_son)
    - Demo: [Youtube](https://www.youtube.com/watch?v=WiqDej9jEnk&feature=youtu.be)




- [Java](https://www.java.com/en/) 

## Software Design (UML)
### Class Diagram: 
![Alt text](https://github.com/bdt-proptit/seabattle/blob/d22_bui_thai_sy/CD.png)

### Activity Diagram:
![Alt text](https://github.com/bdt-proptit/seabattle/blob/d22_bui_thai_sy/AD.png)

## Installation

- Clone the repo
- Open the project in your IDE
- Run BattleShip.bat
- Run the project

## Demo Video

[C War](https://www.youtube.com/watch?v=Jmc0e5tBXe8)

## Demo Image

![Alt text](https://github.com/bdt-proptit/seabattle/blob/d22_bui_thai_sy/image1.png)

![Alt text](https://github.com/bdt-proptit/seabattle/blob/d22_bui_thai_sy/image2.png)

![Alt text](https://github.com/bdt-proptit/seabattle/blob/d22_bui_thai_sy/image3.png)
## Usage

- Project Structure

```bash

├── src
│   ├── main
│   ├── controller
│   │   ├── Controller.java
│   │   ├── ClearScreen.java
│   │   ├── FillColor.java
│   │   ├── PressEnterToContinue.java
│   │   └── Wait.java
│   ├── model
│   │   ├── Board.java
│   │   ├── Ship.java
│   │   ├── Player.java
│   │   ├── Computer.java
│   │   └── Position.java
```
## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.
=======
##### Độ khó ⭐
- Cơ chế kiểm tra khi nhập liệu cần kiểm tra không cho đặt tàu chồng lấn, đặt tàu ngoài vùng, bắn điểm ngoài vùng, bắn điểm đã bắn, ...
- Hiển thị giao diện bảng rõ ràng, có thể dùng emoji, kí tự đặc biệt, ...
- Output màn hình hiển thị menu, bảng của hai bên có thể in ra màu (https://www.geeksforgeeks.org/how-to-print-colored-text.../), có thể hiển thị vùng bị bắn rồi, chỗ tàu bị nổ, ... rõ ràng và đẹp hơn
- Cơ chế sau khi người chơi bắn trúng thì sẽ được bắn tiếp cho đến khi bắn trượt

##### Độ khó ⭐⭐
- Chế độ tự động đặt tàu ngẫu nhiên ở vòng chuẩn bị
- Thêm tính năng bảng xếp hạng số lượt bắn ít nhất, số tàu còn lại của người chơi khi thắng, Lúc này khi vào game cần nhập thêm tên người chơi để lưu lại, ở menu ban đầu có thể chọn hiển thị bảng xếp hạng
- Đóng gói được chương trình thành 1 file jar để có thể chạy game mà không cần ide

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
