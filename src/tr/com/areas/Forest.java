package tr.com.areas;

import Main.Player;
import Monsters.Vampire;

public class Forest extends BattleLocation{


    public Forest(Player player){
        super(player,"Orman",new Vampire(),"Odun");
    }


}
