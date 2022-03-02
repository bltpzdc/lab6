package collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import sources.CustomVector;
import sources.Movie;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionLoader {
    private CustomVector<Movie> movieList;

    public CollectionLoader(){
        var env = System.getenv();
        File fileName = new File(env.get("PROCESSOR_ARCHITECTURE") + ".json");
        List<String> filesLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){
            String jsonHelper;
            while((jsonHelper = reader.readLine())!=null){
                filesLines.add(jsonHelper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json="";
        for (String i:filesLines){
            json+=i;
        }
        Gson gson = new GsonBuilder()
                .setDateFormat("dd/MM/yyyy").create();
        Type movieTypes = new TypeToken<CustomVector<Movie>>(){}.getType();
        movieList = gson.fromJson(json, movieTypes);
        Collections.sort(movieList);
    }

    public CustomVector<Movie> getMovieList(){
        return movieList;
    }
}
