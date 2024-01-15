import java.util.Scanner;

public class LogIn {
    public int logIn(Scanner sc, Player player1, Player player2, Manage manage) {
        String choice;
        System.out.println("Mời bạn chọn chế độ chơi!!!");
        System.out.println("----------------------------");
        System.out.println("Chơi với máy: 1");
        System.out.println("Chơi với người đang ngồi cạnh bạn: 2");
        System.out.println("Xem luật chơi: 3");
        System.out.println("Thoát: 4");
        while (true){
            System.out.print("Nhập lựa chọn: ");
            choice = sc.next();
            if(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) break;
            else System.out.println("Lựa chọn không phù hợp, mời nhập lại lựa chọn!");
        }

        switch (choice){
            case "1":
                sc.nextLine();
                System.out.print("Nhập tên người chơi: ");
                String namePlayer= sc.nextLine();

                player1.setName(namePlayer);
                player2.setName("Bot");

                System.out.print("Nhập size map (>=10 và <=20): ");
                int sizee = sc.nextInt();
                System.out.println();

                player1.getMap().setSize(sizee,sizee);
                player2.getMap().setSize(sizee,sizee);

                System.out.println("Xin mời " + player1.getName() + " hãy setup tàu của mình!");
                manage.setUpMap(player1, manage);
                manage.setUpMap(player2, manage);
                return 1;
            case "2":
                sc.nextLine();
                System.out.print("Nhập tên người chơi 1: ");
                String namePlayer1 = sc.nextLine();
                System.out.print("Nhập tên người chơi 2: ");
                String namePlayer2 = sc.nextLine();
                System.out.println();

                player1.setName(namePlayer1);
                player2.setName(namePlayer2);

                System.out.print("Nhập size map (>=10 và <=20): ");
                int size = sc.nextInt();
                System.out.println();

                player1.getMap().setSize(size,size);
                player2.getMap().setSize(size,size);

                System.out.println("Xin mời " + player1.getName() + " hãy setup tàu của mình!");
                manage.setUpMap(player1, manage);
                for(int i=1 ; i<=50 ; i++) System.out.println();
                System.out.println("Xin mời " + player2.getName() + " hãy setup tàu của mình!");
                manage.setUpMap(player2, manage);
                for(int i=1 ; i<=50 ; i++) System.out.println();
                return 2;
            case "3":
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("Luật chơi Battleship rất đơn giản. Mỗi thành viên tham gia sẽ có một bàn cờ dựng " +
                        "\n" + "gồm các ô vuông đánh số hàng ngang và ô chữ cái hàng dọc. Trong quá trình chơi, người chơi " +
                        "\n" +"sẽ đặt các tàu của mình trên bảng này mà đối thủ không thấy được. Mỗi loại tàu có một chiều " +
                        "\n" +"dài khác nhau, từ 1 ô vuông đến 5 ô vuông.\n" +
                        "\n" +
                        "Sau khi các tàu được đặt xong, người chơi lần lượt " +
                        "\n" +"tấn công đối thủ bằng cách chọn một ô vuông trên bảng " +
                        "\n" +"của đối thủ để tấn công. Nếu ô vuông đó chứa một phần " +
                        "\n" +"của một tàu, đối thủ phải thông báo rằng tàu của họ bị " +
                        "\n" +"đánh chìm. Nếu không, đối thủ sẽ thông báo rằng tấn công " +
                        "\n" +"đã thất bại và lượt chơi được chuyển sang người kế tiếp. " +
                        "\n" +"Trò chơi kết thúc khi tất cả các tàu của một người chơi đều bị đánh chìm.");
                System.out.println("-----------------------------------------------------------------------------------");
                return 3;
            case "4":
                System.out.println("Thanks for đã chơi game nha :>");
                return 4;
        }
        return 0;
    }
}