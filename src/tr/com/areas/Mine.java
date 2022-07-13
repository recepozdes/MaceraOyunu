package tr.com.areas;

import Main.Player;
import Monsters.Snake;

import java.util.Random;

public class Mine extends BattleLocation {




    public Mine(Player player, int damageValue) {
        super(player, "Maden", new Snake(), "Gold");
    }




}
