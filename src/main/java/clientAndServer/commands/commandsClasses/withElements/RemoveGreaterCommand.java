package commands.commandsClasses.withElements;

import exeptions.TooManyArgsException;
import lombok.Getter;
import lombok.Setter;
import startingData.Movie;
import tools.MovieBuilder;
import tools.collectionTools.CollectionManager;
import commands.Command;

import java.io.Serializable;

public class RemoveGreaterCommand implements Command, Serializable {
    private String name="remove_greater";
    @Getter
    private Movie movie;
    private CollectionManager manager;
    @Getter
    @Setter
    private String params;

    public RemoveGreaterCommand(CollectionManager manager){
        this.manager=manager;
    }
    public RemoveGreaterCommand(String name, String params) throws TooManyArgsException {
        this.name=name;
        if (!params.equals("")){throw new TooManyArgsException();
        }
        MovieBuilder movieBuilder = new MovieBuilder();
        movie = movieBuilder.build();
    }

    @Override
    public void execute(String params) {

    }
    public void execute(Movie movie){
        manager.removeGreater(movie);
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
        return true;
    }

    @Override
    public boolean isWithArgs() {
        return false;
    }
}
