package commands.commandsClasses.withArgs;

import exeptions.NonArgsExeption;
import lombok.Getter;
import lombok.Setter;
import startingData.Movie;
import tools.collectionTools.CollectionManager;
import commands.Command;
import startingData.MpaaRating;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.Optional;

public class MpaaFilterCommand implements Command, Serializable {
    private String name="filter_less_than_mpaa_rating";
    @Getter
    private Movie movie;
    private CollectionManager manager;
    @Getter
    private String params;

    public void setParams(String params){
        this.params=params;
        tryParse(params);
    }

    public MpaaFilterCommand(String name, String params) throws NonArgsExeption, IllegalArgumentException{
        this.name=name;
        this.params = params;
        if (params.equals("")){throw new NonArgsExeption();
        }
        tryParse(params);
    }

    public MpaaFilterCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String params) {
        manager.mpaaRatingFilter(tryParse(params));
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
    public MpaaRating tryParse(String text){
        try{
            MpaaRating mpaaRating = MpaaRating.valueOf(text);
            return mpaaRating;
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid parameter. Try G, PG, PG_13 or R");
            throw new IllegalArgumentException();
        }
    }
}
