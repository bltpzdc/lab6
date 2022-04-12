package commands;

import lombok.Getter;
import lombok.Setter;
import startingData.Movie;

public interface Command {
    public Movie getMovie();
    public void setParams(String params);
    public String getParams();
    public void execute(String params);
    public void execute(Movie movie);
    public void execute(String params, Movie movie);
    public String getName();
    public boolean isWithElement();
    public boolean isWithArgs();
}
