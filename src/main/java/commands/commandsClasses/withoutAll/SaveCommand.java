package commands.commandsClasses.withoutAll;

import tools.collectionTools.CollectionManager;
import commands.Command;

public class SaveCommand implements Command {
    private String name="save";
    private CollectionManager manager;

    public SaveCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.save();
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
