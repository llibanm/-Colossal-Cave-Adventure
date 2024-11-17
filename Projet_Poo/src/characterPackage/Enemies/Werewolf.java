package characterPackage.Enemies;

import DamageTypePackage.EnumDamageType;
import characterPackage.Character;
import characterPackage.EnumFoes;

public class Werewolf extends Character {

    private static int powerupLasting;
    private EnumDamageType.DamageType damageType;
    private String foeName;
    private static EnumFoes.Foes DEFAULT_FOE= EnumFoes.Foes.WEREWOLF;
    private EnumFoes.FoesStatus foesStatus;

    public Werewolf(int status) {
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
    public void setStat(int level) {
        setHp(getLevel()*5);
        setArmor(getLevel());
        setPower(getLevel()*2);
        setMagicResistance(getLevel());
    }

    @Override
    public void switchStats(){// Werewolves have higher HP/ATK but lower armor/magic resist
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

    @Override
    public void SpecialAbility(){// their strength double for 3 turn
        multiplyPower(2);
        setPowerupLasting(3);
    }

    public void setPowerupLasting(int p){
        powerupLasting=p;
    }

    public void decreasePowerupLasting(){
        powerupLasting--;
    }
}
