package characterPackage.Enemies;

import characterPackage.Character;

public abstract class Foes extends Character {

    public abstract void SpecialAbility();
    public abstract void setStat(int level);
    public abstract String switchName(int s);
    public abstract void switchStats();

}
