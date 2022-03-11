package commands.commandsClasses.withoutAll;

import collection.CollectionManager;
import commands.Command;

public class ExitCommand implements Command {
    private String name="exit";
    private CollectionManager manager;

    public ExitCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.exit();
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
