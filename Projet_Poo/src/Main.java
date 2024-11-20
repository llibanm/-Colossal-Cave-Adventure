import characterPackage.Character;
import characterPackage.*;
import characterPackage.Enemies.Goblin;
import characterPackage.Enemies.Werewolf;
import location.Location;

public class Main {
    public static void main(String[] args) {

       // CommandImplementation command = new CommandImplementation();

        //Character h=new Character("Liban");
        //h.printStats();
      /* Game.Game c=new Game.Game();
       c.gameLoop();*/
        Werewolf w=new Werewolf(4);
        Goblin g=new Goblin(4);
        g.printStats();
        w.printStats();

        //initialisation d'une location
        Location entryloc  = new Location("entree");
        Location middleLoc = new Location("middle");
        entryloc.addExit(true, "middleloc",middleLoc);
        Location finalLoc = new Location("final");
        entryloc.printLocation();
        middleLoc.printLocation();


    }
}