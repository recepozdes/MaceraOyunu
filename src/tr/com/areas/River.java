package tr.com.areas;

import Main.Player;
import Monsters.Bear;

public class River extends BattleLocation{



    public River(Player player){
        super(player,"Nehir",new Bear(),"Su");
    }



}
