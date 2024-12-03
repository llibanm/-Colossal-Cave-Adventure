package Game;

import CommandImplementationPackage.*;
import Game.StoryPackage.Story;
import characterPackage.Enemies.Foes;
import characterPackage.Hero;
import location.*;

import java.util.Scanner;

public class Game //extends CommandImplementation.CommandImplementation
{
    private final CommandImplementation command;
    private EnumCommand.Command currentCommand;
    private Location currentLocation;
    private Boolean DeepAction;// for strong actions such as attack or go

    private static Scanner sc;
    private static boolean gameFinished;
    private static String commandString;
    private Hero h;
    private Story story;


    public Game(){
        gameFinished = false;
        command = new CommandImplementation();
        h = new Hero();
        /**location principal contenant les accès vers toutes
         les autres*/
        currentLocation = Location.genererMonde();
        DeepAction=false;
    }

    //for deep action

    public void setDeepAction(Boolean action){
        DeepAction=action;
    }

    public boolean getDeepAction(){
        return DeepAction;
    }

    //for commandImplementation

    public void setCommand(){
        command.setGame(this);
    }
    // pour l'histoire du jeu
    public void setStory(){
        this.story=Story.beginningStory();
    }

    //for hero

    public Hero getHero(){
        return h;
    }


    public void PrintMessageWithHeroName(String message){
        System.out.println(message+h.getHeroName());
    }

    public void PrintMessageWithHeroNameQuestionMark(String message){
        System.out.println(message+h.getHeroName()+" ?");
    }

    public void PrintMessageWithHeroNameExclamationMark(String message){
        System.out.println(message+h.getHeroName()+" !");
    }

    public void PrintMessageWithHeroNameInBetween(String message1,String message2){
        System.out.println(message1+h.getHeroName()+message2);
    }

    public void setHero(){
        String name1=null; //name for hero
        String name2=null; // input to confirm name of hero
        boolean check=true;
        boolean check2;

        while(check){
            check2=true;
            System.out.println("Enter the name in the name tag: ");
            name1 = sc.nextLine();

            if(name1 == null){
                System.out.println("name not entered please retry !");
            }

            else{

                while(check2){
                    System.out.println("Is "+name1+" the name of the name tag?");
                    System.out.println("Enter [Y] for yes or [N] for no: ");
                    name2 = sc.nextLine();

                    switch(name2.toUpperCase()){
                        case "Y":
                            check2=false;
                            check=false;
                            break;
                        case "N":
                            //System.out.println("You will able to enter again !");
                            check2=false;
                            break;

                        default:
                            System.out.println("Input couldn't be found, please try again !");
                            break;
                    }

                }

            }

        }
        h.setHeroName(name1);
        PrintMessageWithHeroName("\nThe name is :");
        PrintMessageWithHeroNameInBetween("\nIs "," your name you used to have ? you can only wonder.");
        System.out.println("\nIt's time to go.");
        //PrintMessageWithHeroName("Welcome to the Game :");
    }



    //to check if game finished
    public boolean isGameFinished(){
        return gameFinished;
    }

    public void setGameFinished(){
        gameFinished = true;
    }

    public boolean checkGameFinished(){
        if(h.isHeroDead()){
            System.out.println("You were slain dead!");
            System.out.println("End of the game");
            return true;
        }
        return false;
    }

    //test

    public void printCommand(){// pour test
        System.out.println("Command typed :"+commandString);
    }


    public void welcomePrint(){
        System.out.println("""
                           Welcome to the game!
                           I hope you will enjoy it.
                           If you need any help, don't forget to enter the command HELP to know about all the command,
                           or HELP with a specific command to know about it.""");

    }
    //for fighting


    public void fight(){

        if(getCurrentLocation().areFoesEmpty()){
        }
        else{

            System.out.println("\nThere are monsters in the area");

            Story.pause(1);

            System.out.println("\nOne of them is attacking you");
            Foes f= getCurrentLocation().getFirstFoe();

            Story.pause(1);
            f.attackFoes(getHero());


        }

    }

    //for entry input

    public void openScan(){
        sc = new Scanner(System.in);
    }

    public void closeScan(){
        sc.close();
    }

    public void ScanGame(){//pour l'entrée
        System.out.println("""
                \nEnter the command that you want to perform. Write HELP with or without another command if need.
                """);
        System.out.print("Command: ");
        commandString=sc.nextLine();
    }


