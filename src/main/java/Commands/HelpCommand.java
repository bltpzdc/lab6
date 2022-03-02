package Commands;

public class HelpCommand implements Command{
    private String name = "help";

    public HelpCommand(){
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(String[] params) {
        System.out.println("Commands :\n"+
                "info : collection information.\n"+
                "show : all elements of collection.\n"+
                "add {element} : add new element in collection.\n"+
                "update id {element} : update element value by its id.\n"+
                "remove_by_id id : delete element from collection by its id.\n"+
                "clear : delete all elements from collection.\n"+
                "save : save collection to the file.\n"+
                "execute_script file_name : read and execute script from the file.\n"+
                "exit : exit without saving collection to the file.\n"+
                "insert_at index {element} : add new element to the specified index.\n"+
                "remove_greater {element} : remove all elements that exceed the specified.\n"+
                "history : show last 8 commands without their arguments.\n"+
                "group_counting_by_id : group collection elements by their id and show count of elements in every group.\n"+
                "filter_less_than_mpaa_rating mpaaRating : show elements with mpaa rating lower than specified.\n"+
                "print_descending : show elements in descending order.");
    }
}
