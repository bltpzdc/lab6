package sources;

import java.time.LocalDate;

public class Movie implements Comparable<Movie>{
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private Long oscarsCount;
    private MovieGenre genre;
    private MpaaRating mpaaRating;
    private Person director;
    private java.time.LocalDate creationDate;

    public Movie(int id){
        this.id=id;
    }

    public Movie(){}

    public int getID(){
        return id;
    }

    @Override
    public String toString(){
        return "id: "+id+". Name: "+name+". Coordinates: "+coordinates+". Creation date: "+creationDate+". Oscars count: "+oscarsCount+". Genre: "+genre+". Mpaa rating: "+mpaaRating+". Director: "+director;
    }

    @Override
    public int compareTo(Movie o) {
        return id.compareTo(o.getID());
    }


}
