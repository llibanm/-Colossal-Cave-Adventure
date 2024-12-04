package characterPackage;

public abstract class Character {
    //stats
    private int level;
    private int hp;
    private int armor;
    private int power;
    private int magicResistance;
    //name



    // getter/setter/increase

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setMagicResistance(int magicResistance) {
        this.magicResistance = magicResistance;
    }

    public int getLevel() {
        return level;
    }

    public void increaseLevel() {
        level++;
    }


    public int getHp(){
        return hp;
    }

    public int getArmor() {
        return armor;
    }

    public int getMagicResistance() {
        return magicResistance;
    }

    public int getPower() {
        return power;
    }


    public void increaseHp(int amount) {
            this.hp+=amount;
    }

    public void lowerHp(int amount) {
        this.hp-=amount;
    }

    public void increaseArmor(int amount) {
        this.armor+=amount;
    }

    public void lowerArmor(int amount) {
        this.armor-=amount;
    }

    public void increasePower(int amount) {
        this.power+=amount;
    }

    public void lowerPower(int amount) {
        this.power-=amount;
    }

    public void multiplyPower(int amount) {
        this.power*=amount;
    }

    public void increaseMagicResistance(int amount) {
        this.magicResistance+=amount;
    }

    public void lowerMagicResistance(int amount) {
        this.magicResistance-=amount;
    }

    public void printStats() {
        System.out.println("\nLevel : " + " ["+getLevel()+"] \n" +
                           "Health : " + "["+getHp()+"]\n"+
                           "Power : " + " ["+getPower()+"]\n"+
                           "Armor : " + " ["+getArmor()+"]\n"+
                           "Magic resist :" + "["+getMagicResistance()+"]\n");
    }

    public void printDamageDealt(int amount, EnumDamageType.DamageType damageType,String source) {
        System.out.println("["+amount+"] of ["+damageType+"] damage have been dealt to ["+source+"]" );
    }





}
