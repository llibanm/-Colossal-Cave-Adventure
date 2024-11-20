package location;

import game.Game;

public class ExitWithPin extends  ExitWithPass {
    int pin;
    ExitWithPin(Location dest, Location source, int pin, Boolean isbidirectionnal){
        super(dest, source, isbidirectionnal);
        this.pin = pin;
    }
    public void unlock(int pin){
        if(this.pin == pin){
            setCanCross(true);
        }
    }
    public  void setPin(int newPin){
        this.pin = newPin;
    }
}
