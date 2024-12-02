package characterPackage.Enemies;

import characterPackage.EnumDamageType;

import java.util.Random;

public class Blob extends Foes {

    private EnumDamageType.DamageType damageType;
    private String foeName;
    private static EnumFoes.Foes DEFAULT_FOE= EnumFoes.Foes.BLOB;
    private EnumFoes.FoesStatus foesStatus;

    private static int maxHp;

    Random rand = new Random();
    //special ability



    public Blob(int status) {
        foeName=switchName(status);
        switchStats();
        damageType= EnumDamageType.DamageType.MAGIC;
        maxHp=getHp();
    }


    @Override
    public void switchStats() {
        int random;
        switch(foesStatus){

            case LOWER :
                random =1+rand.nextInt(3);
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
                res="LOWER BLOB";
                foesStatus=EnumFoes.FoesStatus.LOWER;
                break;

            case 2:
                res="UPPER BLOB";
                foesStatus=EnumFoes.FoesStatus.UPPER;
                break;

            case 3:
                res="ELITE BLOB";
                foesStatus=EnumFoes.FoesStatus.ELITE;
                break;
            case 4:
                res="BOSS BLOB";
                foesStatus=EnumFoes.FoesStatus.BOSS;
                break;
        }
        return res;
    }

    @Override
    public void printStats() {
        System.out.println("\n["+foeName+"]");
        super.printStats();
    }

    @Override
    public void setStat(int p){
        int armor=(int)(getLevel()*1.5);

        setHp(getLevel()*7);
        setPower(getLevel());
        setArmor(armor);
        setMagicResistance(getLevel()*7);
    }


    public boolean checkIfHpInf30(){

        int percentage_hp_below_30=(getHp()*100)/maxHp;

        if(percentage_hp_below_30<=30){
            return true;
        }
        return false;
    }



    @Override
    public void SpecialAbility() {// will regenerate HP based of his Magic resist for 2 turns when Hp <=30%
        //int percentage_hp_below_30=(getHp()*100)/maxHp;
        int regenPerTurnPercentage=getMagicResistance()/2; // regen will be half of MR
        int regenPerTurn=(100+regenPerTurnPercentage)/100; // percentage of regen
        int regenHp=getHp()*regenPerTurn; //get newer hp amount*/

        if(checkIfHpInf30())
            if(regenHp>maxHp){
                increaseHp(regenHp-maxHp);
            } else{
                increaseHp(getHp());}




    }
}
