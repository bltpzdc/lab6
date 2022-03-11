package tools.collectionTools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import startingData.CustomVector;
import startingData.Movie;

import java.io.*;

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
