import characterPackage.Character;
import characterPackage.*;
import characterPackage.Enemies.Goblin;
import characterPackage.Enemies.Werewolf;

public class Main {
    public static void main(String[] args) {

       // CommandImplementation command = new CommandImplementation();

        //Character h=new Character("Liban");
        //h.printStats();
      /* Game c=new Game();
       c.gameLoop();*/
        Werewolf w=new Werewolf(4);
        Goblin g=new Goblin(4);
        g.printStats();
        w.printStats();


    }
}