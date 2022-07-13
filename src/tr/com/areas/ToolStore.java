package tr.com.areas;

import Main.Player;
import Weapons.Weapons;
import Weapons.Rifle;
import Weapons.Sword;
import Weapons.Gun;
import Armor.*;


public class ToolStore extends NormalLocation {

    public Player player;

    public Weapons[] weaponList = {new Gun(), new Sword(), new Rifle()};
    public Armor[] armorList = {new LightArmor(), new MiddleArmor(), new HeavyArmor()};


    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz. Ne almak istersiniz? :) ");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silahlar " + "\n" + "2 - Zırhlar" + "\n" + "3 - Çıkış Yap");
            int selection = scanner.nextInt();
            while (selection < 1 || selection > 3) {
                System.out.println("Lütfen geçerli bir seçim yapınız.");
                selection = scanner.nextInt();
            }
            switch (selection) {
                case 1:
                    System.out.println("Silah reyonuna hoşgeldiniz. Ne almak istersiniz? :) ");
                    System.out.println("**** Silahlar Listeleniyor ****");
                    for (int i = 0; i < weaponList.length; i++) {
                        System.out.println("ID : " + (i + 1) + "\tTipi : " + weaponList[i].getWeaponType() + "\tHasar :" + weaponList[i].getWeaponDamage() + "\tFiyatı : " + weaponList[i].getWeaponPrice());
                    }

                    buyWeapon();

                    break;
                case 2:
                    System.out.println("Zırh reyonuna hoşgeldiniz. Ne almak istersiniz? :) ");
                    System.out.println("**** Zırhlar Listeleniyor ****");
                    for (int i = 0; i < armorList.length; i++) {
                        System.out.println("ID : " + (i + 1) + "\tTipi : " + armorList[i].getArmorType() + "\tEngelleme Miktarı :" + armorList[i].getArmorBlock() + "\tFiyatı : " + armorList[i].getArmorPrice());
                    }

                    buyArmor();

                    break;
                case 3:
                    System.out.println("Mağazadan Çıkılıyor. Hayatta Kalmaya ve Mücadeleye Devam Et...");
                    showMenu = false;
                    break;
            }
            return true;
        }
        return true;
    }


    public void buyWeapon() {
        System.out.println("Satın almak istediğiniz silahın ID'sini giriniz. Ya da çıkış yapmak için 0 a basınız.");
        int weaponID = scanner.nextInt();

        while (weaponID < 0 || weaponID > weaponList.length) {
            System.out.println("Lütfen geçerli bir seçim yapınız.");
            weaponID = scanner.nextInt();
        }

        if(weaponID !=0){
            switch (weaponID) {
                case 1:
                    if (this.getPlayer().getMoney() >= weaponList[0].getWeaponPrice()) {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() - weaponList[0].getWeaponPrice());
                        System.out.println(weaponList[0].getWeaponType() + " başarıyla satın alındı. Kalan Para Miktarınız : " + this.getPlayer().getMoney());
                        System.out.println("Önceki silahınız :" + this.getPlayer().getInventory().getWeapons().getWeaponType());
                        this.getPlayer().getInventory().setWeapons(weaponList[0]);

                    } else {
                        System.out.println("Yeterli paranız yok. Lütfen daha fazla para kazanmak için savaş alanına dönünüz.");
                    }
                    break;
                case 2:
                    if (this.getPlayer().getMoney() >= weaponList[1].getWeaponPrice()) {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() - weaponList[1].getWeaponPrice());
                        System.out.println(weaponList[1].getWeaponType() + " başarıyla satın alındı. Kalan Para Miktarınız : " + this.getPlayer().getMoney());

                        System.out.println("Önceki silahınız :" + this.getPlayer().getInventory().getWeapons().getWeaponType());
                        this.getPlayer().getInventory().setWeapons(weaponList[1]);

                    } else {
                        System.out.println("Yeterli paranız yok. Lütfen daha fazla para kazanmak için savaş alanına dönünüz.");
                    }
                    break;
                case 3:
                    if (this.getPlayer().getMoney() >= weaponList[2].getWeaponPrice()) {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() - weaponList[2].getWeaponPrice());
                        System.out.println(weaponList[2].getWeaponType() + " başarıyla satın alındı. Kalan Para Miktarınız : " + this.getPlayer().getMoney());

                        System.out.println("Önceki silahınız :" + this.getPlayer().getInventory().getWeapons().getWeaponType());
                        this.getPlayer().getInventory().setWeapons(weaponList[2]);

                    } else {
                        System.out.println("Yeterli paranız yok. Lütfen daha fazla para kazanmak için savaş alanına dönünüz.");
                    }
                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız.");
                    break;
            }
        }else{
            System.out.println("Çıkış Yapılıyor ...");
        }


    }



    public void buyArmor() {
        System.out.println("Satın almak istediğiniz zırhın ID'sini giriniz. Ya da çıkış yapmak için 0 a basınız.");
        int armorID = scanner.nextInt();
        while (armorID < 0 || armorID > 3) {
            System.out.println("Lütfen geçerli bir seçim yapınız.");
            armorID = scanner.nextInt();
        }
        if(armorID!=0){
            switch (armorID) {
                case 1:
                    if (this.getPlayer().getMoney() >= armorList[0].getArmorPrice()) {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() - armorList[0].getArmorPrice());
                        System.out.println(armorList[0].getArmorType() + " başarıyla satın alındı. Kalan Para Miktarınız : " + this.getPlayer().getMoney());
                        System.out.println("Önceki zırhınız :" + this.getPlayer().getInventory().getArmor().getArmorType());
                        this.getPlayer().getInventory().setArmor(armorList[0]);
                    } else {
                        System.out.println("Yeterli paranız yok. Lütfen daha fazla para kazanmak için savaş alanına dönünüz.");
                    }
                    break;
                case 2:
                    if (this.getPlayer().getMoney() >= armorList[1].getArmorPrice()) {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() - armorList[1].getArmorPrice());
                        System.out.println(armorList[1].getArmorType() + " başarıyla satın alındı. Kalan Para Miktarınız : " + this.getPlayer().getMoney());
                        System.out.println("Önceki zırhınız :" + this.getPlayer().getInventory().getArmor().getArmorType());
                        this.getPlayer().getInventory().setArmor(armorList[1]);
                    } else {
                        System.out.println("Yeterli paranız yok. Lütfen daha fazla para kazanmak için savaş alanına dönünüz.");
                    }
                    break;
                case 3:
                    if (this.getPlayer().getMoney() >= armorList[2].getArmorPrice()) {
                        this.getPlayer().setMoney(this.getPlayer().getMoney() - armorList[2].getArmorPrice());
                        System.out.println(armorList[2].getArmorType() + " başarıyla satın alındı. Kalan Para Miktarınız : " + this.getPlayer().getMoney());
                        System.out.println("Önceki zırhınız :" + this.getPlayer().getInventory().getArmor().getArmorType());
                        this.getPlayer().getInventory().setArmor(armorList[2]);
                    } else {
                        System.out.println("Yeterli paranız yok. Lütfen daha fazla para kazanmak için savaş alanına dönünüz.");
                    }
                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız.");
                    break;
            }
        }else{
            System.out.println("Çıkış Yapılıyor ...");
        }


    }


}
