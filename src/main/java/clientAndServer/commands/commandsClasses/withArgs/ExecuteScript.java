package commands.commandsClasses.withArgs;

import exeptions.NonArgsExeption;
import exeptions.TooManyArgsException;
import lombok.Getter;
import lombok.Setter;
import startingData.Movie;
import tools.collectionTools.CollectionManager;
import commands.Command;

import java.io.Serializable;

public class ExecuteScript implements Command, Serializable {
    private String name="execute_script";
    @Getter
    private Movie movie;
    private CollectionManager manager;
    @Getter @Setter
    private String params;

    public ExecuteScript(CollectionManager manager){
        this.manager=manager;
    }
    public ExecuteScript(String name, String params) throws NonArgsExeption {
        this.name=name;
        this.params = params;
        if (params.equals("")){throw new NonArgsExeption();
        }
    }

    @Override
    public void execute(String params) {
        manager.executeScript(params);
    }
    public void execute(Movie movie){
    }
    @Override
    public void execute(String params, Movie movie) {

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
