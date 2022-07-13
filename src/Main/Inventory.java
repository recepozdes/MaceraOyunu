package Main;

import Armor.Armor;
import Weapons.Weapons;

import java.util.ArrayList;

public class Inventory {
    private Weapons weapons;
    private Armor armor;
    public ArrayList<String> awarList=new ArrayList<String>();
    private int awardCount;


    public Inventory() {
        this.weapons = new Weapons("Yumruk",-1,0,0);
        this.armor = new Armor("Giysi",-1,0,0);
        this.awardCount=4;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public ArrayList<String> getAwarList() {
        return awarList;
    }

    public void setAwarList(ArrayList<String> awarList) {
        this.awarList = awarList;
    }

    public void addAwardList(String award){
        awarList.add(award);
    }

    public int getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(int awardCount) {
        this.awardCount = awardCount;
    }
}
