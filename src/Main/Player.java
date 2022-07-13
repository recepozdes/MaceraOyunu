package Main;

import Weapons.Weapons;
import com.Character.Archer;
import com.Character.GameCharacter;
import com.Character.Knight;
import com.Character.Samurai;
import Main.Inventory;

import java.util.Scanner;

public class Player {
    private GameCharacter gameCharacter;
    Scanner scanner = new Scanner(System.in);
    private int damage;
    private int health;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;
    private int orjinalHealth;

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }

    public void selectCharacter(){

        GameCharacter[] characterList = {new Samurai(),new Archer() , new Knight()};
        System.out.println("**********************************");
        for(GameCharacter gameCharacter : characterList){
            System.out.println("Karakter : "+ gameCharacter.getCharacterType()+ "\t Hasar : "+gameCharacter.getCharacterDamage()+"\t Sağlık : "+gameCharacter.getCharacterHealth()+"\t Para : "+gameCharacter.getCharacterMoney());
        }

        System.out.println("Oynamak istediğiniz karakteri seçiniz:  " +
                "\n 1. Samurai" +
                "\n 2. Archer" +
                "\n 3. Knight");

        int selectedCharacter = scanner.nextInt();

//        if(selectedCharacter==gameCharacter.getCharacterId()){
//            System.out.println(gameCharacter.getCharacterType()+" Karakterini Seçtiniz");
//        }

        if(selectedCharacter==1 || selectedCharacter==2||selectedCharacter==3){
            switch (selectedCharacter) {
                case 1:
                    initPlayer(new Samurai());
                    System.out.println("Samurai seçtiniz.");
                    break;
                case 2:
                    initPlayer(new Archer());
                    System.out.println("Archer seçtiniz.");
                    break;
                case 3:
                    initPlayer(new Knight());
                    System.out.println("Knight seçtiniz.");
                    break;
                default:

                    break;

            }
        }else{
                System.out.println("Hatalı seçim yaptınız. Lütfen 1-2-3 seçeneleri için tekrar deneyiniz.");
            }
    }

    public void initPlayer(GameCharacter gameCharacter){

        this.setDamage(gameCharacter.getCharacterDamage());
        this.setHealth(gameCharacter.getCharacterHealth());
        this.setOrjinalHealth(gameCharacter.getCharacterHealth());
        this.setMoney(gameCharacter.getCharacterMoney());
        this.setCharName(gameCharacter.getCharacterType());
    }

    public void printPlayerInfo(){
        System.out.println("Mevcut Silahınız : "+this.getInventory().getWeapons().getWeaponType() +
                "\tHasarınız : "+ this.getTotalDamage()+
                "\tSağlığınız : "+ this.getHealth()+
                "\tMevcut Zırhınız : "+ this.getInventory().getArmor().getArmorType()+
                "\tMevcut Bloklama değeriniz : "+ this.getInventory().getArmor().getArmorBlock()+
                "\tParanız : "+ this.getMoney());
    }



    public int getTotalDamage(){
        return damage+this.getInventory().getWeapons().getWeaponDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}

