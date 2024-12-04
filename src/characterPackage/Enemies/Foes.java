package characterPackage.Enemies;

import characterPackage.EnumDamageType;
import characterPackage.Character;
import characterPackage.Hero;


public abstract class Foes extends Character {

    private String foeName;
    private EnumFoes.Foes foe;
    private EnumDamageType.DamageType damageType;

    public void setFoe(EnumFoes.Foes foe) {
        this.foe = foe;
    }

    public void setDamageType(EnumDamageType.DamageType damageType) {
        this.damageType = damageType;
    }

    public EnumDamageType.DamageType getDamageType() {
        return damageType;
    }

    public boolean isDamageTypePhy(){
        return getDamageType().equals(EnumDamageType.DamageType.PHYSICAL);
    }

    public boolean isDamageTypeMag(){
        return getDamageType().equals(EnumDamageType.DamageType.MAGIC);
    }

    public EnumFoes.Foes getFoe() {
        return foe;
    }

    public void setFoeName(String foeName) {
        this.foeName = foeName;
    }

    public String getFoeName() {
        return foeName;
    }
    // attack hero

    public void attackFoes(Hero hero) {

        double percentageOfTotalDamage;
        int damageDealt;

        if(isDamageTypePhy()){

            int getArmor = hero.getArmor();// get armor

            percentageOfTotalDamage= (double) (100 - getArmor) /100;
            damageDealt= (int)(percentageOfTotalDamage * getPower());// damage will be reduced by a percentage magic/armor
            hero.lowerHp(damageDealt);// lower hp by the respective damage dealt

            printDamageDealt(damageDealt,getDamageType()," you");

        }
        else{

            int getMagicResistance = hero.getMagicResistance();// get magic resist

            percentageOfTotalDamage= (double) (100 - getMagicResistance) /100;
            damageDealt= (int)(percentageOfTotalDamage * getPower());// damage will be reduced by a percentage magic/armor
            hero.lowerHp(damageDealt);// lower hp by the respective damage dealt

            printDamageDealt(damageDealt,getDamageType()," you");


        }

    }


   // public abstract void SpecialAbility();
    public abstract void setStat(int level);
    public abstract String switchName(int s);
    public abstract void switchStats();

}
