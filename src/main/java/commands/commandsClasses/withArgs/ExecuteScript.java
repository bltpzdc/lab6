package commands.commandsClasses.withArgs;

import tools.collectionTools.CollectionManager;
import commands.Command;

public class ExecuteScript implements Command {
    private final String name="execute_script";
    private CollectionManager manager;

    public ExecuteScript(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.executeScript(params[0]);
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
        return true;
    }
}
