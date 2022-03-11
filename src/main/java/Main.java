import commands.CommandManager;
import collection.CollectionLoader;
import collection.CollectionManager;
import collection.ConsoleReader;
import commands.FilesSafe;

public class Main {
    public static void main(String[] args){
        CommandManager commandManager = new CommandManager();
        ConsoleReader reader = new ConsoleReader();
        reader.run();
    }
}
