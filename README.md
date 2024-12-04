# -Colossal-Cave-Adventure
Creation of a  Colossal Cave Adventure -like game in JAVA.

COMMAND [ARGUMENT] -> execute a specific action based on a game command with/without the argument
The various commands are as such:

-> GO location -> send the player to a location/exit.

-> LOOK object -> Display a description of the given argument, whether items , location or monster.

-> ATTACK -> attack a nearby monster in the area of the player.

-> HELP[COMMAND] -> if no argument given, indicates the set of availaible commands, else return the description of the given command in argument.

-> TAKE object -> send a specific object to the backpack if enough space is availaible.

-> DROP object -> drop a specific object from the backpack in the location the character is currently in.

-> DESTROY object -> remove an object from the game, it cannot be recovered.

-> SAVE -> save the game in the game files.

-> QUIT -> exit the game

-> USE object1 [object2] -> use an object, if the object require a second argument then it must be used with
a second one. 
