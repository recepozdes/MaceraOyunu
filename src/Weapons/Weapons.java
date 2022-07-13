package Weapons;

public class Weapons {
    private String weaponType;
    private int weaponID;
    private int weaponDamage;
    private int weaponPrice;

    public Weapons(String weaponType, int weaponID, int weaponDamage, int weaponPrice) {
        this.weaponType = weaponType;
        this.weaponID = weaponID;
        this.weaponDamage = weaponDamage;
        this.weaponPrice = weaponPrice;
    }//Silah sınıfının constructorı oluşturuldu.

    //Silah sınıfını ilgilendiren getter ve setter metodları oluşturuldu.

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponPrice() {
        return weaponPrice;
    }

    public void setWeaponPrice(int weaponPrice) {
        this.weaponPrice = weaponPrice;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }
}
