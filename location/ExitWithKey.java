package location;

import game.Game;

public class ExitWithKey extends ExitWithPass {
    private Key key;
    public ExitWithKey(Location dest, Location source, Key key, Boolean isbidirectionnal){
        super(dest, source, isbidirectionnal);
        this.key = key;
    }

    public void unlock(Key key){
        if(this.key == key){
            setCanCross(true);
        }
    }
    public  void setPin(Key newKey){
        this.key = newKey;
    }
}