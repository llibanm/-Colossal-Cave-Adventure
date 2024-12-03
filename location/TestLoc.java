package location;

import Game.Game;

public class TestLoc {
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
        c.goTodestination("middleloc");
        System.out.println("location actuelle "+c.getCurrentLocation().getName());


    }

    public void parcourirMonde(){
    /**Teste : on traverse les locations en insérant les clés si nécessaire...*/
        Game g = new Game();
       Location monde = Location.genererMonde();
       g.setCurrentLocation(monde);
       g.goTodestination("foret");

       g.goTodestination("montagne");//erreur car mdp pas inséré !!!
       g.unlockExitWithPin(1234);
       g.goTodestination("montagne");

        g.getCurrentLocation().printLocation();
       System.out.println(g.getCurrentLocation().getName());
    }
}
