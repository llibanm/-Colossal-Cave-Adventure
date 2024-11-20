package location;

import game.Game;

public  class Exit {

    private Location[] destination = new Location[2];
    private Boolean isbidirectionnal = true;
    public Exit(Location dest, Location source, Boolean isbidirectionnal ) {
        this.destination[0] = dest;
        this.destination[1] = source;
        this.isbidirectionnal = isbidirectionnal;
        if(this.isbidirectionnal){
            bidirectionnalAddExit(source, dest);
        }
    }
    public <E extends Exit> void bidirectionnalAddExit(Location source, Location dest){
        if(this.isbidirectionnal){
            dest.setExit(source.getName(), this);
        }
    }

    public  void cross(Game game) {
        Location currloc = game.getCurrentLocation();
        for(Location dest : this.destination){
            if( currloc != dest){
                //on met la location courant du monde
                game.setCurrentLocation(dest);
            }
        }
    }

}


