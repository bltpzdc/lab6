package commands.commandsClasses.withArgsElems;

import tools.collectionTools.CollectionManager;
import commands.Command;

public class UpdateCommand implements Command {
    private CollectionManager movieList;
    private String name="update";

    public UpdateCommand(CollectionManager movieList){
        this.movieList=movieList;
    }

    @Override
    public void execute(String[] params) {
        movieList.update(tryParse(params[0]));
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
