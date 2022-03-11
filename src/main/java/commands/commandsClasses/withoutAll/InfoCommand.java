package commands.commandsClasses.withoutAll;

import tools.collectionTools.CollectionManager;
import commands.Command;

public class InfoCommand implements Command {
    private String name = "info";
    private CollectionManager manager;

    public InfoCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.info();
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
}
