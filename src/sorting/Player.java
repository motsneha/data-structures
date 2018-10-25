package sorting;

import java.util.Comparator;

public class Player implements Comparator<Player> {
     int score;
     String name;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compare(Player o1, Player o2) {
        int scoreCompare =  o1.score - o2.score;
        int nameCompare = o1.name.compareTo(o2.name);
        if(scoreCompare == 0){
            return nameCompare;
        }else{
            return scoreCompare;
        }
    }

}
