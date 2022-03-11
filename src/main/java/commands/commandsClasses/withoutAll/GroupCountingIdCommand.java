package commands.commandsClasses.withoutAll;

import collection.CollectionManager;
import commands.Command;

public class GroupCountingIdCommand implements Command {
    private String name="group_counting_by_id";
    private CollectionManager manager;

    public GroupCountingIdCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.groupCountingId();
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
