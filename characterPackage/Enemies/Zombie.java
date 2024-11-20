package characterPackage.Enemies;
import java.util.Random;
import DamageTypePackage.EnumDamageType;
import characterPackage.Character;
import characterPackage.EnumFoes;
public class Zombie extends Character {

    private EnumDamageType.DamageType damageType;
    private String foeName;
    private static EnumFoes.Foes DEFAULT_FOE= EnumFoes.Foes.WEREWOLF;
    private EnumFoes.FoesStatus foesStatus;

    private Random rand = new Random();
    public Zombie(int status){
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
    public String switchName(int s) {
        String res=null;

        switch(s){
            case 1:
                res="LOWER ZOMBIE";
                foesStatus=EnumFoes.FoesStatus.LOWER;
                break;

            case 2:
                res="UPPER ZOMBIE";
                foesStatus=EnumFoes.FoesStatus.UPPER;
                break;

            case 3:
                res="ELITE ZOMBIE";
                foesStatus=EnumFoes.FoesStatus.ELITE;
                break;
            case 4:
                res="BOSS ZOMBIE";
                foesStatus=EnumFoes.FoesStatus.BOSS;
                break;
        }
        return res;
    }

    @Override
    public void setStat(int level) {
        int hp=(int)(getLevel()*2.5);
        int power=(int)(getLevel()*1.5);

        setHp(hp);
        setPower(power);
        setArmor(getLevel()*2);
        setMagicResistance(getLevel()*2);
    }

    @Override
    public void SpecialAbility() {// will inflict bleed status

    }
}