package Player;

public class Test extends Player_Prepare{
    public Test(Player player) {
        super(player);
    }
    public static void main(String[] args) {
        Player player = new Player();
        new Player_Prepare(player).prepare();
    }
}
