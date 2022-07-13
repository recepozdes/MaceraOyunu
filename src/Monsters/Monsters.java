package Monsters;

public class Monsters {
    private String monsterType;
    private int monsterID;
    private int monsterDamage;
    private int monsterHealth;
    private int monsterReward;

    public Monsters(String monsterType, int monsterID, int monsterDamage, int monsterHealth, int monsterReward) {
        this.monsterType = monsterType;
        this.monsterID = monsterID;
        this.monsterDamage = monsterDamage;
        this.monsterHealth = monsterHealth;
        this.monsterReward = monsterReward;
    }//canavar sınıfının constructorı oluşturuldu.

    //canavar sınıfını ilgilendiren getter ve setter metodları oluşturuldu.
    public Monsters(String monsterType, int monsterID, int monsterHealth, int monsterReward) {
        this.monsterType = monsterType;
        this.monsterID = monsterID;
        this.monsterHealth = monsterHealth;
        this.monsterReward = monsterReward;
    }// yılan için ayrı constructor oluşturuldu.

    public int getMonsterID() {
        return monsterID;
    }

    public void setMonsterID(int monsterID) {
        this.monsterID = monsterID;
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(int monsterDamage) {
        this.monsterDamage = monsterDamage;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public int getMonsterReward() {
        return monsterReward;
    }

    public void setMonsterReward(int monsterReward) {
        this.monsterReward = monsterReward;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }
}
