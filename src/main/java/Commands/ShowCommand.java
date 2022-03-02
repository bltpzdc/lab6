package Commands;

import collection.CollectionManager;
import sources.CustomVector;
import sources.Movie;

public class ShowCommand implements Command{
    private String name="show";

    @Override
    public void execute(String[] params) {
        CollectionManager.show();
    }

    @Override
    public String getName() {
        return name;
    }
}
