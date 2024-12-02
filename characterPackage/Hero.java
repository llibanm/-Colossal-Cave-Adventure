package characterPackage;

import item.Backpack;

public class Hero extends Character {

    private String heroName;
    private boolean heroDead;
    private Backpack currentBackpack;

    public Hero() {
        super();
        currentBackpack = new Backpack(50.0);
        heroDead = false;
        initStatHero();
    }

    public Backpack getBasicBackpack() {
        return this.currentBackpack;
    }

    public void initStatHero(){
        setLevel(1);
        setHp(10);
        setPower(5);
        setArmor(1);
        setMagicResistance(0);
    }

    @Override
    public void printStats() {
        System.out.println("Hero Name: " + heroName);
        super.printStats();
    }

    public boolean isHeroDead(){
        return getHp()==0;
    }

    public void setHeroDead(){
        heroDead=true;
    }

    public boolean getHeroDead(){
        return heroDead;
    }

    public void setHeroName(String name){
        heroName = name;
    }

    public String getHeroName(){
        return heroName;
    }

}
