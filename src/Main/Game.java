package Main;

import tr.com.areas.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {


    private Scanner input = new Scanner(System.in);

    //oyunun başlaması için metot oluşturuldu.
    public void basla() {
        System.out.println("Macera Oyununa Hoşgeldiniz");
        System.out.print("Lütfen Avatar İsminizi Giriniz :");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " macera oyununa hoşgeldin");
        System.out.println("**********************************");
        System.out.println("Karakter Özellikleri Listeleniyor");
        player.selectCharacter();
        Location location = null;
        selectLocation(player, location); //hangi bölgelere gitmek istediğini seçme metodu çağırıldı.

    }

    //oyuncu bir bölgenin ödülünü kazanmışsa tekrar o bölgeye girmemesi için ayrı bir metot oluşturuldu.
    public void selectLocation(Player player, Location location) {

        while (true) {

            player.printPlayerInfo();
            System.out.println("**********************");
            System.out.println("Bölgeler Listeleniyor");
            System.out.println("1 - Güvenli Ev \n2 - Eşya Dükkanı \n3 - Mağara \n4 - Orman \n5 - Nehir \n6 - Maden");
            System.out.println("0 - Oyunu Sonlandır");
            System.out.println("**********************");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectedLocation = input.nextInt(); //bölge seçimi kullanıcıdan alındı.
            while (selectedLocation < 0 || selectedLocation > 6) {
                System.out.println("Lütfen geçerli bir bölge seçiniz : ");
                selectedLocation = input.nextInt();
            } // kullanıcıdan alınan değer kontrol edildi.
            switch (selectedLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    System.out.println("Güvenli Ev seçtiniz.");
                    System.out.println("-------------------------------------------------");
                    location = new SafeHouse(player);
                    break;
                case 2:
                    System.out.println("Eşya Dükkanı seçtiniz.");
                    System.out.println("-------------------------------------------------");
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (player.getInventory().getAwarList().contains("Yemek") != true) {           //ilgili bölge daha önceden kazanılmışsa tekrar bölgeye girişin engellenmesi oluşturuldu.
                        System.out.println("Mağara seçtiniz. Mağara bölgesine giriş yapılıyor");
                        System.out.println("-------------------------------------------------");
                        location = new Cave(player);
                    } else {
                        System.out.println("Mağara bölgesini daha önce tamamladınız lütfen başka bölgeye gidiniz");
                        selectLocation(player, location);
                        break;
                    }
                    break;
                case 4:
                    if (player.getInventory().getAwarList().contains("Odun") != true) {         //ilgili bölge daha önceden kazanılmışsa tekrar bölgeye girişin engellenmesi oluşturuldu.
                        System.out.println("Orman seçtiniz. Orman bölgesine giriş yapılıyor");
                        System.out.println("-------------------------------------------------");
                        location = new Forest(player);
                    } else {
                        System.out.println("Orman bölgesini daha önce tamamladınız lütfen başka bölgeye gidiniz");
                        selectLocation(player, location);

                    }

                    break;
                case 5:
                    if (player.getInventory().getAwarList().contains("Su") != true) {              //ilgili bölge daha önceden kazanılmışsa tekrar bölgeye girişin engellenmesi oluşturuldu.
                        System.out.println("Nehir seçtiniz. Nehir bölgesine giriş yapılıyor");
                        System.out.println("-------------------------------------------------");
                        location = new River(player);
                    } else {
                        System.out.println("Nehir bölgesini daha önce tamamladınız lütfen başka bölgeye gidiniz");
                        selectLocation(player, location);

                    }
                    break;
                case 6:
                        if (player.getInventory().getAwarList().contains("Gold") != true) {              //ilgili bölge daha önceden kazanılmışsa tekrar bölgeye girişin engellenmesi oluşturuldu.
                            System.out.println("Maden seçtiniz. Maden bölgesine giriş yapılıyor");
                            System.out.println("-------------------------------------------------");
                            location = new Mine(player,-5);
                        } else {
                            System.out.println("Maden bölgesini daha önce tamamladınız lütfen başka bölgeye gidiniz");
                            selectLocation(player,location);

                        }

                    break;
                default:
                    System.out.println("Güvenli Evdesiniz.");
                    System.out.println("-------------------------------------------------");
                    location = new SafeHouse(player);
                    break;
            }
            //bölge seçimine göre ilgili bölgelerin locationları oluşturuldu.

            if (location == null) {

                System.out.println("Oyun Bitti Tekrar Görüşmek Üzere");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("Oyun Bitti Tekrar Görüşmek Üzere");
                break;
            }

        }

    }


}
