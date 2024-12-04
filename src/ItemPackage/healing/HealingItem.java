package ItemPackage.healing;

import ItemPackage.Item;
import characterPackage.Hero;

public class HealingItem extends Item {

    private final int healingAmount;

    public HealingItem(String nom, String description, double volume, int healingAmount) {
        super(nom, description, volume);
        this.healingAmount = healingAmount;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public boolean useHealingItem(Hero hero){
        int maxHp= hero.getMaxHp();
        int ammount_to_add=healingAmount;

        if(hero.getHp() == maxHp){
            System.out.println("HP is already full !");
            return false;
        }



        while(hero.getHp() < maxHp){

            if(ammount_to_add <= 0){
                break;
            }
            hero.increaseHp(1);
            ammount_to_add--;
        }


        return true;

    }

}
