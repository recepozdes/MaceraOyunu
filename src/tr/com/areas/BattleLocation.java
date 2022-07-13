package tr.com.areas;

import Main.Game;
import Main.Inventory;
import Main.Player;
import Monsters.Monsters;
import Weapons.Rifle;
import Weapons.Weapons;
import Armor.Armor;

import java.util.Locale;
import java.util.Random;


public abstract class BattleLocation extends Location {
    private Monsters monster;
    public String award;
    Game game;
    Inventory inventory;
    Location location;
    SafeHouse safeHouse;
    int possibility;

    Random random = new Random();

    public BattleLocation(Player player, String name, Monsters monster, String award) {
        super(player, name);
        this.monster = monster;
        this.award = award;

    }


    @Override
    public boolean onLocation() {

        System.out.println("Şuanda " + this.getName() + " bölgesindesiniz .");
        System.out.println(this.getName() + " bölgesinde dikkatli olmalısın burada " + this.monster.getMonsterType() + " türünde canavarlar karşına çıkabilir.");
        int monsterNumber = monsterNumber();
        System.out.println("Dikkat et ve saldırıya hazırlan karşında " + monsterNumber + " tane " + this.monster.getMonsterType() + " canavarı var.");
        System.out.println("Savaşmak için S ya da kaçmak için K harfine basınız.");
        String selected = scanner.nextLine();
        selected = selected.toUpperCase();

        if (selected.equals("S")) {
            System.out.println("Savaş için oyuncu ve canavar bilgileri hazırlanıyor.");
            battle(monsterNumber);
        } else {
            System.out.println("Savaş alanından kaçtığına göre yeterli malzemen ya da gücün yok. Bence mağazaya gidip yeteneklerini geliştirmeli ve tekrar savaş alanına dönmelisin");

        }

        return true;
    }

    public int monsterNumber() {

        Random random = new Random();
        if (this.getMonster().getMonsterType().equals("Yılan")) {
            return random.nextInt(5) + 1;
        } else {
            return random.nextInt(3) + 1;
        }

    }

