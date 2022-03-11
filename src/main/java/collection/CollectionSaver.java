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

public class CollectionSaver {
    private CollectionManager manager;
    private CustomVector<Movie> movieList;

    public CollectionSaver(CollectionManager manager){
        this.manager=manager;
        movieList = manager.getMovieList();
    }

    public void save() {
        var env = System.getenv();
        File fileName = new File("src\\main\\resources\\"+env.get("PROCESSOR_ARCHITECTURE") + ".json");
        Gson gson = new GsonBuilder()
                .setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(movieList);
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Collection has been uploaded to the file.");
    }
}
