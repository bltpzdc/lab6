import tools.worksWithCommands.CommandManager;
import tools.consoleTools.ConsoleReader;

public class Main {
    public static void main(String[] args){
        CommandManager commandManager = new CommandManager();
        ConsoleReader reader = new ConsoleReader();
        reader.run();
    }
}
