package ItemPackage.WeaponPackagge;
import DamageTypePackage.*;
import ItemPackage.Item;

public class Weapons extends Item {

    private EnumDamageType.DamageType damageType;
    private EnumWeapon.WeaponType WeaponType;

    private int damage;

    public Weapons(String nom, double poids,String description,EnumWeapon.WeaponType weaponType,EnumDamageType.DamageType type, int damage) {
        super(nom,poids,description);
        this.WeaponType=weaponType;
        this.damageType=type;
        this.damage=damage;
    }


    @Override
    public void use() {
        super.printUsageItem();
    }
}
