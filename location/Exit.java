package location;

public  class Exit {
    /**une porte pouvant mener vers 2 destination */
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

    public  Location cross(Location currloc) {
        /**on va vers la location qui est différente de celle
         actuelle étant donné qu'une porte peut mener à 2 endroits
         */

        for(Location dest : this.destination){
            if( currloc != dest){
                //on met la location courant du monde
                return  dest;
            }
        }
        return currloc;
    }


}


