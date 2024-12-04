package characterPackage.Enemies;

import java.util.Random;
import characterPackage.EnumDamageType;

public class Werewolf extends Foes {


    private EnumFoes.FoesStatus foesStatus;

    private Random rand=new Random();

    public Werewolf(int status) {
        setFoe(EnumFoes.Foes.WEREWOLF);
        String n=switchName(status);
        setFoeName(n);
        switchStats();
        setDamageType(EnumDamageType.DamageType.PHYSICAL);

    }

    @Override
    public void printStats() {
        System.out.println("\n["+getFoeName()+"]");
        super.printStats();
    }

    @Override
    public void setStat(int level) {
        int power= (int)(getLevel()*2.5);

        setHp(getLevel()*5);
        setArmor(getLevel());
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
                random = 4+rand.nextInt(3);
                setLevel(random);
                setStat(getLevel());
                break;

            case ELITE:
                random = 7+rand.nextInt(3);
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
                res="LOWER WEREWOLF";
                foesStatus=EnumFoes.FoesStatus.LOWER;
                break;

            case 2:
                res="UPPER WEREWOLF";
                foesStatus=EnumFoes.FoesStatus.UPPER;
                break;

            case 3:
                res="ELITE WEREWOLF";
                foesStatus=EnumFoes.FoesStatus.ELITE;
                break;
            case 4:
                res="BOSS WEREWOLF";
                foesStatus=EnumFoes.FoesStatus.BOSS;
                break;
        }
        return res;
    }

   /* @Override
    public void SpecialAbility(){// power double
        multiplyPower(2);

    }*/


}
