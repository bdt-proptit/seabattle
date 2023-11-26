public class Welcome_Menu {
    public void Show(){
        Instruction I = new Instruction();
        I.ShowInstruction();
        System.out.println("Let's play Now!");
    }
    public void PlayNow(){
        Game_Menu menugame = new Game_Menu();
        // B1: Create new Map
        menugame.CreateNewMap();

        // B2: Input Map
        System.out.println("Create Map for A and B: ");
        menugame.CreateBoat();

        // B3: Play game
        while(true){
            int cnt = 0;
            for(int p = 0; p <= 1; p++){
                cnt = 0;
                menugame.TurnAttack(p);
                //  ClearScreen.clrscr();
                for(int i = 0; i < 10 ; i++){
                    for(int j = 0; j < 10; j++){
                        if(Main.List.get(1- p).board_Me[i][j] == 1) cnt ++;
                    }
                }

                // B4: Check Winner
                if(cnt == 0){
                    System.out.println("CONGRATULATION! Player " + (1 - p) + " is winner!");
                    break;
                }
            }
            if(cnt == 0) break;
        }
    }
}