    public void transformStringToEnum(String command){
        switch(command.toUpperCase()){ // on le change en type énuméré
            case "HELP":
                currentCommand= EnumCommand.Command.HELP;break;
            case "QUIT":
                currentCommand= EnumCommand.Command.QUIT;break;
            case "SAVE":
                currentCommand= EnumCommand.Command.SAVE;break;
            case "LOAD":
                currentCommand= EnumCommand.Command.LOAD;break;
            case "USE":
                currentCommand= EnumCommand.Command.USE;break;
            case "DESTROY":
                currentCommand= EnumCommand.Command.DESTROY;break;
            case "LOOK":
                currentCommand= EnumCommand.Command.LOOK;break;
            case "DROP":
                currentCommand= EnumCommand.Command.DROP;break;
            case "TAKE":
                currentCommand= EnumCommand.Command.TAKE;break;
            case "ATTACK":
                currentCommand= EnumCommand.Command.ATTACK;break;
            case "GO":
                currentCommand= EnumCommand.Command.GO;break;
            default:
                System.out.println("""
                        Unknown command.
                        please try again.
                        """);
        }

    }


    public void addCommandArgumentIntoList(){// pour récupérer les commandes dans le chaine de charactere
        String commandInput;

        int index=commandString.indexOf(' ');

        if( index== -1 ){
            commandInput=commandString;
            transformStringToEnum(commandInput);
        }

        else {
            commandInput = commandString.substring(0, index); //on récupère la première instance avant un espace
            transformStringToEnum(commandInput);

            commandInput=commandString.substring(index+1); // on récupère ce qu'il y'a après l'espace

            if(commandInput.isEmpty()){
                return;
            }

            index=commandInput.indexOf(' '); // on récupère la deuxieme instance d'espace

            if(index== -1 ){
                command.addCommand(commandInput); // si pas de deuxiemme argument, on ajoute le premier arg dans
            }                                     // la liste

            else{ // on ajoute les  deux arguments dans la liste
                command.addCommand(commandInput.substring(0, index));
                command.addCommand(commandInput.substring(index+1));
            }
        }


    }
    /**MARCEL add.......*/
    public Location getCurrentLocation(){
        return  this.currentLocation;
    }
    public  void setCurrentLocation(Location dest){
        this.currentLocation = dest;
    }

    public void goTodestination(String dest){
        /**on change le lieux actuel en traversant la sortie dest */
       Location newLoc = getCurrentLocation().goToDestination(dest, getCurrentLocation());
       setCurrentLocation(newLoc);
    }

    public void unlockExitWithPin(int pin){
        /**si la porte est bloqué goTOdestination renverra une erreur
         il faut d'abord la debloquer en appellant celle ci
         (ex: COMMANDE UNLOCK dest... puis GO dest)*/
        Exit e = getCurrentLocation().getExit("montagne");
        if (e instanceof ExitWithPin){
            ((ExitWithPin) e).unlock(pin);
        }
        else{
            System.out.println("cette porte n'est pas une porte avec code pin");
        }
    }

    public void unlockExitWithKey(Key key){
        Exit e = getCurrentLocation().getExit("montagne");
        if (e instanceof ExitWithKey){
            ((ExitWithKey) e).unlock(key);
        }
        else{
            System.out.println("cette porte n'est pas une porte à clé");
        }
    }




    // JEU

    public void gameLoop(){

        setCommand();
       welcomePrint();
       openScan();
      // setStory();
       setHero();
       while(!isGameFinished()) {
           fight();

           if(checkGameFinished()){
               break;
           }

           PrintMessageWithHeroName("It's your turn to take action ");
           Story.pause(2);
           PrintMessageWithHeroNameQuestionMark("What shall you do ");

           while (!getDeepAction()) {


           while (currentCommand == null) {
               ScanGame();
               addCommandArgumentIntoList();
           }

           //printCommand();

           switch (currentCommand) {
               //EnumCommand.Command.HELP
               case GO:
                   setDeepAction(true);
                   break;
               case HELP:
                   command.Help();
                   currentCommand=null;
                   break;
               //EnumCommand.Command.QUIT:
               case SAVE:
                   break;
               case QUIT:
                   setGameFinished();
                   setDeepAction(true);
                   break;
               case LOOK:
                   command.Look();
                   currentCommand=null;
                   command.emptyCommand();
                   break;
               case TAKE:
                   command.TAKE();
                   setDeepAction(true);
                   break;
               case DROP:
                   command.DROP();
                   setDeepAction(true);
                   break;
               case DESTROY:
                   command.DESTROY();
                   setDeepAction(true);
                   break;
               case ATTACK:
                   command.ATTACK();
                   setDeepAction(true);
                   break;

               case USE:
                   command.USE();
                   currentCommand=null;
                   command.emptyCommand();
                   break;

               case LOAD:
                   break;
               default:
                   System.out.println("""
                           The command you typed has not been recognized.
                           Please try again.
                           """);
                   currentCommand=null;
                   break;
           }

             }
           currentCommand=null;
           command.emptyCommand();
           setDeepAction(false);

       }
       closeScan();
       h=null;
       currentLocation=null;
       commandString=null;


    }

}
