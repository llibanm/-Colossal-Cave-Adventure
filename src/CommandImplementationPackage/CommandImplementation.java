package CommandImplementationPackage;

import ItemPackage.Item;
import ItemPackage.Key;
import ItemPackage.Weapon;
import ItemPackage.healing.HealingItem;
import characterPackage.Enemies.Foes;
import Game.*;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import Game.StoryPackage.Story;


public class CommandImplementation implements CommandInterface {

    private List<String> command;
    private Game game;

    public CommandImplementation() {
        this.command = new ArrayList<>();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void addCommand(String command) {
        this.command.add(command);
    }

    public void printCommand() {
        for (String command : this.command) {
            System.out.println(command);
        }
    }

    public int getNumCommand() {
        return command.size();
    }

    public String getFirstArg() {
        return command.get(0);
    }

    public String getNArg(int index) {
        try {
            return command.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Index " + index + " is out of bounds.");
            return null;
        }
    }

    public boolean isEmptyCommand() {
        return command.isEmpty();
    }

    public String getSecondArg() {
        //return command.get(getNumCommand()-1);
        try {
            return command.get(1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
        }
        return  "";
    }

    public void emptyCommand() {
        this.command.clear();
    }

    @Override
    public void Help() {

        if(isEmptyCommand()){
            System.out.println("""
                        HELP <Argument> -> Print the menu of commands if no argument given with it. Else, print the corresponding argument's description.
                        GO <Location> -> Move the main character in the corresponding Location
                        LOOK [LOCATION] -> if no argument given, display a menu of all observable arguments. Else display a description of the given argument, whether items or location
                        TAKE object -> send a specific object to the backpack if enough space is available
                        DROP object -> drop a specific object from the backpack in the location the character is currently in.
                        DESTROY object -> remove an object from the game, it cannot be recovered
                        USE object1 [object2] -> use an object, if the object require a second argument then it must be used with
                        a second one.
                        SAVE -> save the game in the game files.
                        QUIT -> Exit the game.\s
                        """);
            return;
        }

        String c= getFirstArg();
        switch(c.toUpperCase()){
            case "GO":
                System.out.println("\"GO <Location> -> Move the main character in the corresponding Location\n");
                break;

            case "HELP":
                System.out.println("HELP <Argument> -> Print the menu of commands if no argument given with it. Else, print the corresponding argument's description\n");
                break;

            case "LOOK":
                System.out.println("LOOK object -> if no argument given, display a menu of all observable arguments. Else display a description of the given argument, whether items or location\n");
                break;

            case "TAKE":
                System.out.println("TAKE object -> send a specific object to the backpack if enough space is available\n");
                break;

            case "DROP":
                System.out.println("DROP object -> drop a specific object from the backpack in the location the character is currently in.\n");
                break;

            case "DESTROY":
                System.out.println("DESTROY object -> remove an object from the game, it cannot be recovered\n");
                break;

            case "SAVE":
                System.out.println("SAVE -> save the game in the game files\n");
                break;

            case "USE":
                System.out.println("USE object1 [object2] -> use an object, if the object require a second argument then it must be used with a second one.\n");
                break;

            case "ATTACK":
                System.out.println("Attack the first enemy with the current equipped weapon");

            case "QUIT":
                System.out.println("QUIT -> Exit the game.\n");
                break;
            default:
                System.out.println("""
                        HELP <Argument> -> Print the menu of commands if no argument given with it. Else, print the corresponding argument's description.
                        GO <Location> -> Move the main character in the corresponding Location
                        LOOK object -> if no argument given, display a menu of all observable arguments. Else display a description of the given argument, whether items or location
                        TAKE object -> send a specific object to the backpack if enough space is available
                        DROP object -> drop a specific object from the backpack in the location the character is currently in.
                        DESTROY object -> remove an object from the game, it cannot be recovered
                        USE object1 [object2] -> use an object, if the object require a second argument then it must be used with
                        a second one.
                        SAVE -> save the game in the game files.
                        QUIT -> Exit the game.\s
                        """);
        }

    }

   /* @Override
    public void Change() {
        if(isEmptyCommand()){
            System.out.println("Please recall CHANGE with whatever you want to change");
            return;
        }

        String c= getFirstArg();
        switch(c.toUpperCase()){

            case "NAME":

            default:
                System.out.println("The second argumant has not been recognized, please try again");
        }
        return;
    }*/

    public void setPin(Game g){
        if(isEmptyCommand()){
            System.out.println("Please recall LOOK with whatever you want to look at");
            return;
        }
        String c= getFirstArg();
        String dest = getSecondArg();
        String regex = "-?\\d+(\\.\\d+)?";
        // Permet de vérifier les nombres entiers, décimaux et négatifs
        if (c.matches(regex)) {
            System.out.println("La chaîne est un nombre.");
            int pin = Integer.parseInt(c);
            g.unlockExitWithPin(pin, dest);
        }
    }
    public void Go(Game g){
        if(isEmptyCommand()){
            System.out.println("Please recall LOOK with whatever you want to look at");
            return;
        }

        String c= getFirstArg();

        g.goTodestination(c);

    }
    @Override
    public void Look(){
        if(isEmptyCommand()){
            System.out.println("Please recall GO with whatever you want to look at");
            return;
        }

        String c= getFirstArg();

        switch(c.toUpperCase()){
            case "NAME","HERO-NAME","HERO NAME":
                game.getHero().printHeroName();
                break;
            case "STAT","STATS":
                game.getHero().printStats();
                break;
            case "LOCATION":
                game.getCurrentLocation().printLocation();
                break;
            case "ITEM", "BACKPACK":
                game.getHero().getCurrentBackpack().printItems();
                break;
            case "ENEMY","ENEMIES","FOES","FOE":
                if(game.getCurrentLocation().areFoesEmpty()){
                    System.out.println("There are no enemies in the area");
                }
                else{
                    game.getCurrentLocation().printFoes();
                }
                break;

            default:
                System.out.println("""
                        "Please recall LOOK with whatever you want to look at".
                        """);
                break;
        }
        emptyCommand();
    }

    @Override
    public void ATTACK(){
        if(game.getCurrentLocation().areFoesEmpty()){
            System.out.println("There are no enemies in the area to attack");
        }

        else{
            Foes f=game.getCurrentLocation().getFirstFoe();
            game.getHero().attackHero(f);
            if(f.getHp()<=0){
                game.getCurrentLocation().removeFoe(0);
                Story.pause(1);
                System.out.println("The enemy named ["+f.getFoeName()+"] has been defeated");
                Story.pause(2);
            }

        }
    }

    @Override
    public void TAKE(){
        if(isEmptyCommand()){
            System.out.println("Please recall TAKE with whatever you want to take to your backpack.");
            return;
        }
        else{
            Item item=null;

            String s=getFirstArg();
            item = game.getCurrentLocation().getItem(s);

            if(item != null) {
                game.getHero().getCurrentBackpack().addItem(item);
                System.out.println("\nThe Item [" + s + "] has been added to your backpack.");
            }
            else{
                System.out.println("\nThe Item [" + s + "] does not exist.");
            }
        }
    }

    @Override
    public void DROP(){

        if(isEmptyCommand()){
            System.out.println("Please recall DROP with whatever you want to DROP to your backpack.");
            return;
        }
        else{
            Item i=null;
            String s=getFirstArg();

            i=game.getHero().getCurrentBackpack().getItem(s);

            if(i != null) {
                game.getHero().getCurrentBackpack().removeItem(i);
                game.getCurrentLocation().addItem(i);
                System.out.println("\nThe Item [" + s + "] has been dropped to your current location.");
            }
            else{
                System.out.println("\nThe Item [" + s + "] does not exist in your backpack.");
            }


        }


    }

    @Override
    public void DESTROY(){
        if(isEmptyCommand()){
            System.out.println("Please recall DESTROY with whatever you want to destroy.");
            return;
        }

        else{
            Item i=null;
            String s=getFirstArg();

            i=game.getHero().getCurrentBackpack().getItem(s);

            if(i != null) {
                game.getHero().getCurrentBackpack().removeItem(i);
                i=null;
                System.out.println(" The item ["+s+"] has been permanently destroyed.");
            }
            else{
                System.out.println("\nThe Item [" + s + "] does not exist in your backpack.");
            }
        }
    }

    @Override
    public void USE(){

        if(isEmptyCommand()){
            System.out.println("Please recall USE with whatever you want to use the command with.");
        }
        else{

            String s1=getFirstArg();
            String s2=getSecondArg();


            int Number=0;
            Item i=null;

            if(s2 != s1) {

                try {
                    Number = Integer.parseInt(s2);
                } catch (NumberFormatException e) {
                    System.out.println("Error Invalid chain, second choice should be a number.");
                    return;
                }

                i=game.getHero().getCurrentBackpack().getItem(Number);

                if(i==null) {
                    System.out.println("Error, the position of the item you stated is wrong");
                    return;
                }
            }
            else{
                i=game.getHero().getCurrentBackpack().getItem(s1);

                if(i==null) {

                    System.out.println("Error, the item you stated doesn't exist in backpack");
                    return;
                }
            }

            switch(s1){
                case "Key":
                    String s3 = getNArg(2);
                    // System.out.println(s3);
                    Key k = (Key)i;
                    game.unlockExitWithKey(k, s3);
                    break;
                case "Rocky-Hammer":
                    game.getHero().setEquippedWeapon((Weapon) i);
                    System.out.println("\nYou have equipped ["+s1+"]");
                    break;


                case "Band-Aid":
                    HealingItem i1 = (HealingItem)i;
                    boolean b= i1.useHealingItem(game.getHero());

                    if(!b){
                        i1=null;
                        i=null;
                        return;
                    }
                    else {
                        System.out.println("\n[" + game.getHero().getHeroName() + "] recovered some hp !");
                        game.getHero().getCurrentBackpack().removeItem(i);
                        i1 = null;
                        i = null;
                        break;
                    }

            }



        }

    }

}
