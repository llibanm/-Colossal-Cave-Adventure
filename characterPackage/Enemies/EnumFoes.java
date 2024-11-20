package characterPackage.Enemies;

public class EnumFoes {

    public enum FoesStatus{
        LOWER, //Level 1
        UPPER, //Level 4
        ELITE, //Level 7
        BOSS   //Level 10
    }

    public enum Foes{
        GOBLIN,// Higher atk/armor, lower hp/magic resist | damageType : Physical
        BLOB, //  Higher Magic resist/hp , lower atk/armor | damageType : Magic
        ZOMBIES,// Balanced stats | damageType : Physical
        WEREWOLF,//Higher hp/atk, lower armor/magic resist | damageType : Physical
    }

}
