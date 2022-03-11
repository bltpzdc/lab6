package commands.commandsClasses.withoutAll;

import collection.CollectionManager;
import commands.Command;

public class ClearCommand implements Command {
    private String name="clear";
    private CollectionManager movieList;

    public ClearCommand(CollectionManager movieList){
        this.movieList=movieList;
    }

    @Override
    public void execute(String[] params) {
        movieList.clear();
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
