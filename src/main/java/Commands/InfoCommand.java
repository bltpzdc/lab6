package Commands;

import collection.CollectionLoader;
import collection.CollectionManager;
import sources.CustomVector;
import sources.Movie;

import java.util.ArrayList;
import java.util.List;

public class InfoCommand implements Command{
    private String name = "info";

    @Override
    public void execute(String[] params) {
        CollectionManager.info();
    }

    @Override
    public String getName() {
        return name;
    }
}
