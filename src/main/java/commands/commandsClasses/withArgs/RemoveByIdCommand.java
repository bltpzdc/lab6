package commands.commandsClasses.withArgs;

import collection.CollectionManager;
import commands.Command;

public class RemoveByIdCommand implements Command {
    private String name="remove_by_id";
    private CollectionManager movieList;

    public RemoveByIdCommand(CollectionManager movieList){
        this.movieList=movieList;
    }

    @Override
    public void execute(String[] params) {
        movieList.remove(tryParse(params[0]));
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
    public int tryParse(String text){
        try{
            return Integer.parseInt(text);
        }
        catch(NumberFormatException e){
            System.out.println("Invalid argument. You should enter only numbers as arguments.");
            return -1;
        }
    }
}
