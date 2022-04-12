package commands.commandsClasses.withArgsElems;

import exeptions.NonArgsExeption;
import lombok.Getter;
import lombok.Setter;
import startingData.Movie;
import tools.MovieBuilder;
import tools.collectionTools.CollectionManager;
import commands.Command;

import java.io.Serializable;

public class UpdateCommand implements Command, Serializable {
    private CollectionManager movieList;
    private String name="update";
    @Getter
    private Movie movie;
    @Getter
    @Setter
    private String params;

    public UpdateCommand(CollectionManager movieList){
        this.movieList=movieList;
    }
    public UpdateCommand(String name, String params) throws NonArgsExeption, IllegalArgumentException{
        this.name=name;
        this.params = params;
        if (params.equals("")){throw new NonArgsExeption();
        }
        tryParse(params);
        MovieBuilder movieBuilder = new MovieBuilder();
        movie = movieBuilder.build();
    }

    @Override
    public void execute(String params) {

    }
    public void execute(Movie movie){
    }
    @Override
    public void execute(String params, Movie movie) {
        movieList.update(tryParse(params), movie);
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
        return true;
    }

    public int tryParse(String text){
        try{
            return Integer.parseInt(text);
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid argument. You should enter only numbers as arguments.");
            throw new IllegalArgumentException();
        }
    }
}
