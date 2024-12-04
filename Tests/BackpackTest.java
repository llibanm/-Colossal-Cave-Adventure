package Tests;

import ItemPackage.BackpackPackage.Backpack;
import ItemPackage.Item;
import ItemPackage.Key;
import ItemPackage.MeleeWeapon;
import ItemPackage.healing.HealingItem;
import characterPackage.EnumDamageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackpackTest {

    private Backpack backpack;
    private Item item1;
    private Item item2;

    @BeforeEach
    void setUp() {
        backpack = new Backpack(10.0); // Initialiser un sac à dos avec une capacité de 10.0

        // Simuler des objets Item
        item1 = new Key("Laptop", "A portable computer", 3.0,true,"1");
        item2 = new MeleeWeapon("Book", "A programming book", 2.0,false,4, EnumDamageType.DamageType.PHYSICAL ) {
        };
    }

    @Test
    void testAddItem() {
        backpack.addItem(item1);
        assertEquals(1, backpack.getNumberItems());
        assertEquals(3.0, backpack.getCapacity(), 0.001);
    }

    @Test
    void testAddItemOverCapacity() {
        Item heavyItem = new HealingItem("heal", "help to get more life", 30,5);
        backpack.addItem(heavyItem);
        assertEquals(0, backpack.getNumberItems()); // Aucun élément ajouté
    }

    @Test
    void testRemoveItem() {
        backpack.addItem(item1);
        backpack.removeItem(item1);
        assertEquals(0, backpack.getNumberItems());
    }

    @Test
    void testGetItemByName() {
        backpack.addItem(item1);
        backpack.addItem(item2);

        Item retrievedItem = backpack.getItem("Laptop");
        assertNotNull(retrievedItem);
        assertEquals("Laptop", retrievedItem.getNom());
    }

    @Test
    void testPrintItems() {
        backpack.addItem(item1);
        backpack.addItem(item2);

        backpack.printItems();
        // Vous pouvez vérifier les sorties console manuellement.
    }

    @Test
    void testLookIntoItem() {
        backpack.addItem(item1);
        backpack.lookIntoItem(item1);
        // Vous pouvez vérifier les sorties console manuellement.
    }
}
