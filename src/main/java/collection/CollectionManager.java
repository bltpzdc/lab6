package collection;

import sources.CustomVector;
import sources.Movie;

public class CollectionManager {
    private static CustomVector<Movie> movieList;
    private CollectionLoader loader;

    public CollectionManager(CollectionLoader loader){
        this.loader=loader;
        movieList=loader.getMovieList();
    }

    public static void info(){
        String[] listik =  movieList.getClass().getName().split("\\.");
        System.out.println("Collection information:\n"+
                "Type: "+listik[listik.length-1]+".\n"+
                "Initialize date: "+movieList.getInitTime()+".\n"+
                "Element count: "+movieList.size());
    }
    public static void add(int index){
        movieList.remove(index);
    }
    public static void show(){
        for (Movie i:movieList){
            System.out.println(i);
        }
        if (movieList.size()==0){
            System.out.println("There's no any elements in collection.");
        }
    }
}
