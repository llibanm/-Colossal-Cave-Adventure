package ItemPackage.Item.BackpackPackage;

import ItemPackage.Item.healing.bandAid;
import ItemPackage.Item.meleeWeapon.RockyHammer;

public class StartingBackpack extends Backpack {

    public StartingBackpack() {
        super(50.0);
        addItem(new RockyHammer());
        addItem(new bandAid());
        addItem(new bandAid());
        addItem(new bandAid());
    }
}
