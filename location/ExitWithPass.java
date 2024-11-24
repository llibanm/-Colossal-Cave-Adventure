package location;

import game.Game;

public class ExitWithPass extends Exit{
    /**classe de base representant les comportements
     commun entre toutes les portes nécessitant une
     clé quelconque pour traverser*/
    private boolean cancross = false;
    public ExitWithPass(Location dest, Location source, Boolean isbidirectionnal){
        super(dest, source, isbidirectionnal);
    }
    public  boolean getCanCross(){
        return this.cancross;
    }

    public  void setCanCross(boolean v){
        this.cancross = v;
    }
    @Override
    public Location cross(Location currloc){
        /**on rédéfinit afin de verifier si on peut la traverser
         cancross sera passé à true si le mot de passe fournit est est correcte
         dans les classes filles*/
        if(this.cancross){

            System.out.println("vous avez traversé la porte");
            this.cancross = false;
            return super.cross(currloc);
        }
        else{
            System.out.println("Vous ne pouvez pas traverser, insérez le code pin ou la clé");
        }
        return  currloc;
    }

}
