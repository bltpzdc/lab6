import Commands.CommandManager;
import collection.CollectionLoader;
import collection.CollectionManager;
import collection.ConsoleReader;

import java.io.Console;


public class Main {
    public static void main(String[] args){
        CollectionLoader loader = new CollectionLoader();
        CollectionManager collectionManager = new CollectionManager(loader);
        CommandManager commandManager = new CommandManager();
        ConsoleReader reader = new ConsoleReader();
        //System.out.println(CommandManager.getCommands());
    }
}
