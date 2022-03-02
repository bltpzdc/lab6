package Commands;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private static final Map<String, Command> commands= new HashMap<>();

    public static Map<String, Command> getCommands() {
        return commands;
    }

    private void registerCommand(Command command){
        commands.put(command.getName(), command);
    }

    public CommandManager(){
        registerCommand(new HelpCommand());
        registerCommand(new InfoCommand());
        registerCommand(new AddCommand());
        registerCommand(new ShowCommand());
    }
}
