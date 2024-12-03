package characterPackage.Enemies;

import characterPackage.EnumDamageType;

import java.util.Random;

public class Goblin extends Foes {

    private EnumFoes.FoesStatus foesStatus;

    private Random rand = new Random();

    public Goblin(int status) {
        setFoe(EnumFoes.Foes.GOBLIN);
        String s=switchName(status);
        switchStats();
        setDamageType(EnumDamageType.DamageType.PHYSICAL);
    }

    @Override
    public void printStats() {
        System.out.println("\n["+getFoeName()+"]");
        super.printStats();
    }

    @Override
    public void setStat(int p){
       int power= (int) (getLevel()*3.0);

        setHp(getLevel()*2);
        setArmor(getLevel()*3);
        setPower(power);
        setMagicResistance(getLevel());
    }

    @Override
    public void switchStats() {
        int random;
        switch(foesStatus){

            case LOWER :
                random = 1+rand.nextInt(3);
                setLevel(random);
                setStat(getLevel());
                break;

            case UPPER :
                random = 7+rand.nextInt(3);
                setLevel(random);
                setStat(getLevel());
                break;

            case ELITE:
                random = 7+(9-7)*rand.nextInt(3);
                setLevel(random);
                setStat(getLevel());
                break;

            case BOSS:
                setLevel(10);
                setStat(getLevel());
        }

    }

    @Override
    public String switchName(int s){
        String res=null;

        switch(s){
            case 1:
                res="LOWER GOBLIN";
                foesStatus=EnumFoes.FoesStatus.LOWER;
                break;

            case 2:
                res="UPPER GOBLIN";
                foesStatus=EnumFoes.FoesStatus.UPPER;
                break;

            case 3:
                res="ELITE GOBLIN";
                foesStatus=EnumFoes.FoesStatus.ELITE;
                break;
            case 4:
                res="BOSS GOBLIN";
                foesStatus=EnumFoes.FoesStatus.BOSS;
                break;
        }
        return res;
    }

   /* @Override
    public void SpecialAbility(){// attack twice

    }*/



}
