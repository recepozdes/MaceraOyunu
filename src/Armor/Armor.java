package Armor;

public class Armor {
    private String armorType;
    private int armorID;
    private int armorBlock;
    private int armorPrice;

    public Armor(String armorType,int armorID, int armorBlock, int armorPrice) {
        this.armorType = armorType;
        this.armorID = armorID;
        this.armorBlock = armorBlock;
        this.armorPrice = armorPrice;
    } //armor sınıfının constructorı oluşturuldu.

    //armor sınıfını ilgilendiren getter ve setter metodları oluşturuldu.

    public int getArmorID() {
        return armorID;
    }

    public void setArmorID(int armorID) {
        this.armorID = armorID;
    }

    public int getArmorBlock() {
        return armorBlock;
    }

    public void setArmorBlock(int armorBlock) {
        this.armorBlock = armorBlock;
    }

    public int getArmorPrice() {
        return armorPrice;
    }

    public void setArmorPrice(int armorPrice) {
        this.armorPrice = armorPrice;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }
}