    public void battle(int monsterNumber) {

        int remainingMonsterCount = monsterNumber;
        int health = this.monster.getMonsterHealth();
        for (int i = 0; i < monsterNumber; i++) {
            this.getMonster().setMonsterHealth(health);
            playerStatus();
            monsterStatus();


            while (this.getPlayer().getHealth() > 0 && this.getMonster().getMonsterHealth() > 0) {
                System.out.println("Savaş başlıyor...");
                System.out.println("Savaşmak için S Kaçmak için K harfine basınız.");
                String selected = scanner.nextLine();
                selected = selected.toUpperCase();
                if (selected.equals("S")) {
                    System.out.println("Savaşa Hazırlan");
                    int whoHit = whoFightFirst();
                    if (whoHit == 1) {
                        if (this.getMonster().getMonsterHealth() > 0) {
                            this.getMonster().setMonsterHealth(this.getMonster().getMonsterHealth() - this.getPlayer().getTotalDamage());
                            if(this.getMonster().getMonsterHealth()<0){
                                this.getMonster().setMonsterHealth(0);
                            }
                            System.out.println("Vuruşunuz sonucu canavarın kalan canı : " + this.getMonster().getMonsterHealth());
                            if (this.getMonster().getMonsterHealth() <= 0) {
                                remainingMonsterCount--;
                                this.getMonster().setMonsterHealth(0);
                                if (this.getMonster().getMonsterType().equals("Yılan")) {
                                    System.out.println("******* CANAVAR ÖLDÜRME SONUCU KAZANILAN ÖDÜL BİLGİSİ *******");
                                    rewardGenerator();

                                }
                                this.getMonster().setMonsterHealth(0);
                                System.out.println("Tebrikler " + (i + 1) + "'nci " + this.getMonster().getMonsterType() + " canavarını öldürdünüz. Geriye " + remainingMonsterCount + " adet kaldı");
                                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getMonsterReward());
                            }

                        }
                        if (this.getPlayer().getHealth() > 0) {//canavar ölmüşmü kontrol et ona göre playerın canını azalt
                            if (this.getMonster().getMonsterHealth() != 0) {
                                int monsterDamage = this.getMonster().getMonsterDamage() - this.getPlayer().getInventory().getArmor().getArmorBlock();
                                if (monsterDamage < 0) {
                                    monsterDamage = 0;
                                }
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                                System.out.println("Canavar vuruşu sonucu karakterin kalan canı : " + this.getPlayer().getHealth());
                            }

                            if (this.getPlayer().getHealth() <= 0) {
                                this.getPlayer().setHealth(0);
                                System.out.println("Maalesef Öldünüz Çıkış Yapılıyor. Yeniden Görüşmek Üzere");
                                System.exit(0);
                                break;
                            }

                        }

                    } else {
                        if (this.getPlayer().getHealth() > 0) {
                            int monsterDamage = this.getMonster().getMonsterDamage() - this.getPlayer().getInventory().getArmor().getArmorBlock();
                            if (monsterDamage < 0) {
                                monsterDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                            System.out.println("Canavar vuruşu sonucu karakterin kalan canı : " + this.getPlayer().getHealth());
                            if (this.getPlayer().getHealth() <= 0) {
                                this.getPlayer().setHealth(0);
                                System.out.println("Maalesef Öldünüz Çıkış Yapılıyor. Yeniden Görüşmek Üzere");
                            }

                        }
                        if (this.getMonster().getMonsterHealth() > 0) {
                            this.getMonster().setMonsterHealth(this.getMonster().getMonsterHealth() - this.getPlayer().getTotalDamage());
                            if(this.getMonster().getMonsterHealth()<0){
                                this.getMonster().setMonsterHealth(0);
                            }
                            System.out.println("Vuruşunuz sonucu canavarın kalan canı : " + this.getMonster().getMonsterHealth());
                            if (this.getMonster().getMonsterHealth() <= 0) {
                                remainingMonsterCount--;
                                this.getMonster().setMonsterHealth(0);
                                if (this.getMonster().getMonsterType().equals("Yılan")) {
                                    System.out.println("******* CANAVAR ÖLDÜRME SONUCU KAZANILAN ÖDÜL BİLGİSİ *******");
                                    rewardGenerator();

                                }
                                System.out.println("Tebrikler " + (i + 1) + "'nci " + this.getMonster().getMonsterType() + " canavarını öldürdünüz. Geriye " + remainingMonsterCount + " adet kaldı");

                                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getMonsterReward());
                            }

                        }
                    }
                    System.out.println("***************************");
//                    playerStatus();
//                    monsterStatus();
                } else {
                    System.out.println("Savaş alanından kaçtığına göre yeterli malzemen ya da gücün yok. Bence mağazaya gidip yeteneklerini geliştirmeli ve tekrar savaş alanına dönmelisin");
                    break;
                }
            }

            if (remainingMonsterCount == 0 && this.getPlayer().getHealth() > 0) {
                if(this.award=="Gold"){
                    System.out.println("Tebrikler  " + this.getName() + " bölgesini canavarlardan temizlediniz. Canınızı yenilemek için lütfen güvenli eve gidiniz. \nYa da birşeyler satın almak için eşya dükkanını ziyaret ediniz");
                }else {
                    System.out.println("Tebrikler  " + this.getName() + " bölgesini canavarlardan temizlediniz." + "\n" + this.award + " ödülünü kazandınız. Canınızı yenilemek için lütfen güvenli eve gidiniz. \nYa da birşeyler satın almak için eşya dükkanını ziyaret ediniz");
                }


                this.getPlayer().getInventory().addAwardList(this.award);
                if (this.getPlayer().getInventory().getAwarList().size() == this.getPlayer().getInventory().getAwardCount()) {
                    System.out.println("Tebrikler tüm bölgeleri canavarlardan temizlediniz. Oyunu kazandınız. Lütfen Güvenli eve gidiniz...");

                    break;
                }

                //System.out.println(this.getPlayer().getInventory().getAwarList());


            } else if (this.getPlayer().getHealth() == 0) {
                System.out.println("Maalesef Öldünüz Çıkış Yapılıyor. Yeniden Görüşmek Üzere");
                System.exit(0);
            }

        }


    }

    public void playerStatus() {
        System.out.println("Mevcut Oyuncu Değerleri Yazdırılıyor");
        System.out.println("---------------------------------------");
        System.out.println("Sağlığınız : " + this.getPlayer().getHealth());
        if (this.getPlayer().getInventory().getWeapons().getWeaponDamage() > 0) {
            System.out.println("Silahınız : " + this.getPlayer().getInventory().getWeapons().getWeaponType());
        } else {
            System.out.println("Silahınız : Yumruk");
        }
        if (this.getPlayer().getInventory().getArmor().getArmorBlock() > 0) {
            System.out.println("Zırhınız : " + this.getPlayer().getInventory().getArmor().getArmorType());
        } else {
            System.out.println("Zırhınız : Giysi");
        }
        System.out.println("Hasarınız : " + this.getPlayer().getTotalDamage());
        System.out.println("Paranız : " + this.getPlayer().getMoney());


    }

    public void monsterStatus() {
        System.out.println("---------------------------------------");
        System.out.println("Mevcut Canavar Değerleri Yazdırılıyor");
        System.out.println("---------------------------------------");
        System.out.println("Canavar Türü : " + this.getMonster().getMonsterType());
        System.out.println("Canavar Sağlığı : " + this.getMonster().getMonsterHealth());
        System.out.println("Canavar Hasar Değeri : " + this.getMonster().getMonsterDamage());
        System.out.println("Canavardan kazanılacak para miktarı : " + this.getMonster().getMonsterReward());
        ;

    }

    public int whoFightFirst() {
        Random random = new Random();
        int value = random.nextInt(2);
        if (value % 2 == 0) {
            System.out.println("Oyuncu Saldırıyor");
            return 1;
        } else {
            System.out.println("Canavar saldırıyor");
            return 2;
        }

    }

    public Monsters getMonster() {
        return monster;
    }

    public void rewardGenerator() {
        possibility = (int) (Math.random() * 100);
        if (possibility >= 0 && possibility < 15) {
            System.out.println("Silah kazanma ihtimali olumlu");
            weaponReward();
        }
        if (possibility >= 15 && possibility < 30) {
            System.out.println("Zırh kazanma ihtimali olumlu");
            armorReward();
        }

        if (possibility >= 30 && possibility < 55) {
            System.out.println("Para kazanma ihtimali olumlu");
            moneyReward();
        }

        if (possibility >= 55 && possibility < 100) {

            noReward();
        }
    }

    public void weaponReward() {
        possibility = (int) (Math.random() * 100);

        if (possibility >= 0 && possibility < 20) {
            if (this.getPlayer().getInventory().getWeapons().getWeaponType() != "Rifle") {
                System.out.println("Çok Şanslısın Tüfek kazandınız");
                this.getPlayer().getInventory().setWeapons(new Weapons("Rifle", 3, 7, 45));
                System.out.println("Yeni silahiniz " + this.getPlayer().getInventory().getWeapons().getWeaponType());
            } else {
                System.out.println("Canavarı öldürmen sonucu tüfek kazanmıştın ama envanterinde zaten tüfek var");
            }

        }
        if (possibility >= 20 && possibility < 50) {
            if (this.getPlayer().getInventory().getWeapons().getWeaponType() == "Rifle") {
                System.out.println("Kılıç kazandın ama envanterinde eşdeğer ya da daha güçlü bir silah mevcut");
            } else if (this.getPlayer().getInventory().getWeapons().getWeaponType() != "Sword") {
                System.out.println("Çok Şanslısın Kılıç kazandınız");
                this.getPlayer().getInventory().setWeapons(new Weapons("Sword", 2, 3, 35));
                System.out.println("Yeni silahiniz " + this.getPlayer().getInventory().getWeapons().getWeaponType());
            }

        }
        if (possibility >= 50 && possibility < 100) {
            if (this.getPlayer().getInventory().getWeapons().getWeaponType() == "Rifle" || this.getPlayer().getInventory().getWeapons().getWeaponType() == "Sword") {
                System.out.println("Tabanca kazandın ama envanterinde eşdeğer ya da daha güçlü bir silah mevcut");
            } else if (this.getPlayer().getInventory().getWeapons().getWeaponType() != "Gun") {
                System.out.println("Çok Şanslısın Tabanca kazandınız");
                this.getPlayer().getInventory().setWeapons(new Weapons("Gun", 1, 2, 25));
                System.out.println("Yeni silahiniz " + this.getPlayer().getInventory().getWeapons().getWeaponType());
            }

        }
    }

    public void armorReward() {
        possibility = (int) (Math.random() * 100);
        if (possibility >= 0 && possibility < 20) {
            if (this.getPlayer().getInventory().getArmor().getArmorType() != "Ağır Zırh") {
                System.out.println("Çok Şanslısın Ağır Zırh kazandınız");
                this.getPlayer().getInventory().setArmor(new Armor("Ağır Zırh", 3, 5, 40));
                System.out.println("Yeni zırhınız " + this.getPlayer().getInventory().getArmor().getArmorType());
            } else {
                System.out.println("Canavarı öldürmen sonucu ağır zırh kazanmıştın ama envanterinde zaten ağır zırh var");
            }

        }
        if (possibility >= 20 && possibility < 50) {
            if (this.getPlayer().getInventory().getArmor().getArmorType() == "Ağır Zırh") {
                System.out.println("Orta zırh kazandın ama envanterinde eşdeğer ya da daha güçlü bir zırh mevcut. Mevcut zırh kullanılıyor");
            } else if (this.getPlayer().getInventory().getArmor().getArmorType() != "Orta Zırh") {
                System.out.println("Çok Şanslısın Orta Zırh kazandınız");
                this.getPlayer().getInventory().setArmor(new Armor("Orta Zırh", 2, 3, 25));
                System.out.println("Yeni zırhınız " + this.getPlayer().getInventory().getArmor().getArmorType());
            }
        }
        if (possibility >= 50 && possibility < 100) {
            if (this.getPlayer().getInventory().getArmor().getArmorType() == "Ağır Zırh" || this.getPlayer().getInventory().getArmor().getArmorType() == "Orta Zırh") {
                System.out.println("Hafif zırh kazandın ama envanterinde eşdeğer ya da daha güçlü bir zırh mevcut. Mevcut zırh kullanılıyor");
            } else if (this.getPlayer().getInventory().getArmor().getArmorType() != "Hafif Zırh") {
                System.out.println("Çok Şanslısın Hafif Zırh kazandınız");
                this.getPlayer().getInventory().setArmor(new Armor("Hafif Zırh", 1, 1, 15));
                System.out.println("Yeni zırhınız " + this.getPlayer().getInventory().getArmor().getArmorType());
            }

        }
    }

    public void moneyReward() {
        possibility = (int) (Math.random() * 100);
        if (possibility >= 0 && possibility < 20) {
            System.out.println("Çok Şanslısın 10 Para kazandınız");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
        }
        if (possibility >= 20 && possibility < 50) {
            System.out.println("Çok Şanslısın 5 Para kazandınız");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
        }
        if (possibility >= 50 && possibility < 100) {
            System.out.println("Çok Şanslısın 1 Para kazandınız");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
        }
    }

    public void noReward() {
        System.out.println("Üzgünüm maalesef herhangi bir ödül kazanamadınız");
    }

    public void setMonster(Monsters monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}

