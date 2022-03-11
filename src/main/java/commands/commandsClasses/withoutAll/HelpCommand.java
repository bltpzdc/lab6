package commands.commandsClasses.withoutAll;

import tools.collectionTools.CollectionManager;
import commands.Command;

public class HelpCommand implements Command {
    private String name = "help";
    private CollectionManager manager;

    public HelpCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isWithElement() {
        return false;
    }

    @Override
    public boolean isWithArgs() {
        return false;
    }

    @Override
    public void execute(String[] params) {
        manager.help();
    }
}
