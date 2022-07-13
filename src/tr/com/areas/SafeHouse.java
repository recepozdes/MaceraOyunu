package tr.com.areas;

import Main.Player;



public class SafeHouse extends NormalLocation{



    public SafeHouse(Player player){
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz. Canınız yenilendi !! ");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());

        if(this.getPlayer().getInventory().getAwardCount()==this.getPlayer().getInventory().getAwarList().size()){
            System.out.println();
            System.out.println("Tebrikler tüm ödülleri kazanarak güvenli eve ulaştınız.\nYeni macera alanları oyuna eklenene kadar kazanabileceğiniz ödül kalmadı.\nÇıkış yapılıyor ...");
            return false;
        }

        return true;
    }
    public void goToSafeHouse(){
        this.onLocation();
    }
}
