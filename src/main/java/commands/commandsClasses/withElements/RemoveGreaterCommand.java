package commands.commandsClasses.withElements;

import tools.collectionTools.CollectionManager;
import commands.Command;

public class RemoveGreaterCommand implements Command {
    private String name="remove_greater";
    private CollectionManager manager;

    public RemoveGreaterCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.removeGreater();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isWithElement() {
        return true;
    }

    @Override
    public boolean isWithArgs() {
        return false;
    }
}
