package commands.commandsClasses.withArgs;

import tools.collectionTools.CollectionManager;
import commands.Command;
import startingData.MpaaRating;

public class MpaaFilterCommand implements Command {
    private String name="filter_less_than_mpaa_rating";
    private CollectionManager manager;

    public MpaaFilterCommand(CollectionManager manager){
        this.manager=manager;
    }

    @Override
    public void execute(String[] params) {
        manager.mpaaRatingFilter(tryParse(params[0]));
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
    public MpaaRating tryParse(String text){
        try{
            MpaaRating mpaaRating = MpaaRating.valueOf(text);
            if (mpaaRating==mpaaRating.G){
                System.out.println("There are no any elements with mpaa rating lower entered because G is the lowest one.");
            }
            return mpaaRating;
        }
        catch (Exception e){
            System.out.println("Invalid mpaa rating.\n" +
                    "Choose G, PG, PG_13 or R the next time.");
            return MpaaRating.G;
        }
    }
}
