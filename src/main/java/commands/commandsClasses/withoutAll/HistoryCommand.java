package commands.commandsClasses.withoutAll;

import collection.CollectionManager;
import commands.Command;

public class HistoryCommand implements Command {
    private String name="history";
    private CollectionManager manager;

    public HistoryCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.history();
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
