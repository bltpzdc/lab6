import tools.collectionTools.CollectionLoader;
import tools.collectionTools.CollectionManager;
import tools.worksWithCommands.CommandManager;
import tools.consoleTools.ConsoleReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        CollectionLoader loader = new CollectionLoader();
        loader.load();
        CollectionManager collectionManager = new CollectionManager(loader);
        CommandManager commandManager = new CommandManager(collectionManager);
        ConsoleReader reader = new ConsoleReader();
        reader.run();
    }
}
