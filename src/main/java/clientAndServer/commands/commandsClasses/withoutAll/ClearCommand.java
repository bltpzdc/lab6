package commands.commandsClasses.withoutAll;

import exeptions.TooManyArgsException;
import lombok.Getter;
import lombok.Setter;
import startingData.Movie;
import tools.collectionTools.CollectionManager;
import commands.Command;

import java.io.Serializable;

public class ClearCommand implements Command, Serializable {
    private String name="clear";
    @Getter
    private Movie movie;
    private CollectionManager movieList;
    @Getter
    @Setter
    private String params;

    public ClearCommand(CollectionManager movieList){
        this.movieList=movieList;
    }
    public ClearCommand(String name, String params) throws TooManyArgsException {
        this.name=name;
        if (!params.equals("")){throw new TooManyArgsException();
        }
    }

    @Override
    public void execute(String params) {
        movieList.clear();
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
        return false;
    }
}
