package characterPackage;

import ItemPackage.BackpackPackage.Backpack;
import ItemPackage.BackpackPackage.StartingBackpack;
import ItemPackage.Weapon;
import ItemPackage.Item;
import characterPackage.Enemies.Foes;

public class Hero extends Character {


    private boolean heroDead;
    private Backpack currentBackpack;
    private Weapon equippedWeapon;
    private String heroName;

    private int maxHp;

    public Hero() {
        super();
        currentBackpack = new StartingBackpack();
        heroDead = false;
        initStatHero();
        setEquippedWeapon(getStartingWeapon());
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void increaseMaxHp(int amount) {
        maxHp += amount;
    }

    public int getMaxHp() {
        return maxHp;
    }

   // equiped weapon
    public Weapon getStartingWeapon(){
        return (Weapon)getCurrentBackpack().getItem("Rocky-Hammer");
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public int getCumulativeDamage(){
        return getPower()+ getEquippedWeapon().getDegats();
    }

    public boolean isDamageTypePhy(){
        return getEquippedWeapon().getDamageType().equals(EnumDamageType.DamageType.PHYSICAL);
    }

    public boolean isDamageTypeMag(){
        return getEquippedWeapon().getDamageType().equals(EnumDamageType.DamageType.MAGIC);
    }

    public boolean isDamageTypeTru(){
        return getEquippedWeapon().getDamageType().equals(EnumDamageType.DamageType.TRUE_DAMAGE);
    }

    //
    public Backpack getCurrentBackpack() {
        return this.currentBackpack;
    }

    public void changeBackpack(Backpack newBackpack) {
        this.currentBackpack = newBackpack;
    }

    public Boolean isItemInBackpack(Item item) {
        for(int i=0;i<getCurrentBackpack().getNumberItems();i++){
            if( getCurrentBackpack().getItem(i).equals(item)){
                return true;
            }
        }
        return false;
    }



    public void initStatHero(){
        setLevel(1);
        setMaxHp(10);
        setHp(10);
        setPower(5);
        setArmor(1);
        setMagicResistance(0);
    }

    @Override
    public void printStats() {
        System.out.println("Hero Name: " + getHeroName());
        super.printStats();
    }
    //

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
    public String getHeroName() {
        return heroName;
    }

    public boolean isHeroDead(){
        return getHp()<=0;
    }

    public void setHeroDead(){
        heroDead=true;
    }

    public boolean getHeroDead(){
        return heroDead;
    }


    public void printHeroName(){
        System.out.println("Your Hero Name is : " + this.getHeroName());
    }
    // attack mechanics

    public void attackHero(Foes f){
        double percentageOfTotalDamage;
        int damageDealt;
        switch (getEquippedWeapon().getDamageType()){

        case MAGIC:

            int getMagicResistance = f.getMagicResistance();// get magic resist
            percentageOfTotalDamage= (double) (100 - getMagicResistance) /100;
            damageDealt= (int)(percentageOfTotalDamage * getCumulativeDamage());// damage will be reduced by a percentage magic/armor
            f.lowerHp(damageDealt);// lower hp by the respective damage dealt

            printDamageDealt(damageDealt, getEquippedWeapon().getDamageType(),f.getFoeName());// print damage dealt

            break;

        case PHYSICAL:

            int getArmor = f.getArmor();// get armor
            percentageOfTotalDamage = (double) (100 - getArmor) / 100;//
            damageDealt= (int)(percentageOfTotalDamage * getCumulativeDamage());
            f.lowerHp(damageDealt);

            printDamageDealt(damageDealt, getEquippedWeapon().getDamageType(),f.getFoeName());

            break;

        case TRUE_DAMAGE:// no need to calculate percentage, the total damage ignore amor/magic resit
            damageDealt= getCumulativeDamage();
            f.lowerHp(damageDealt);

            printDamageDealt(damageDealt, getEquippedWeapon().getDamageType(),f.getFoeName());
            break;
    }


    }

}
