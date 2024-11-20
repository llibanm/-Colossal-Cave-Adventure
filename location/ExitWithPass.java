package location;

import game.Game;

public class ExitWithPass extends Exit{
    private boolean cancross;
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
    public void cross(Game game){
        if(this.cancross){
            super.cross(game);
            this.cancross = false;
        }
    }

}
