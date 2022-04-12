package commands.commandsClasses.withoutAll;

import lombok.Getter;
import lombok.Setter;
import startingData.Movie;
import tools.collectionTools.CollectionManager;
import commands.Command;

public class SaveCommand implements Command {
    private String name="save";
    @Getter
    private Movie movie;
    private CollectionManager manager;
    @Getter
    @Setter
    private String params;

    public SaveCommand(CollectionManager manager){
        this.manager=manager;
    }
    public void execute(Movie movie){
    }
    @Override
    public void execute(String params, Movie movie) {

    }

    @Override
    public void execute(String params) {
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
