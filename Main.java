import DamageTypePackage.EnumDamageType;
import ItemPackage.WeaponPackagge.EnumWeapon;
import ItemPackage.WeaponPackagge.Weapons;
import characterPackage.Enemies.*;
import characterPackage.Hero;

public class Main {
    public static void main(String[] args) {

        Hero hero = new Hero();
        hero.setHeroName("Liban");
        hero.printStats();

        Weapons weapon=new Weapons("epee",10.0,"Epee enchantée", EnumWeapon.WeaponType.SWORD, EnumDamageType.DamageType.MAGIC,10);

        hero.getBasicBackpack().addItem(weapon);
        hero.getBasicBackpack().lookIntoItem(weapon);
        hero.getBasicBackpack().removeItem(weapon);
        hero=null;



    }
}