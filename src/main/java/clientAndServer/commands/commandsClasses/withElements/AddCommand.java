package commands.commandsClasses.withElements;

import exeptions.TooManyArgsException;
import lombok.Getter;
import lombok.Setter;
import startingData.Movie;
import tools.MovieBuilder;
import tools.collectionTools.CollectionManager;
import commands.Command;

import java.io.Serializable;

public class AddCommand implements Command, Serializable {
    private CollectionManager manager;
    private String name="add";
    @Getter @Setter
    private Movie movie;
    @Getter
    @Setter
    private String params;

    public AddCommand(CollectionManager manager){
        this.manager=manager;
    }
    public AddCommand(String name, String params) throws TooManyArgsException {
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
        manager.add(movie);
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
