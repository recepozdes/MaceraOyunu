package com.Character;

public abstract class GameCharacter {
    private String characterType;
    private int characterId;
    private int characterDamage;
    private int characterHealth;
    private int characterMoney;

    public GameCharacter(String characterType, int characterId, int characterDamage, int characterHealth, int characterMoney) {
        this.characterType = characterType;
        this.characterId = characterId;
        this.characterDamage = characterDamage;
        this.characterHealth = characterHealth;
        this.characterMoney = characterMoney;
    }
    //karakter sınıfının constructorı oluşturuldu.

    //karakter sınıfını ilgilendiren getter ve setter metodları oluşturuldu.

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getCharacterDamage() {
        return characterDamage;
    }

    public void setCharacterDamage(int characterDamage) {
        this.characterDamage = characterDamage;
    }

    public int getCharacterHealth() {
        return characterHealth;
    }

    public void setCharacterHealth(int characterHealth) {
        this.characterHealth = characterHealth;
    }

    public int getCharacterMoney() {
        return characterMoney;
    }

    public void setCharacterMoney(int characterMoney) {
        this.characterMoney = characterMoney;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }
}
