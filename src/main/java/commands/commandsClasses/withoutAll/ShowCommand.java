package commands.commandsClasses.withoutAll;

import tools.collectionTools.CollectionManager;
import commands.Command;

public class ShowCommand implements Command {
    private String name="show";
    private final boolean isWithElement=false;
    private CollectionManager manager;

    public ShowCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.show();
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
