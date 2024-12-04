package ItemPackage.meleeWeapon;


import ItemPackage.MeleeWeapon;

import characterPackage.EnumDamageType.DamageType;


public class RockyHammer extends MeleeWeapon {

    public RockyHammer() {
        super("Rocky-Hammer",
                "A low quality hammer, commonly used for manual labour by miners or blacksmith. Although not the best thing to defend oneself with."
        ,5.0,true,5, DamageType.PHYSICAL);
    }

}
