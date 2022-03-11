package commands.commandsClasses.withElements;

import tools.collectionTools.CollectionManager;
import commands.Command;

public class AddCommand implements Command {
    private CollectionManager manager;
    private String name="add";

    public AddCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.add();
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
