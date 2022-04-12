package commands.commandsClasses.withoutAll;

import exeptions.TooManyArgsException;
import lombok.Getter;
import lombok.Setter;
import startingData.Movie;
import tools.collectionTools.CollectionManager;
import commands.Command;

import java.io.Serializable;

public class HelpCommand implements Command, Serializable {
    private String name = "help";
    @Getter
    private Movie movie;
    private CollectionManager manager;
    @Getter
    @Setter
    private String params;

    public HelpCommand(CollectionManager manager){
        this.manager=manager;
    }
    public HelpCommand(String name, String params) throws TooManyArgsException {
        this.name=name;
        if (!params.equals("")){throw new TooManyArgsException();
        }
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

    @Override
    public void execute(String params) {
        manager.help();
    }
    public void execute(Movie movie){
    }
    @Override
    public void execute(String params, Movie movie) {

    }
}
