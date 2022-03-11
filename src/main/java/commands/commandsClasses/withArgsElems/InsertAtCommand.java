package commands.commandsClasses.withArgsElems;

import collection.CollectionManager;
import commands.Command;

public class InsertAtCommand implements Command {
    private String name="insert_at";
    private CollectionManager manager;

    public InsertAtCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.insertAt(tryParse(params[0]));
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
        catch (NumberFormatException e){
            System.out.println("Invalid argument. You should enter only numbers as arguments.");
            return -1;
        }
    }
}
