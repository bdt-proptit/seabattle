package Display;
import Player.*;
import java.util.Comparator;


public class SortComparator implements Comparator<Player> {
    public int compare(Player player1, Player player2) {
        if(player1.getShotCount()==player2.getShotCount() && player1.getListShip().size()==player2.getListShip().size()) {
            return player1.getName().compareToIgnoreCase(player2.getName());
        }
        if(player1.getShotCount()==player2.getShotCount() && player1.getListShip().size()>player2.getListShip().size()) return player1.getListShip().size()- player2.getListShip().size();
        return player1.getShotCount()-player2.getShotCount();
    }
}