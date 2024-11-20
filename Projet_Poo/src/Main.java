import characterPackage.Character;
import characterPackage.*;
import characterPackage.Enemies.Goblin;
import characterPackage.Enemies.Werewolf;
import game.Game;
import location.Location;
import location.TesteLoc;


public class Main {


    public static void main(String[] args) {
        TesteLoc testloc = new TesteLoc();
        testloc.teste_location_aller_A_vers_B();
       // CommandImplementation command = new CommandImplementation();

        //Character h=new Character("Liban");
        //h.printStats();
      /* Game.Game c=new Game.Game();
       c.gameLoop();*/
        Werewolf w=new Werewolf(4);
        Goblin g=new Goblin(4);
        g.printStats();
        w.printStats();

    }
}