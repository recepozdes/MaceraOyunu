package tr.com.areas;

import Main.Player;
import Monsters.Monsters;
import Monsters.Zombie;

public class Cave extends BattleLocation {


    public Cave(Player player){
        super(player,"Mağara",new Zombie(),"Yemek");
    }



}
