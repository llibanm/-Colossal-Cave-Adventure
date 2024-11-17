package characterPackage.Enemies;

import DamageTypePackage.EnumDamageType;
import characterPackage.Character;
import characterPackage.EnumFoes;

import java.lang.reflect.GenericArrayType;

public class Goblin extends Character {

    private EnumDamageType.DamageType damageType;
    private String foeName;
    private static EnumFoes.Foes DEFAULT_FOE= EnumFoes.Foes.GOBLIN;
    private EnumFoes.FoesStatus foesStatus;

    public Goblin(int status) {
        foeName=switchName(status);
        switchStats();
        damageType= EnumDamageType.DamageType.PHYSICAL;
    }

    @Override
    public void printStats() {
        System.out.println("\n["+foeName+"]");
        super.printStats();
    }

    @Override
    public void setStat(int p){
       int power= (int) (getLevel()*3.5);

        setLevel(p);
        setHp(getLevel()*2);
        setArmor(getLevel()*3);
        setPower(power);
        setMagicResistance(getLevel());
    }

    @Override
    public void switchStats(){// Higher atk/armor, lower hp/magic resist | damageType : Physical
        switch(foesStatus){

            case LOWER :
                setLevel(1);
                setStat(getLevel());
                break;

            case UPPER :
                setLevel(4);
                setStat(getLevel());
                break;

            case ELITE:
                setLevel(7);
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
                res="LOWER GOBELIN";
                foesStatus=EnumFoes.FoesStatus.LOWER;
                break;

            case 2:
                res="UPPER GOBELIN";
                foesStatus=EnumFoes.FoesStatus.UPPER;
                break;

            case 3:
                res="ELITE GOBELIN";
                foesStatus=EnumFoes.FoesStatus.ELITE;
                break;
            case 4:
                res="BOSS GOBELIN";
                foesStatus=EnumFoes.FoesStatus.BOSS;
                break;
        }
        return res;
    }

    @Override
    public void SpecialAbility(){

    }



}
