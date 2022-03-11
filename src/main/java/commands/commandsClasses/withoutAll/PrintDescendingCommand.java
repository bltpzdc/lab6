package commands.commandsClasses.withoutAll;

import tools.collectionTools.CollectionManager;
import commands.Command;

public class PrintDescendingCommand implements Command {
    private String name="print_descending";
    private CollectionManager manager;

    public PrintDescendingCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.printDescending();
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
