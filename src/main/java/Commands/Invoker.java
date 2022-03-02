package Commands;

import java.util.Scanner;

public class Invoker {

    public void findCommand(String name, String[] params){
        CommandManager.getCommands().get(name).execute(params);
    }
}
