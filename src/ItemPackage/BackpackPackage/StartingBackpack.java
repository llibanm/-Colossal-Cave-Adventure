package ItemPackage.BackpackPackage;

import ItemPackage.healing.bandAid;
import ItemPackage.meleeWeapon.RockyHammer;

public class StartingBackpack extends Backpack {

    public StartingBackpack() {
        super(50.0);
        addItem(new RockyHammer());
        addItem(new bandAid());
        addItem(new bandAid());
        addItem(new bandAid());
    }
}
