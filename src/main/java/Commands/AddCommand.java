package Commands;

import collection.CollectionManager;
import sources.CustomVector;
import sources.Movie;

public class AddCommand implements Command{
    private String name="add";

    @Override
    public void execute(String[] params) {
        CollectionManager.add((Integer.parseInt(params[0])));
    }
    @Override
    public String getName(){
        return name;
    }
}
