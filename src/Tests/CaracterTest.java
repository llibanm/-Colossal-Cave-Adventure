package Tests;

import characterPackage.EnumDamageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import characterPackage.Character;



import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    // Classe concrète pour tester la classe abstraite Character
    static class TestCharacter extends Character {
        // Implémentation fictive si nécessaire
    }

    private Character character;

    @BeforeEach
    void setUp() {
        character = new TestCharacter();
        character.setLevel(1);
        character.setHp(100);
        character.setArmor(50);
        character.setPower(20);
        character.setMagicResistance(30);
    }

    @Test
    void testInitialStats() {
        assertEquals(1, character.getLevel());
        assertEquals(100, character.getHp());
        assertEquals(50, character.getArmor());
        assertEquals(20, character.getPower());
        assertEquals(30, character.getMagicResistance());
    }

    @Test
    void testIncreaseStats() {
        character.increaseLevel();
        assertEquals(2, character.getLevel());

        character.increaseHp(10);
        assertEquals(110, character.getHp());

        character.increaseArmor(5);
        assertEquals(55, character.getArmor());

        character.increasePower(15);
        assertEquals(35, character.getPower());

        character.increaseMagicResistance(10);
        assertEquals(40, character.getMagicResistance());
    }

    @Test
    void testLowerStats() {
        character.lowerHp(20);
        assertEquals(80, character.getHp());

        character.lowerArmor(10);
        assertEquals(40, character.getArmor());

        character.lowerPower(5);
        assertEquals(15, character.getPower());

        character.lowerMagicResistance(5);
        assertEquals(25, character.getMagicResistance());
    }

    @Test
    void testMultiplyPower() {
        character.multiplyPower(2);
        assertEquals(40, character.getPower());
    }

    @Test
    void testPrintStats() {
        // Simple appel pour vérifier qu'il n'y a pas d'exception
        character.printStats();
    }

    @Test
    void testPrintDamageDealt() {
        // Simple appel pour vérifier qu'il n'y a pas d'exception
        character.printDamageDealt(50, EnumDamageType.DamageType.PHYSICAL, "Enemy");
    }
}
