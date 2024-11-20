package location;

import game.Game;

public class TesteLoc {
    public  void teste_location_aller_A_vers_B(){
        Game c=new Game();
        Location entryloc  = new Location("entree");
        c.setCurrentLocation(entryloc);
        Location middleLoc = new Location("middle");
        entryloc.addExit(true, "middleloc",middleLoc);
        Location finalLoc = new Location("final");
        entryloc.printLocation();
        middleLoc.printLocation();
        System.out.println("location actuelle "+c.getCurrentLocation().getName());
        //location après déplacement
        Location curr = c.getCurrentLocation();
        curr.goToDestination("middleloc", c);
        System.out.println("location actuelle "+c.getCurrentLocation().getName());


    }
}
